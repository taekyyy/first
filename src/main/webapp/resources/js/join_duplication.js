// 비밀번호 중복

function printPw() {
	   const pw = document.querySelector('input[name="userpw"]').value
	   const pwChk = document.querySelector('input[name="userpw_check"]').value
	   const result = document.getElementById('pwResult')
	   const resist = document.getElementById('pwResist')
	// 지금안쓰는 이유 프로젝트 완성전에 설정하면 회원 가입 테스트 로그인 테스트 귀찮아짐...
//	    if(!/^[a-zA-Z0-9!@#$%^&*()?_~]{6,15}$/.test(newPassword1))
	// {
	//  alert("비밀번호는 숫자, 영문, 특수문자 조합으로 6~15자리를 사용해야 합니다.");
	//  return false;
	// }
	   if (!/^[a-zA-Z0-9!@#$%^&*()?_~]{6,15}$/.test(pw)) {
		   if(pw == '') {
			   resist.innerHTML = ''
		   }
	   	   else if(pw != '' && pw < 16) {
	   		   resist.innerHTML = '<span>비밀번호는 숫자, 영문, 특수문자 조합으로 6~15자리를 사용해야 합니다</span>'
	   	   }
	   	   else if(pw.length > 5) {
	           resist.innerHTML = '<span style="color: red;">비밀번호 자릿 수를 벗어났습니다</span>'
           }
	   }
	   else {
	      resist.innerHTML = ''
	   }

	   if (pw == pwChk && pw != '') {
	      result.innerHTML = '<span>비밀번호 중복 확인 완료</span>'
	   }
	   else if(pw != pwChk && pw != '') {
		   result.innerHTML = '<span style="color: red;">비밀번호가 다릅니다</span>'
	   }
	   else {
	      result.innerHTML = ''
	   }
	}

