<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<script>const cpath = '${cpath}'</script>
<script src="${cpath }/resources/js/admin.js"></script>

   <div id="admin_title">관리자 페이지</div>
    <div class="admin_list">
        <div class="admin_list_left">
            <nav>
                <ul>
                    <li><a href="${cpath }/admin">전체글 관리</a></li>
                    <li><a href="${cpath }/admin/memberAll">회원정보 관리</a></li>
                    <li><a href="${cpath }/admin/travelAll">여행지</a></li>
                </ul>
            </nav>
        </div>
        <div class="admin_list_right_wrap">
            <div class="admin_list_right"> <!-- admin_list_bottom-->
	        	<div class="admin_list_right_top" id="adminCnts">
	                <div class="admin_user">
	                    <h2>위시리스트</h2>
	                    <span>${admin.wishcnt }개</span>
	                </div>
	                <div class="admin_user">
	                    <h2>전체글</h2>
	                    <span>${admin.boardcnt }개</span>
	                </div>
	                <div class="admin_user">
	                    <h2>회원정보</h2>
	                    <span>${admin.membercnt }개</span>
	                </div>
	                <div class="admin_user" style="border-right: none;">
	                    <h2>여행지</h2>
	                    <span>${admin.travelcnt }개</span>
	                </div>
	        	</div>
                <c:choose>
                	<c:when test="${adminState == 1 }">
                		<div class="admin_right_title">  <!-- admin_right_title-->
	                   		<div>전체 글 관리</div>
		                </div>
			                <div class="admin_right_search">  <!-- admin_bottom_search-->
			                    <form class="admin_borderSelect">  <!-- admin_list_bottom-->
			                         <input autocomplete="off" type="search" name="search" placeholder="입력해주세요" value="${param.search }" autofocus>
			                        <input class="adminSearchBtn" type="submit" value="찾기">
			                    </form>
			                    <span></span>
			                </div>
			                <div class="admin_board_bottom">
			                <nav>
			                <form method="POST">
	                        	<ul class="mypage_board" id="join_board_title">
		                           <li>
		                         		<input type="checkbox" name="boardChk" value="selectAll" onclick='selectAll(this)'>
		                           </li>	
		                           <li>No</li>
		                           <li>도시</li>
		                           <li>제목</li>
		                           <li>작성자</li>
		                           <li>현재 인원/희망 인원</li>
		                           <li>작성일</li>
	                        	</ul>
	                        	<c:forEach var="board" items="${board }">
									<ul class="mypage_board" id="join_board_list">
										<li><input type="checkbox" name="boardChk" value="${board.idx }" onclick='selectOne(event)'></li>
										<li>${board.idx }</li>
										<li>${board.city }</li>
										<li><a href="${cpath}/partyInf/${board.idx}">${board.title }</a></li>
										<li>${board.writer }</li>
										<li>${board.nowMember} / ${board.maxMember }</li>
										<li>${board.writeDate }</li>
									</ul>
								</c:forEach>
							<div class="board_paging">
								<div style="display: block; text-align: center; width: 96%; padding-top: 10px;">
									<c:if test="${paging.startPage != 1 }">
										<a
											href="${cpath}/admin?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">prev&lt;</a>
									</c:if>
									<c:forEach begin="${paging.startPage }"
										end="${paging.endPage }" var="p">
										<c:choose>
											<c:when test="${p == paging.nowPage }">
												<b>${p }</b>
											</c:when>
											<c:when test="${p != paging.nowPage }">
												<a
													href="${cpath}/admin?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
											</c:when>
										</c:choose>
									</c:forEach>
									<c:if test="${paging.endPage != paging.lastPage}">
										<a
											href="${cpath}/admin?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">next&gt;</a>
									</c:if>
									<input type="submit"class="boardDelete" id="boardDelete" value="삭제">
								</div>
									</form>
								</nav>
			                </div>
                	</c:when>
                	<c:when test="${adminState == 2}">
                		<div class="admin_right_title">  <!-- admin_right_title-->
	                   		<div>회원 정보</div>
		                </div>
			                <div class="admin_right_search">  <!-- admin_bottom_search-->
			                    <form class="admin_borderSelect">  <!-- admin_list_bottom-->
			                         <input autocomplete="off" type="search" name="search" placeholder="입력해주세요" value="${param.search }" autofocus>
			                        <input class="adminSearchBtn" type="submit" value="찾기">
			                    </form>
			                    <span></span>
			                </div>
			                <div class="admin_board_bottom">
			                   <nav>
			                    <form method="POST">
	                        	<ul class="mypage_board" id="join_board_title">
		                           <li>
		                         		<input type="checkbox" name="boardChk" value="selectAll" onclick='selectAll(this)'>
		                           </li>	
		                           <li>No</li>
		                           <li>이름</li>
		                           <li>이메일</li>
		                           <li>작성 글 갯수</li>
		                           <li>참여 글 갯수</li>
		                           <li>위시리스트</li>
		                           <li>상태</li>
	                        	</ul>
	                        	<c:forEach var="list" items="${list }" varStatus="status">
									<ul class="mypage_board" id="join_board_list">
										<li><input type="checkbox" name="boardChk" value="${list.idx }" onclick='selectOne(event)'></li>
										<li>${list.idx }</li>
										<li><a href="${cpath }/memberDetails/${list.idx }" >${list.username }</a></li>
										<li><a href="${cpath }/memberDetails/${list.idx }" >${list.useremail }</a></li>
										<li>${list.writeCnt }</li>
										<li>${list.joinCnt }</li>
										<li>${list.wishCnt }</li>
										<li>
											<c:if test="${list.resignState == 1}">회원</c:if>
											<c:if test="${list.resignState == 0}">휴면</c:if>
										</li>
									</ul>
								</c:forEach>
							<div class="board_paging">
								<div style="display: block; text-align: center; width: 97%; padding-top: 10px;">
									<c:if test="${paging.startPage != 1 }">
										<a href="${cpath}/admin/memberAll?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">prev&lt;</a>
									</c:if>
									<c:forEach begin="${paging.startPage }"
										end="${paging.endPage }" var="p">
										<c:choose>
											<c:when test="${p == paging.nowPage }">
												<b>${p }</b>
											</c:when>
											<c:when test="${p != paging.nowPage }">
												<a
													href="${cpath}/admin/memberAll?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
											</c:when>
										</c:choose>
									</c:forEach>
									<c:if test="${paging.endPage != paging.lastPage}">
										<a
											href="${cpath}/admin/memberAll?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">next&gt;</a>
									</c:if>
									<input type="submit"class="boardDelete" id="boardDelete" value="삭제">
								</div>
							</div>
							</form>
						</nav>
						</div>
                	</c:when>
				<c:when test="${adminState == 3 }">
					<div class="admin_right_title">
						<!-- admin_right_title-->
						<div>여행지 관리</div>
					</div>
					<div class="admin_right_search">
						<!-- admin_bottom_search-->
						<form class="admin_borderSelect">
							<!-- admin_list_bottom-->
							<input autocomplete="off" type="search" autocomplete="off" name="search"
								placeholder="입력해주세요" value="${param.search }" autofocus>
							<input class="adminSearchBtn" type="submit" value="찾기">
						</form>
						<span></span>
					</div>
					<div class="admin_board_bottom">
						<form method="POST">
							<nav>
								<ul class="mypage_board" id="join_board_title">
									<li><input type="checkbox" name="boardChk"
										value="selectAll" onclick='selectAll(this)'></li>
									<li>No</li>
									<li>대륙</li>
									<li>도시</li>
									<li>나라</li>
									<li>비자</li>
									<li>시차</li>
								</ul>
								<c:forEach var="travel" items="${travel }">
									<ul class="mypage_board" id="join_board_list">
										<li><input type="checkbox" name="boardChk"
											value="${travel.idx }"></li>
										<li>${travel.idx }</li>
										<li>${travel.continent }</li>
										<li>${travel.city }</li>
										<li>${travel.country }</li>
										<li>${travel.visa }</li>
										<li>${travel.timeD }</li>
									</ul>
								</c:forEach>
								<div class="board_paging">
								<div style="display: block; text-align: center; width: 97.5%; padding-top: 10px;">
									<c:if test="${paging.startPage != 1 }">
										<a href="${cpath}/admin/travelAll?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">prev&lt;</a>
									</c:if>
									<c:forEach begin="${paging.startPage }"
										end="${paging.endPage }" var="p">
										<c:choose>
											<c:when test="${p == paging.nowPage }">
												<b>${p }</b>
											</c:when>
											<c:when test="${p != paging.nowPage }">
												<a
													href="${cpath}/admin/travelAll?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
											</c:when>
										</c:choose>
									</c:forEach>
									<c:if test="${paging.endPage != paging.lastPage}">
										<a
											href="${cpath}/admin/travelAll?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">next&gt;</a>
									</c:if>
									<span><button class="boardDelete" onclick="travelAdd()" type="button">추가</button></span>
									<span><input type="submit" class="boardDelete" id="boardDelete" value="삭제"></span>
								</div>
							</div>
							</nav>
						</form>
					</div>
				</c:when>
			</c:choose>
            </div>
        </div>
    </div>
<script src="${cpath }/resources/js/check.js"></script>
<script>

</script>

</body>
</html>