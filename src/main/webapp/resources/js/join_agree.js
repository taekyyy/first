//개인정보 수집동의 팝업창 스크립트
function agreePopUp1(url, name) { 
	var url = cpath + '/agreePopUp1'
	var name = '개인정보 수집동의'
	var option = 'width = 800, height = 500, top = 100, left = 200, scrollbars=yes, status=yes, resizable=yes'
	window.open(url, name, option)
}

// 이용약관 동의 팝업창 스크립트
function agreePopUp2(url, name) {
	var url = cpath + '/agreePopUp2'
	var name = '이용약관 동의'
	var option = 'width = 510, height = 500, top = 100, left = 200, scrollbars=yes, status=yes, resizable=yes'
	window.open(url, name, option)
}

// 체크박스 여부에 따른 버튼 바꾸기
function isBoxChecked() {
	let agree1 = document.getElementById('agree1').checked
    let agree2 = document.getElementById('agree2').checked
    const box = document.getElementById('box')
    const boxChecking = document.getElementById('boxChecking')
    const sb = document.getElementById('sb')
    const sbdv = document.getElementById('sbdv')
    const sendDuplicate = document.getElementById('sendDuplicate')
	const emailDup = document.querySelector('.emailDup')    
	const nickDup = document.querySelector('.nickDup')		
	const emailDupBtn = document.getElementById('emailConfirm')
	const pw = document.querySelector('input[name="userpw"]').value
    const pwChk = document.querySelector('input[name="userpw_check"]').value
    const result = document.getElementById('pwResult')
    const resist = document.getElementById('pwResist')
	
	if(!agree1 || !agree2) { 
	   alert('약관동의를 하셔야 가입이 가능합니다')
   } 
    else { 
    	const email = document.getElementById('member_email').value
    	console.log(email)
    	const url = cpath + '/emailDuplicate/'
    	const opt = {
    			method: 'POST',
    			body: email,
    			headers: {
    				'Content-Type' : 'application/json; charset=utf-8'
    			}
    	}
    	fetch(url, opt)
    	.then(resp => resp.json())
    	.then(text => {
    		if(text == 1) {
    			alert('이메일 중복체크 해주세요')
    		}
    		else {
    			   console.log(pw)
    			   if (pw == pwChk && pw != '') {
    				    box.style.display = 'none'
   			    	    boxChecking.style.display = 'none'
   				        sb.style.display = 'block'
   				        sbdv.style.display = 'block'
    			   }
    			   else {
   				    	alert('비밀번호가 다릅니다')
    			   }
    		}
    	})
    } 
}
		