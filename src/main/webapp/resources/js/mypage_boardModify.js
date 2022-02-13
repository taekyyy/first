const boardModifyBtn = document.querySelectorAll('.boardModifyBtn') // 수정 버튼

const boardmodifyModal = document.querySelector('.myboardModify') // 수정 모달창
const modifyHidden = document.querySelector('.modifyHidden') // 모달을 숨기기위한 class 선택자

boardModifyBtn.forEach(modify => {
   modify.addEventListener('click', (event) => {
	  boardmodifyModal.classList.remove('modifyHidden')
      const idx = event.target.dataset.idx
      console.log(idx)
      myBoardMidifyHandler(idx)
   })
})


function myBoardMidifyHandler(idx) {
   const url = cpath + '/myboardSelectOne/'+ idx
   const opt = {
      method: 'GET'
   }
   fetch(url, opt)
   .then(resp => resp.json())
   .then(json => {
      console.log(json)
      boardmodifyModal.innerHTML = ''
      const dom = myboardDom(json)
      boardmodifyModal.innerHTML = dom
      
      const myboardInfForm = document.querySelector('.myboardInf_form')
//      myboardInfForm.onsubmit = myboardUpdate
      
      const boardmodifyCloseBtn = document.querySelector('.myboardClose')
      boardmodifyCloseBtn.addEventListener('click', () => {
     boardmodifyModal.classList.add('modifyHidden')
      })
   })
}

function myboardDom(json) {
   let dom = ``
         dom += `<div class="myboard_inf_context">`
         dom += `<button type="button" class="myboardClose"><i class="fas fa-times"></i></button>`
         dom += `<h2>동행 글쓰기</h2>`
         dom += `<form class="myboardInf_form" method="POST" action="${cpath}/mypage_default/myWrite/modify">`
         dom += `<input type="text" id="myboardInf_title" name="title" value="${json.title }" readonly>`
         dom += `<div id="gap"></div>`
         dom += `<span>도시&nbsp;&nbsp;</span><input type="text" id="tripInf_city" value="${json.city}" name="city" readonly>`
         dom += `<div id="gap"></div>`
            dom += `<input id="writer" type="text" name="writer" value="${json.writer }" readonly>`
    	    dom += `<div id="gap"></div>`
            dom += `<span>최대인원 수&nbsp;&nbsp;</span>`
            dom += `<input type="number" name="maxMember" min="2" value="${json.maxMember }" required></p>`
    	    dom += `<div id="gap"></div>`
            dom += `<span>만나는 날짜&nbsp;&nbsp;</span>`
        	dom += `<div id="gap"></div>`
            dom += `<input type="date" class="myboardInf_date" name="meetDate" required>`
    	    dom += `<div id="gap"></div>`
            dom += `<span>만나는 목적</span>`
    	    dom += `<div id="gap"></div>`
            dom += `<input type="radio" id="tasty" name="purpose" value="맛집탐방">`
            dom += `<label for="tasty">맛집 탐방</label>`
            dom += `<input type="radio" id="party" name="purpose" value="파티">`
            dom += `<label for="party">파티</label>`
            dom += `<input type="radio" id="shopping" name="purpose" value="쇼핑">`
            dom += `<label for="shopping">쇼핑</label>`
            dom += `<input type="radio" id="watch" name="purpose" value="관람">`
            dom += `<label for="watch">관람</label>`
            dom += `<input type="radio" id="tour" name="purpose" value="투어">`
            dom += `<label for="tour">투어</label>`
            dom += `<input type="radio" id="guitar" name="purpose" value="기타">`
            dom += `<label for="guitar">기타</label>`
    	    dom += `<div id="gap"></div>`
		    dom += `<textarea cols="89" rows="5" name="content">${json.content }</textarea>`
            dom += `<input type="hidden" class="myboardInf_date" name="country" value="${json.country}">`
            dom += `<input type="hidden" class="myboardInf_date" name="idx" value="${json.idx}">`
        	dom += `<div class="mypageModifyBtn">`
            dom += `<input type="submit" id="mypageModifyBtn" value="등록">`
        	dom += `</div>`
            dom += `</form>`
        	dom += `</div>`
               
     return dom
}
//function myboardUpdate(event) {
//   event.preventDefault()
//   const ob = {}
//   const formData = new FormData(event.target)
//   for(key of formData.keys()) {
//      const value = formData.get(key)
//      ob[key] = value
//   }
//   console.log(ob)
//   const url = cpath + '/myboardUpdate'
//   const opt = {
//         method: 'POST',
//         body: JSON.stringify(ob),
//         headers: {
//            'Content-Type': 'application/json; charset=utf-8'
//         }
//   }
//   fetch(url, opt)
//   .then(resp => resp.json())
//   .then(json => {
//    console.log(json)
////    location.href= cpath + '/alert'
//    
// <input type="radio" id="watch" name="purpose" value="관람">
//	<label for="watch">관람</label>
//  	<input type="radio" id="tour" name="purpose" value="투어">
//  	<label for="tour">투어</label>     
//   })
//}

