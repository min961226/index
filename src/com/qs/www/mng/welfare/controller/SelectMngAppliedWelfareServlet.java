package com.qs.www.mng.welfare.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qs.www.approval.model.service.ApprovalService;
import com.qs.www.common.paging.Pagenation;
import com.qs.www.common.paging.SelectCriteria;
import com.qs.www.member.model.dto.MemberInfoDTO;
import com.qs.www.mng.welfare.model.service.MngWelfareService;
import com.qs.www.schedule.model.dto.ReportDTO;
import com.qs.www.welfare.model.service.WelfareService;

@WebServlet("/mng/welfare/applied/select")
public class SelectMngAppliedWelfareServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MngWelfareService mngWelfareService = new MngWelfareService();

		/*-----------------------------------------------------------------------------------------------------------------------*/
		/*
		 * 목록보기를 눌렀을 시 가장 처음에 보여지는 페이지는 1페이지이다. 파라미터로 전달되는 페이지가 있는 경우 currentPage는 파라미터로
		 * 전달받은 페이지 수 이다.
		 */
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;

		if (currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		/* 0보다 작은 숫자값을 입력해도 1페이지를 보여준다 */
		if (pageNo <= 0) {
			pageNo = 1;
		}

		/* 검색에 사용할것 */
		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");

		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);

		Pagenation pagenation = new Pagenation();

		int totalCount = mngWelfareService.selectWaitingAPPCount(searchMap);					//totalCount 는 DB에 가서 총 게시물 수를 세어와야 함 count(*) 중, where 삭제안된거.

		int limit = 10;																			//limit는 한 페이지에서 보여지는 게시물 수

		int buttonAmount = 5;																	//buttonAmount는 한번에 보여줄 버튼 수

		SelectCriteria selectCriteria = null;

		if (searchCondition != null && !"".equals(searchCondition)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition,
					searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}

		/*-----------------------------------------------------------------------------------------------------------------------*/

		List<ReportDTO> allAppliedWelfareList = mngWelfareService.selectAllAppliedWelfareList(selectCriteria);

		request.setAttribute("selectCriteria", selectCriteria);
		request.setAttribute("allAppliedWelfareList", allAppliedWelfareList);
		request.getRequestDispatcher("/WEB-INF/views/mngwelfare/appliedWelfare.jsp").forward(request, response);
	}

}
