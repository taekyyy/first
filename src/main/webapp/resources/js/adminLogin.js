function adminLogin() {
	const admin = document.getElementById('admin_form')
	const login = document.getElementById('login_form')
	const join = document.getElementById('join')
	const adminLogin = document.getElementById('adminLogin')
	
	admin.style.display = 'block'
	login.style.display = 'none'
	join.style.display = 'none'
	adminLogin.style.display = 'none'
}

function goBack() {
	const admin = document.getElementById('admin_form')
	const login = document.getElementById('login_form')
	const join = document.getElementById('join')
	const adminLogin = document.getElementById('adminLogin')
	
	admin.style.display = 'none'
	login.style.display = 'block'
	join.style.display = 'block'
	adminLogin.style.display = 'block'
}