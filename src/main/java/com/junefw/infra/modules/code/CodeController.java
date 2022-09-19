package com.junefw.infra.modules.code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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
		
		vo.setShUseNy(vo.getShUseNy() == null ? 1 : vo.getShUseNy());
		vo.setShDelNy(vo.getShDelNy() == null ? 0 : vo.getShDelNy());
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
			dto.setIfcdSeq(checkboxSeq);
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
			
//	        each column width setting
	        sheet.setColumnWidth(0, 2100);
	        sheet.setColumnWidth(1, 3100);

//	        Header
	        String[] tableHeader = {"코드그룹 코드", "코드그룹 이름", "코드", "대체 코드", "코드 이름", "코드 이름 (영문)", "사용", "순서", "등록일", "수정일"};

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
	            
//	            String type: null 전달 되어도 ok
//	            int, date type: null 시 오류 발생 하므로 null check
//	            String type 이지만 정수형 데이터가 전체인 seq 의 경우 캐스팅
	            
	            cell = row.createCell(0);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	            cell.setCellValue(Integer.parseInt(list.get(i).getIfcgSeq()));
	            
	            cell = row.createCell(1);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	cell.setCellValue(list.get(i).getIfcgName());
	        	
	            cell = row.createCell(2);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	cell.setCellValue(Integer.parseInt(list.get(i).getIfcdSeq()));
	        	
	            cell = row.createCell(3);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	cell.setCellValue(list.get(i).getIfcdSeqAnother());
	            
	            cell = row.createCell(4);
	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
	            cell.setCellStyle(cellStyle);
	            cell.setCellValue(list.get(i).getIfcdName());
	            
	            cell = row.createCell(5);
	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
	            cell.setCellStyle(cellStyle);
	            cell.setCellValue(list.get(i).getIfcdNameEng());
     
	            cell = row.createCell(6);
	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
	            cell.setCellStyle(cellStyle);
	            if(list.get(i).getIfcdUseNy() != null) cell.setCellValue(list.get(i).getIfcdUseNy() == 0 ? "N" : "Y");
	            
	            cell = row.createCell(7);
	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
	            cell.setCellStyle(cellStyle);
	            if(list.get(i).getIfcdOrder() != null) cell.setCellValue(list.get(i).getIfcdOrder());
	            
	            cell = row.createCell(8);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	if(list.get(i).getRegDateTime() != null) cell.setCellValue(UtilDateTime.dateTimeToString(list.get(i).getRegDateTime()));
	        	
	        	cell = row.createCell(9);
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
	@RequestMapping(value = "codeInit")
	public Map<String, Object> logoutProc() throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		service.selectListCachedCodeArrayList();
		returnMap.put("rt", "success");
		return returnMap;
	}	
}