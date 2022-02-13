const modalBtn = document.getElementById('memberDelete')
const closeBtn = document.querySelector('.delete_overlay')
const modal = document.querySelector('.deleteModal')
const cancellBtn = document.querySelector('.cancel')


    modalBtn.addEventListener('click', (event) =>{
        if(modal.style.display = 'none') {
            modal.style.display = 'flex'
            body.style.overflow = 'hidden'
            	
        }
    })

    closeBtn.addEventListener('click', (event) =>{
        if(modal.style.display = 'flex') {
            modal.style.display = 'none'
            body.style.overflow = 'auto'	
        }
    })
    
    cancellBtn.addEventListener('click', (event) =>{
        if(modal.style.display = 'flex') {
            modal.style.display = 'none'
            body.style.overflow = 'auto'
        }
    })
    