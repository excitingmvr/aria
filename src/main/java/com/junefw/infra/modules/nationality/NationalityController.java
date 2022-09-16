package com.junefw.infra.modules.nationality;

import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.junefw.infra.common.base.BaseController;
import com.junefw.infra.common.constants.Constants;
import com.junefw.infra.common.util.UtilDateTime;

@Controller
@RequestMapping(value = "/nationality/")
public class NationalityController extends BaseController {

	@Autowired
	NationalityServiceImpl service;

	
	public void setSearchAndPaging(NationalityVo vo) throws Exception {
		
		vo.setShOptionDate(vo.getShOptionDate() == null ? null : vo.getShOptionDate());
		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));

		vo.setParamsPaging(service.selectOneCount(vo));
	}
	
	
	@RequestMapping(value = "nationalityList")
	public String nationalityList(@ModelAttribute("vo") NationalityVo vo, Model model) throws Exception {

		setSearchAndPaging(vo);

		if (vo.getTotalRows() > 0) {
			List<Nationality> list = service.selectList(vo);
			model.addAttribute("list", list);
		}
		
		return "infra/nationality/xdmin/nationalityList";
	}

	
	@RequestMapping(value = "nationalityForm")
	public String nationalityForm(@ModelAttribute("vo") NationalityVo vo, Model model) throws Exception {

		if (vo.getIfnaSeq().equals("0") || vo.getIfnaSeq().equals("")) {
			//	insert
		} else {
			Nationality item = service.selectOne(vo);
			model.addAttribute("item", item);
		}

		return "infra/nationality/xdmin/nationalityForm";
	}

	
	@SuppressWarnings(value = { "all" })
	@RequestMapping(value = "nationalityInst")
	public String nationalityInst(NationalityVo vo, Nationality dto, RedirectAttributes redirectAttributes) throws Exception {

		service.insert(dto);
	
		vo.setIfnaSeq(dto.getIfnaSeq());
		
		redirectAttributes.addFlashAttribute("vo", vo);

		if (Constants.INSERT_AFTER_TYPE == 1) {
			return "redirect:/nationality/nationalityForm";
		} else {
			return "redirect:/nationality/nationalityList";
		}
	}
	
	
	@SuppressWarnings(value = { "all" })
	@RequestMapping(value = "nationalityUpdt")
	public String nationalityUpdt(NationalityVo vo, Nationality dto, RedirectAttributes redirectAttributes) throws Exception {

		service.update(dto);

		redirectAttributes.addFlashAttribute("vo", vo);

		if (Constants.UPDATE_AFTER_TYPE == 1) {
			return "redirect:/nationality/nationalityForm";
		} else {
			return "redirect:/nationality/nationalityList";
		}
	}

	
	@RequestMapping(value = "nationalityUele")
	public String nationalityUele(NationalityVo vo, Nationality dto, RedirectAttributes redirectAttributes) throws Exception {
		
		service.uelete(dto);

		redirectAttributes.addFlashAttribute("vo", vo);

		return "redirect:/nationality/nationalityList";
	}

	
	@RequestMapping(value = "nationalityDele")
	public String nationalityDele(NationalityVo vo, RedirectAttributes redirectAttributes) throws Exception {

		service.delete(vo);

		redirectAttributes.addFlashAttribute("vo", vo);

		return "redirect:/nationality/nationalityList";
	}

	
	@RequestMapping(value = "nationalityMultiUele")
	public String nationalityMultiUele(NationalityVo vo, Nationality dto, RedirectAttributes redirectAttributes) throws Exception {

		for (String checkboxSeq : vo.getCheckboxSeqArray()) {
			dto.setIfnaSeq(checkboxSeq);
			service.uelete(dto);
		}

		redirectAttributes.addFlashAttribute("vo", vo);

		return "redirect:/nationality/nationalityList";
	}

	
	@RequestMapping(value = "nationalityMultiDele")
	public String nationalityMultiDele(NationalityVo vo, RedirectAttributes redirectAttributes) throws Exception {

		for (String checkboxSeq : vo.getCheckboxSeqArray()) {
			vo.setIfnaSeq(checkboxSeq);
			service.delete(vo);
		}

		redirectAttributes.addFlashAttribute("vo", vo);

		return "redirect:/nationality/nationalityList";
	}
	
	
	@RequestMapping("excelDownload")
    public void excelDownload(NationalityVo vo, HttpServletResponse httpServletResponse) throws Exception {
		
		setSearchAndPaging(vo);

		if (vo.getTotalRows() > 0) {
			List<Nationality> list = service.selectList(vo);
			
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
	        String[] tableHeader = {"Seq", "국가 이름", "국가 이름 (영문)", "국가 코드 (2자리)", "국가 코드 (3자리)", "사용", "순서", "등록일", "수정일"};

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
	            cell.setCellValue(Integer.parseInt(list.get(i).getIfnaSeq()));
	            
	            cell = row.createCell(1);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	cell.setCellValue(list.get(i).getIfnaName());
	        	
	            cell = row.createCell(2);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	cell.setCellValue(list.get(i).getIfnaNameEng());
	        	
	            cell = row.createCell(3);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	            cell.setCellValue(list.get(i).getIfnaCode2Char());
	            
	            cell = row.createCell(4);
	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
	            cell.setCellStyle(cellStyle);
	            cell.setCellValue(list.get(i).getIfnaCode3Char());
	            
	            cell = row.createCell(5);
	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
	            cell.setCellStyle(cellStyle);
	            if(list.get(i).getIfnaUseNy() != null) cell.setCellValue(list.get(i).getIfnaUseNy() == 0 ? "N" : "Y");
	            
	            cell = row.createCell(6);
	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
	            cell.setCellStyle(cellStyle);
	            if(list.get(i).getIfnaOrder() != null) cell.setCellValue(list.get(i).getIfnaOrder());	            
	            
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

}