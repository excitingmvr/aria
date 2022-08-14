package com.junefw.infra.modules.code;

import java.util.List;

public interface CodeService {

	public int selectOneCount(Code code) throws Exception;
	public List<Code> selectList(Code code) throws Exception; 
	public Code selectOne(Code code) throws Exception;
	public int insert(Code code) throws Exception;
	public int update(Code code) throws Exception;
	
}
