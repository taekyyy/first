<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<script>const cpath = '${cpath}'</script>
<script src="${cpath }/resources/js/join_duplication.js"></script>

	<div class="search_password_title"> <!-- 비밀번호 찾기 타이틀 -->
        <div><h3>비밀번호 찾기</h3></div>
        <div><p>동행 구하기 사이트 - onEarth(us)</p></div>
    </div>

    <div class="search_password_form" > <!-- 비밀번호 찾기 폼 -->
        <form id="newPassForm1">
            <div> <!-- 이메일 입력란 -->
                <div><h3>이메일</h3></div>
                <span><input class="joinFormInput" type="email" name="useremail" placeholder="for@example.com" required autofocus></span>
                <span><button type="button" class="confirm" onclick="sendMailHandler()">확인</button></span>
                <div class="inf_duplicate emailDup"></div>
            </div>
            <br>
            <div class="codeChecking" id="codeChecking"> <!-- 인증번호 발급 -->
            <div>
            	<span><input class="joinFormInput" name="codeCheck" type="text" required placeholder="인증번호 입력"></span>
            	<span><button type="button" onclick="codeChkBtn()" class="confirm">확인</button></span>
            <div class="timer"></div>
            <div id="codeCheckingMsg"></div>
            </div>
            </div>

        </form>
    	<form class="editPw" id="newPassForm2">
        	<div>
        		<div><h3>새 비밀번호</h3></div>
        		<div><input class="joinFormInput" type="password" name="userpw" onkeyup="printPw()" required></div>
        		<div class="pwChk" id="pwResist"></div>
        		
        		<div><h3>새 비밀번호 확인</h3></div>
        		<div><input class="joinFormInput" type="password" name="userpw_check" onkeyup="printPw()" required></div>
        		<div class="pwChk" id="pwResult"></div>
        	</div>
	        <div class="search_password_buttons" id="goToEditPw"><button class="btnByShin" type="button" onclick="modifyPass()">비밀번호 수정하기</button></div>
        </form>
        <div class="search_password_buttons"><a href="${cpath }/login"><button class="btnByShin">뒤로가기</button></a></div>
    </div>
        
<script src="${cpath }/resources/js/join_codeChecking.js"></script>
<script>
	
</script>

</body>
</html>