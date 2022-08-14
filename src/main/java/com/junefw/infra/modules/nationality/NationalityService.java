package com.junefw.infra.modules.nationality;

import java.util.List;

public interface NationalityService {

	int selectOneCount(NationalityVo vo) throws Exception;
	List<Nationality> selectList(NationalityVo vo) throws Exception; 
	Nationality selectOne(NationalityVo vo) throws Exception;
	int insert(Nationality dto) throws Exception;
	int update(Nationality dto) throws Exception; 
	int uelete(Nationality dto) throws Exception; 
	int delete(NationalityVo vo) throws Exception;
	
}
