const modalBtn = document.getElementById('tripInf')
const closeBtn = document.querySelector('.partyClose')
const modal = document.querySelector('.tripModal')
modalBtn.addEventListener('click', (event) => {
    
        if(modal.style.display = 'none') {
            modal.style.display = 'flex'
        }
		form.onsubmit = submitHandler
    })
    closeBtn.addEventListener('click', (event) => {
        if(modal.style.display = 'flex') {
            modal.style.display = 'none'
        }
    })