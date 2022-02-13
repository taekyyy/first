function submitHandler(event) {
   event.preventDefault()
   
   const ob = {}
   const formData = new FormData(event.target)
   for(key of formData.keys()) {
      const value = formData.get(key)
      ob[key] = value
   }
   console.log(ob)
   
   const url = cpath + '/mypage_update'
   const opt = {
      method: 'POST',
      body: JSON.stringify(ob),
      headers: {
         'Content-Type': 'application/json; charset=utf-8'
      }
   }
   fetch(url,opt)
   .then(resp => resp.text())
   .then(text => {
      console.log(text)
      if(text == 1) {
         alert('수정 성공, 다시 로그인해주세요')
         window.location= cpath + '/login'
      }
      else {
         alert('수정실패')
      }
   })
}

function loadHandler(event) {
   const url = cpath + '/mypage_update'
   const opt = {
         method:'GET'
   }
   fetch(url,opt)
   .then(resp=>resp.json())
   .then(json => {
//      console.log(json)
      list.innerHTML = ''
      for(dto of json) {
         const dom = getDom(dto)
         if(typeof dom =='string') {
               list.innerHTML += dom
            }
            else {
               list.appendChild(dom)
            }
      }
      const modifyModal = document.querySelector('.modify_modal')
  	  const modifyCloseBtn = document.querySelector('.citiesClose')
  	  modifyCloseBtn.addEventListener('click', (event) =>{
          if(modifyModal.style.display = 'flex') {
          	  modifyModal.style.display = 'none'
              body.style.overflow = 'auto'
          }
      })
   })
}


function getDom(dto) {
   let dom = ``
      dom += `<p>`
      dom += `<label for="email">`
      dom +=`<span>이메일</span><br>`
      dom += ` <input type="text" id="email" class="memberInput" name="useremail" value="${dto.useremail}" readonly>`
      dom += `</label>`
      dom +=`</p>`
      dom +=`<p>`
      dom += `<label for="username">`
      dom +=`<span>닉네임</span><br>`
      dom += `<input type="text" id="username" class="memberInput" name="username" value="${dto.username}" required>`
      dom += `</label>`
      dom +=`</p>`
      dom +=`<p>`
      dom += `<label for="userpw">`
      dom +=`<span>비밀번호</span><br>`
      dom += ` <input type="password" id="userpw" class="memberInput" name="userpw" onkeyup="printPw()" required>`
      dom += `</label>`
      dom +=`</p>`
      dom +=`<div class="modify_pwChk" id="modify_pwResist">&nbsp;</div>`
      dom += `<p>`
      dom +=`<label for="userpw_chk">`
      dom += `<span>비밀번호 확인</span><br>`
      dom +=`<input type="password" id="userpw_chk" class="memberInput" onkeyup="printPw()">`
      dom +=`</label>`
      dom +=`</p>`
      dom +=`<div class="modify_pwChk" id="modify_pwResult">&nbsp;</div>`
      dom +=`<div class="modify_btn_box">`
      dom +=`<input id="modify_btn" type="submit" value="수정">`
      dom +=`</div>`

      return dom
}