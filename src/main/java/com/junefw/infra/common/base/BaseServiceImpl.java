package com.junefw.infra.common.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.junefw.infra.common.util.UtilDateTime;
import com.junefw.infra.common.util.UtilRegMod;
import com.junefw.infra.modules.member.Member;

public class BaseServiceImpl {

	public void setRegMod(Object dto) throws Exception {
		HttpServletRequest httpServletRequest = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		
		((Base) dto).setRegIp(UtilRegMod.getClientIp(httpServletRequest));
		
//		((Base) dto).setRegIp(UtilRegMod.getClientIp(httpServletRequest));
		
//		dto.setRegIp(UtilRegMod.getClientIp(httpServletRequest));
//		dto.setRegSeq(UtilRegMod.getSessionSeq(httpServletRequest));
//		dto.setRegDeviceCd(UtilRegMod.getDevice());
//		dto.setRegDateTime(UtilDateTime.nowDate());
//		
//		dto.setModIp(UtilRegMod.getClientIp(httpServletRequest));
//		dto.setModSeq(UtilRegMod.getSessionSeq(httpServletRequest));
//		dto.setModDeviceCd(UtilRegMod.getDevice());
//		dto.setModDateTime(UtilDateTime.nowDate());
	}

}
