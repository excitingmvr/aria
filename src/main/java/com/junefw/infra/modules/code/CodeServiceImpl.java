package com.junefw.infra.modules.code;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeServiceImpl implements CodeService{

	@Autowired
	CodeDao dao;

	
	@Override
	public int selectOneCount(Code code) throws Exception {
		return dao.selectOneCount(code);
	}
	
	
	@Override
	public List<Code> selectList(Code code) throws Exception {
		return dao.selectList(code);
	}
	
	
	@Override
	public Code selectOne(Code code) throws Exception {
		return dao.selectOne(code);
	}

	
	@Override
	public int insert(Code code) throws Exception {
		return dao.insert(code);
	}

	
	@Override
	public int update(Code code) throws Exception {
		return dao.update(code);
	}

	@PostConstruct
	public void selectListCachedCodeArrayList() throws Exception {
		List<Code> codeListFromDb = (ArrayList<Code>) dao.selectListCachedCodeArrayList();
//		codeListFromDb = (ArrayList<Code>) dao.selectListCachedCodeArrayList();
		Code.cachedCodeArrayList.clear(); 
		Code.cachedCodeArrayList.addAll(codeListFromDb);
		System.out.println("cachedCodeArrayList: " + Code.cachedCodeArrayList.size() + " chached !");
	}

	public static List<Code> selectListCachedCode(String ifcgSeq) throws Exception {
		List<Code> rt = new ArrayList<Code>();
		for(Code codeRow : Code.cachedCodeArrayList) {
			if (codeRow.getIfcgSeq().equals(ifcgSeq)) {
				rt.add(codeRow);
			} else {
				// by pass
			}
		}
		return rt;
	}

	public static Code selectOneCachedCode(String ifcdSeq) throws Exception {
		Code rt = new Code();
		for(Code codeRow : Code.cachedCodeArrayList) {
			if (codeRow.getIfcdSeq().equals(ifcdSeq)) {
				rt = codeRow;
			} else {
				// by pass
			}
		}
		return rt;
	}
	
	public static void clear() throws Exception {
		Code.cachedCodeArrayList.clear();
	}
	
}
