package com.qs.www.approval.model.service;

import static com.qs.www.common.mybatis.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.qs.www.approval.model.dao.ApprovalDAO;
import com.qs.www.approval.model.dto.ApprovalLineDTO;
import com.qs.www.approval.model.dto.ApproverDTO;
import com.qs.www.approval.model.dto.ApproverLogPerReportDTO;
import com.qs.www.member.model.dto.MemberDTO;
import com.qs.www.schedule.model.dto.ApproverPerReportDTO;
import com.qs.www.schedule.model.dto.ReportDTO;
import com.qs.www.schedule.model.dto.WorkingDocumentItemDTO;

public class ApprovalService {

	private final ApprovalDAO approvalDAO;

	public ApprovalService() {
		approvalDAO =new ApprovalDAO();
	}

	public List<ApprovalLineDTO> selectApprovalLine(int no) {
		SqlSession session = getSqlSession();

		List<ApprovalLineDTO> lineList = approvalDAO.selectApprovalLine(session, no);

		session.close();

		return lineList;
	}

	public List<ApproverDTO> selectApprover(int lineNo) {
		SqlSession session = getSqlSession();

		List<ApproverDTO> approverList = approvalDAO.selectApprover(session, lineNo);

		session.close();

		return approverList;
	}

	public int selectReportNum() {
		SqlSession session = getSqlSession();

		int reportNum = approvalDAO.selectReportNum(session);

		if(reportNum > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();

		return reportNum;
	}

	public List<ReportDTO> selectMyReport(int no) {
		SqlSession session = getSqlSession();

		List<ReportDTO> reportList = approvalDAO.selectMyReport(session, no);

		session.close();

		return reportList;
	}

	public ReportDTO selectOneReportDetail(int reportNo) {
		SqlSession session = getSqlSession();

		ReportDTO reportList = approvalDAO.selectOneReportDetail(session, reportNo);

		session.close();

		return reportList;
	}

	public List<WorkingDocumentItemDTO> selectReportItemList(int no) {
		SqlSession session = getSqlSession();

		List<WorkingDocumentItemDTO>  itemList = approvalDAO.selectReportItemList(session, no);

		session.close();

		return itemList;
	}

	public int callbackSelectedReport(int no) {
		SqlSession session = getSqlSession();

		int result = approvalDAO.callbackSelectedReport(session, no);

		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();

		return result;
	}

	public int callbackApproverPerReport(int no) {
		SqlSession session = getSqlSession();

		int result = approvalDAO.callbackApproverPerReport(session, no);

		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();

		return result;
	}

	public List<ApproverPerReportDTO> selectMyTurnAPR(int no) {
		SqlSession session = getSqlSession();

		List<ApproverPerReportDTO>  APRList = approvalDAO.selectMyTurnAPR(session, no);

		session.close();

		return APRList;
	}
	
	public int insertALPR(ApproverLogPerReportDTO aLPR) {
		SqlSession session = getSqlSession();

		int result = approvalDAO.insertALPR(session, aLPR);

		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();

		return result;
	}
	
	public ApproverPerReportDTO selectThisTurnAPR(ApproverPerReportDTO thisAPR) {

		SqlSession session = getSqlSession();

		ApproverPerReportDTO APR = approvalDAO.selectThisTurnAPR(session, thisAPR);

		session.close();

		return APR;
	}
	
	public int updateThisTurnAPR(ApproverPerReportDTO thisAPR) {
		SqlSession session = getSqlSession();

		int result = approvalDAO.updateThisTurnAPR(session, thisAPR);

		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();

		return result;
	}

	public int updateNextTurnAPR(ApproverPerReportDTO thisAPR) {
		SqlSession session = getSqlSession();

		int result = approvalDAO.updateNextTurnAPR(session, thisAPR);

		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();

		return result;
	}

	public int finishAppReport(ApproverPerReportDTO thisAPR) {
		SqlSession session = getSqlSession();

		int result = approvalDAO.finishAppReport(session, thisAPR);

		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();

		return result;
	}

	public List<ApproverPerReportDTO> selecReceivedAPR(int no) {
		SqlSession session = getSqlSession();

		List<ApproverPerReportDTO>  APRList = approvalDAO.selecReceivedAPR(session, no);

		session.close();

		return APRList;
	}


}
