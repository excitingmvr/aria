package com.junefw.infra.modules.nationality;

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
public class NationalityServiceImpl extends BaseServiceImpl implements NationalityService{

	@Autowired
	NationalityDao dao;

	@Override
	public int selectOneCount(NationalityVo vo){
		return dao.selectOneCount(vo);
	}
	
	@Override
	public List<Nationality> selectList(NationalityVo vo) throws Exception {
		return dao.selectList(vo);
	}
	
	@Override
	public Nationality selectOne(NationalityVo vo) throws Exception {
		return dao.selectOne(vo);
	}
	
	@Override
	public int insert(Nationality dto) throws Exception {
		setRegMod(dto);
		return dao.insert(dto);
	}

	@Override
	public int update(Nationality dto) throws Exception {
		setRegMod(dto);
		return dao.update(dto);
	}
	
	@Override
	public int uelete(Nationality dto) throws Exception {
		setRegMod(dto);
		return dao.uelete(dto);
	}
	
	@Override
	public int delete(NationalityVo vo) throws Exception {
		return dao.delete(vo);
	}
	
	
	public void setRegMod(Nationality dto) throws Exception {
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

}
