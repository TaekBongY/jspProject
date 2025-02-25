<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert title here</title>
    <!--jQuery-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <!--부트스트랩 5.3.3 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        a{
            text-decoration: none;
            color: black;
        }
        .login-area>*{
            float: right;
        }
        .login-area input[type="button"],
        .login-area input[type="submit"]{
            width: 50%;
            float: left;
        }
        .nav-area{
            background-color: black;
        }
        .menu{
            display: table-cell;
            width: 150px;
            height: 50px;
        }
        .menu a{
            color: white;
            font-size: 20px;
            font-weight: bold;
            text-align: center;
            width: 100%;
            height: 100%;
            line-height: 50px;
            display: inline-block;
        }
    </style>
</head>

    <body>
        <h1 align="center">Welcome KH World</h1>
        <div class="login-area">
        <!--로그인 전-->
        <form action="${pageContext.request.contextPath}/login.me" method="POST">
            <table>
                <tr>
                    <th>아이디</th>
                    <td><input type="text" name="userID" required></td>
                </tr>
                <tr>
                    <th>비밀번호</th>
                    <td><input type="text" name="userPwd" required></td>
                </tr>
                <tr>
                    <th colspan="2">
                        <input type="submit" value="로그인">
                        <input type="button" value="회원가입">
                    </th>
                </tr>
            </table>
        </form>
    </div>
    <br clear="both">
    <div class="nav-area">
        <div class="menu"><a href="">HOME</a></div>
        <div class="menu"><a href="">공지사항</a></div>
        <div class="menu"><a href="">일반게시판</a></div>
        <div class="menu"><a href="">사진게시판</a></div>
    </div>
</body>

</html>