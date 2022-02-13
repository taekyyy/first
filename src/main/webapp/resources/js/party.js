function submitHandler(event) {
	event.preventDefault()
	
	const ob = {}
	const formData = new FormData(event.target)
	
	for(key of formData.keys()) {
		const value = formData.get(key)
		ob[key] = value
	}
	const url = cpath + '/party'
	const opt = {
		method: 'POST',
		body: JSON.stringify(ob),
		headers: {
			'Content-Type': 'application/json; charset=utf-8'
		}
	}
	
	fetch(url, opt)
	.then(resp => resp.text())
	.then(text => {
		if(text == 1) {
			event.target.reset()
			alert('등록 성공!!!')
			location.href = cpath + '/' + 'party/' + city
		}
		else {
			event.target.querySelector('input').select()
			alert('등록 실패...')
		}
	})
}


