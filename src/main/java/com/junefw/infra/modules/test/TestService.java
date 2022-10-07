package com.junefw.infra.modules.test;

import java.util.List;

public interface TestService {

	public void setRegMod(Test dto) throws Exception;
	
	public int selectOneCount(TestVo vo) throws Exception;
	public List<Test> selectList(TestVo vo) throws Exception; 
	public Test selectOne(TestVo vo) throws Exception;
	public int insert(Test dto) throws Exception;
	public int update(Test dto) throws Exception; 
	public int uelete(Test dto) throws Exception; 
	public int delete(TestVo vo) throws Exception;
	
}
