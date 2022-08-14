package com.junefw.infra.modules.code;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.junefw.infra.common.base.BaseController;

@Controller
@RequestMapping(value="/code/")
public class CodeController extends BaseController{
	
	@Autowired
	CodeServiceImpl service;
		
	// CdgrSeq
	
	@RequestMapping(value = "codeGroupList")
	public ModelAndView codeGroupList(Code code, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", service.selectList(code));

		mav.setViewName("/modules/code/codeGroupList");
		return mav;
	}
	
//	@RequestMapping(value = "codeGroupForm")
//	public ModelAndView authForm(Code vo) throws Exception {
//		ModelAndView mav = new ModelAndView();
//		if (vo.getCdgrSeq() != null) {
//				vo.setCdgrSeq(base64Decoder(vo.getCdgrSeq()));
//				mav.addObject("rt", service.selectOne(vo));
//		}else {
//
//		}
//		mav.setViewName("/modules/code/codeGroupForm");
//		return mav;
//	}
//	
//	@RequestMapping(value = "codeGroupInst")
//	public String authInst(Code vo) throws Exception {
//		service.insert(vo);
//		vo.setCdgrSeq(base64Encoder(vo.getCdgrSeq()));
//		return "redirect:/code/codeGroupForm" + "?CdgrSeq=" + vo.getCdgrSeq() + makeParams(params);
//	}
	
//	@RequestMapping(value = "authUpdt")
//	public String authUpdt(Code auth, CodeParams params) throws Exception {
//		authService.update(auth);
//		auth.setAUTH_SEQ(base64Encoder(auth.getAUTH_SEQ()));
//		return "redirect:/auth/authForm" + "?AUTH_SEQ=" + auth.getAUTH_SEQ() + makeParams(params);
//	}		
	
//	/*
//	 * public String makeParams (CodeParams params) { String paramString =
//	 * "&thisPage=" + params.getThisPage(); paramString += "&rowNumToShow=" +
//	 * params.getRowNumToShow(); paramString += "&searchValue=" +
//	 * params.getSearchValue(); paramString += "&gubun=" + params.getGubun();
//	 * 
//	 * return paramString; }
//	 */
	

	
//	@RequestMapping(value = "codeGroupView")
//	public ModelAndView authView(Code vo) throws Exception {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("one", service.selectOne(vo));
//		mav.setViewName("/modules/code/codeGroupView");
//		return mav;
//	}
}