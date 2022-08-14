package com.junefw.infra.modules.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.junefw.infra.common.base.BaseServiceImpl;
import com.junefw.infra.common.constants.Constants;
import com.junefw.infra.common.util.UtilDateTime;
import com.junefw.infra.common.util.UtilRegMod;
import com.junefw.infra.common.util.UtilUpload;


@Service
public class MemberServiceImpl extends BaseServiceImpl implements MemberService{

	@Autowired
	MemberDao dao;

	@Override
	public int selectOneCount(MemberVo vo){
		return dao.selectOneCount(vo);
	}
	
	@Override
	public List<Member> selectList(MemberVo vo) throws Exception {
		return dao.selectList(vo);
	}
	
	@Override
	public Member selectOne(MemberVo vo) throws Exception {
		return dao.selectOne(vo);
	}
	
	@Override
	public int insert(Member dto) throws Exception {
	    try {
	    	
	    	setRegMod(dto);
	    	
	    	dto.setIfmmPwdModDate(UtilDateTime.nowDate());
	    	dao.insert(dto);
	    	
	    	int j = 0;
	    	for(MultipartFile multipartFile : dto.getFile0() ) {
	    		String pathModule = this.getClass().getSimpleName().toString().toLowerCase().replace("serviceimpl", "");
	    		UtilUpload.upload(multipartFile, pathModule, dto);
	    		
	    		dto.setTableName("infrMemberUploaded");
	    		dto.setType(0);
	    		dto.setDefaultNy(0);
	    		dto.setSort(j);
	    		dto.setPseq(dto.getIfmmSeq());

				dao.insertUploaded(dto);
				j++;
	    	}
	    	
	    	j = 0;
	    	for(MultipartFile multipartFile : dto.getFile1() ) {
	    			String pathModule = this.getClass().getSimpleName().toString().toLowerCase().replace("serviceimpl", "");		
	    			UtilUpload.upload(multipartFile, pathModule, dto);
	    			
		    		dto.setTableName("infrMemberUploaded");
		    		dto.setType(1);
		    		dto.setDefaultNy(0);
		    		dto.setSort(j);
		    		dto.setPseq(dto.getIfmmSeq());

					dao.insertUploaded(dto);
					j++;
	    	}
	    	
	    	// infrMemberEmail
			for(int i = 0 ; i < dto.getIfmeEmailFullArray().length ; i++) {
				dto.setIfmeDefaultNy(dto.getIfmeDefaultNyArray()[i]);
				dto.setIfmeTypeCd(dto.getIfmeTypeCdArray()[i]);
				dto.setIfmeEmailFull(dto.getIfmeEmailFullArray()[i]);
				dao.insertEmail(dto);
			}
	    	
			// infrMemberPhone
			for(int i = 0 ; i < dto.getIfmpNumberArray().length ; i++) {
				dto.setIfmpDefaultNy(dto.getIfmpDefaultNyArray()[i]);
				dto.setIfmpTypeCd(dto.getIfmpTypeCdArray()[i]);
				dto.setIfmpDeviceCd(dto.getIfmpDeviceCdArray()[i]);
				dto.setIfmpTelecomCd(dto.getIfmpTelecomCdArray()[i]);
				dto.setIfmpNumber(dto.getIfmpNumberArray()[i]);
				dao.insertPhone(dto);
			}
			
//			infrMemberAddress
			for(int i = 0 ; i < dto.getIfmaZipcodeArray().length ; i++) {
				dto.setIfmaDefaultNy(dto.getIfmaDefaultNyArray()[i]);
				dto.setIfmaTypeCd(dto.getIfmaTypeCdArray()[i]);
				dto.setIfmaTitle(dto.getIfmaTitleArray()[i]);
				dto.setIfmaAddress1(dto.getIfmaAddress1Array()[i]);
				dto.setIfmaAddress2(dto.getIfmaAddress2Array()[i]);
				dto.setIfmaAddress3(dto.getIfmaAddress3Array()[i]);
				dto.setIfmaZipcode(dto.getIfmaZipcodeArray()[i]);
				dto.setIfmaLat(dto.getIfmaLatArray()[i]);
				dto.setIfmaLng(dto.getIfmaLngArray()[i]);
				dao.insertAddress(dto);
			}
			
			return 1;

	    } catch (Exception e) {
	        throw new Exception();
	    }
	}

	@Override
	public int update(Member dto) throws Exception {
		return dao.update(dto);
	}
	
	@Override
	public int uelete(MemberVo vo) throws Exception {
		return dao.uelete(vo);
	}
	
	@Override
	public int delete(MemberVo vo) throws Exception {
		return dao.delete(vo);
	}

//	login
	
	@Override
	public Member selectOneId(Member dto) throws Exception {
		return dao.selectOneId(dto);
	}

	@Override
	public Member selectOneLogin(Member dto) throws Exception {
		return dao.selectOneLogin(dto);
	}
	
	
	public void setRegMod(Member dto) throws Exception {
		HttpServletRequest httpServletRequest = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		
		dto.setRegIp(UtilRegMod.getClientIp(httpServletRequest));
		dto.setRegSeq(UtilRegMod.getSessionSeq(httpServletRequest));
		dto.setRegDeviceCd(UtilRegMod.getDevice());
		dto.setRegDateTime(UtilDateTime.nowDate());
		
		dto.setModIp(UtilRegMod.getClientIp(httpServletRequest));
		dto.setModSeq(UtilRegMod.getSessionSeq(httpServletRequest));
		dto.setModDeviceCd(UtilRegMod.getDevice());
		dto.setModDateTime(UtilDateTime.nowDate());
	}

	@Override
	public List<Member> selectListPhone(MemberVo vo) throws Exception {
		return dao.selectListPhone(vo);
	}
	
	
	public int insertLogLogin(Member dto) throws Exception {
		setRegMod(dto);
		return dao.insertLogLogin(dto);
	}
	
	
	public int updateIfmmPwdModDate(Member dto) throws Exception {
		dto.setIfmmPwdModDate(UtilDateTime.calculateDayDate(UtilDateTime.nowLocalDateTime(), (int) Constants.PASSWOPRD_CHANGE_INTERVAL));
		return dao.updateIfmmPwdModDate(dto);
	}


}
