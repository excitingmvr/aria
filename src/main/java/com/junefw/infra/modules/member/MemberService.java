package com.junefw.infra.modules.member;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface MemberService {

	public void setRegMod(Member dto) throws Exception;
	public void uploadFiles(MultipartFile[] multipartFiles, Member dto, String tableName, int type) throws Exception;

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
