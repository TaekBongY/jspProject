package com.kh.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.kh.member.model.vo.Member;
import com.kh.member.service.MemberService;

/**
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/update.me")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청된 회원정보 -> 정보 수정 -> int -> 성공(myPage) / 실패(errorPage)
		String userID = request.getParameter("userID");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		//아래는 필수값 아님
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String adress = request.getParameter("adress");
		String[] interestArrr = request.getParameterValues("interest");
		
		//String[] -> String
		String interest = "";
		if(interestArrr != null) {
			interest = String.join(",", interestArrr);
		}
		
		Member m = new Member(userID,userPwd,userName,phone,email,adress,interest);
		
		//sql요청-> service
		int result = new MemberService().insertMember(m);
		
		if(result>0) {
			//수정성공
			request.getSession().setAttribute("alertMsg", "성공적으로 수정이 완료되었습니다.");
			response.sendRedirect(request.getContextPath());
		} else {
			//수정실패
			//에러문구가 있는 에러페이지
			request.setAttribute("alertMsg", "회원정보 수정에 실패하였습니다.");
			request.getRequestDispatcher("views/common/error.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
