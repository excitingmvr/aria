package com.junefw.infra.modules.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeGroupServiceImpl implements CodeGroupService{

	@Autowired
	CodeGroupDao dao;
	
	@Override
	public int selectOneCount(CodeGroupVo vo) throws Exception {
		return dao.selectOneCount(vo);
	}
	
	
	@Override
	public List<CodeGroup> selectList(CodeGroupVo vo) throws Exception {
		return dao.selectList(vo);
	}
	
	
	@Override
	public CodeGroup selectOne(CodeGroupVo vo) throws Exception {
		return dao.selectOne(vo);
	}

	
	@Override
	public int insert(CodeGroup dto) throws Exception {
		return dao.insert(dto);
	}

	
	@Override
	public int update(CodeGroup dto) throws Exception {
		return dao.update(dto);
	}
	
	
	@Override
	public int uelete(CodeGroupVo vo) throws Exception {
		return dao.uelete(vo);
	}
	
	
	@Override
	public int delete(CodeGroupVo vo) throws Exception {
		return dao.delete(vo);
	}
	

//	@PostConstruct
//	public void selectListCachedCodeArrayList() throws Exception {
//		List<CodeGroup> codeListFromDb = (ArrayList<CodeGroup>) dao.selectListCachedCodeArrayList();
////		codeListFromDb = (ArrayList<Code>) dao.selectListCachedCodeArrayList();
//		CodeGroup.cachedCodeArrayList.clear(); 
//		CodeGroup.cachedCodeArrayList.addAll(codeListFromDb);
//		System.out.println("cachedCodeArrayList: " + CodeGroup.cachedCodeArrayList.size() + " chached !");
//	}
//
//	public static List<CodeGroup> selectListCachedCode(String ifcgSeq) throws Exception {
//		List<CodeGroup> rt = new ArrayList<CodeGroup>();
//		for(CodeGroup codeRow : CodeGroup.cachedCodeArrayList) {
//			if (codeRow.getIfcgSeq().equals(ifcgSeq)) {
//				rt.add(codeRow);
//			} else {
//				// by pass
//			}
//		}
//		return rt;
//	}
//
//	public static CodeGroup selectOneCachedCode(String ifcdSeq) throws Exception {
//		CodeGroup rt = new CodeGroup();
//		for(CodeGroup codeRow : CodeGroup.cachedCodeArrayList) {
//			if (codeRow.getIfcdSeq().equals(ifcdSeq)) {
//				rt = codeRow;
//			} else {
//				// by pass
//			}
//		}
//		return rt;
//	}
//	
//	public static void clear() throws Exception {
//		CodeGroup.cachedCodeArrayList.clear();
//	}



	
}
