<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="${cpath}/resources/js/mypage_memberDelete_modal.js"></script>
<div id="mypage_title">마이페이지</div>
<div class="deleteModal">
   <div class="delete_overlay"></div>
    <div id="delete_context">
        <h2>회원탈퇴</h2>
        <div class="delete_context">가입된 회원정보가 모두 <span style="color: rgba(255,0,0,0.7); font-weight: 700;">삭제</span>됩니다. 작성하신 게시물은 삭제되지 않습니다.</div>
        <div class="delete_context">탈퇴 후 같은 계정으로 재가입 시 기존에 가지고 있던 개인 기록들은 복원되지 않으며, 사용 및 업로드했던 이미지도 확인 불가능합니다.</div>
        <div class="delete_context">회원 탈퇴를 진행하시겠습니까?</div>
        <div class="delete_box">
            <button class="user_delete cancel">취소</button>
            <button class="user_delete delete_au">회원탈퇴</button>
        </div>
    </div>
</div>