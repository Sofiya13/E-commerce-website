<!DOCTYPE html>
<html>
<head>
<title>User Request Form</title>
<link href='https://fonts.googleapis.com/css?family=Merienda' rel='stylesheet'>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<style>
body {
	background-image:url('https://d1yn1kh78jj1rr.cloudfront.net/image/preview/rDtN98Qoishumwih/light-blue-background_GkNvxFHd_PM.jpg');
	 background-size: cover; /* Set the background size to cover the full page */
    background-repeat: no-repeat;
	font-family: Merienda;
}

.container {
	background-image: url('https://cdn.wallpapersafari.com/8/68/i7xkMe.jpg');
	background-size: cover; /* Set the background size to cover the full page */
    background-repeat: no-repeat;
	width: 45%;
	padding: 20px;
	border-radius: 22px;
	box-shadow: 0 0 30px #0ef;
	margin-top: 90px;
	transition: background-color 0.3s;
	
	background-color: #f5f5f5;
}

.container:hover {
	background-color: #f5f5f5;
}

.container h1 {
	text-align: center;
	margin-bottom: 30px;
	color: black;
}

.form-group label {
	font-weight: bold;
	font-size: 20px;
}

.form-group input[type="text"], .form-group input[type="number"],
	.form-group input[type="date"] {
	width: 100%;
	padding: 10px;
	font-size: 16px;
	border: 1px solid #ccc;
	border-radius: 5px;
	transition: border-color 0.3s, box-shadow 0.3s;
}

.form-group input[type="text"]:focus, .form-group input[type="number"]:focus,
	.form-group input[type="date"]:focus {
	
      border-color: #007bff;
      box-shadow: 0 0 25px #0ef;
    
}



.btn-primary:focus {
	box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
}

/* Additional styles for customization */
.form-group input[type="color"] {
	padding: 0;
	border: none;
}


.btn-primary {
	background-color: #2F3C7E;
	border-color: #2F3C7E;
	color: #fff;
	margin-left: 230px;
	padding-left:50px;
padding-right:50px;
font-size: 20px;
}

.btn-primary:hover {
	background-color: #FBEAEB;
	color: #2F3C7E;
	border-color: #1A2250;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Admin Sample Page</h1>
		<form
			action="Admin_sampleController?username=<%=request.getParameter("username")%>"
			method="post" enctype="multipart/form-data">

			<div class="form-group">
				<label for="design_image">Select Design:</label> <input type="file"
					id="design_image" name="design_image"
					style="font-family: monospace" required>
			</div>
			<div class="form-group">
				<label for="hexValue">Color Hex Value:</label> <input type="color"
					id="hexValue" name="hexValue" required>
			</div>
			<div class="form-group">
				<label for="price">Price of one piece:</label> <input type="number"
					id="price" name="price" required>
			</div>
			<div class="form-group">
				<label for="date">Date:</label> <input type="date" id="date"
					name="date" required>
			</div>

			<button type="submit" class="btn btn-primary" name="submit">Submit</button>

		</form>
	</div>
</body>
</html>
