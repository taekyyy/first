<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="tripModal">
	<div class="trip_inf_context">
	    <button type="button" class="partyClose"><i class="fas fa-times"></i></button>
	    <h2>동행 글쓰기</h2>
	         <form class="tripInf_form" method="POST">
	<!--            			<div id="gap"></div> -->
	       		<input type="text" id="tripInf_title" name="title" placeholder="제목을 입력하세요" required><br>
	       		
	       		<div id="gap"></div>
	       		
	       		<span>도시&nbsp;&nbsp;</span><input type="text" id="tripInf_city" value="${dto.city}" name="city" readonly>
	       		
	       		<div id="gap"></div>
	       		
	       		<input id="writer" type="text" name="writer" value="${login.useremail }" readonly>  <!-- 회원 메일 -->
	       		
	       		<div id="gap"></div>
	       		
	       		<span>최대인원 수&nbsp;&nbsp;</span>
	       		
	       		<input type="number" name="maxMember" min="2" required>
	       		
	       		<div id="gap"></div>
	       		
				<span>만나는 날짜&nbsp;&nbsp;</span>
				
				<div id="gap"></div>
				
				<input type="date" id="tripInf_date" name="meetDate" required>
				
				<div id="gap"></div>
				
	           	<span>만나는 목적</span>
	           	
	           	<div id="gap"></div>
	           	
	           	<input type="radio" id="tasty" name="purpose" value="맛집탐방">
	           	<label for="tasty">맛집</label>
	           	
	           	<input type="radio" id="party" name="purpose" value="파티">
	           	<label for="party">파티</label>
	           	
	           	<input type="radio" id="shopping" name="purpose" value="쇼핑">
	           	<label for="shopping">쇼핑</label>
	           	
	           	<input type="radio" id="watch" name="purpose" value="관람">
	           	<label for="watch">관람</label>
	           	
	           	<input type="radio" id="tour" name="purpose" value="투어">
	           	<label for="tour">투어</label>
	           	
	           	<input type="radio" id="guitar" name="purpose" value="기타">
	           	<label for="guitar">기타</label>
	           	
	           	<div id="gap"></div>
	              	
			   <textarea cols="89" rows="5" name="content" placeholder="만날 시간을 꼭 적어주세요!!" required ></textarea>
			   
	           <input type="hidden" id="tripInf_date" name="country" value="${dto.country}">   <!-- 나라 -->
	           
	           <div class="toPartyInf">
	           		<input id="partyModalBtn" style="margin-left: 240px;" type="submit" value="등록">
	           	</div>
	        </form>
    </div>
</div>
