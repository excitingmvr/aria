
package com.junefw.location.modules.location;

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
@RequestMapping(value = "/location/")
public class LocationController extends BaseController {

	@Autowired
	LocationServiceImpl service;

	public void setSearch(LocationVo vo) throws Exception {
		
		vo.setShUseNy(vo.getShUseNy() == null ? 1 : vo.getShUseNy());
		vo.setShDelNy(vo.getShDelNy() == null ? 0 : vo.getShDelNy());
		vo.setShOptionDate(vo.getShOptionDate() == null ? null : vo.getShOptionDate());
		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));
	}
	
	@RequestMapping(value = "locationList")
	public String locationList(@ModelAttribute("vo") LocationVo vo, Model model) throws Exception {

		setSearch(vo);
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
			List<Location> list = service.selectList(vo);
			model.addAttribute("list", list);
		}

		return "location/location/xdmin/locationList";
	}
	
	
	@RequestMapping(value = "locationAjaxList")
	public String locationAjaxList(@ModelAttribute("vo") LocationVo vo, Model model) throws Exception {
		
		setSearch(vo);

		return "location/location/xdmin/locationAjaxList";
	}
	
	
	@RequestMapping(value = "locationAjaxLita")
	public String locationLita(@ModelAttribute("vo") LocationVo vo, Model model) throws Exception {
		
		vo.setParamsPaging(service.selectOneCount(vo));

		if (vo.getTotalRows() > 0) {
			List<Location> list = service.selectList(vo);
			model.addAttribute("list", list);
		}
		
		return "location/location/xdmin/locationAjaxLita";
	}
	

	@RequestMapping(value = "locationForm")
	public String locationForm(@ModelAttribute("vo") LocationVo vo, Model model) throws Exception {

		if (vo.getLtltSeq().equals("0") || vo.getLtltSeq().equals("")) {
			//	insert
		} else {
			Location item = service.selectOne(vo);
			model.addAttribute("item", item);
		}
		
		return "location/location/xdmin/locationForm";
	}

	
	@SuppressWarnings(value = { "all" })
	@RequestMapping(value = "locationInst")
	public String locationInst(LocationVo vo, Location dto, RedirectAttributes redirectAttributes) throws Exception {

		service.insert(dto);
	
		vo.setLtltSeq(dto.getLtltSeq());
		
		redirectAttributes.addFlashAttribute("vo", vo);

		if (Constants.INSERT_AFTER_TYPE == 1) {
			return "redirect:/location/locationForm";
		} else {
			return "redirect:/location/locationAjaxList";
		}
	}
	
	
	@SuppressWarnings(value = { "all" })
	@RequestMapping(value = "locationUpdt")
	public String locationUpdt(LocationVo vo, Location dto, RedirectAttributes redirectAttributes) throws Exception {

		service.update(dto);

		redirectAttributes.addFlashAttribute("vo", vo);

		if (Constants.UPDATE_AFTER_TYPE == 1) {
			return "redirect:/location/locationForm";
		} else {
			return "redirect:/location/locationAjaxList";
		}
	}

	
	@RequestMapping(value = "locationUele")
	public String locationUele(LocationVo vo, Location dto, RedirectAttributes redirectAttributes) throws Exception {

		service.uelete(dto);

		redirectAttributes.addFlashAttribute("vo", vo);

		return "redirect:/location/locationAjaxList";
	}

	
	@RequestMapping(value = "locationDele")
	public String locationDele(LocationVo vo, RedirectAttributes redirectAttributes) throws Exception {

		service.delete(vo);

		redirectAttributes.addFlashAttribute("vo", vo);

		return "redirect:/location/locationAjaxList";
	}

	
	@RequestMapping(value = "locationMultiUele")
	public String locationMultiUele(LocationVo vo, Location dto, RedirectAttributes redirectAttributes) throws Exception {

		for (String checkboxSeq : vo.getCheckboxSeqArray()) {
			dto.setLtltSeq(checkboxSeq);
			service.uelete(dto);
		}

		redirectAttributes.addFlashAttribute("vo", vo);

		return "redirect:/location/locationAjaxList";
	}

	
	@RequestMapping(value = "locationMultiDele")
	public String locationMultiDele(LocationVo vo, RedirectAttributes redirectAttributes) throws Exception {

		for (String checkboxSeq : vo.getCheckboxSeqArray()) {
			vo.setLtltSeq(checkboxSeq);
			service.delete(vo);
		}

		redirectAttributes.addFlashAttribute("vo", vo);

		return "redirect:/location/locationAjaxList";
	}
	

	@RequestMapping("excelDownload")
    public void excelDownload(LocationVo vo, HttpServletResponse httpServletResponse) throws Exception {
		
		setSearch(vo);
		vo.setParamsPaging(service.selectOneCount(vo));

		if (vo.getTotalRows() > 0) {
			List<Location> list = service.selectList(vo);
			
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
	        String[] tableHeader = {"Seq", "?????? ??????", "?????? ?????? (??????)", "?????? ?????? (2??????)", "?????? ?????? (3??????)", "??????", "??????", "?????????", "?????????"};

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
	            
//	            cell = row.createCell(0);
//	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
//	        	cell.setCellStyle(cellStyle);
//	            cell.setCellValue(Integer.parseInt(list.get(i).getIfnaSeq()));
//	            
//	            cell = row.createCell(1);
//	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
//	        	cell.setCellStyle(cellStyle);
//	        	cell.setCellValue(list.get(i).getIfnaName());
//	        	
//	            cell = row.createCell(2);
//	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
//	        	cell.setCellStyle(cellStyle);
//	        	cell.setCellValue(list.get(i).getIfnaNameEng());
//	        	
//	            cell = row.createCell(3);
//	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
//	        	cell.setCellStyle(cellStyle);
//	            cell.setCellValue(list.get(i).getIfnaCode2Char());
//	            
//	            cell = row.createCell(4);
//	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
//	            cell.setCellStyle(cellStyle);
//	            cell.setCellValue(list.get(i).getIfnaCode3Char());
//	            
//	            cell = row.createCell(5);
//	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
//	            cell.setCellStyle(cellStyle);
//	            if(list.get(i).getIfnaUseNy() != null) cell.setCellValue(list.get(i).getIfnaUseNy() == 0 ? "N" : "Y");
//	            
//	            cell = row.createCell(6);
//	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
//	            cell.setCellStyle(cellStyle);
//	            if(list.get(i).getIfnaOrder() != null) cell.setCellValue(list.get(i).getIfnaOrder());	            
//	            
//	            cell = row.createCell(7);
//	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
//	        	cell.setCellStyle(cellStyle);
//	        	if(list.get(i).getRegDateTime() != null) cell.setCellValue(UtilDateTime.dateTimeToString(list.get(i).getRegDateTime()));
//	            
//	            cell = row.createCell(8);
//	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
//	            cell.setCellStyle(cellStyle);
//	            if(list.get(i).getModDateTime() != null) cell.setCellValue(UtilDateTime.dateTimeToString(list.get(i).getModDateTime()));
	        }

	        httpServletResponse.setContentType("ms-vnd/excel");
//	        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=example.xls");	// for xls
	        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=example.xlsx");

	        workbook.write(httpServletResponse.getOutputStream());
	        workbook.close();
		}
    }
}