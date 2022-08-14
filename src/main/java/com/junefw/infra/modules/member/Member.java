package com.junefw.infra.modules.member;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.junefw.infra.common.base.Base;


public class Member extends Base{
	
	private Boolean autoLogin;

//	infrMember	
	private String ifmmSeq;
	private Integer ifmmAdminNy;
	private Integer ifmmDormancyNy;
	private String ifmmName;
	private String ifmmNameEng;
	private String ifmmLastName;
	private String ifmmFirstName;
	private String ifmmLastNameEng;
	private String ifmmFirstNameEng;
	private String ifmmId;
	private String ifmmPassword;
	private Date ifmmPwdModDate;
	private String ifmmNickname;
	private Integer ifmmGenderCd;
	private String ifmmDob;
	private Integer ifmmSavedCd;
	private Integer ifmmMarriageCd;
	private String ifmmMarriageDate;
	private Integer ifmmChildrenNum;
	private String ifmmFavoriteColor;
	private String ifmmRecommenderSeq;
	private Integer ifmmEmailConsentNy;
	private Integer ifmmSmsConsentNy;
	private Integer ifmmPushConsentNy;
	private String ifmmDesc;
	private Integer ifmmDelNy;

	
//	infrMemberEmail
	private String ifmeSeq;
	private Integer ifmeDefaultNy;
	private Integer ifmeTypeCd;
	private String ifmeEmailFull;
	private String ifmeEmailAccount;
	private String ifmeEmailDomain;
	private String ifmeEmailDomainCd;
	private Integer ifmeDelNy;
//	private String ifmmSeq;
	
	
//	infrMemberEmailArray
//	private String ifmeSeq;
	private Integer[] ifmeDefaultNyArray;
	private Integer[] ifmeTypeCdArray;
	private String[] ifmeEmailFullArray;
	private String[] ifmeEmailAccountArray;
	private String[] ifmeEmailDomainArray;
	private String[] ifmeEmailDomainCdArray;
	private Integer[] ifmeDelNyArray;
//	private String ifmmSeq;
	
	
//	infrMemberPhone
	private String ifmpSeq;
	private Integer ifmpDefaultNy;
	private Integer ifmpTypeCd;
	private Integer ifmpDeviceCd;
	private Integer ifmpTelecomCd;
	private String ifmpNumber;
	private Integer ifmpDelNy;
//	private String ifmmSeq;
	

//	infrMemberPhoneArray
//	private String ifmpSeq;
	private Integer[] ifmpDefaultNyArray;
	private Integer[] ifmpTypeCdArray;
	private Integer[] ifmpDeviceCdArray;
	private Integer[] ifmpTelecomCdArray;
	private String[] ifmpNumberArray;
	private Integer[] ifmpDelNyArray;
//	private String ifmmSeq;
	
	
//	infrMemberAddress
	private String ifmaSeq;
	private Integer ifmaDefaultNy;
	private Integer ifmaTypeCd;
	private String ifmaTitle;
	private String ifmaAddress1;
	private String ifmaAddress2;
	private String ifmaAddress3;
	private String ifmaZipcode;
	private Double ifmaLat;
	private Double ifmaLng;
	private Integer ifmaDelNy;
	
	
//	infrMemberAddressArray
//	private String ifmaSeq;
	private Integer[] ifmaDefaultNyArray;
	private Integer[] ifmaTypeCdArray;
	private String[] ifmaTitleArray;
	private String[] ifmaAddress1Array;
	private String[] ifmaAddress2Array;
	private String[] ifmaAddress3Array;
	private String[] ifmaZipcodeArray;
	private Double[] ifmaLatArray;
	private Double[] ifmaLngArray;	
	private Integer[] ifmaDelNyArray;
	
	
//	infrLogLogin
	private String iflgSeq;
//	private Integer ifmmId;
//	private Integer ifmmSeq;
	private Integer iflgResultNy;
	private Integer iflgDelNy;
	
	private MultipartFile[] file0;		// memberForm.image
	private MultipartFile[] file1;		// memberForm.file
//	----------
	public Boolean getAutoLogin() {
		return autoLogin;
	}
	public void setAutoLogin(Boolean autoLogin) {
		this.autoLogin = autoLogin;
	}
	public String getIfmmSeq() {
		return ifmmSeq;
	}
	public void setIfmmSeq(String ifmmSeq) {
		this.ifmmSeq = ifmmSeq;
	}
	public Integer getIfmmAdminNy() {
		return ifmmAdminNy;
	}
	public void setIfmmAdminNy(Integer ifmmAdminNy) {
		this.ifmmAdminNy = ifmmAdminNy;
	}
	public Integer getIfmmDormancyNy() {
		return ifmmDormancyNy;
	}
	public void setIfmmDormancyNy(Integer ifmmDormancyNy) {
		this.ifmmDormancyNy = ifmmDormancyNy;
	}
	public String getIfmmName() {
		return ifmmName;
	}
	public void setIfmmName(String ifmmName) {
		this.ifmmName = ifmmName;
	}
	public String getIfmmNameEng() {
		return ifmmNameEng;
	}
	public void setIfmmNameEng(String ifmmNameEng) {
		this.ifmmNameEng = ifmmNameEng;
	}
	public String getIfmmLastName() {
		return ifmmLastName;
	}
	public void setIfmmLastName(String ifmmLastName) {
		this.ifmmLastName = ifmmLastName;
	}
	public String getIfmmFirstName() {
		return ifmmFirstName;
	}
	public void setIfmmFirstName(String ifmmFirstName) {
		this.ifmmFirstName = ifmmFirstName;
	}
	public String getIfmmLastNameEng() {
		return ifmmLastNameEng;
	}
	public void setIfmmLastNameEng(String ifmmLastNameEng) {
		this.ifmmLastNameEng = ifmmLastNameEng;
	}
	public String getIfmmFirstNameEng() {
		return ifmmFirstNameEng;
	}
	public void setIfmmFirstNameEng(String ifmmFirstNameEng) {
		this.ifmmFirstNameEng = ifmmFirstNameEng;
	}
	public String getIfmmId() {
		return ifmmId;
	}
	public void setIfmmId(String ifmmId) {
		this.ifmmId = ifmmId;
	}
	public String getIfmmPassword() {
		return ifmmPassword;
	}
	public void setIfmmPassword(String ifmmPassword) {
		this.ifmmPassword = ifmmPassword;
	}
	public Date getIfmmPwdModDate() {
		return ifmmPwdModDate;
	}
	public void setIfmmPwdModDate(Date ifmmPwdModDate) {
		this.ifmmPwdModDate = ifmmPwdModDate;
	}
	public String getIfmmNickname() {
		return ifmmNickname;
	}
	public void setIfmmNickname(String ifmmNickname) {
		this.ifmmNickname = ifmmNickname;
	}
	public Integer getIfmmGenderCd() {
		return ifmmGenderCd;
	}
	public void setIfmmGenderCd(Integer ifmmGenderCd) {
		this.ifmmGenderCd = ifmmGenderCd;
	}
	public String getIfmmDob() {
		return ifmmDob;
	}
	public void setIfmmDob(String ifmmDob) {
		this.ifmmDob = ifmmDob;
	}
	public Integer getIfmmSavedCd() {
		return ifmmSavedCd;
	}
	public void setIfmmSavedCd(Integer ifmmSavedCd) {
		this.ifmmSavedCd = ifmmSavedCd;
	}
	public Integer getIfmmMarriageCd() {
		return ifmmMarriageCd;
	}
	public void setIfmmMarriageCd(Integer ifmmMarriageCd) {
		this.ifmmMarriageCd = ifmmMarriageCd;
	}
	public String getIfmmMarriageDate() {
		return ifmmMarriageDate;
	}
	public void setIfmmMarriageDate(String ifmmMarriageDate) {
		this.ifmmMarriageDate = ifmmMarriageDate;
	}
	public Integer getIfmmChildrenNum() {
		return ifmmChildrenNum;
	}
	public void setIfmmChildrenNum(Integer ifmmChildrenNum) {
		this.ifmmChildrenNum = ifmmChildrenNum;
	}
	public String getIfmmFavoriteColor() {
		return ifmmFavoriteColor;
	}
	public void setIfmmFavoriteColor(String ifmmFavoriteColor) {
		this.ifmmFavoriteColor = ifmmFavoriteColor;
	}
	public String getIfmmRecommenderSeq() {
		return ifmmRecommenderSeq;
	}
	public void setIfmmRecommenderSeq(String ifmmRecommenderSeq) {
		this.ifmmRecommenderSeq = ifmmRecommenderSeq;
	}
	public Integer getIfmmEmailConsentNy() {
		return ifmmEmailConsentNy;
	}
	public void setIfmmEmailConsentNy(Integer ifmmEmailConsentNy) {
		this.ifmmEmailConsentNy = ifmmEmailConsentNy;
	}
	public Integer getIfmmSmsConsentNy() {
		return ifmmSmsConsentNy;
	}
	public void setIfmmSmsConsentNy(Integer ifmmSmsConsentNy) {
		this.ifmmSmsConsentNy = ifmmSmsConsentNy;
	}
	public Integer getIfmmPushConsentNy() {
		return ifmmPushConsentNy;
	}
	public void setIfmmPushConsentNy(Integer ifmmPushConsentNy) {
		this.ifmmPushConsentNy = ifmmPushConsentNy;
	}
	public String getIfmmDesc() {
		return ifmmDesc;
	}
	public void setIfmmDesc(String ifmmDesc) {
		this.ifmmDesc = ifmmDesc;
	}
	public Integer getIfmmDelNy() {
		return ifmmDelNy;
	}
	public void setIfmmDelNy(Integer ifmmDelNy) {
		this.ifmmDelNy = ifmmDelNy;
	}
	public String getIfmeSeq() {
		return ifmeSeq;
	}
	public void setIfmeSeq(String ifmeSeq) {
		this.ifmeSeq = ifmeSeq;
	}
	public Integer getIfmeDefaultNy() {
		return ifmeDefaultNy;
	}
	public void setIfmeDefaultNy(Integer ifmeDefaultNy) {
		this.ifmeDefaultNy = ifmeDefaultNy;
	}
	public Integer getIfmeTypeCd() {
		return ifmeTypeCd;
	}
	public void setIfmeTypeCd(Integer ifmeTypeCd) {
		this.ifmeTypeCd = ifmeTypeCd;
	}
	public String getIfmeEmailFull() {
		return ifmeEmailFull;
	}
	public void setIfmeEmailFull(String ifmeEmailFull) {
		this.ifmeEmailFull = ifmeEmailFull;
	}
	public String getIfmeEmailAccount() {
		return ifmeEmailAccount;
	}
	public void setIfmeEmailAccount(String ifmeEmailAccount) {
		this.ifmeEmailAccount = ifmeEmailAccount;
	}
	public String getIfmeEmailDomain() {
		return ifmeEmailDomain;
	}
	public void setIfmeEmailDomain(String ifmeEmailDomain) {
		this.ifmeEmailDomain = ifmeEmailDomain;
	}
	public String getIfmeEmailDomainCd() {
		return ifmeEmailDomainCd;
	}
	public void setIfmeEmailDomainCd(String ifmeEmailDomainCd) {
		this.ifmeEmailDomainCd = ifmeEmailDomainCd;
	}
	public Integer getIfmeDelNy() {
		return ifmeDelNy;
	}
	public void setIfmeDelNy(Integer ifmeDelNy) {
		this.ifmeDelNy = ifmeDelNy;
	}
	public Integer[] getIfmeDefaultNyArray() {
		return ifmeDefaultNyArray;
	}
	public void setIfmeDefaultNyArray(Integer[] ifmeDefaultNyArray) {
		this.ifmeDefaultNyArray = ifmeDefaultNyArray;
	}
	public Integer[] getIfmeTypeCdArray() {
		return ifmeTypeCdArray;
	}
	public void setIfmeTypeCdArray(Integer[] ifmeTypeCdArray) {
		this.ifmeTypeCdArray = ifmeTypeCdArray;
	}
	public String[] getIfmeEmailFullArray() {
		return ifmeEmailFullArray;
	}
	public void setIfmeEmailFullArray(String[] ifmeEmailFullArray) {
		this.ifmeEmailFullArray = ifmeEmailFullArray;
	}
	public String[] getIfmeEmailAccountArray() {
		return ifmeEmailAccountArray;
	}
	public void setIfmeEmailAccountArray(String[] ifmeEmailAccountArray) {
		this.ifmeEmailAccountArray = ifmeEmailAccountArray;
	}
	public String[] getIfmeEmailDomainArray() {
		return ifmeEmailDomainArray;
	}
	public void setIfmeEmailDomainArray(String[] ifmeEmailDomainArray) {
		this.ifmeEmailDomainArray = ifmeEmailDomainArray;
	}
	public String[] getIfmeEmailDomainCdArray() {
		return ifmeEmailDomainCdArray;
	}
	public void setIfmeEmailDomainCdArray(String[] ifmeEmailDomainCdArray) {
		this.ifmeEmailDomainCdArray = ifmeEmailDomainCdArray;
	}
	public Integer[] getIfmeDelNyArray() {
		return ifmeDelNyArray;
	}
	public void setIfmeDelNyArray(Integer[] ifmeDelNyArray) {
		this.ifmeDelNyArray = ifmeDelNyArray;
	}
	public String getIfmpSeq() {
		return ifmpSeq;
	}
	public void setIfmpSeq(String ifmpSeq) {
		this.ifmpSeq = ifmpSeq;
	}
	public Integer getIfmpDefaultNy() {
		return ifmpDefaultNy;
	}
	public void setIfmpDefaultNy(Integer ifmpDefaultNy) {
		this.ifmpDefaultNy = ifmpDefaultNy;
	}
	public Integer getIfmpTypeCd() {
		return ifmpTypeCd;
	}
	public void setIfmpTypeCd(Integer ifmpTypeCd) {
		this.ifmpTypeCd = ifmpTypeCd;
	}
	public Integer getIfmpDeviceCd() {
		return ifmpDeviceCd;
	}
	public void setIfmpDeviceCd(Integer ifmpDeviceCd) {
		this.ifmpDeviceCd = ifmpDeviceCd;
	}
	public Integer getIfmpTelecomCd() {
		return ifmpTelecomCd;
	}
	public void setIfmpTelecomCd(Integer ifmpTelecomCd) {
		this.ifmpTelecomCd = ifmpTelecomCd;
	}
	public String getIfmpNumber() {
		return ifmpNumber;
	}
	public void setIfmpNumber(String ifmpNumber) {
		this.ifmpNumber = ifmpNumber;
	}
	public Integer getIfmpDelNy() {
		return ifmpDelNy;
	}
	public void setIfmpDelNy(Integer ifmpDelNy) {
		this.ifmpDelNy = ifmpDelNy;
	}
	public Integer[] getIfmpDefaultNyArray() {
		return ifmpDefaultNyArray;
	}
	public void setIfmpDefaultNyArray(Integer[] ifmpDefaultNyArray) {
		this.ifmpDefaultNyArray = ifmpDefaultNyArray;
	}
	public Integer[] getIfmpTypeCdArray() {
		return ifmpTypeCdArray;
	}
	public void setIfmpTypeCdArray(Integer[] ifmpTypeCdArray) {
		this.ifmpTypeCdArray = ifmpTypeCdArray;
	}
	public Integer[] getIfmpDeviceCdArray() {
		return ifmpDeviceCdArray;
	}
	public void setIfmpDeviceCdArray(Integer[] ifmpDeviceCdArray) {
		this.ifmpDeviceCdArray = ifmpDeviceCdArray;
	}
	public Integer[] getIfmpTelecomCdArray() {
		return ifmpTelecomCdArray;
	}
	public void setIfmpTelecomCdArray(Integer[] ifmpTelecomCdArray) {
		this.ifmpTelecomCdArray = ifmpTelecomCdArray;
	}
	public String[] getIfmpNumberArray() {
		return ifmpNumberArray;
	}
	public void setIfmpNumberArray(String[] ifmpNumberArray) {
		this.ifmpNumberArray = ifmpNumberArray;
	}
	public Integer[] getIfmpDelNyArray() {
		return ifmpDelNyArray;
	}
	public void setIfmpDelNyArray(Integer[] ifmpDelNyArray) {
		this.ifmpDelNyArray = ifmpDelNyArray;
	}
	public String getIfmaSeq() {
		return ifmaSeq;
	}
	public void setIfmaSeq(String ifmaSeq) {
		this.ifmaSeq = ifmaSeq;
	}
	public Integer getIfmaDefaultNy() {
		return ifmaDefaultNy;
	}
	public void setIfmaDefaultNy(Integer ifmaDefaultNy) {
		this.ifmaDefaultNy = ifmaDefaultNy;
	}
	public Integer getIfmaTypeCd() {
		return ifmaTypeCd;
	}
	public void setIfmaTypeCd(Integer ifmaTypeCd) {
		this.ifmaTypeCd = ifmaTypeCd;
	}
	public String getIfmaTitle() {
		return ifmaTitle;
	}
	public void setIfmaTitle(String ifmaTitle) {
		this.ifmaTitle = ifmaTitle;
	}
	public String getIfmaAddress1() {
		return ifmaAddress1;
	}
	public void setIfmaAddress1(String ifmaAddress1) {
		this.ifmaAddress1 = ifmaAddress1;
	}
	public String getIfmaAddress2() {
		return ifmaAddress2;
	}
	public void setIfmaAddress2(String ifmaAddress2) {
		this.ifmaAddress2 = ifmaAddress2;
	}
	public String getIfmaAddress3() {
		return ifmaAddress3;
	}
	public void setIfmaAddress3(String ifmaAddress3) {
		this.ifmaAddress3 = ifmaAddress3;
	}
	public String getIfmaZipcode() {
		return ifmaZipcode;
	}
	public void setIfmaZipcode(String ifmaZipcode) {
		this.ifmaZipcode = ifmaZipcode;
	}
	public Double getIfmaLat() {
		return ifmaLat;
	}
	public void setIfmaLat(Double ifmaLat) {
		this.ifmaLat = ifmaLat;
	}
	public Double getIfmaLng() {
		return ifmaLng;
	}
	public void setIfmaLng(Double ifmaLng) {
		this.ifmaLng = ifmaLng;
	}
	public Integer getIfmaDelNy() {
		return ifmaDelNy;
	}
	public void setIfmaDelNy(Integer ifmaDelNy) {
		this.ifmaDelNy = ifmaDelNy;
	}
	public Integer[] getIfmaDefaultNyArray() {
		return ifmaDefaultNyArray;
	}
	public void setIfmaDefaultNyArray(Integer[] ifmaDefaultNyArray) {
		this.ifmaDefaultNyArray = ifmaDefaultNyArray;
	}
	public Integer[] getIfmaTypeCdArray() {
		return ifmaTypeCdArray;
	}
	public void setIfmaTypeCdArray(Integer[] ifmaTypeCdArray) {
		this.ifmaTypeCdArray = ifmaTypeCdArray;
	}
	public String[] getIfmaTitleArray() {
		return ifmaTitleArray;
	}
	public void setIfmaTitleArray(String[] ifmaTitleArray) {
		this.ifmaTitleArray = ifmaTitleArray;
	}
	public String[] getIfmaAddress1Array() {
		return ifmaAddress1Array;
	}
	public void setIfmaAddress1Array(String[] ifmaAddress1Array) {
		this.ifmaAddress1Array = ifmaAddress1Array;
	}
	public String[] getIfmaAddress2Array() {
		return ifmaAddress2Array;
	}
	public void setIfmaAddress2Array(String[] ifmaAddress2Array) {
		this.ifmaAddress2Array = ifmaAddress2Array;
	}
	public String[] getIfmaAddress3Array() {
		return ifmaAddress3Array;
	}
	public void setIfmaAddress3Array(String[] ifmaAddress3Array) {
		this.ifmaAddress3Array = ifmaAddress3Array;
	}
	public String[] getIfmaZipcodeArray() {
		return ifmaZipcodeArray;
	}
	public void setIfmaZipcodeArray(String[] ifmaZipcodeArray) {
		this.ifmaZipcodeArray = ifmaZipcodeArray;
	}
	public Double[] getIfmaLatArray() {
		return ifmaLatArray;
	}
	public void setIfmaLatArray(Double[] ifmaLatArray) {
		this.ifmaLatArray = ifmaLatArray;
	}
	public Double[] getIfmaLngArray() {
		return ifmaLngArray;
	}
	public void setIfmaLngArray(Double[] ifmaLngArray) {
		this.ifmaLngArray = ifmaLngArray;
	}
	public Integer[] getIfmaDelNyArray() {
		return ifmaDelNyArray;
	}
	public void setIfmaDelNyArray(Integer[] ifmaDelNyArray) {
		this.ifmaDelNyArray = ifmaDelNyArray;
	}
	public String getIflgSeq() {
		return iflgSeq;
	}
	public void setIflgSeq(String iflgSeq) {
		this.iflgSeq = iflgSeq;
	}
	public Integer getIflgResultNy() {
		return iflgResultNy;
	}
	public void setIflgResultNy(Integer iflgResultNy) {
		this.iflgResultNy = iflgResultNy;
	}
	public Integer getIflgDelNy() {
		return iflgDelNy;
	}
	public void setIflgDelNy(Integer iflgDelNy) {
		this.iflgDelNy = iflgDelNy;
	}
	public MultipartFile[] getFile0() {
		return file0;
	}
	public void setFile0(MultipartFile[] file0) {
		this.file0 = file0;
	}
	public MultipartFile[] getFile1() {
		return file1;
	}
	public void setFile1(MultipartFile[] file1) {
		this.file1 = file1;
	}
	
}