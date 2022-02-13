<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
<link type="text/css" rel="stylesheet" href="${cpath }/resources/css/admin.css">
<link type="text/css" rel="stylesheet" href="${cpath }/resources/css/mypage.css">
<style>
	.memberDetails > h1 {
		text-align: center;
		width: 98%;
	}
	.memberNN {
		font-weight: 600;
		margin-bottom: 10px;
	}
	ul {
		list-style:none;
	}
	#backBtn {
		float: right;
    	margin-right: 13.5px;
    	margin-top: 10px;
	}
</style>
</head>
<body>

<div class="memberDetails">
	<h1>회원 전체댓글</h1>
	<hr><br>
	
	<div class="memberNN">
		<span>닉네임 : ${dto.username }</span>
		<span style="float: right;">작성한 댓글수 : ${total }개</span>
	</div>
	
	<div>
		<ul class="mypage_board" id="join_board_title">
           <li>No</li>
           <li>글번호</li>
           <li style="width: 100%;">내용</li>
           <li>작성일</li>
           <li>삭제</li>
       	</ul>
		<c:forEach var="reply" items="${list }">
			<ul class="mypage_board" id="join_board_list">
				<li>${reply.idx }</li>
				<li>${reply.boardIdx }</li>
				<li style="width: 100%;">${reply.content }</li>
				<li>${reply.writeDate }</li>		
				<li><button class="myBoardBtn replyDelete" value="${reply.idx }" onclick="ReplyDelete()">댓글 삭제</button></li>
			</ul>
		</c:forEach>
		<button class="myBoardBtn replyDelete" id="backBtn" onclick="btnClick()">뒤로가기</button>
	</div>
</div>

<script>
	const cpath = '${cpath}'
	const btn = document.getElementById('backBtn')

	function btnClick(event) {
		location.href= cpath + '/admin/memberAll'
	}

	function ReplyDelete(event) {
		const ReplyDelete = document.querySelector('.replyDelete')
		let idx = ReplyDelete.value
		const url = cpath + '/deleteReply/' + idx
		const opt = {
			method: 'Delete'
		}
		fetch(url, opt)
		.then(resp => resp.text())
		.then(text => {
			if(text == 1) {
				alert('댓글이 성공적으로 삭제되었습니다')
				idx = '${dto.idx}'
				location.href = cpath + '/memberDetails/' + idx
			}
			else {
				alert('삭제 실패..')
			}
		})
	}
</script>


</body>
</html>