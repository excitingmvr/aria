package com.junefw.infra.modules.codegroup;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class CodeGroupDao {
	  
	@Inject
	@Resource(name = "sqlSession")
	private SqlSession sqlSession;
	
	private static String namespace = "com.junefw.infra.modules.codegroup.CodeGroupMpp";

	public int selectOneCount(CodeGroupVo vo) { return sqlSession.selectOne(namespace + ".selectOneCount", vo); }
	public List<CodeGroup> selectList(CodeGroupVo vo){ return sqlSession.selectList(namespace + ".selectList", vo); }
	public CodeGroup selectOne(CodeGroupVo vo) { return sqlSession.selectOne(namespace + ".selectOne", vo); }
	public int insert(CodeGroup dto) { return sqlSession.insert(namespace + ".insert", dto); }
	public int update(CodeGroup dto) { return sqlSession.update(namespace + ".update", dto); }
	public int uelete(CodeGroupVo vo) { return sqlSession.update(namespace + ".uelete", vo); }
	public int delete(CodeGroupVo vo) { return sqlSession.delete(namespace + ".delete", vo); }
	
//	for cache
	public List<CodeGroup> selectListCachedCodeArrayList(){ return sqlSession.selectList(namespace + ".selectListCachedCodeArrayList", null); }
}
