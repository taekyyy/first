<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>

<div class="title">
   <h3>어디로 여행을 가시나요?</h3>
</div>

<!-- 검색창 -->
<div class="search">
   <form class="search" method="GET">
      <span class="search">
         <input id="search" type="search" name="search" placeholder="검색할 나라이름 혹은 도시이름" autocomplete="off">
         <button id="searchBtn" type="submit"><i class="fas fa-search" id="searchIcon"></i></button>
      </span>
   </form>
</div>

<!-- 대륙선택 버튼 -->
<div class="land">
   <span><a href="${cpath }/cities"><button class="clickBtn">전체</button></a></span>
   <span><button class="clickBtn" value="아시아">아시아</button></span>
   <span><button class="clickBtn" value="유럽">유럽</button></span>
   <span><button class="clickBtn" value="아메리카">아메리카</button></span>
   <span><button class="clickBtn" value="아프리카">아프리카</button></span>
   <span><button class="clickBtn" value="오세아니아" style="width: auto;">오세아니아</button></span>
</div>     

<!-- 나라선택(메인) -->
<div class="select_main">
   <div id="city">
       <c:forEach var="dto" items="${list }">
         <div class="city_context">
            <div class="city_img_wrap">
               <div class="city_img">
                  <img src= "${dto.mainImg}" data-idx="${dto.idx}" onclick="citymodal()">
               </div>
            </div>
            <div class="city_inf">
               <div>${dto.country}</div>
               <div>${dto.city}</div>
            </div>
         </div>
       </c:forEach> 
   </div>
</div>

<!-- 여기는 모달창 모달창 모달창 모달창 모달창 모달창 모달창 모달창-->
<div class="cities_modal">
   <div class="cities_modal_overlay"></div>
   <div class="cities_modal_content trip1"></div>
</div>


<script src="${cpath }/resources/js/cities.js"></script>

<script>
   const result = document.getElementById('city')
   const cityList = document.querySelectorAll('.city_context > .city_img_wrap > .city_img')
   const btnList = document.querySelectorAll('.clickBtn')
   const searchBtn = document.getElementById('searchBtn')
   let search = document.getElementById('search').value   

   btnList.forEach(btn => btn.onclick = function(event) {
      let target = event.target
      let continent = target.value
      location.href = cpath + '/' + 'selectContinent/' + continent
   })

   searchBtn.onclick = function(event) {   
      location.href = cpath + '/cities?search=' + search
   }
   
   window.onload = citymodal(event)
   
</script>

</body>
</html>