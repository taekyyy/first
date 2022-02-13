function getDomFromDTO(admin) {
	let dom = ``
	dom += `<div class="admin_user">`
	dom += `<h2>위시리스트</h2>`
	dom += `<span>${admin.wishcnt}개</span>`
	dom += `</div>`
	dom += `<div class="admin_user">`
	dom += `<h2>전체글</h2>`
	dom += `<span>${admin.boardcnt}개</span>`
	dom += `</div>`
	dom += `<div class="admin_user">`
	dom += `<h2>회원정보</h2>`
	dom += `<span>${admin.membercnt}개</span>`
	dom += `</div>`
	dom += `<div class="admin_user">`
	dom += `<h2>여행지</h2>`
	dom += `<span>${admin.travelcnt}개</span>`
	dom += `</div>`
	return dom
}

function render(event) {

	const url = cpath + '/admin'
	const opt = {
		method: 'GET'
	}
	
	fetch(url, opt)					
	.then(resp => resp.json())		
									
	.then(json => {					
		target.innerHTML = ''		
		
	})
}

function travelAdd(url, name) { 
	var url = cpath + '/adminTravelAdd'
	var name = '여행지 추가'
	var option = 'width = 500, height = 700, top = 100, left = 700, scrollbars=yes, status=yes, resizable=yes'
	window.open(url, name, option)
}
