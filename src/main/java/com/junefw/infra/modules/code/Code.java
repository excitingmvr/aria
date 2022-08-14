package com.junefw.infra.modules.code;

import java.util.ArrayList;
import java.util.List;

import com.junefw.infra.common.base.Base;

public class Code extends Base {
	
//	infr_code_group
	private String ifcgSeq = "";
	private String ifcgSeqAnother = "";
	private String ifcgName = "";
	private String ifcgNameEng = "";
	private String ifcgUseNy = "";
	private String ifcgOrder = "";
	private String ifcgReferenceV1 = "";
	private String ifcgReferenceV2 = "";
	private String ifcgReferenceV3 = "";
	private String ifcgReferenceI1  = "";
	private String ifcgReferenceI2 = "";
	private String ifcgReferenceI3 = "";
	private String ifcgDesc  = "";
	private String ifcgDelNy  = "";

	
//	infr_code
	private String ifcdSeq = "";
	private String ifcdSeqAnother = "";
	private String ifcdName = "";
	private String ifcdNameEng = "";
	private String ifcdNameLang1 = "";
	private String ifcdNameLang2 = "";
	private String ifcdNameLang3 = "";
	private String ifcdNameLang4 = "";
	private String ifcdNameLang5 = "";
	private String ifcdUseNy = "";
	private String ifcdOrder = "";
	private String ifcdReferenceV1 = "";
	private String ifcdReferenceV2 = "";
	private String ifcdReferenceV3 = "";
	private String ifcdReferenceI1 = "";
	private String ifcdReferencei2 = "";
	private String ifcdReferenceI3 = "";
	private String ifcdDesc = "";
	private String ifcdDelNy = "";
//	private String ifcgSeq = "";

	
//	for cache
	public static List<Code> cachedCodeArrayList = new ArrayList<Code>();
	
	
//	----------
	public String getIfcgSeq() {
		return ifcgSeq;
	}
	public void setIfcgSeq(String ifcgSeq) {
		this.ifcgSeq = ifcgSeq;
	}
	public String getIfcgSeqAnother() {
		return ifcgSeqAnother;
	}
	public void setIfcgSeqAnother(String ifcgSeqAnother) {
		this.ifcgSeqAnother = ifcgSeqAnother;
	}
	public String getIfcgName() {
		return ifcgName;
	}
	public void setIfcgName(String ifcgName) {
		this.ifcgName = ifcgName;
	}
	public String getIfcgNameEng() {
		return ifcgNameEng;
	}
	public void setIfcgNameEng(String ifcgNameEng) {
		this.ifcgNameEng = ifcgNameEng;
	}
	public String getIfcgUseNy() {
		return ifcgUseNy;
	}
	public void setIfcgUseNy(String ifcgUseNy) {
		this.ifcgUseNy = ifcgUseNy;
	}
	public String getIfcgOrder() {
		return ifcgOrder;
	}
	public void setIfcgOrder(String ifcgOrder) {
		this.ifcgOrder = ifcgOrder;
	}
	public String getIfcgReferenceV1() {
		return ifcgReferenceV1;
	}
	public void setIfcgReferenceV1(String ifcgReferenceV1) {
		this.ifcgReferenceV1 = ifcgReferenceV1;
	}
	public String getIfcgReferenceV2() {
		return ifcgReferenceV2;
	}
	public void setIfcgReferenceV2(String ifcgReferenceV2) {
		this.ifcgReferenceV2 = ifcgReferenceV2;
	}
	public String getIfcgReferenceV3() {
		return ifcgReferenceV3;
	}
	public void setIfcgReferenceV3(String ifcgReferenceV3) {
		this.ifcgReferenceV3 = ifcgReferenceV3;
	}
	public String getIfcgReferenceI1() {
		return ifcgReferenceI1;
	}
	public void setIfcgReferenceI1(String ifcgReferenceI1) {
		this.ifcgReferenceI1 = ifcgReferenceI1;
	}
	public String getIfcgReferenceI2() {
		return ifcgReferenceI2;
	}
	public void setIfcgReferenceI2(String ifcgReferenceI2) {
		this.ifcgReferenceI2 = ifcgReferenceI2;
	}
	public String getIfcgReferenceI3() {
		return ifcgReferenceI3;
	}
	public void setIfcgReferenceI3(String ifcgReferenceI3) {
		this.ifcgReferenceI3 = ifcgReferenceI3;
	}
	public String getIfcgDesc() {
		return ifcgDesc;
	}
	public void setIfcgDesc(String ifcgDesc) {
		this.ifcgDesc = ifcgDesc;
	}
	public String getIfcgDelNy() {
		return ifcgDelNy;
	}
	public void setIfcgDelNy(String ifcgDelNy) {
		this.ifcgDelNy = ifcgDelNy;
	}
	public String getIfcdSeq() {
		return ifcdSeq;
	}
	public void setIfcdSeq(String ifcdSeq) {
		this.ifcdSeq = ifcdSeq;
	}
	public String getIfcdSeqAnother() {
		return ifcdSeqAnother;
	}
	public void setIfcdSeqAnother(String ifcdSeqAnother) {
		this.ifcdSeqAnother = ifcdSeqAnother;
	}
	public String getIfcdName() {
		return ifcdName;
	}
	public void setIfcdName(String ifcdName) {
		this.ifcdName = ifcdName;
	}
	public String getIfcdNameEng() {
		return ifcdNameEng;
	}
	public void setIfcdNameEng(String ifcdNameEng) {
		this.ifcdNameEng = ifcdNameEng;
	}
	public String getIfcdNameLang1() {
		return ifcdNameLang1;
	}
	public void setIfcdNameLang1(String ifcdNameLang1) {
		this.ifcdNameLang1 = ifcdNameLang1;
	}
	public String getIfcdNameLang2() {
		return ifcdNameLang2;
	}
	public void setIfcdNameLang2(String ifcdNameLang2) {
		this.ifcdNameLang2 = ifcdNameLang2;
	}
	public String getIfcdNameLang3() {
		return ifcdNameLang3;
	}
	public void setIfcdNameLang3(String ifcdNameLang3) {
		this.ifcdNameLang3 = ifcdNameLang3;
	}
	public String getIfcdNameLang4() {
		return ifcdNameLang4;
	}
	public void setIfcdNameLang4(String ifcdNameLang4) {
		this.ifcdNameLang4 = ifcdNameLang4;
	}
	public String getIfcdNameLang5() {
		return ifcdNameLang5;
	}
	public void setIfcdNameLang5(String ifcdNameLang5) {
		this.ifcdNameLang5 = ifcdNameLang5;
	}
	public String getIfcdUseNy() {
		return ifcdUseNy;
	}
	public void setIfcdUseNy(String ifcdUseNy) {
		this.ifcdUseNy = ifcdUseNy;
	}
	public String getIfcdOrder() {
		return ifcdOrder;
	}
	public void setIfcdOrder(String ifcdOrder) {
		this.ifcdOrder = ifcdOrder;
	}
	public String getIfcdReferenceV1() {
		return ifcdReferenceV1;
	}
	public void setIfcdReferenceV1(String ifcdReferenceV1) {
		this.ifcdReferenceV1 = ifcdReferenceV1;
	}
	public String getIfcdReferenceV2() {
		return ifcdReferenceV2;
	}
	public void setIfcdReferenceV2(String ifcdReferenceV2) {
		this.ifcdReferenceV2 = ifcdReferenceV2;
	}
	public String getIfcdReferenceV3() {
		return ifcdReferenceV3;
	}
	public void setIfcdReferenceV3(String ifcdReferenceV3) {
		this.ifcdReferenceV3 = ifcdReferenceV3;
	}
	public String getIfcdReferenceI1() {
		return ifcdReferenceI1;
	}
	public void setIfcdReferenceI1(String ifcdReferenceI1) {
		this.ifcdReferenceI1 = ifcdReferenceI1;
	}
	public String getIfcdReferencei2() {
		return ifcdReferencei2;
	}
	public void setIfcdReferencei2(String ifcdReferencei2) {
		this.ifcdReferencei2 = ifcdReferencei2;
	}
	public String getIfcdReferenceI3() {
		return ifcdReferenceI3;
	}
	public void setIfcdReferenceI3(String ifcdReferenceI3) {
		this.ifcdReferenceI3 = ifcdReferenceI3;
	}
	public String getIfcdDesc() {
		return ifcdDesc;
	}
	public void setIfcdDesc(String ifcdDesc) {
		this.ifcdDesc = ifcdDesc;
	}
	public String getIfcdDelNy() {
		return ifcdDelNy;
	}
	public void setIfcdDelNy(String ifcdDelNy) {
		this.ifcdDelNy = ifcdDelNy;
	}	
	
}