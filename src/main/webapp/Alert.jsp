<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>Login</title>
<link rel="stylesheet" id="style.css">

<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'
	rel='stylesheet'>
</head>

<style>
@import
	url('https://fonts.googleapis.com/css2?family=poppins:wght#300;400;500;600;700;800;900&display=swap')
	;

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}
body {
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    background-image: url('https://www.wallpaperandblindslongisland.com/wp-content/uploads/2018/05/wallpaper-with-shade.png');
    background-size: cover; /* Set the background size to cover the full page */
    background-repeat: no-repeat; /* Prevent the background image from repeating */
    font-family: "Courier New", Courier;
    opacity: 0.7;
}



.wrapper {
	position: relative;
	width: 750px;
	height: 450px;
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

.wrapper .form-box.login {
	left: 0;
	padding: 0 60px 0 40px;
}

.form-box h2 {
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
	color: #Oef;
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

.btn{
	margin-top: 26px;
	position: relative;
	width: 100%;
	height: 45px;
	background: transparent;
	border: 3px solid #0ef;
	outline: none;
	border-radius: 40px;
	cursor: pointer;
	font-size: 20px;
	color: #2F3C7E;
	font-weight: 600;
	z-index: 1;
	overflow: hidden;
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
	font-size: 14.5px;
	color: #fff;
	text-align: center;
	margin: 20px 0 10px;
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

.wrapper .info-text.login {
	right: 0;
	text-align: right;
	padding: 0 40px 60px 150px;
}

.info-text h2 {
	font-size: 45px;
	color: #2F3C7E;
	line-height: 1.3;
	text-transform: uppercase;
}

.info-text p {
	font-size: 16px;
	color: #fff;
}

span {
	padding-bottom: 16px;
	width: 60%;
}

.wrapper .bg-animate {
	position: absolute;
	top: -4px;
	right: 0;
	width: 850px;
	height: 600px;
	background: linear-gradient(45deg, #A9A654, #FBEAEB);
	border-bottom: 3px solid #0ef;
	transform: rotate(10deg) skewY(40deg);
	transform-origin: bottom right;
}
</style>

<body>
	<div class="wrapper">
		<span class="bg-animate"></span>
		<div class="form-box login">
			<h2>Login</h2>
			<form method="post">
    <div class="input-box">
        <input type="text" name="username" required> <label>Username</label>
        <i class='bx bxs-user'></i>
    </div>
    <button type="submit" class="btn" formaction="MailSender">Send OTP</button>
    <div class="input-box">
        <input type="text" name="otp"> <label>Enter OTP</label>
        <i class='bx bxs-lock-alt'></i>
    </div>
    <button type="submit" class="btn" formaction="Otp_verifying">Submit</button>
</form>

		</div>
	</div>
</body>

</html>