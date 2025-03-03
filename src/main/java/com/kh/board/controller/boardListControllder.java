package com.kh.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;
import com.kh.common.vo.PageInfo;

/**
 * Servlet implementation class boardListControllder
 */
@WebServlet("/list.bo")
public class boardListControllder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public boardListControllder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//views/board/boardListView.jsp 포워딩
		//board데이터를 전달
		//---------------- 페이징 처리 -----------------
		int listCount; //현재 총 게시글 수
		int currentPage; //현재 페이지(사용자가 요청한 페이지)
		int pageLimit=10; //하단에 ㅗ여질 페이징 바의 수
		int boardLimit=10; //한 페이지에 보여줄 게시글 최대 수
		//위 4개의 값을 기준으로 아래 3개의 값을 계산
		
		int maxPage;//가장 마지막 페이지(총 페이지 수)
		int startPage; //하단의 보여질 페이징 바의 시작수
		int endPage; //하단에 보여질 페이징바의 끝수
		//총 게시글 수
		listCount = new BoardService().selectListCount();
		currentPage = Integer.parseInt(request.getParameter("cpage"));
		//페이지 정보
		PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit);
		ArrayList<Board> List = new BoardService().selectList(pi);
		request.setAttribute("list", List);
		request.setAttribute("pi", pi);
		request.getRequestDispatcher("views/board/boardListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
