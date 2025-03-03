<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		C(INSERT)R(SELECT)U(UPDATE)D(DELETE)
		*회원서비스
		-로그인(R), 회원가입(C), 마이페이지(R), 정보수정(U), 회원탈퇴(U), 아이디중복체크(R)
		
		*공지사항
		-공지사항목록조회(R), 상세조회(R), 게시글작성(C), 게시글수정(U), 게시글삭제(D)
		
		*일반게시판
		-게시글목록조회(R), 상세조회(R), 게시글작성(C), 게시글수정(U), 게시글삭제(D), 댓글작성(C), 댓글목록조회(R)
		
		*사진게시판
		-게시글작성-첨부파일업로드(C), 게시판리스트조회(R), 상세조회(R)
	--%>
	<%-- com.kh.common.JDBCTemplate.getConnection(); --%>

	<%@ include file="views/common/menubar.jsp" %>

</body>
</html>