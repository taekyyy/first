<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>


<div class="msgBox">
   <div class="msgContext">
      <span>${msg }</span>
      <div class="msgBtn">
         <button class="masBtnAC" id="msgAgree">확인</button>
      </div>
   </div>
</div>
<script>
   const msg = '${msg}'
   const url = '${url}'
   const msgAgree = document.getElementById('msgAgree')
   
   msgAgree.onclick = function() {
      if(url == '') {
          history.go(-1);
       }
       else {
          location.href = cpath + '/' + url
       }
   }

</script>
</body>
</html>