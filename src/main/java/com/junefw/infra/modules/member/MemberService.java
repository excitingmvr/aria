package com.junefw.infra.modules.member;

import java.util.List;

import com.junefw.infra.modules.codegroup.CodeGroup;

public interface MemberService {

	public void setRegMod(CodeGroup dto) throws Exception;

//	infrMember
	int selectOneCount(MemberVo vo) throws Exception;
	List<Member> selectList(MemberVo vo) throws Exception; 
	Member selectOne(MemberVo vo) throws Exception;
	int insert(Member dto) throws Exception;
	int update(Member dto) throws Exception; 
	int uelete(Member dto) throws Exception; 
	int delete(MemberVo vo) throws Exception;
	
	List<Member> selectListUploaded(MemberVo vo) throws Exception; 
	int selectOneIdCheck(Member dto) throws Exception;
	
	
//	infrMemberPhone
	List<Member> selectListPhone(MemberVo vo) throws Exception; 
	
	
//	login
	Member selectOneId(Member dto) throws Exception;
	Member selectOneLogin(Member dto) throws Exception;
	
}
