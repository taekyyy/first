<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

	<div class="main_left">
        <h1>여행 동행 사이트</h1>
        <strong>onEarth(us)</strong>
        <a href="${cpath }/cities"><button class="mainBtn"><span>여행지</span><span>Click</span></button></a>
    </div>

    <div class="main_right">
        <img id="main_img" onerror="this.src='${cpath }/resources/img/main_img/main_img.jpg';">
    </div>
    <div class="main_middle">
        <div class="main_middle_sul">
        	<div class="sul_gap">가고 싶은 여행지가 있다면</div>
        	<div class="sul_gap">여행지를 선택해 게시물을 작성하거나</div>
        	<div class="sul_gap">원하는 게시물에 참여를 해보세요</div>
        </div>
        <div class="step">
            <h3><b>SELECT</b></h3>
            <div>여행지 선택</div>
        </div>
        <div class="step">
            <h3><b>WRITE</b></h3>
            <div>게시글 작성</div>
        </div>
        <div class="step">
            <h3><b>JOIN</b></h3>
            <div>참여하기</div>
        </div>
    </div>
    <div class="main_bottom">
        <div class="main_bottom_title">
             추천 여행지
        </div>
        <!-- 슬라이드 css, js가 따로있음 -->
        <div class="main_bottom_blog">  
            <ul class="main_slides">
                <li>
                    <div class="slide_img">
                        <a href="https://m.blog.naver.com/PostView.naver?blogId=34510_hee&logNo=221731109433&navType=by">
                            <img src="${cpath }/resources/img/main_img/blogImg.png">
                        </a>
                    </div>
                    <div class="img_text">
                        <h2>희자매의 상하이 여행</h2>
                    </div>
                </li>
                <li>
                    <div class="slide_img">
                        <a href="https://blog.naver.com/hp0210/222209676470">
                            <img src="https://a.cdn-hotels.com/gdcs/production166/d135/a06c88d0-2446-4d2f-96d9-7afc2d01e8fb.jpg?impolicy=fcrop&w=800&h=533&q=medium">
                        </a>
                        <div class="img_text">
                            <h2>이탈리아 여행 그리움을 타고 떠나는 랜선여행</h2>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="slide_img">
                        <a href="https://blog.naver.com/acubens_/221655976437">
                            <img src="http://www.dentalnews.or.kr/data/photos/20210417/art_16197487593433_d6caeb.jpg">
                        </a>
                        <div class="img_text">
                            <h2>가족과 함께 떠나는 호주 여행</h2>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="slide_img">
                        <a href="https://blog.naver.com/borumi0312/222633857239">
                            <img src="http://www.noblesse.com/shop/data/board/magazine/e2b79ec811ba8a2d">
                        </a>
                        <div class="img_text">
                            <h2>독일여행, 베를린 돔(Berliner Dom) 그리고 전망대</h2>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="slide_img">
                        <a href="https://m.blog.naver.com/suyeon1809/221853000970">
                            <img src="https://i0.wp.com/tripplus.co.kr/wp-content/uploads/2020/11/blog_the_trip_220879304496_1.jpg?w=696&ssl=1">
                        </a>
                        <div class="img_text">
                            <h2>몬트리올 퀘벡 4일간의 여행</h2>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="slide_img">
                        <a href="https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=nau2001&logNo=221270772236">
                            <img src="https://pds.joongang.co.kr/news/component/htmlphoto_mmdata/201912/25/91e7352c-6e54-45bc-b18c-3aa4585d6f78.jpg">
                        </a>
                        <div class="img_text">
                            <h2>베트남 다낭여행 3박 4일 여행코스</h2>
                        </div>
                    </div>
                </li>
            </ul>
            <div class="main_controller">
                <div class="main_prev"><i class="fas fa-arrow-left"></i></div>
            <div class="main_next"><i class="fas fa-arrow-right"></i></div>
            </div>
        </div>
    </div>
	<script src="${cpath }/resources/js/main_slide.js"></script>
    <script src="${cpath }/resources/js/main_img.js"></script>
</body>
</html>