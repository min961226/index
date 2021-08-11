package com.qs.www.board.model.service;

import java.util.List; 

import org.apache.ibatis.session.SqlSession;

import com.qs.www.board.model.dao.FreeDAO;
import com.qs.www.board.model.dto.FreeDTO;

import static com.qs.www.common.mybatis.Template.getSqlSession;

public class FreeService {
	
	private final FreeDAO freeDAO;
	
	public FreeService() {
		
		freeDAO = new FreeDAO();
		
	}

	public List<FreeDTO> selectAllFreeList() {
		
		SqlSession session = getSqlSession();
		
		List<FreeDTO> freeList = freeDAO.selectAllFreeList(session);
		
		session.close();
		
		return freeList;
		
	}

	public int insertFree(FreeDTO newFree) {
		
		SqlSession session = getSqlSession();
		
		int result = freeDAO.insertFree(session, newFree);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}

}
