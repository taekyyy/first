const sendDuplicate = document.getElementById('sendDuplicate')
const emailDup = document.querySelector('.emailDup')    
const nickDup = document.querySelector('.nickDup')		
const emailDupBtn = document.getElementById('emailConfirm')
function sendDuplication() {
	const email = document.querySelector('input[name="useremail"]').value
	console.log(email)
	const url = cpath + '/emailDuplicate/'
	const opt = {
			method: 'POST',
			body: email,
			headers: {
				'Content-Type' : 'application/json; charset=utf-8'
			}
	}
	if(email == '') {
		emailDup.innerHTML = ''
	}
	fetch(url, opt)
	.then(resp => resp.json())
	.then(text => {
		console.log(text)
		
		let dom = ``
		emailDup.innerHTML = ``
			
		if(text == 1) {
			dom += `<span style="color: red">중복된 이메일입니다</span>`            
			emailDup.innerHTML = dom
		}
		else {
			dom += `<span style="color: blue">사용가능한 이메일입니다</span>`
			emailDup.innerHTML = dom
		}
	})
}