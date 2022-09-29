package com.junefw.location.modules.location;

import java.io.Serializable;

import com.junefw.infra.common.base.BaseVo;

public class LocationVo extends BaseVo implements Serializable{

	private static final long serialVersionUID = 7402180299784279542L;

	private String ltltSeq = "";
//	----------
	public String getLtltSeq() {
		return ltltSeq;
	}
	
	public void setLtltSeq(String ltltSeq) {
		this.ltltSeq = ltltSeq;
	}
}
