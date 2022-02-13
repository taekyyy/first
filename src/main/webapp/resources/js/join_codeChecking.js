const sendDuplicate = document.getElementById('sendDuplicate')
const emailDup = document.querySelector('.emailDup')    
const nickDup = document.querySelector('.nickDup')		
const emailDupBtn = document.getElementById('emailConfirm')
const codeChkForm = document.getElementById('codeChecking')
const codeChkMsg = document.getElementById('codeCheckingMsg')

let second = 120		//인증시간
let interval = 0

// timer
function timer() {
	let min = Math.floor(second/60) + ''
	let sec = second % 60 + ''
	if(min.length < 2)	min = '0' + min
	if(sec.length < 2)	sec = '0' + sec
	
	const format = min + ' : ' + sec
	const div = document.querySelector('.timer')
	div.innerText = format
	
	if(second <= 0) {
		div.style.color = 'red'
		clearInterval(interval)
		codeChkForm.querySelector('input').placeholder = '유효기간이 지났습니다'
		codeChkForm.querySelector('input').disabled = 'disabled'
			
		codeChkMsg.innerText = '인증번호를 다시 발송해주세요'
		codeChkMsg.style.color = 'red'
	}
	second -= 1

}
// email이 DB에 있는지 확인
//function sendDuplication123() {
//	const email = document.querySelector('input[name="useremail"]').value
//	console.log(email)
//	const url = cpath + '/emailDuplicate/'
//	const opt = {
//			method: 'POST',
//			body: email,
//			headers: {
//				'Content-Type' : 'application/json; charset=utf-8'
//			}
//	}
//	if(email == '') {
//		emailDup.innerHTML = ''
//	}
//	fetch(url, opt)
//	.then(resp => resp.json())
//	.then(text => {
//		console.log(text)
//		
//		let dom = ``
//		emailDup.innerHTML = ``
//			
//		if(text == 1) {
//			dom += `<span style="color: blue">존재하는 이메일, 인증번호 발송완료</span>`            
//			emailDup.innerHTML = dom
//			codeChkForm.style.display = 'block'
//		}
//		else {
//			dom += `<span style="color: red">존재하지 않는 이메일입니다</span>`
//			emailDup.innerHTML = dom
//		}
//	})
//}


function sendMailHandler() {
	event.preventDefault()
	const email = document.querySelector('input[name="useremail"]').value
	const url = cpath + '/emailDuplicate/' + email + '/'
	const opt = {
		method: 'GET'
	}
	fetch(url, opt)
	.then(resp => resp.json())
	.then(json => {
		console.log(json)
		emailDup.innerText = json.message
		emailDup.style.color = json.status == 'OK' ? 'blue' : 'red'
		if(json.status =='OK') {
			codeChkForm.style.display = 'block'
			
			interval = setInterval(timer, 1000)
			second = 120
			codeChkForm.querySelector('input').disabled = ''
			codeChkForm.querySelector('input').placeholder = '인증번호를 입력하세요'
			codeChkForm.querySelector('input').focus()
			codeChkMsg.innerText = ''
		}
	})
}

function codeChkBtn() {
	const codeChk = document.querySelector('input[name="codeCheck"]').value
	const form1 = document.getElementById('newPassForm1')
	const form2 = document.getElementById('newPassForm2')
	console.log(codeChk)
	if(second <= 0) {
		alert('유효시간이 지났습니다. 다시 메일을 보내주세요')
		return
	}
	const url = cpath + '/getCodeChkResult/' + codeChk + '/'
	const opt = {
			method: 'GET'
	}
	fetch(url, opt)
	.then(url,opt)
	.then(resp => resp.json())
	.then(json => {
		console.log(json)
		codeChkMsg.innerText = json.message
		
		if(json.status == 'OK') {
			clearInterval(interval)
			document.querySelector('.timer').innerHTML = ''
			form1.style.display = 'none'
			form2.style.display = 'block'
		}
		else {
			codeChkMsg.style.color = 'red'
			codeChk.select()
		}

	})
}

function modifyPass() {
	const email = document.querySelector('input[name="useremail"]').value
	const newPass = document.querySelector('input[name="userpw"]').value
	const ob = newPass
	const url = cpath + '/newPass/' + email
	const opt = {
		method: 'POST',
		body: newPass,
		headers: {
	         'Content-Type': 'application/json; charset=utf-8'
	      }
	}
	fetch(url,opt)
	.then(resp=>resp.text())
	.then(text => {
//		console.log(text)
//		if(text == 1) {
			alert('수정 성공, 다시 로그인해주세요')
	        window.location= cpath + '/login'
//		}
//		 else {
//	         alert('수정실패')
//	      }
	})
	
}



