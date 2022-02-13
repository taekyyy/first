function btnClick(event) {
		switch(kinds) {
		case 'join':
			location.href = cpath + '/' + 'joinParty/' + idx
			break;
		case 'cancle':
			location.href = cpath + '/' + 'outParty/' + idx
			break;
		case 'delete':
			const url = cpath + '/deleteBoard/' + idx
			const opt = {
				method: 'GET'
			}
			fetch(url, opt)
			.then(resp => resp.text())
			.then(text => {
				if(text == 1) {
					alert('게시글이 삭제되었습니다')
					location.href = document.referrer
				}
				else {
					alert('삭제 실패')
				}
			})
			break;
		}	
	}

function replyDelete(event) {
	const deleteReplyBtn = document.getElementById('deleteReplyBtn')
	let idx = deleteReplyBtn.value
	console.log(idx)
	const url = cpath + '/deleteReply/' + idx
	const opt = {
		method: 'Delete'
	}
	fetch(url, opt)
	.then(resp => resp.text())
	.then(text => {
		if(text == 1) {
			alert('댓글이 성공적으로 삭제되었습니다')
			history.go(0)
		}
		else {
			alert('삭제 실패..')
		}
	})
}

function submitHandler(event) {
	event.preventDefault()
	
	const ob = {}
	const formData = new FormData(event.target)
	
	for(key of formData.keys()) {
		const value = formData.get(key)
		ob[key] = value
	}
	const url = cpath + '/replyInsert'
	const opt = {
		method: 'POST',
		body: JSON.stringify(ob),
		headers: {
			'Content-Type': 'application/json; charsest=utf-8'
		}
	}
	fetch(url, opt)
	.then(resp => resp.text())
	.then(text => {
		if(text == 1) {
			event.target.reset()
			alert('댓글 등록 성공!')
			location.href = cpath + '/partyInf/' + idx
		}
		else {
			alert('등록 실패...')
		}
	})
}