
package com.junefw.infra.common.constants;

public final class Constants {

//	for paging
	public static final int ROW_NUM_TO_SHOW = 10;
	public static final int PAGE_NUM_TO_SHOW = 5;

// insert 또는 update 후 페이지 전환 타입: 1:form, 2:list	
	public static final int INSERT_AFTER_TYPE = 1;		
	public static final int UPDATE_AFTER_TYPE = 1;		
	
	public static final int SESSION_MINUTE = 30;
	
	public static final String URL_LOGINFORM = "/member/loginForm";
	
	public static final String DATETIME_FORMAT_BASIC = "yyyy-MM-dd HH:mm:ss";

	public static final String TIME_FORMAT_BASIC = "HH:mm:ss";
	
	public static final int DATE_INTERVAL = -7;
	
	public static final long PASSWOPRD_CHANGE_INTERVAL = 90;
	
	public static final String UPLOAD_PATH_PREFIX = "D://factory/ws_sts_4131/alice/src/main/webapp/resources/uploaded";
	
	public static final int COOKIE_MAXAGE = 60 * 60 * 24 * 30;	//초 * 분 * 시간 * 일 : 30day
	public static final String COOKIE_DOMAIN = "";
	public static final String COOKIE_PATH = "/";
	public static final String COOKIE_NAME_SEQ = "cookieSeq";
	
}
