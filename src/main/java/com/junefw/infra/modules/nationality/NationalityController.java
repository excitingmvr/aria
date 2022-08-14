
package com.junefw.infra.modules.nationality;

import java.util.List;

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

	@RequestMapping(value = "nationalityList")
	public String nationalityList(@ModelAttribute("vo") NationalityVo vo, Model model) throws Exception {

		vo.setShOptionDate(vo.getShOptionDate() == null ? 1 : vo.getShOptionDate());
		vo.setShDateStart(vo.getShDateStart() == null
				? UtilDateTime.calculateDayString(UtilDateTime.nowLocalDateTime(), Constants.DATE_INTERVAL)
				: UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null ? UtilDateTime.nowString()
				: UtilDateTime.addNowTimeString(vo.getShDateEnd()));

		vo.setParamsPaging(service.selectOneCount(vo));

		if (vo.getTotalRows() > 0) {
			List<Nationality> list = service.selectList(vo);
			model.addAttribute("list", list);
		}

		return "xdmin/nationality/nationalityList";
	}

	@RequestMapping(value = "nationalityForm")
	public String nationalityForm(@ModelAttribute("vo") NationalityVo vo, Model model) throws Exception {

		if (vo.getIfnaSeq().equals("0") || vo.getIfnaSeq().equals("")) {
			//	insert
		} else {
			Nationality item = service.selectOne(vo);
			model.addAttribute("item", item);
		}

		return "xdmin/nationality/nationalityForm";
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
		}

		redirectAttributes.addFlashAttribute("vo", vo);

		return "redirect:/nationality/nationalityList";
	}

}