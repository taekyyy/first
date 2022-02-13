<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행지 추가</title>
</head>
<style>
	.travelAddPop {
		overflow-x: hidden; 
	}
	.travelAddPop > h1 {
		text-align: center;
	}
	.travelAddtypeForm > input, textarea {
		display: block;
		height: 35px;
		width: 300px;
		position: relative;
		left: 17%;
		margin-bottom: 20px;
	}
	.travelAddtypeForm > textarea {
		resize: none;
		width: 302px;
		height: 100px;
	}
	.travelImgUpload {
		position: relative;
		left: 17%;
	}
	.travelAddBtn {
		text-align: center;
		margin-top: 30px;
	}
	.travelAddBtn > input {
		height: 30px;
	    width: 200px;
	    border: 1px solid #1e5784;
	    background-color: #1e5784;
	    border-radius: 0.2cm;
	    color: white;
	    font-size: large;
	    font-weight: 900;
	    cursor: pointer;
	    transition: all 0.9s, color 0.3s;
	}
	.travelAddBtn > input:hover {
		box-shadow: 0 80px 0 0 rgba(0,0,0,0.25) inset, 
				0 -80px 0 0 rgba(0,0,0,0.25) inset;
	}
</style>
<body>

	<div class="travelAddPop">
		<h1>여행지 추가</h1>
		<hr><br>
		
		<div class="travelAddForm">
			<form method="POST" enctype="multipart/form-data">
				<div class="travelAddtypeForm">
					<input type="text" name="continent" placeholder="대륙 이름을 입력해주세요" required autofocus>
					<input type="text" name="country" placeholder="나라 이름을 입력해주세요" required>
					<input type="text" name="city" placeholder="도시 이름을 입력해주세요" required>
					<input type="number" name="timeD" placeholder="시차를 입력해주세요" required>
					<input type="number" name="lati" placeholder="위도를 입력해주세요" step="0.0000000001" required>
					<input type="number" name="longi" placeholder="경도를 입력해주세요" step="0.0000000001" required>
					<input type="text" name="visa" placeholder="비자여부를 입력해주세요" required>
					
					<textarea name="content" placeholder="내용을 입력해주세요" required></textarea>
			 	</div>
			 	<div class="travelImgUpload">
				 	<h4>메인 사진</h4>
				 	<input type="file" name="uploadMain" required>
				 	
				 	<h4>서브 사진1</h4>
				 	<input type="file" name="uploadSub1" required>
				 	
				 	<h4>서브 사진2</h4>
				 	<input type="file" name="uploadSub2" required>
				 	
				 	<h4>서브 사진3</h4>
				 	<input type="file" name="uploadSub3" required>
				 	
				 	<h4>서브 사진4</h4>
				 	<input type="file" name="uploadSub4" required>
				 	
				 	<h4>서브 사진5</h4>
				 	<input type="file" name="uploadSub5" required>
			 	</div>
			 	<div class="travelAddBtn">
			 		<input type="submit" value="추가">
			 	</div>
			</form>
		</div>
	</div>
</body>
</html>