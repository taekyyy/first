<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="initial-scale=1.0">
<meta charset="UTF-8">
<title>onEarth(us)-동행 구하기</title>
<link type="text/css" rel="stylesheet" href="${cpath }/resources/css/header.css">
<link type="text/css" rel="stylesheet" href="${cpath }/resources/css/base.css">
<link type="text/css" rel="stylesheet" href="${cpath }/resources/css/alert.css">

<link type="text/css" rel="stylesheet" href="${cpath }/resources/css/main.css">

<link type="text/css" rel="stylesheet" href="${cpath }/resources/css/cities.css">
<link type="text/css" rel="stylesheet" href="${cpath }/resources/css/cities_modal.css">

<link type="text/css" rel="stylesheet" href="${cpath }/resources/css/mypage.css">
<link type="text/css" rel="stylesheet" href="${cpath }/resources/css/mypage_memberUpdate.css">

<link type="text/css" rel="stylesheet" href="${cpath }/resources/css/admin.css">

<link type="text/css" rel="stylesheet" href="${cpath }/resources/css/party.css">
<link type="text/css" rel="stylesheet" href="${cpath }/resources/css/partyInf.css"> 

<link type="text/css" rel="stylesheet" href="${cpath }/resources/css/login.css">
<link type="text/css" rel="stylesheet" href="${cpath }/resources/css/newPass.css">
<link type="text/css" rel="stylesheet" href="${cpath }/resources/css/join.css">

<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic+Coding&family=Noto+Sans+KR&display=swap" rel="stylesheet">

<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script>
	const cpath = '${cpath}'
</script>
</head>
<body>

    <div class="header">
        <div class="logo">
            <a href="${cpath }">
               <!-- 로고이미지 -->
               <img id="img1" src="${cpath }/resources/img/web_logo2.png">
               <img id="img2" src="${cpath }/resources/img/web_logo1.png">
            </a>
        </div>
        <div class=header_menu>
            <ul>
            	<c:if test="${not empty login && empty adminLogin}"><li>사용자 : ${login.username }</li></c:if>
            	<c:if test="${not empty adminLogin }"><li>사용자 : ${adminLogin.adminname }</li></c:if>
            	<li><a href="${cpath }/cities">도시선택</a></li>
            	<c:if test="${not empty login && empty adminLogin}"><li><a href="${cpath }/mypage_default">마이페이지</a></li></c:if>
            	<c:if test="${not empty adminLogin }"><li><a href="${cpath }/admin">관리자 페이지</a></li></c:if>
                <c:if test="${empty login }"><li><a href="${cpath }/login">로그인</a></li></c:if>
                <c:if test="${not empty login || not empty adminLogin}"><li><a href="${cpath }/logout">로그아웃</a></li></c:if>
            </ul>
        </div>
    </div>
