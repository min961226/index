package com.qs.www.welfare.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;

@WebServlet("/welfare/laptopRental/insert")
public class InsertLaptopRentalWelfareServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("노트북대여 신청서");
		String requestContent = "<p>값을 전달받는중입니다.</p>";
		
		String postContent = request.getParameter("postContent");
		request.setAttribute("requestContent", requestContent);
		
		String path = "/WEB-INF/views/welfare/result.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}
}
