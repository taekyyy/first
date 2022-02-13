const modifyModalBtn = document.getElementById('memberUpdate')
const modifyModal = document.querySelector('.modify_modal')

	modifyModalBtn.addEventListener('click', (event) =>{
		if(modifyModal.style.display = 'none') {
			modifyModal.style.display = 'flex'
			body.style.overflow = 'hidden'
		    loadHandler(event)
		}
	})
