package com.junefw.infra.modules.member;

import java.io.Serializable;

import com.junefw.infra.common.base.BaseVo;

public class MemberVo extends BaseVo implements Serializable{

	private static final long serialVersionUID = 717598492426181310L;

//	seq (mandotory)
	private String ifmmSeq;

	private Integer shAdminNy;
//-----------
	public String getIfmmSeq() {
		return ifmmSeq;
	}

	public void setIfmmSeq(String ifmmSeq) {
		this.ifmmSeq = ifmmSeq;
	}

	public Integer getShAdminNy() {
		return shAdminNy;
	}

	public void setShAdminNy(Integer shAdminNy) {
		this.shAdminNy = shAdminNy;
	}


	

	
}
