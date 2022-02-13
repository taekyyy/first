function deleteHandler(event) {
   
    const url = cpath + '/mypage_delete'
    const opt = {
          method: 'GET'
    }
    fetch(url,opt)
    .then(resp=>resp.text())
    .then(text => {
       console.log(text)
       if(text == 1) {
          alert('탈퇴 처리되었습니다. 감사합니다')
          window.location= cpath+'/logout'
       }
       else {
          alert('탈퇴 실패')
       }
    })
}