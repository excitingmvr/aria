package com.junefw.infra.modules.codegroup;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.junefw.infra.common.base.BaseServiceImpl;
import com.junefw.infra.common.util.UtilDateTime;
import com.junefw.infra.common.util.UtilRegMod;

@Service
public class CodeGroupServiceImpl extends BaseServiceImpl implements CodeGroupService{

	@Autowired
	CodeGroupDao dao;
	
	@Override
	public void setRegMod(CodeGroup dto) throws Exception {
		HttpServletRequest httpServletRequest = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		
		dto.setRegIp(UtilRegMod.getClientIp(httpServletRequest));
		dto.setRegSeq(UtilRegMod.getSessionSeq(httpServletRequest));
		dto.setRegDeviceCd(UtilRegMod.getDevice());
		dto.setRegDateTime(UtilDateTime.nowDate());
		
		dto.setModIp(UtilRegMod.getClientIp(httpServletRequest));
		dto.setModSeq(UtilRegMod.getSessionSeq(httpServletRequest));
		dto.setModDeviceCd(UtilRegMod.getDevice());
		dto.setModDateTime(UtilDateTime.nowDate());
	}


	@Override
	public int selectOneCount(CodeGroupVo vo) throws Exception {
		return dao.selectOneCount(vo);
	}
	
	
	@Override
	public List<CodeGroup> selectList(CodeGroupVo vo) throws Exception {
		return dao.selectList(vo);
	}
	
	
	@Override
	public CodeGroup selectOne(CodeGroupVo vo) throws Exception {
		return dao.selectOne(vo);
	}

	
	@Override
	public int insert(CodeGroup dto) throws Exception {
    	setRegMod(dto);
		return dao.insert(dto);
	}

	
	@Override
	public int update(CodeGroup dto) throws Exception {
		setRegMod(dto);
		return dao.update(dto);
	}
	
	
	@Override
	public int uelete(CodeGroup dto) throws Exception {
		setRegMod(dto);
		return dao.uelete(dto);
	}
	
	
	@Override
	public int delete(CodeGroupVo vo) throws Exception {
		return dao.delete(vo);
	}


	@Override
	public List<CodeGroup> selectListWithoutPaging() throws Exception {
		return dao.selectListWithoutPaging();
	}
	
}
