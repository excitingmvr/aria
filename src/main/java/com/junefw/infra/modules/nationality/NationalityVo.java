package com.junefw.infra.modules.nationality;

import java.io.Serializable;

import com.junefw.infra.common.base.BaseVo;

public class NationalityVo extends BaseVo implements Serializable{

	private static final long serialVersionUID = -7487131550711258015L;

	//	seq (mandotory)
	private String ifnaSeq = "";

	public String getIfnaSeq() {
		return ifnaSeq;
	}

	public void setIfnaSeq(String ifnaSeq) {
		this.ifnaSeq = ifnaSeq;
	}


	
//	search item extra (optional)
//	----------
	
}
