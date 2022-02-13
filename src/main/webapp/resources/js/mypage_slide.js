const slide = document.querySelector('.mypage_slide')
const prev = document.querySelector('.prev')
const next = document.querySelector('.next')
const slideImg = document.querySelector('.mypage_slide li')
const slideCount = slideImg.length

const slideWidth = 426;
const slidepadding = 30;
let imgCount = 3
let currentIdx = 0;

function moveSlide(num) {
    slide.style.left = -num * imgCount * (slideWidth + slidepadding) + 'px';
    currentIdx = num
}

prev.addEventListener('click', function () {
    if(currentIdx !== 0) moveSlide(currentIdx -1);
  })
  
next.addEventListener('click', function() {
    if(currentIdx !== slideCount -1) {
      moveSlide(currentIdx + 1);
    }
  })

