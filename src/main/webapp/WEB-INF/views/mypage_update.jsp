<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="${cpath}/resources/js/mypage_memberUpdate_modal.js"></script>

<div class="modify_modal">
   <div class="modify_context">
   	   <button type="button" class="citiesClose"><i class="fas fa-times"></i></button>
       <h2>회원정보 수정</h2>
       <form class="modify_form">
<!--            <p> -->
<!--                  <span>이메일</span><br> -->
<%--                  <input type="text" id="email" name="useremail" value="${info.useremail}" readonly> --%>
<!--            </p> -->
<!--            <p> -->
<!--                   <span>닉네임</span><br> -->
<%--                   <input type="text" id="username" name="username" value="${info.username}" required> --%>
<!--            </p> -->
<!--            <p> -->
<!--                   <span>비밀번호</span><br> -->
<!--                   <input type="password" id="userpw" name="userpw" required> -->
<!--            </p> -->
<!--            <p> -->
<!--                <input id="modify_btn" type="submit" value="수정"> -->
<!--            </p> -->
       </form>
      </div>
</div>

<script src="${cpath}/resources/js/mypage_update_duplication.js"></script>
<script>
   const form = document.forms[0]
   const list = document.querySelector('.modify_form')
   
   form.onsubmit = submitHandler
   window.onload = loadHandler
</script>