<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer{
		background-color:rgb(75, 73, 73);
		color: white;
		width: 1000px;
		margin: auto;
		margin-top: 50px;
		padding: 10px 0px 50px;
	}

    .list-area{
        border: 1px solid white;
        text-align: center;
    }

    .list-area td,
    .list-area th{
        border: 1px solid white;
    }

    .list-area select,
    .list-area input,
    .list-area textarea{
        width: 100%;
        box-sizing: border-box;
        background-color: #222222;
    }
</style>
</head>
<body>
    <%@include file="../common/menubar.jsp"%>

    <div class="outer">
        <br>
        
        <%--
        	파일을 전송하기 위해서는 enctype="mulipart/form-data"로 변경
        	기본적인 form 전송시 인코딩 타입 -> application/x-www-form-urlencoded
         --%>
        <form action="${pageContext.request.contextPath}/insert.bo" method="POST" enctype="mulipart/form-data">
        <h2 align="center">일반게시글 작성하기</h2>
        <br>
            <table align="center" class="list-area">
                <tr>
                    <th width="70px">카테고리</th>
                    <td width="500px">
                        <select name="category">
                            <c:forEach var="c" items="${categorys}">
                                <option value="${c.categoryNo}">${categoryName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>제목</th>
                    <td>
                        <input type="text" name="title" required>
                    </td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td>
                        <textarea name="content" rows="10" style="resize: none;" />
                    </td>
                </tr>
                <tr>
                    <th>첨부파일</th>
                    <td>
                        <input type="file" name="upfile">
                    </td>
                </tr>
            </table>
            <br>

            <div align="center">
                <button type="submit">작성하기</button>
                <button type="reset">취소하기</button>
            </div>
        </form>

    </div>
</body>
</html>