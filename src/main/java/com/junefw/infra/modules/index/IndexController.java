package com.junefw.infra.modules.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.junefw.infra.common.base.Base;

@Controller
public class IndexController extends Base{

	@RequestMapping(value = "/")
	public String indexView() throws Exception {

		return "infra/index/usr/indexUsrView";
	}
}
