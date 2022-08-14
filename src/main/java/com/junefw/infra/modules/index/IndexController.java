package com.junefw.infra.modules.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.junefw.infra.common.base.Base;

@Controller
@RequestMapping(value="/index/")
public class IndexController extends Base{

	@RequestMapping(value = "indexView")
	public String indexView() throws Exception {
		
		return "xdmin/index/indexView";
	}
}
