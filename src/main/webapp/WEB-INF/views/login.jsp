<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<script src="${cpath }/resources/js/adminLogin.js"></script>

	<div class="login_title"> <!-- 로그인 타이틀 -->
        <div class="login_titleH3"><h3>로그인</h3></div>
        <div><p>동행 구하기 사이트 - onEarth(us)</p></div>
    </div>

    <div class="login_form"> <!-- 로그인폼 -->
        <form method="POST" id="login_form">
            <div> <!-- 이메일 입력란 -->
                <div><h3>이메일</h3></div>
                <div><input class="joinFormInput" type="text" name="useremail" placeholder="for@example.com" required autofocus></div>
            </div>

            <div> <!-- 비밀번호 입력란 -->
                <div><h3>비밀번호</h3></div>
                <div><input class="joinFormInput" type="password" name="userpw" required></div>
                <div id="didU4getC"><a id="didU4get" href="${cpath }/newPass">비밀번호를 잊으셨나요?</a></div>
            </div>

			<!-- 로그인 및 회원가입 버튼 -->
            <div class="login_buttons"><input class="btnByShin" type="submit" value="로그인"></div>
        </form>
            <div class="login_buttons" id="join"><a href="${cpath }/join"><button class="btnByShin">회원가입 하기</button></a></div>
            
<!--             관리자 로그인 -->
<!--             <div class="login_buttons" id="adminLogin"><button type="button" onclick="adminLogin()" class="btnByShin">관리자 로그인</button></div> -->
            
<!--         <form method="POST" id="admin_form" style="display: none;"> -->
<!--         	<div> 관리자 이메일 입력란 -->
<!--                 <div><h3>관리자 이메일</h3></div> -->
<!--                 <div><input class="joinFormInput" type="text" name="adminemail" placeholder="for@example.com" required autofocus></div> -->
<!--             </div> -->
            
<!--             <div> 비밀번호 입력란 -->
<!--                 <div><h3>관리자 비밀번호</h3></div> -->
<!--                 <div><input class="joinFormInput" type="password" name="adminpw" required></div> -->
<!--             </div> -->
            
<!--             <div class="login_buttons"><input class="btnByShin" type="submit" value="로그인"></div> -->
<!--             <div class="login_buttons"><button class="btnByShin" type="button" onclick="goBack()">뒤로가기</button></div> -->
<!--         </form> -->
    </div>

<script>
	
</script>

</body>
</html>