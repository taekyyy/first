function printPw() {
const pw = document.querySelector('input[name="userpw"]').value
const pwChk = document.getElementById('userpw_chk').value
const result = document.getElementById('modify_pwResult')
const resist = document.getElementById('modify_pwResist')
// 지금안쓰는 이유 프로젝트 완성전에 설정하면 회원 가입 테스트 로그인 테스트 귀찮아짐...
//    if(!/^[a-zA-Z0-9!@#$%^&*()?_~]{6,15}$/.test(newPassword1))
// {
//  alert("비밀번호는 숫자, 영문, 특수문자 조합으로 6~15자리를 사용해야 합니다.");
//  return false;
// }
   
   if (!/^[A-Za-z0-9]{2,4}$/.test(pw)) {
      resist.innerHTML = '<span>2~4자리 수를 입력하세요</span>'
         if(pw.length > 4) {
            resist.innerHTML = '&nbsp;'
            resist.innerHTML = '<span style="color: red;">비밀번호 자릿 수를 벗어났습니다</span>'
         }
   }
   else {
      resist.innerHTML = '&nbsp;'
   }

   if (pw == pwChk && pw != '') {
      result.innerHTML = '<span>비밀번호 중복 확인 완료</span>'
   }
   else {
      result.innerHTML = '&nbsp;'
   }
}