package com.qs.www.mypage.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.qs.www.member.model.dto.CheckQuestionDTO;
import com.qs.www.member.model.dto.MemberInfoDTO;
import com.qs.www.mypage.model.dto.CommutingLogDTO;

public class MypageDAO {

	public int updateInfo(SqlSession sqlSession, MemberInfoDTO memberInfo) {
		return sqlSession.update("MypageDAO.updateInfo", memberInfo);
	}

	public List<CheckQuestionDTO> selectQuestionList(SqlSession sqlSession) {
		return sqlSession.selectList("MypageDAO.selectQuestionList");
	}

	public String selectCommute(SqlSession sqlSession, CommutingLogDTO commutingLog) {
		return sqlSession.selectOne("MypageDAO.selectCommute", commutingLog);
	}
	
	public int insertCommute(SqlSession sqlSession, CommutingLogDTO commutingLog) {
		return sqlSession.insert("MypageDAO.insertCommute", commutingLog);
	}
}
