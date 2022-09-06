package com.junefw.infra.modules.code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.core.tools.picocli.CommandLine.Help.TextTable.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
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
import com.junefw.infra.modules.codegroup.CodeGroupServiceImpl;

@Controller
@RequestMapping(value="/code/")
public class CodeController extends BaseController{
	
	@Autowired
	CodeServiceImpl service;

	@Autowired
	CodeGroupServiceImpl codeGroupServiceImpl;
	

	public void setSearchAndPaging(CodeVo vo) throws Exception {
		
		vo.setShOptionDate(vo.getShOptionDate() == null ? 2 : vo.getShOptionDate());
		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));

		vo.setParamsPaging(service.selectOneCount(vo));
		
	}
	
	
	@RequestMapping(value = "codeList")
	public String codeList(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception {

		setSearchAndPaging(vo);
		
		if (vo.getTotalRows() > 0) {
			List<Code> list = service.selectList(vo);
			model.addAttribute("list", list);
		}

		return "infra/code/xdmin/codeList";
	}

	
	@RequestMapping(value = "codeForm")
	public String codeForm(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception {
		
		model.addAttribute("list", codeGroupServiceImpl.selectListWithoutPaging());
		
		if (vo.getIfcdSeq().equals("0") || vo.getIfcdSeq().equals("")) {
			//	insert
		} else {
			Code item = service.selectOne(vo);
			model.addAttribute("item", item);
		}

		return "infra/code/xdmin/codeForm";
	}
	

	@SuppressWarnings(value = { "all" })
	@RequestMapping(value = "codeInst")
	public String codeyInst(CodeVo vo, Code dto, RedirectAttributes redirectAttributes) throws Exception {

		service.insert(dto);
	
		vo.setIfcdSeq(dto.getIfcdSeq());
		
		redirectAttributes.addFlashAttribute("vo", vo);

		if (Constants.INSERT_AFTER_TYPE == 1) {
			return "redirect:/code/codeForm";
		} else {
			return "redirect:/code/codeList";
		}
	}
	
	
	@SuppressWarnings(value = { "all" })
	@RequestMapping(value = "codeUpdt")
	public String codeUpdt(CodeVo vo, Code dto, RedirectAttributes redirectAttributes) throws Exception {

		service.update(dto);

		redirectAttributes.addFlashAttribute("vo", vo);

		if (Constants.UPDATE_AFTER_TYPE == 1) {
			return "redirect:/code/codeForm";
		} else {
			return "redirect:/code/codeList";
		}
	}

	
	@RequestMapping(value = "codeUele")
	public String codeUele(CodeVo vo, Code dto, RedirectAttributes redirectAttributes) throws Exception {

		service.uelete(dto);

		redirectAttributes.addFlashAttribute("vo", vo);

		return "redirect:/code/codeList";
	}

	
	@RequestMapping(value = "codeDele")
	public String nationalityDele(CodeVo vo, RedirectAttributes redirectAttributes) throws Exception {

		service.delete(vo);

		redirectAttributes.addFlashAttribute("vo", vo);

		return "redirect:/code/codeList";
	}

	
	@RequestMapping(value = "codeMultiUele")
	public String codeMultiUele(CodeVo vo, Code dto, RedirectAttributes redirectAttributes) throws Exception {

		for (String checkboxSeq : vo.getCheckboxSeqArray()) {
			vo.setIfcdSeq(checkboxSeq);
			service.uelete(dto);
		}

		redirectAttributes.addFlashAttribute("vo", vo);

		return "redirect:/code/codeList";
	}

	
	@RequestMapping(value = "codeMultiDele")
	public String nationalityMultiDele(CodeVo vo, RedirectAttributes redirectAttributes) throws Exception {

		for (String checkboxSeq : vo.getCheckboxSeqArray()) {
			vo.setIfcdSeq(checkboxSeq);
			service.delete(vo);
		}

		redirectAttributes.addFlashAttribute("vo", vo);

		return "redirect:/code/codeList";
	}
	

	@RequestMapping("excelDownload")
    public void excelDownload(CodeVo vo, HttpServletResponse httpServletResponse) throws Exception {
		
		setSearchAndPaging(vo);

		if (vo.getTotalRows() > 0) {
			List<Code> list = service.selectList(vo);
			
//			Workbook workbook = new HSSFWorkbook();	// for xls
	        Workbook workbook = new XSSFWorkbook();
	        Sheet sheet = workbook.createSheet("첫번째 시트");
	        CellStyle cellStyle = workbook.createCellStyle();        
	        Row row = null;
	        Cell cell = null;
	        int rowNum = 0;
			
	        sheet.setColumnWidth(0, 2100);
	        sheet.setColumnWidth(1, 3100);

//	        Header
	        String[] tableHeader = {"번호","이름","아이디","생년월일","수정일"};

	        row = sheet.createRow(rowNum++);
//			for(int i=0; i<tableHeader.length; i++) {
//				cell = row.createCell(i);
//	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
//	        	cell.setCellStyle(cellStyle);
//				cell.setCellValue(tableHeader[i]);
//			}

	        // Body
	        for (int i=0; i<list.size(); i++) {
	            row = sheet.createRow(rowNum++);
	            
//	            cell = row.createCell(0);
//	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
//	        	cell.setCellStyle(cellStyle);
//	            cell.setCellValue(Integer.parseInt(list.get(i).getIfmmSeq()));
//	            
//	            cell = row.createCell(1);
//	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
//	        	cell.setCellStyle(cellStyle);
//	        	cell.setCellValue(list.get(i).getIfmmName());
//	        	
//	            cell = row.createCell(2);
//	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
//	        	cell.setCellStyle(cellStyle);
//	        	cell.setCellValue(list.get(i).getIfmmId());
//	        	
//	            cell = row.createCell(3);
//	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
//	        	cell.setCellStyle(cellStyle);
//	            cell.setCellValue(list.get(i).getIfmmDob());
//	            
//	            cell = row.createCell(4);
//	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
//	        	cell.setCellStyle(cellStyle);
//	            cell.setCellValue(dateTimeToString(list.get(i).getRegDateTime()));
	        }

	        httpServletResponse.setContentType("ms-vnd/excel");
//	        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=example.xls");	// for xls
	        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=example.xlsx");

	        workbook.write(httpServletResponse.getOutputStream());
	        workbook.close();
		}
    }
	
	@ResponseBody
	@RequestMapping(value = "codeInit")
	public Map<String, Object> logoutProc() throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		service.selectListCachedCodeArrayList();
		returnMap.put("rt", "success");
		return returnMap;
	}	
}