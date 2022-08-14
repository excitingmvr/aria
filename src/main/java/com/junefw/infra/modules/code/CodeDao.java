package com.junefw.infra.modules.code;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class CodeDao {
	  
	@Inject
	@Resource(name = "sqlSession")
	private SqlSession sqlSession;
	
	private static String namespace = "com.junefw.infra.modules.code.CodeMpp";

	public int selectOneCount(Code code) { return sqlSession.selectOne(namespace + ".selectOneCount", code); }
	public List<Code> selectList(Code code){ return sqlSession.selectList(namespace + ".selectList", code); }
	public Code selectOne(Code code) { return sqlSession.selectOne(namespace + ".selectOne", code); }
	public int insert(Code code) { return sqlSession.insert(namespace + ".insert", code); }
	public int update(Code code) { return sqlSession.update(namespace + ".update", code); }
	
//	for cache
	public List<Code> selectListCachedCodeArrayList(){ return sqlSession.selectList(namespace + ".selectListCachedCodeArrayList", null); }
}
