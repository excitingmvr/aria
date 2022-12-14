package com.junefw.infra.modules.member;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.junefw.infra.common.base.BaseController;
import com.junefw.infra.common.constants.Constants;
import com.junefw.infra.common.util.UtilCookie;
import com.junefw.infra.common.util.UtilDateTime;
import com.junefw.infra.modules.code.CodeServiceImpl;
import com.junefw.infra.modules.nationality.Nationality;
import com.junefw.infra.modules.nationality.NationalityServiceImpl;
import com.junefw.infra.modules.nationality.NationalityVo;

@Controller
@RequestMapping(value = "/member/")
public class MemberController extends BaseController {

	@Autowired
	MemberServiceImpl service;
	
	@Autowired
	NationalityServiceImpl serviceNationality;


	public void setSearch(MemberVo vo) throws Exception {
		
		vo.setShDelNy(vo.getShDelNy() == null ? 0 : vo.getShDelNy());
		vo.setShOptionDate(vo.getShOptionDate() == null ? null : vo.getShOptionDate());
		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));

//		vo.setShOptionDate(vo.getShOptionDate() == null ? 1 : vo.getShOptionDate());
//		vo.setShDateStart(vo.getShDateStart() == null
//		    ? UtilDateTime.calculateDayString(UtilDateTime.nowLocalDateTime(), Constants.DATE_INTERVAL)
//		    : UtilDateTime.add00TimeString(vo.getShDateStart()));
//		vo.setShDateEnd(vo.getShDateEnd() == null
//		    ? UtilDateTime.nowString()
//		    : UtilDateTime.addNowTimeString(vo.getShDateEnd()));
	}
	
	
	@RequestMapping(value = "memberList")
	public String memberList(@ModelAttribute("vo") MemberVo vo, Model model) throws Exception {

		setSearch(vo);
		vo.setParamsPaging(service.selectOneCount(vo));

		if (vo.getTotalRows() > 0) {
			List<Member> list = service.selectList(vo);
//			List<?> list = service.selectList(vo);
			model.addAttribute("list", list);
		}
		return "infra/member/xdmin/memberList";
	}

	
	@RequestMapping(value = "memberForm")
	public String memberForm(@ModelAttribute("vo") MemberVo vo, Model model, NationalityVo nationalityVo) throws Exception {
		
		nationalityVo.setShUseNy(1);
		nationalityVo.setShDelNy(0);
		List<Nationality> listNationality = serviceNationality.selectList(nationalityVo);
		model.addAttribute("listNationality", listNationality);
		
		if (vo.getIfmmSeq().equals("0") || vo.getIfmmSeq().equals("")) {
//			insert
		} else {
//			update
			Member item = service.selectOne(vo);
			model.addAttribute("item", item);
			
			model.addAttribute("listPhone", service.selectListPhone(vo));
			model.addAttribute("listUploaded", service.selectListUploaded(vo));
		}

//		model.addAttribute("codeGender", CodeServiceImpl.selectListCachedCode("3"));
//		model.addAttribute("codeTelecom", CodeServiceImpl.selectListCachedCode("10"));

		return "infra/member/xdmin/memberForm";
	}

	
	@SuppressWarnings(value = { "all" })
	@RequestMapping(value = "memberInst")
	public String memberInst(MemberVo vo, Member dto, RedirectAttributes redirectAttributes) throws Exception {
		
		service.insert(dto);
	
		vo.setIfmmSeq(dto.getIfmmSeq());
		
		redirectAttributes.addFlashAttribute("vo", vo);

		if (Constants.INSERT_AFTER_TYPE == 1) {
			return "redirect:/member/memberForm";
		} else {
			return "redirect:/member/memberList";
		}
	}
	
	
	@SuppressWarnings(value = { "all" })
	@RequestMapping(value = "memberUpdt")
	public String memberUpdt(MemberVo vo, Member dto, RedirectAttributes redirectAttributes) throws Exception {

		service.update(dto);

		redirectAttributes.addFlashAttribute("vo", vo);

		if (Constants.UPDATE_AFTER_TYPE == 1) {
			return "redirect:/member/memberForm";
		} else {
			return "redirect:/member/memberList";
		}
	}
	

	@RequestMapping(value = "memberUele")
	public String memberUele(MemberVo vo, Member dto, RedirectAttributes redirectAttributes) throws Exception {

		service.uelete(dto);

		redirectAttributes.addFlashAttribute("vo", vo);

		return "redirect:/member/memberList";
	}

	
	@RequestMapping(value = "memberDele")
	public String memberDele(MemberVo vo, RedirectAttributes redirectAttributes) throws Exception {

		service.delete(vo);

		redirectAttributes.addFlashAttribute("vo", vo);

		return "redirect:/member/memberList";
	}

	
	@RequestMapping(value = "memberMultiUele")
	public String memberMultiUele(MemberVo vo, Member dto, RedirectAttributes redirectAttributes) throws Exception {

		for (String checkboxSeq : vo.getCheckboxSeqArray()) {
			dto.setIfmmSeq(checkboxSeq);
			service.uelete(dto);
		}

		redirectAttributes.addFlashAttribute("vo", vo);

		return "redirect:/member/memberList";
	}
	

	@RequestMapping(value = "memberMultiDele")
	public String memberMultiDele(MemberVo vo, RedirectAttributes redirectAttributes) throws Exception {

		for (String checkboxSeq : vo.getCheckboxSeqArray()) {
			vo.setIfmmSeq(checkboxSeq);
//			service.delete(vo);
		}

		redirectAttributes.addFlashAttribute("vo", vo);

		return "redirect:/member/memberList";
	}
	
	
	@RequestMapping("excelDownload")
    public void excelDownload(MemberVo vo, HttpServletResponse httpServletResponse) throws Exception {
		
		setSearch(vo);
		vo.setParamsPaging(service.selectOneCount(vo));

		if (vo.getTotalRows() > 0) {
			List<Member> list = service.selectList(vo);
			
//			Workbook workbook = new HSSFWorkbook();	// for xls
	        Workbook workbook = new XSSFWorkbook();
	        Sheet sheet = workbook.createSheet("Sheet1");
	        CellStyle cellStyle = workbook.createCellStyle();        
	        Row row = null;
	        Cell cell = null;
	        int rowNum = 0;
			
//	        each column width setting	        
	        sheet.setColumnWidth(0, 2100);
	        sheet.setColumnWidth(1, 3100);

//	        Header
	        String[] tableHeader = {"Seq", "??????", "?????????", "??????", "??????", "?????????", "?????????", "?????????", "?????????"};

	        row = sheet.createRow(rowNum++);
	        
			for(int i=0; i<tableHeader.length; i++) {
				cell = row.createCell(i);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
				cell.setCellValue(tableHeader[i]);
			}

//	        Body
	        for (int i=0; i<list.size(); i++) {
	            row = sheet.createRow(rowNum++);
	            
//	            String type: null ?????? ????????? ok
//	            int, date type: null ??? ?????? ?????? ????????? null check
//	            String type ????????? ????????? ???????????? ????????? seq ??? ?????? ?????????	            
	            
	            cell = row.createCell(0);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	            cell.setCellValue(Integer.parseInt(list.get(i).getIfmmSeq()));
	            
	            cell = row.createCell(1);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	cell.setCellValue(list.get(i).getIfmmName());
	        	
	            cell = row.createCell(2);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	cell.setCellValue(list.get(i).getIfmmId());
	        	
	            cell = row.createCell(3);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	            if(list.get(i).getIfmmGenderCd() != null) cell.setCellValue(CodeServiceImpl.selectOneCachedCode(list.get(i).getIfmmGenderCd()));
	            
	            cell = row.createCell(4);
	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
	            cell.setCellStyle(cellStyle);
	            cell.setCellValue(list.get(i).getIfmmDob());
	            
	            cell = row.createCell(5);
	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
	            cell.setCellStyle(cellStyle);
	            cell.setCellValue(list.get(i).getIfmeEmailFull());
	            
	            cell = row.createCell(6);
	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
	            cell.setCellStyle(cellStyle);
	            cell.setCellValue(list.get(i).getIfmpNumber());    
	            
	            cell = row.createCell(7);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	if(list.get(i).getRegDateTime() != null) cell.setCellValue(UtilDateTime.dateTimeToString(list.get(i).getRegDateTime()));
	            
	            cell = row.createCell(8);
	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
	            cell.setCellStyle(cellStyle);
	            if(list.get(i).getModDateTime() != null) cell.setCellValue(UtilDateTime.dateTimeToString(list.get(i).getModDateTime()));
	        }

	        httpServletResponse.setContentType("ms-vnd/excel");
//	        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=example.xls");	// for xls
	        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=example.xlsx");

	        workbook.write(httpServletResponse.getOutputStream());
	        workbook.close();
		}
    }
	
	
	@ResponseBody
	@RequestMapping(value = "checkId")
	public Map<String, Object> checkId(Member dto) throws Exception {

		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		int result = service.selectOneIdCheck(dto);

		if (result > 0) {
			returnMap.put("rt", "fail");
		} else {
			returnMap.put("rt", "success");
		}
		return returnMap;
	}
	

	@RequestMapping(value = "loginForm")
	public String loginForm(MemberVo vo, HttpSession httpSession) throws Exception {
		if(UtilCookie.getValue(Constants.COOKIE_NAME_SEQ) != null) {

			//	auto login
			if(httpSession.getAttribute("sessSeq") == null) {
				
				vo.setIfmmSeq(UtilCookie.getValue(Constants.COOKIE_NAME_SEQ));
				
				Member rtMember = service.selectOne(vo);
				
				httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE); // 60second * 30 = 30minute
				httpSession.setAttribute("sessSeq", rtMember.getIfmmSeq());
				httpSession.setAttribute("sessId", rtMember.getIfmmId());
				httpSession.setAttribute("sessName", rtMember.getIfmmName());
			} else {
				//	by pass
			}
			return "redirect:/index/indexView";
		} else {
			//	by pass
			return "infra/member/xdmin/loginForm";
		}
	}

	
	@ResponseBody
	@RequestMapping(value = "loginProc")
	public Map<String, Object> loginProc(Member dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();

		Member rtMember = service.selectOneId(dto);

		if (rtMember != null) {
//			dto.setIfmmPassword(UtilSecurity.encryptSha256(dto.getIfmmPassword()));
			Member rtMember2 = service.selectOneLogin(dto);

			if (rtMember2 != null) {
				
				if(dto.getAutoLogin() == true) {
					UtilCookie.createCookie(Constants.COOKIE_NAME_SEQ, rtMember2.getIfmmSeq(), Constants.COOKIE_DOMAIN, Constants.COOKIE_PATH, Constants.COOKIE_MAXAGE);
				} else {
					// by pass
				}
				
				httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE); // 60second * 30 = 30minute
				httpSession.setAttribute("sessSeq", rtMember2.getIfmmSeq());
				httpSession.setAttribute("sessId", rtMember2.getIfmmId());
				httpSession.setAttribute("sessName", rtMember2.getIfmmName());

				rtMember2.setIfmmSocialLoginCd(103);
				rtMember2.setIflgResultNy(1);
				service.insertLogLogin(rtMember2);

				Date date = rtMember2.getIfmmPwdModDate();
				LocalDateTime ifmmPwdModDateLocalDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());

				if (ChronoUnit.DAYS.between(ifmmPwdModDateLocalDateTime, UtilDateTime.nowLocalDateTime()) > Constants.PASSWOPRD_CHANGE_INTERVAL) {
					returnMap.put("changePwd", "true");
				}

				returnMap.put("rt", "success");
			} else {
				dto.setIfmmSocialLoginCd(103);
				dto.setIfmmSeq(rtMember.getIfmmSeq());
				dto.setIflgResultNy(0);
				service.insertLogLogin(dto);

				returnMap.put("rt", "fail");
			}
		} else {
			dto.setIfmmSocialLoginCd(103);
			dto.setIflgResultNy(0);
			service.insertLogLogin(dto);

			returnMap.put("rt", "fail");
		}
		return returnMap;
	}

	
	@ResponseBody
	@RequestMapping(value = "logoutProc")
	public Map<String, Object> logoutProc(HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		UtilCookie.deleteCookie();
		httpSession.invalidate();
		returnMap.put("rt", "success");
		return returnMap;
	}
	
	
	@RequestMapping(value = "findIdPwdForm")
	public String findIdPwdForm() throws Exception {
		
		return "infra/member/xdmin/findIdPwdForm";
	}

	
	@ResponseBody
	@RequestMapping(value = "findIdPwdProc")
	public Map<String, Object> findIdPwdForm(Member dto) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		Member rtMember = service.selectOneFindIdPwd(dto);
		
		if (rtMember != null) {
			returnMap.put("rt", "success");
			returnMap.put("item", rtMember);
		
		} else {
			returnMap.put("rt", "fail");
			
		}
		return returnMap;
	}
	
	
	@RequestMapping(value = "changePwdForm")
	public String changePwdForm() throws Exception {
		
		return "infra/member/xdmin/changePwdForm";
	}

	
	@ResponseBody
	@RequestMapping(value = "extendPwd")
	public Map<String, Object> extendPwd(Member dto) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		service.updateIfmmPwdModDate(dto);
		returnMap.put("rt", "success");
		return returnMap;
	}
	
	
	@RequestMapping(value = "loginNaverCallback")
	public String loginNaverCallback() throws Exception {

		return "infra/member/xdmin/loginNaverCallback";
	}
	
	
	@RequestMapping(value = "loginNaverProc")
	public String loginNaverProc(Member dto, HttpSession httpSession) throws Exception {

		Member rtMember = service.selectOneId(dto);
		
		if (rtMember != null) {
			
			httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE); // 60second * 30 = 30minute
			httpSession.setAttribute("sessSeq", rtMember.getIfmmSeq());
			httpSession.setAttribute("sessId", rtMember.getIfmmId());
			httpSession.setAttribute("sessName", "??????????????????");
			
			dto.setIfmmSocialLoginCd(105);
			dto.setIflgResultNy(1);
			service.insertLogLogin(dto);
			
		} else {

			dto.setIfmmSocialLoginCd(105);
			service.insertSocialLoginMember(dto);
			
			httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE); // 60second * 30 = 30minute
			httpSession.setAttribute("sessSeq", dto.getIfmmSeq());
			httpSession.setAttribute("sessId", dto.getIfmmId());
			httpSession.setAttribute("sessName", "??????????????????");
			
			dto.setIfmmSocialLoginCd(105);
			dto.setIflgResultNy(0);
			service.insertLogLogin(dto);
		}
		
		return "redirect:/index/indexView";
	}
	
	
	@RequestMapping(value = "/memberUsrForm")
	public String memberUsrForm() throws Exception {


		
		return "infra/member/usr/memberUsrForm";
	}
	
	
	@RequestMapping(value = "/memberLoginUsrForm")
	public String memberLoginUsrFrom() throws Exception {


		
		return "infra/member/usr/memberLoginUsrForm";
	}
	
	
}