package com.junefw.infra.modules.code;

import java.util.List;

public interface CodeService {

	public void setRegMod(Code dto) throws Exception;
	
	public int selectOneCount(CodeVo vo) throws Exception;
	public List<Code> selectList(CodeVo vo) throws Exception; 
	public Code selectOne(CodeVo vo) throws Exception;
	public int insert(Code dto) throws Exception;
	public int update(Code dto) throws Exception;
	public int uelete(CodeVo vo) throws Exception; 
	public int delete(CodeVo vo) throws Exception;	
	
}
