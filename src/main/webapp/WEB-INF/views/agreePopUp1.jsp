<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인정보 수집 동의</title>
<style>
	table, th, td {
		border: 1px solid black;
		border-collapse : collapse;
	}
	
	table {
		width: 760px;
		text-align: center;
	}
	
	th {
		background-color: rgb(247,248,249);
	}
	
	.smallTable {
		height: 85px;
	}
	
	.important {
		font-weight: 800;
		text-decoration: underline;
	}
	
	.noCh {
		white-space: nowrap;
	}
	
	.table > p {
		color: blue;
	}
</style>
</head>
<body>

<div><h2>개인정보 수집·이용 내역</h2></div>

<table border="1">
	<th class="noCh">구분</th>
	<th>수집·이용 항목</th>
	<th>수집·이용 목적</th>
	<th>보유기간</th>
	<tr>
		<td class="noCh">필수</td>
		<td class="important">아이디, 비밀번호, 고유인증키값, 이메일, 특정사용자의 경우 추가 처리항목(소속업체명, 등록번호, 직급/직책, 유선번호, 신청사유, 자격증명자료)</td>
		<td class="important" rowspan="2">공유자원 이용 및 회원관리</td>
		<td class="important" rowspan="2">사용자 정보는 탈퇴 시 즉시 파기, 거래정보에 포함된 사용자 정보는 따로 분리하여 보관·관리(5년)</td>
	</tr>
	<tr>
		<td class="noCh">선택</td>
		<td class="important">환불계좌정보(은행명, 계좌번호, 예금주), 공유자원 사용이력정보</td>
	</tr>
</table>

<br><br>

<div><h2>위치정보 수집·이용 내역</h2></div>

<table class="smallTable" border="1">
	<th class="noCh">구분</th>
	<th>수집·이용 항목</th>
	<th>수집·이용 목적</th>
	<th>보유기간</th>
	<tr>
		<td>선택</td>
		<td class="important">위치정보</td>
		<td class="important">주변 공유서비스 제공</td>
		<td class="important">서비스 제공 후 즉시 파기</td>
	</tr>
</table>

<br><br>

<div><h2>개인정보 3자 제공 내역</h2></div>
<div class="table"><p>※일반회원의 경우 개인정보를 제3자에게 제공하지 않습니다.</p></div>

</body>
</html>