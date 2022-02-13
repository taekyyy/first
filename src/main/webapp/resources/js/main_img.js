const imgArray = new Array();
	imgArray[0] = cpath + '/resources/img/main_img/main_imgA.jpg'
	imgArray[1] = cpath + '/resources/img/main_img/main_imgA2.jpg'
	imgArray[2] = cpath + '/resources/img/main_img/main_imgA4.jpg'
	
	function showImage() {
		let imgNum = Math.round(Math.random() * 3);
		const mainImg = document.getElementById('main_img')
		mainImg.src = imgArray[imgNum]
		
		setTimeout('showImage()', 5000)
	}
	
	onload = showImage
			
	
