const i = 1;
const mainsSlides = document.querySelector('.main_slides')
const slideImg = document.querySelectorAll('.main_slides li') //slides 자식 li
const slideCount = slideImg.length
const prev = document.querySelector('.main_prev')
const next = document.querySelector('.main_next')
const slideWidth = 664; //이미지크기
const slidepadding = 40;//패딩간격
let currentIdx = 0
//전체 슬라이드 컨테이너 넓이 설정/한개 넓이 + 슬라이드간 간격 * 슬라이드 개수
// slides.style.width = (slideWidth + slideMargin) * slideCount + 'px'

function moveSlide(num) {
  //전체 슬라이드 컨테이너를 -왼쪽(오른쪽)
	mainsSlides.style.left = -num * (slideWidth + slidepadding) + 'px';
  currentIdx = num;
}

prev.addEventListener('click', function () {
	if(currentIdx !== 0) {
		console.log(i)
		moveSlide(currentIdx -1)
	}
})

next.addEventListener('click', function() {
	if(currentIdx !== slideCount -1) {
		moveSlide(currentIdx + 1);
	}
})




//function moveAuto() {
//  let i = 0
//  for(i = 0; i < slideCount; i++){
//    slides.style.left = -1 * (slideWidth + slidepadding) + 'px';
//    setTimeout(moveAuto,3000);
//  }
//  i++;
//  if(i == slideCount) {
//    i = 1;
//    slides.style.left = 0;
//  }
//  setTimeout(moveAuto,3000);
//}


//moveAuto()









