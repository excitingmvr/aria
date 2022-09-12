package com.junefw.infra.modules.nationality;

import java.util.List;

public interface NationalityService {

	public void setRegMod(Nationality dto) throws Exception;
	
	public int selectOneCount(NationalityVo vo) throws Exception;
	public List<Nationality> selectList(NationalityVo vo) throws Exception; 
	public Nationality selectOne(NationalityVo vo) throws Exception;
	public int insert(Nationality dto) throws Exception;
	public int update(Nationality dto) throws Exception; 
	public int uelete(Nationality dto) throws Exception; 
	public int delete(NationalityVo vo) throws Exception;
	
}
