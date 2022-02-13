<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<%@ include file="partyModal.jsp" %>

    <div class="party_left">
        <h1>동행 게시글</h1>
        <div class="country A">
            <h3>${dto.city }</h3> 
        </div>
        <nav class="party_board_nav">
        	<ul class="party_board_ul" id="party_board_title">
        		<li>작성일</li>
        		<li>제목</li>
        		<li>작성자</li>
        		<li>동행일</li>        	
        	</ul>
        	<c:forEach var="dto" items="${list }">
	        	<ul class="party_board_ul" id="party_board_list">
	        			<li><a href="${cpath}/partyInf/${dto.idx}">${dto.writeDate }</a></li>
	        			<li><a href="${cpath}/partyInf/${dto.idx}">${dto.title }</a></li>
	        			<li><a href="${cpath}/partyInf/${dto.idx}">${dto.writer }</a></li>
	        			<li><a href="${cpath}/partyInf/${dto.idx}">${dto.meetDate }</a></li>
	        	</ul>
        	</c:forEach>
        </nav>
        <div class="board_page">
        	<div style="display: block; text-align: center;">
				<c:if test="${paging.startPage != 1 }">
					<a href="${cpath}/party/${dto.city }?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">prev&lt;</a>
				</c:if>
				<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
					<c:choose>
						<c:when test="${p == paging.nowPage }">
							<b>${p }</b>
						</c:when>
						<c:when test="${p != paging.nowPage }">
							<a href="${cpath}/party/${dto.city }?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
						</c:when>
					</c:choose>
				</c:forEach>
				<c:if test="${paging.endPage != paging.lastPage}">
					<a href="${cpath}/party/${dto.city }?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">next&gt;</a>
				</c:if>
			</div>  	
	        <button id="tripInf">동행글 쓰기</button>
        </div>
    </div>
    <div class="party_right"></div>
<script src="${cpath }/resources/js/party.js"></script>

<script async defer src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBpP1shKMy1q1GtXaODxlpNh5I9RWnXD7k&callback=initMap&region=kr"></script>
<script>
    const body = document.querySelector('body')
	const form = document.querySelector('.tripInf_form')
	const city = '${dto.city}'
	const lati = '${dto.lati}'
	const longi = '${dto.longi}'
	
	var map;
	var service;
	var infowindow;
	var marker;
	
	function initMap() {
		  var loca = new google.maps.LatLng(lati, longi);

		  infowindow = new google.maps.InfoWindow();

		  map = new google.maps.Map(
		      document.querySelector('.party_right'), {center: loca, zoom: 15});
		  
		  marker = new google.maps.Marker({
				position: loca,
				map: map,
				draggable: true,
				animation: google.maps.Animation.BOUNCE
			});
		  marker.addListener('click', toggleBounce);
		  
	}
	function toggleBounce() {
		if (marker.getAnimation() !== null) {
			marker.setAnimation(null);
		} else {
			marker.setAnimation(google.maps.Animation.BOUNCE);
		}
	}
</script>
<script src="${cpath }/resources/js/party_modal.js"></script>
</body>
</html>