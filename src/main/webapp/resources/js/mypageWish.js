function render(target) {          
	
     const modalBtn = target.querySelectorAll('.city_img img')  
     const modal = document.querySelector('.cities_modal')
     const body = document.querySelector('body')
     
     modalBtn.forEach(btn => btn.onclick = function() {
            if(modal.style.display = 'none') {
                modal.style.display = 'flex'
                body.style.overflowY = 'hidden'
            }        
     })
}

function wishmodal(event) {
	wishList.forEach(img => img.onclick = function(event) {
		const country = document.querySelector('.cities_modal_content')
		let city = event.target.dataset.city
		
		console.log(city)
		const url = cpath + '/mypage_default/' + city
		const opt = {
			method: 'GET'
		}
		
		fetch(url, opt)
		.then(resp => resp.json())
		.then(json => {
			json.forEach(dto => {
				country.innerHTML = ''
				const dom = getDomFromDTO(dto)
				country.innerHTML += dom
				
				const modal = document.querySelector('.cities_modal')
				const closeBtnA = document.querySelector('.citiesCloseA')
			    const body = document.querySelector('body')
				closeBtnA.addEventListener('click', (event) => {
			         if(modal.style.display = 'flex') { 
			             modal.style.display = 'none'
			             body.style.overflowY = 'auto'
			         }
			     })
			     
				const toPartyBtnList = document.querySelectorAll('#toPartyBtn')
         	   	toPartyBtnList.forEach(function(btn) {
        		   btn.onclick = function(event) {
        			   const city = event.target.dataset.city
//        			   console.log(city)
        			   location.href = cpath + '/party/' + city
        		   }
        	   })
			})
		})
	})
}

const wishBtnList = document.querySelectorAll('.imtyBtn')
wishBtnList.forEach(function(btn) {
	   btn.onclick = wishHandler(event)
})


function wishHandler(target) {
	
	const imty = document.querySelector('.imtyBtn')
	const city = document.querySelector('.imtyBtn').value
    console.log(city)
    
    const url = cpath + '/wish/' + city
    const opt = {
		method: 'GET'
	}
	fetch(url, opt)
	.then(resp => resp.json())
	.then(json => {
		console.log(json)
		console.log(json.status)
//		const status = document.querySelector('.imty_status')
//		status.innerText = ''
		if(json.wishChk == 1) {
//			location.href = cpath + '/mypage_default'
			history.go(0)
		}
		else {
			imty.innerHTML = ''
			imty.innerHTML = '<i class="far fa-heart"></i>'
		}
		
	})
}


function getDomFromDTO(dto) {
   let dom = ``
   dom += `<div class="cities_content">`
   dom += `	   <button class="citiesCloseA"><i class="fas fa-times"></i></button>`
   dom += `    <h1>${dto.city}</h1>`
   dom += `    <h2>${dto.country}</h2>`
   dom += `    <h3>${dto.content}</h3>`
   dom += `    <div class="simbol">`
   dom += `    	<div class="part">`
   dom += `     	<button class="imtyBtn" value="${dto.city}" onclick="wishHandler()"><i class="fas fa-heart"></i></button>`
   dom += `     	<div class="imty_count">${dto.wishCnt}</div>`
   dom += `    	</div>`
   dom += `     <div class="part">`
   dom += `         <div class="imty">동행글 개수</div>`
   dom += `         <div class="imty_inf">${dto.boardCnt}</div>`
   dom += `     </div>`
   dom += `     <div class="part">`
   dom += `         <div class="imty">비자여부</div>`
   dom += `         <div class="imty_inf">${dto.visa}</div>`
   dom += `     </div>`
   dom += `     <div class="part">`             
   dom += `         <div class="imty">시차</div>`
   dom += `         <div class="imty_inf">${dto.timeD}</div>`
   dom += `     </div>`
   dom += `   </div>`
   dom += `   <button id="toPartyBtn" data-city="${dto.city}">동행 구하기</button>`
   dom += `</div>`
         
   return dom   
}

