<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<div class="partyInf_left"> 
	<h2>동행 게시글</h2>
	<div class="country">
		<h3>${dto.city }</h3>
	</div>
	<div class="country_img">
		<!-- 슬라이드입니다-->
		<ul class="country_slider">
			<li><img src="${dto.subImg1 }"></li>
			<li><img src="${dto.subImg2 }"></li>
			<li><img src="${dto.subImg3 }"></li>
		</ul>
		<div class="main_prev partyInf_p"><i class="fas fa-arrow-left"></i></div>
        <div class="main_next partyInf_n"><i class="fas fa-arrow-right"></i></div>
	</div>
</div>
<div class="planInfo">
	<div class="partyInf_right">
		<div class="boardTitle">${board.title }</div>
		<div class="partyInf_date">
			<span>Write  ${board.meetDate }</span><br>
			<span>Meet  ${board.writeDate }</span>
		</div>
		<div class="partyInf_purpose">
			<span> ${board.purpose }</span>
		</div>
		<div class="partyInf_content">
			<textarea rows="9" cols="160" readonly disabled><c:out value="${board.content }" /></textarea>
		</div>
		<div class="partyInf_joinBtn">
			<c:if
				test="${board.maxMember > board.nowMember && login.useremail != board.writer && joinState == 1}">
				<button id="button1" class="btnByShin" value="join">참여하기</button>
			</c:if>
			<c:if test="${login.useremail == board.writer && joinState == 1}">
				<button id="button1" class="btnByShin" value="delete">동행글 삭제</button>
			</c:if>
			<c:if
				test="${board.maxMember >= board.nowMember && joinState == 2}">
				<button id="button1" class="btnByShin" value="cancle">참여취소</button>
			</c:if>
		</div>
	</div>
	<div class="partyInf_right_bottom">
		<div class="partyInf_replyBox">
			<div id="replyList">
				<form class="replyInsert" method="POST">
						<input id="replyWriter" type="text" name="writer" value="${login.useremail }" readonly><br>
						<input type="hidden" name="boardIdx" value="${board.idx }">
						<textarea rows="2" cols="110" name="content" placeholder="댓글을 작성하세요"></textarea>
						<div class="reply_load">
							<button id="reply_loadBtn" type="submit">작성</button>
						</div>
				</form>
			<div class="comment">
				<c:forEach var="reply" items="${reply }">
					<div class="updateReplyBox">
						<div class="updateReplyContext">
							<div class="updateReplyWriter">${reply.writer }</div>
							<div class="updateReplyContent">${reply.content }</div>
							<div class="updateReplyDate">${reply.writeDate }</div>
						</div>
						<div class="ReplyBtnBox">
							<c:if test="${login.useremail == reply.writer }">
								<button id="deleteReplyBtn" value="${reply.idx }" onclick="replyDelete()">삭제</button>
							</c:if>
						</div>			
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
		<div class="partyInf_users">
		<div class="user_title">동행인</div>
		<div class="user_writer">동행 조장 ${board.writer}</div>
		<div class="user_num">최대 ${board.maxMember }명 / 현재 ${board.nowMember }명 참가</div>
		<div class="users">
			<div>참여 인원</div>
			<c:forEach var="list" items="${list }">
				<div>${list.joiner }</div>
			</c:forEach>
		</div>
	</div>
			<c:if test="${board.maxMember == board.nowMember }">
				<div>더이상 참여할 수 없습니다</div>
			</c:if>
			<button class="btnByPre" onclick="location.href='${cpath}/party/${board.city}'">뒤로가기</button>
	</div>
</div>
<script src="${cpath }/resources/js/partyInf.js"></script>
<script>
    const prev = document.querySelector('.partyInf_p')
    const next = document.querySelector('.partyInf_n')
    const slide = document.querySelector('.country_slider')
    const slideLi = document.querySelectorAll('.country_slider li')
    const slideCount = slideLi.length
    const button1 = document.getElementById('button1')
    const form = document.querySelector('.replyInsert')
    
    let idx = '${board.idx}'
    const writer = '${board.writer}'
	var kinds = button1.value
	
    button1.addEventListener('click', btnClick)
//     deleteReplyBtn.addEventListener('click', replyDelete)
    form.onsubmit = submitHandler
    
    const paddingRight = 112
    const imgWidth = 543
    let slideIdx = 0 
        
    function slideMove(num) {
        slide.style.left = -num * (imgWidth + paddingRight) + 'px'
        slideIdx = num
    }

    prev.addEventListener('click', function() {
        if(slideIdx !== 0) {
            slideMove(slideIdx - 1)
        }
    })
    next.addEventListener('click', function() {
        if(slideIdx !== slideCount - 1) {
            slideMove(slideIdx + 1)
        }
    })
    
</script>
</body>
</html>