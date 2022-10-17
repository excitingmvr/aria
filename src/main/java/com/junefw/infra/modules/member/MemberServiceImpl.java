package com.junefw.infra.modules.member;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.junefw.infra.common.base.BaseServiceImpl;
import com.junefw.infra.common.constants.Constants;
import com.junefw.infra.common.util.UtilDateTime;
import com.junefw.infra.common.util.UtilMail;
import com.junefw.infra.common.util.UtilRegMod;
import com.junefw.infra.common.util.UtilSecurity;


@Service
public class MemberServiceImpl extends BaseServiceImpl implements MemberService{

	@Autowired
	MemberDao dao;
	
	
	@Override
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


	
	public void uploadFiles(MultipartFile[] multipartFiles, Member dto, String tableName, int type, Integer[] sorts) throws Exception {

		System.out.println(" dto.getUploadImgMaxNumber() : " + dto.getUploadImgMaxNumber());
		
		for(int i=0; i<multipartFiles.length; i++) {
    	
			if(!multipartFiles[i].isEmpty()) {
				
				System.out.println(i + ": multipartFiles[i].getOriginalFilename() : " + multipartFiles[i].getOriginalFilename());
				
				String className = dto.getClass().getSimpleName().toString().toLowerCase();		
				String fileName = multipartFiles[i].getOriginalFilename();
				String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
				String uuid = UUID.randomUUID().toString();
				String uuidFileName = uuid + "." + ext;
				String pathModule = className;
				String nowString = UtilDateTime.nowString();
				String pathDate = nowString.substring(0,4) + "/" + nowString.substring(5,7) + "/" + nowString.substring(8,10); 
				String path = Constants.UPLOAD_PATH_PREFIX + "/" + pathModule + "/" + pathDate + "/";
				String pathForView = Constants.UPLOAD_PATH_PREFIX_FOR_VIEW + "/" + pathModule + "/" + pathDate + "/";
				
				File uploadPath = new File(path);
				
				if (!uploadPath.exists()) {
					uploadPath.mkdir();
				} else {
					// by pass
				}
				  
				multipartFiles[i].transferTo(new File(path + uuidFileName));
				
				dto.setPath(pathForView);
				dto.setOriginalName(fileName);
				dto.setUuidName(uuidFileName);
				dto.setExt(ext);
				dto.setSize(multipartFiles[i].getSize());
				
				dto.setTableName(tableName);
				dto.setType(type);
//				dto.setDefaultNy(j == 0 ? 1 : 0);
//				dto.setSort(j + 1);
//				dto.setSort(sorts[i]);
				dto.setSort(dto.get)
				dto.setPseq(dto.getIfmmSeq());

				dao.insertUploaded(dto);
    		}
		}
	}

	
	@Override
	public void deleteFiles(String[] deleteSeq, String[] deletePathFile, Member dto, String tableName) throws Exception{
		
		for (int i=0; i<deleteSeq.length; i++) {
			File file = new File(Constants.UPLOAD_PATH_PREFIX_EXTERNAL + deletePathFile[i]);
            boolean result = file.delete();
            
            if(result) {
            	dto.setSeq(deleteSeq[i]);
            	dto.setTableName(tableName);
            	dao.deleteUploaded(dto);
            }
		}
	}
	
	
	@Override
	public void ueleteFiles(String[] deleteSeq, String[] deletePathFile, Member dto, String tableName) throws Exception{
		
		for (int i=0; i<deleteSeq.length; i++) {
//			File file = new File(Constants.UPLOAD_PATH_PREFIX_EXTERNAL + deletePathFile[i]);
//			boolean result = file.delete();
			
//			if(result) {
				dto.setSeq(deleteSeq[i]);
				dto.setTableName(tableName);
				dao.ueleteUploaded(dto);
//			}
		}
	}
	

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
	    	
    	setRegMod(dto);
    	
    	dto.setIfmmPassword(UtilSecurity.encryptSha256(dto.getIfmmPassword()));
    	dto.setIfmmName(dto.getIfmmLastName() + dto.getIfmmFirstName());
    	dto.setIfmmPwdModDate(UtilDateTime.nowDate());
    	dao.insert(dto);
    	
    	uploadFiles(dto.getUploadImgProfile(), dto, "infrMemberUploaded", 1, dto.getUploadImgProfileSort());
    	uploadFiles(dto.getUploadImg(), dto, "infrMemberUploaded", 2, dto.getUploadImgSort());
    	uploadFiles(dto.getUploadFile(), dto, "infrMemberUploaded", 3, dto.getUploadFileSort());
	
    	// infrMemberEmail
		for(int i = 0 ; i < dto.getIfmeEmailFullArray().length ; i++) {
			dto.setIfmeDefaultNy(dto.getIfmeDefaultNyArray()[i]);
			dto.setIfmeTypeCd(dto.getIfmeTypeCdArray()[i]);
			dto.setIfmeEmailFull(dto.getIfmeEmailFullArray()[i]);
			dao.insertEmail(dto);
		}
    	
		// infrMemberPhone
		for(int i = 0 ; i < dto.getIfmpNumberArray().length ; i++) {
			if(!dto.getIfmpNumberArray()[i].isEmpty()) {	 
				dto.setIfmpDefaultNy(dto.getIfmpDefaultNyArray()[i]);
				dto.setIfmpTypeCd(dto.getIfmpTypeCdArray()[i]);
				dto.setIfmpDeviceCd(dto.getIfmpDeviceCdArray()[i]);
				dto.setIfmpTelecomCd(dto.getIfmpTelecomCdArray()[i]);
				dto.setIfmpNumber(dto.getIfmpNumberArray()[i]);
				dao.insertPhone(dto);
			}
		}
		
//			infrMemberAddress
		if (dto.getIfmaZipcodeArray().length >= 1) {
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
		} else {
			// by pass
		}
		
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				UtilMail.sendMail();
			}
		});
		
		thread.start();
		
		return 1;
	}
	
	
	@Override
	public int update(Member dto) throws Exception {
		
		setRegMod(dto);
    	
		dto.setIfmmName(dto.getIfmmLastName() + dto.getIfmmFirstName());
		dao.update(dto);
		
		deleteFiles(dto.getUploadImgDeleteSeq(), dto.getUploadImgDeletePathFile(), dto, "infrMemberUploaded");
		uploadFiles(dto.getUploadImg(), dto, "infrMemberUploaded", 2, dto.getUploadImgSort());

		return 1;
	}
	
	@Override
	public int uelete(Member dto) throws Exception {
		setRegMod(dto);
		return dao.uelete(dto);
	}
	
	@Override
	public int delete(MemberVo vo) throws Exception {
		return dao.delete(vo);
	}
	
	@Override
	public List<Member> selectListUploaded(MemberVo vo) throws Exception {
		return dao.selectListUploaded(vo);
	}
	
	@Override
	public int selectOneIdCheck(Member dto) throws Exception {
		return dao.selectOneIdCheck(dto);
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
