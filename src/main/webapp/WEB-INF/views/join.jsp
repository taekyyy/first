<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<script>const cpath = '${cpath}'</script>
<script src="${cpath }/resources/js/join_agree.js"></script>
<script src="${cpath }/resources/js/join_duplication.js"></script>

	<div class="search_password_title"> <!-- 회원가입 타이틀 -->
        <div><h3>회원가입</h3></div>
        <div><p>동행 구하기 사이트 - onEarth(us)</p></div>
    </div>

    <div class="search_password_form"> <!-- 회원가입 폼 -->
        <form action="${cpath }/join" id="join_form" method="POST">
            <div> <!-- 이메일 입력란 -->
                <div><h3>이메일</h3></div>
                <span><input class="joinFormInput" type="email" name="useremail" id="member_email" placeholder="for@example.com" onkeyup="sendDuplication()" required autofocus></span>
<!--    				<span><button type="button" class="confirm" id="emailConfirm" onkeyup="sendDuplication()" >확인</button></span> -->
                		<div class="inf_duplicate emailDup">
<!-- 						<span>중복된 이메일입니다</span> -->
                		</div>
            </div>

            <div> <!-- 닉네임 입력란 -->
                <div><h3>닉네임</h3></div>
                <span><input class="joinFormInput" type="text" name="username" required></span>
            </div>

            <div> <!-- 비밀번호 입력란    userpw  userpw_check -->
                <div><h3>비밀번호</h3></div>
                <div><input class="joinFormInput" type="password" name="userpw" onkeyup="printPw()" required></div>
                <div class="pwChk" id="pwResist"></div>
            </div>
            <div> <!-- 비밀번호 확인 -->
                <div><h3>비밀번호 확인</h3></div>
                <div><input class="joinFormInput" type="password" name="userpw_check" onkeyup="printPw()" required></div>
                <div class="pwChk" id="pwResult"></div>
            </div>

            <div class="box" id="box">
                <div class="checkbox"> <!-- 체크박스 정보수집 -->
                    <span><input class="boxes" type="checkbox" id="agree1" value="agree1"><label class="boxLabel">개인정보 수집동의</label></span>
                    <span><a class="cnTrct" onclick="agreePopUp1()">보기</a></span>
                </div>

                <div class="checkbox"> <!-- 체크박스 약관동의 -->
                    <span><input class="boxes" type="checkbox" id="agree2" value="agree2"><label class="boxLabel">이용약관 동의</label></span>
                    <span><a class="cnTrct" onclick="agreePopUp2()">보기</a></span>
                </div>
            </div>

			<!-- 회원가입 버튼 -->
            <div class="search_password_buttons" id="sbdv"><input class="btnByShin" id="sb" type="submit" value="회원가입" onclick="comp()"></div>
        </form>
		<div class="search_password_buttons" id="boxChecking"><button class="btnByShin" type="button" id="boxChecking" onclick="isBoxChecked()">모두동의 완료</button></div>
        <div class="search_password_buttons"><a href="${cpath }/login"><button class="btnByShin">뒤로가기</button></a></div>
    </div>

<script src="${cpath }/resources/js/emailCheck.js"></script>
<script>
	function comp() {
		alert('가입완료')
	}
</script>

</body>
</html>