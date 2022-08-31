package com.junefw.infra.modules.codegroup;

import java.util.List;

public interface CodeGroupService {

	public void setRegMod(CodeGroup dto) throws Exception;
	
	public int selectOneCount(CodeGroupVo vo) throws Exception;
	public List<CodeGroup> selectList(CodeGroupVo vo) throws Exception; 
	public CodeGroup selectOne(CodeGroupVo vo) throws Exception;
	public int insert(CodeGroup dto) throws Exception;
	public int update(CodeGroup dto) throws Exception;
	public int uelete(CodeGroupVo vo) throws Exception; 
	public int delete(CodeGroupVo vo) throws Exception;
	
	public List<CodeGroup> selectListWithoutPaging() throws Exception; 
}
