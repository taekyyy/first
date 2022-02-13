<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

	<div class="login_title"> <!-- 로그인 타이틀 -->
        <div><h3>관리자 페이지</h3></div>
        <div><p>동행 구하기 사이트 - onEarth(us)</p></div>
    </div>

   <div class="login_form"> <!-- 로그인폼 -->
        <form method="POST" id="login_form">
            <div> <!-- 비밀번호 입력란 -->
                <div><h3>비밀번호 확인</h3></div>
                <div><input class="joinFormInput" type="password" name="adminpw" required></div>
            </div>
			<!-- 로그인 및 회원가입 버튼 -->
            <div class="login_buttons"><input class="btnByShin" type="submit" value="로그인"></div>
        </form>
        	<div></div>
        	
    </div>
</body>
</html>