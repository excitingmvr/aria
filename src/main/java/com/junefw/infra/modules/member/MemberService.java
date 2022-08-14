package com.junefw.infra.modules.member;

import java.util.List;

public interface MemberService {

//	infrMember
	int selectOneCount(MemberVo vo) throws Exception;
	List<Member> selectList(MemberVo vo) throws Exception; 
	Member selectOne(MemberVo vo) throws Exception;
	int insert(Member dto) throws Exception;
	int update(Member dto) throws Exception; 
	int uelete(MemberVo vo) throws Exception; 
	int delete(MemberVo vo) throws Exception;
	
//	infrMemberPhone
	List<Member> selectListPhone(MemberVo vo) throws Exception; 
	
	
//	login
	Member selectOneId(Member dto) throws Exception;
	Member selectOneLogin(Member dto) throws Exception;
	
}
