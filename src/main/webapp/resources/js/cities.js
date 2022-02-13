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

function citymodal(event) {
     cityList.forEach(img => img.onclick = function(event) {
     const country = document.querySelector('.cities_modal_content')
     
      let idx = event.target.dataset.idx
      console.log(idx)
      const url = cpath + '/cities/' + idx
      const opt = {
         method: 'GET'
      }
      fetch(url, opt)
      .then(resp => resp.json())
      .then(json => {
         if(json.msg != null) {
            alert(json.msg)
            location.href = cpath + "/login"
         }
         else {
              render(result) 
               const dto = json.travel
               console.log(dto)
               country.innerHTML = ''
               const dom = getDomFromDTO(dto)
               country.innerHTML += dom
               
               const modal = document.querySelector('.cities_modal')
              const closeBtn = document.querySelector('.citiesClose')
              const body = document.querySelector('body')
               closeBtn.addEventListener('click', (event) => { //모달 닫기 버튼
                  if(modal.style.display = 'flex') { 
                       modal.style.display = 'none'
                       body.style.overflowY = 'auto'
                  }
               })
               
               const imtyCount = document.querySelector('.imty_count')
               const imty = document.querySelector('.imtyBtn')
               const wishChk = json.wishChk
               
               console.log('처음 하트 ' + wishChk)
               console.log('처음 위시카운트 ' + json.wishCnt)
               if(wishChk === 1) {
                  imty.innerHTML = ''
                     imtyCount.innerHTML = ''
                  imty.innerHTML = '<i class="fas fa-heart"></i>'
                     imtyCount.innerHTML = json.wishCnt
               }
               else {
                  imty.innerHTML = ''
                     imtyCount.innerHTML = ''
                 imty.innerHTML = '<i class="far fa-heart"></i>'
                    imtyCount.innerHTML = json.wishCnt
               }
              
               const toPartyBtnList = document.querySelectorAll('#toPartyBtn')
                  toPartyBtnList.forEach(function(btn) {
                 btn.onclick = function(event) {
                    const city = event.target.dataset.city
                    location.href = cpath + '/party/' + city
                 }
              }) 
             }
         })
      })
   }

// 좋아요를 누르면이 아니라 도시를 누르면 insert/delete 되버림
// 위에 코드를 post로 받아서 해결 ? 
const wishBtnList = document.querySelectorAll('.imtyBtn')
wishBtnList.forEach(function(btn) {
      btn.onclick = wishHandler(event)
})

function wishHandler(target) {
   const imty = document.querySelector('.imtyBtn')
   const imtyCount = document.querySelector('.imty_count')
   const city = document.querySelector('.imtyBtn').value
    console.log(city)
    
    const url = cpath + '/wish/' + city
    const opt = {
      method: 'GET'
   }
   fetch(url, opt)
   .then(resp => resp.json())
   .then(json => {
      if(json.wishChk == 0) {
         imty.innerHTML = ''
         imtyCount.innerHTML = ''
         imty.innerHTML = '<i class="fas fa-heart"></i>' //채워짐
         imtyCount.innerHTML = json.wishCnt
      }
      else {
         imty.innerHTML = ''
         imtyCount.innerHTML = ''
         imty.innerHTML = '<i class="far fa-heart"></i>' //비어져있음
         imtyCount.innerHTML = json.wishCnt
      }
      
   })
}
      
function getDomFromDTO(dto) {
   let dom = ``
      dom += `<div class="cities_content">`
         dom += `      <button class="citiesClose"><i class="fas fa-times"></i></button>`
         dom += `    <h1>${dto.city}</h1>`
         dom += `    <h2>${dto.country}</h2>`
         dom += `    <div class="cityContent">${dto.content}</div>`
         dom += `    <div class="simbol">`
         dom += `       <div class="part">`
         dom += `        <button type="button" class="imtyBtn" value="${dto.city}" onclick="wishHandler()"></button>`
         dom += `        <div class="imty_count"></div>`
         dom += `       </div>`
         dom += `     <div class="part">`
         dom += `         <div class="imty">동행글 개수</div>`
         dom += `         <div class="imty_inf">${dto.boardCnt}</div>`
         dom += `     </div>`
         dom += `     <div class="part">`
         dom += `         <div class="imty">비자여부</div>`
         dom += `         <div class="imty_inf visa">${dto.visa}</div>`
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