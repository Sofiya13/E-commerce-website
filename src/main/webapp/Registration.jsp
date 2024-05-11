<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>Registration</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/boxicons@2.1.4/css/boxicons.min.css">
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Poppins:wght#300;400;500;600;700;800;900&display=swap')
	;

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: "Courier New", Courier;
}

body {
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
	background-image: url('https://www.ttfs.com.au/wp-content/uploads/2017/02/shade-cloth.jpg');
	background-position: top;
	 background-size: cover; /* Set the background size to cover the full page */
    background-repeat: no-repeat; /* Prevent the background image from repeating */
    opacity: 0.8;
	}

.wrapper {
	position: relative;
	width: 750px;
	height: 650px;
	background: black;
	border: 1px solid #0ef;
	overflow: hidden;
	box-shadow: 0 0 25px #0ef;
}

.wrapper .form-box {
	position: absolute;
	top: 0;
	width: 50%;
	height: 100%;
	display: flex;
	flex-direction: column;
	justify-content: center;
}

.wrapper .form-box.register {
	right: 0;
	padding: 0 40px 0 60px;
}

.form-box h2 {
	padding-top: 50px;
	font-size: 39px;
	color: #fff;
	text-align: center;
}

.form-box .input-box {
	position: relative;
	width: 100%;
	height: 50px;
	margin: 25px 0;
}

.input-box input {
	width: 100%;
	height: 111%;
	background: transparent;
	border: none;
	outline: none;
	border-bottom: 2px solid #fff;
	margin-top: 7px;
	font-size: 23px;
	transition: .5s;
	color: #fff;
	font-weight: 500;
	padding-right: 23px;
}

.input-box input:focus, .input-box input:valid {
	border-bottom-color: #0ef;
}

.input-box label {
	position: absolute;
	top: 50%;
	left: 43px;
	transform: translate(-50%);
	font-size: 18px;
	color: #fff;
	pointer-events: none;
	transition: .5s;
}

.input-box input:focus ~label, .input-box input:valid ~label {
	top: -5px;
	color: #0ef;
}

.input-box i {
	position: absolute;
	top: 50%;
	right: 0;
	transform: translate(-50%);
	font-size: 18px;
	color: #fff;
	transition: .5s;
}

.input-box input:focus ~i, .input-box input:valid ~i {
	color: #0ef;
}

.btn {
	margin-top: 10px;
	position: relative;
	width: 100%;
	height: 45px;
	background: transparent;
	border: 2px solid #0ef;
	outline: none;
	border-radius: 40px;
	cursor: pointer;
	font-size: 22px;
	color: #2F3C7E;
	font-weight: 600;
	z-index: 1;
	overflow: hidden;
	position: relative;
}

.btn::before {
	content: '';
	position: absolute;
	top: -100%;
	left: 0;
	width: 100%;
	height: 300%;
	background: linear-gradient(#A9A654, #619CE9, #A9A654, #619CE9);
	z-index: -1;
	transition: .5s;
}

.btn:hover::before {
	top: 0;
}

.form-box .logreg-link {
	font-size: 15px;
	color: #fff;
	text-align: center;
	margin: 30px 0 20px;
}

.logreg-link p a {
	color: #0ef;
	text-decoration: none;
	font-weight: 600;
}

.logreg-link p a:hover {
	text-decoration: underline;
}

.wrapper .info-text {
	position: absolute;
	top: 0;
	width: 50%;
	height: 100%;
	display: flex;
	flex-direction: column;
	justify-content: center;
}

.wrapper .info-text.register {
	left: 0;
	text-align: left;
	padding: 0 150px 60px 40px;
	margin-top: -99px;
}

.info-text h2 {
	font-size: 40px;
	color: #fff;
	line-height: 1.3;
	text-transform: uppercase;
}

.info-text p {
	font-size: 20px;
	color: black;
}

span {
	padding-bottom: 16px;
	width: 60%;
}

.wrapper .bg-animate2 {
	position: absolute;
	top: 100px;
	left: -50px;
	width: 850px;
	height: 600px;
	background: linear-gradient(45deg, #A9A654, #FBEAEB);
	border-bottom: 3px solid #0ef;
	transform: rotate(-11deg) skewY(-41deg);
	transform-origin: bottom left;
}
.top-menu {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
   
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 10px 20px;
    z-index: 999; 
}


.menu-icon  {
    text-decoration: none;
    color: #fff;
    margin-right: 90px;
    font-size: 25px;
    margin-left: 100px;
}
.menu-icon:hover{
background-color: gray;
}
.top-menu a {
    text-decoration: none;
    color: #fff;
    margin-right: 20px;
    font-size: 24px;
}

.top-menu .logo {
    font-size: 28px;
    font-weight: bold;
     justify-content: center;
}


body {
    padding-top: 70px; 
    background-image: url('https://www.wallpaperandblindslongisland.com/wp-content/uploads/2018/05/wallpaper-with-shade.png');
    background-size: cover;
    background-repeat: no-repeat;
    font-family: "Courier New", Courier;
    opacity: 0.7;
}
.logo {
    border: none;
    outline: none;
}
</style>
</head>
<body>
    <div class="top-menu">
        <div class="menu-icon">
            <a href="Login.jsp" class='bx bx-arrow-back'></a>
        </div>
       <div class="logo">
    <img src="images/logo1.png" alt="Logo" width="200" height="80" style="border-radius: 70%;">
</div>


        <div class="menu-icon">
            <a href="index.jsp" class='bx bx-home'></a>
        </div>
    </div>
	<div class="wrapper">
		<span class="bg-animate2"></span>
		<div class="form-box register">
			<h2>Sign Up</h2>
			<form action="RegistrationController" method="post">
				<div class="input-box">
					<input type="text" name="username" required> <label>Username</label>
					<i class='bx bxs-user'></i>
				</div>
				<div class="input-box">
					<input type="password" name="password" required> <label>Password</label>
					<i class='bx bxs-lock-alt'></i>
				</div>
				<div class="input-box">
					<input type="text" required name="email"> <label
						style="left: 25px">Email</label> <i class='bx bxs-envelope'></i>
				</div>
				<div class="input-box">
					<input type="text" name="fullname" required> <label>Full
						Name</label> <i class='bx bxs-edit-alt'></i>
				</div>
				<div class="input-box">
					<input type="text" name="contact" required maxlength="10">
					<label style="left: 30px">Contact</label> <i class='bx bx-phone'></i>
				</div>
				<button type="submit" class="btn">Sign up</button>

				<div class="logreg-link">
					
					<p>
						Already have an account? <a href="Login.jsp"> Login</a>
					</p>
				</div>
			</form>
		</div>
		<div class="info-text register">
			<h2 style="color: #2F3C7E">Welcome!</h2>
			<p>Please fill in this form to create an account!</p>
		</div>
	</div>
</body>
</html>
