package com.junefw.infra.modules.codegroup;

import java.util.List;

public interface CodeGroupService {

	public int selectOneCount(CodeGroupVo vo) throws Exception;
	public List<CodeGroup> selectList(CodeGroupVo vo) throws Exception; 
	public CodeGroup selectOne(CodeGroupVo vo) throws Exception;
	public int insert(CodeGroup dto) throws Exception;
	public int update(CodeGroup dto) throws Exception;
	int uelete(CodeGroupVo vo) throws Exception; 
	int delete(CodeGroupVo vo) throws Exception;
	
}
