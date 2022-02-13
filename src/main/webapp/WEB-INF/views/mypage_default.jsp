<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ include file="mypage_update.jsp" %>
<%@ include file="mypage_delete.jsp" %>
<script>
const body = document.querySelector('body')
</script>


<!--  작성글 모달창 -->
<div class="myboardModify modifyHidden"></div>
<!--  작성글 모달창 -->

<!-- 위시 모달창-->
<div class="cities_modal">
	<div class="cities_modal_content"></div>
</div>

<div class="list">
    <div class="list_left">
        <nav>
            <ul> 
           		<li><a href="${cpath }/mypage_default">위시리스트</a></li>
          		<li><a href="${cpath }/mypage_default/myWrite">작성글</a></li>
           		<li><a href="${cpath }/mypage_default/myJoin">참여글</a></li>
           		<li><a href="${cpath }/mypage_default/myReply">내가 쓴 댓글</a></li>
                <li><button class="mypageBtn" id="memberUpdate">회원정보 수정</button></li>
                <li><button class="mypageBtn" id="memberDelete">회원 탈퇴</button></li>
            	<li><a href="${cpath }/adminLogin">관리자페이지</a></li>
            </ul>
        </nav>
    </div>
    <div class="list_right">
        <div class="list_top">
            <div class="userInf1">
                <img src="${cpath }/resources/img/user_default.png">
                <span>${user.username }</span>
            </div>
            <div class="userInf2">
                <h2><a href="${cpath }/mypage_default/myWish">위시리스트</a></h2>
                <span>${wishCount }개</span>
            </div>
            <div class="userInf2">
                <h2><a href="${cpath }/mypage_default/myWrite">작성글</a></h2>
                <span>${boardCount } 개</span>
            </div>
            <div class="userInf2">
                <h2><a href="${cpath }/mypage_default/myJoin">참여글</a></h2>
                <span>${joinCount } 개</span>
            </div>
        </div>
        <div class="list_bottom">
            <div class="mypage_title">
            	<c:choose>
            		<c:when test="${empty myBoard && pageState == 2 }">위시리스트</c:when>
            		<c:when test="${boardState == 1}">작성글</c:when>
            		<c:when test="${boardState == 2}">참여글</c:when>
            		<c:when test="${boardState == 3}">내가 쓴 댓글 (${replyCount }개)</c:when>
            	</c:choose>
            </div>
            <div class="board">
               <c:choose>
					<c:when test="${pageState == 1}">
	                  	<nav>
	                        <ul class="mypage_board" id="join_board_title">
	                           <li>	
	                           		<c:if test="${boardState == 1 }">
	                           			<input type="checkbox" name="boardChk" value="selectAll" onclick='selectAll(this)'>
	                           		</c:if>
	                           </li>	
	                           <li>No</li>
	                           <li>
	                           		<c:choose>
										<c:when test="${boardState == 1 || boardState == 2}">도시</c:when>
										<c:when test="${boardState == 3}">게시글 번호</c:when>
									</c:choose>
	                           </li>
	                           <li>
	                       			<c:choose>
										<c:when test="${boardState == 1 || boardState == 2}">제목</c:when>
										<c:when test="${boardState == 3}">내용</c:when>
									</c:choose>
	                           </li>
	                           <li>
	                           		<c:choose>
										<c:when test="${boardState == 1}">참여인원 / 희망 인원</c:when>
										<c:when test="${boardState == 2 || boardState == 3}">작성자</c:when>
									</c:choose>                           
	                           </li>
	                           <li>
	                           		<c:choose>
										<c:when test="${boardState == 1 || boardState == 2}">동행일</c:when>
										<c:when test="${boardState == 3}"></c:when>
									</c:choose>
							   </li>
	                           <li>수정/취소</li>
	                        </ul>

							<c:choose>
								<c:when test="${boardState == 1}">
									<form method="POST" class="mypageFrom">
										<c:forEach var="board" items="${myBoard }">
											<ul class="mypage_board" id="join_board_list">
												<li><input type="checkbox" name="boardChk" value="${board.idx }" onclick='selectOne(event)'></li>
												<li>${board.idx }</li>
												<li><a href="${cpath}/partyInf/${board.idx}">${board.city }</a></li>
												<li><a href="${cpath}/partyInf/${board.idx}">${board.title }</a></li>
												<li><a href="${cpath}/partyInf/${board.idx}">${board.nowMember } / ${board.maxMember }</a></li>
												<li><a href="${cpath}/partyInf/${board.idx}">${board.meetDate }</a></li>
												<li><button type="button" class="myBoardBtn boardModifyBtn" data-idx="${board.idx }">수정</button></li>
											</ul>
										</c:forEach>
										<div class="mypage_board_paging">
												<c:if test="${paging.startPage != 1 }">
													<a href="${cpath}/mypage_default/myWrite?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">prev&lt;</a>
												</c:if>
												<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
													<c:choose>
														<c:when test="${p == paging.nowPage }">
															<b>${p }</b>
														</c:when>
														<c:when test="${p != paging.nowPage }">
															<a href="${cpath}/mypage_default/myWrite?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
														</c:when>
													</c:choose>
												</c:forEach>
												<c:if test="${paging.endPage != paging.lastPage}">
													<a href="${cpath}/mypage_default/myWrite?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">next&gt;</a>
												</c:if>
											<input type="submit" class="mypage_boardDelete" id="myBoardDelete" value="삭제">
										</div>
									</form>
								</c:when>
								<c:when test="${boardState == 2}">
									<c:forEach var="join" items="${myJoin }">
										<ul class="mypage_board" id="join_board_list">
											<li></li>
											<li>${join.boardIdx }</li>
											<li><a href="${cpath}/partyInf/${join.boardIdx}">${join.city }</a></li>
											<li><a href="${cpath}/partyInf/${join.boardIdx}">${join.title }</a></li>
											<li><a href="${cpath}/partyInf/${join.boardIdx}">${join.writer }</a></li>
											<li><a href="${cpath}/partyInf/${join.boardIdx}">${join.playDate }</a></li>
											<li><button class="myBoardBtn JoinCancel" value="${join.boardIdx }" onclick="JoinCancel()">참여취소</button></li>
										</ul>
									</c:forEach>
									<div class="mypage_board_paging">
										<div style="display: block; text-align: center;">
											<c:if test="${paging.startPage != 1 }">
												<a href="${cpath}/mypage_default/myJoin?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">prev&lt;</a>
											</c:if>
											<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
												<c:choose>
													<c:when test="${p == paging.nowPage }">
														<b>${p }</b>
													</c:when>
													<c:when test="${p != paging.nowPage }">
														<a href="${cpath}/mypage_default/myJoin?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
													</c:when>
												</c:choose>
											</c:forEach>
											<c:if test="${paging.endPage != paging.lastPage}">
												<a href="${cpath}/mypage_default/myJoin?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">next&gt;</a>
											</c:if>
										</div>
									</div>
								</c:when>
								<c:when test="${boardState == 3}">
									<c:forEach var="reply" items="${myReply }">
										<ul class="mypage_board" id="join_board_list">
											<li></li>
											<li>${reply.idx }</li>
											<li><a href="${cpath}/partyInf/${reply.boardIdx}">${reply.boardIdx }</a></li>
											<li><a href="${cpath}/partyInf/${reply.boardIdx}">${reply.content }</a></li>
											<li><a href="${cpath}/partyInf/${reply.boardIdx}">${reply.writer }</a></li>
											<li></li>
											<li><button class="myBoardBtn replyDelete" value="${reply.idx }" onclick="ReplyDelete()">댓글 삭제</button></li>
										</ul>
									</c:forEach>
									<div class="mypage_board_paging">
											<c:if test="${paging.startPage != 1 }">
												<a href="${cpath}/mypage_default/myReply?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">prev&lt;</a>
											</c:if>
											<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
												<c:choose>
													<c:when test="${p == paging.nowPage }">
														<b>${p }</b>
													</c:when>
													<c:when test="${p != paging.nowPage }">
														<a href="${cpath}/mypage_default/myReply?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
													</c:when>
												</c:choose>
											</c:forEach>
											<c:if test="${paging.endPage != paging.lastPage}">
												<a href="${cpath}/mypage_default/myReply?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">next&gt;</a>
											</c:if>
										</div>
								</c:when>
                           	</c:choose>
						</nav>
					</c:when>
					<c:when test="${empty myJoin && empty myBoard && empty myReply && pageState == 2}">
						<div class="wishListBox">
							<div class="select_main">
								<div id="city">
									<c:forEach var="dto" items="${list }">
										<div class="city_context" style="margin-left: 45px;">
											<div class="city_img_wrap">
												<div class="city_img">
													<img id="wishImg" style="width: 320px;" src="${dto.wishImg }" data-city="${dto.wishCity}"
														onclick="wishmodal()">
												</div>
											</div>
											<div class="city_inf">
												<div>${dto.wishCountry }</div>
												<div>${dto.wishCity }</div>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</c:when>
				</c:choose>
            </div>
        </div>
    </div>
</div>
<script src="${cpath }/resources/js/mypageWish.js"></script>


<script>
const result = document.getElementById('city')
const wishList = document.querySelectorAll('.city_context > .city_img_wrap > .city_img')

const deleteBtn = document.querySelector('.delete_au')
deleteBtn.onclick = deleteHandler


function JoinCancel(event) {
	const JoinCancel = document.querySelector('.JoinCancel')
	let idx = JoinCancel.value
	console.log(idx)
	location.href = cpath + '/myJoinOut/' + idx
	
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
			location.href = cpath + '/mypage_default/myReply' 
		}
		else {
			alert('삭제 실패..')
		}
	})
}
window.onload = render(result)
wishmodal(event)


</script>
<script src="${cpath }/resources/js/mypage_memberDelete.js"></script>
<script src="${cpath }/resources/js/mypage_memberUpdate.js"></script>
<script src="${cpath }/resources/js/check.js"></script>
<script src="${cpath }/resources/js/mypage_boardModify.js"></script>

</body>
</html>