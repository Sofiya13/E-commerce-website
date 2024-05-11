<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>User Request Form</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Merienda'
	rel='stylesheet'>

<style>
body {
	background-image:url('https://images.unsplash.com/photo-1506220926022-cc5c12acdb35?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2070&q=80');
	  background-size: cover; 
        background-repeat: no-repeat;
        background-position:top;
        font-family: Merienda;
        padding-right: 200px;
}

.container {
	background-image: url('http://www.pixelstalk.net/wp-content/uploads/2016/06/Photos-Light-Blue-HD-Backgrounds.jpg');
	        background-position:right 70%;
	
	padding: 20px;
	border-radius: 20px;
		margin-top: 40px;
	width: 50%;
	
	
	
}


.container h1 {
	text-align: center;
	margin-bottom: 30px;
	color: black;
}

.form-group label {
	font-weight: bold;
	font-size: 20px;
	margin: 11px;
}

.form-group input[type="text"], .form-group input[type="number"],
	.form-group input[type="date"] {
	width: 50%;
	padding: 10px;
	font-size: 16px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

.form-group input[type="text"]:focus, .form-group input[type="number"]:focus,
	.form-group input[type="date"]:focus {
	border-color: #007bff;
	box-shadow: 0 0 25px #0ef;}

.btn {
	 background-color: #2F3C7E; 
	 color: #FBEAEB; 
	 border: none;
	   cursor: pointer;
	  margin-left: 220px;
	 padding: 10px;
	 padding-left: 50px;
	 padding-right: 50px;
	 font-size: 21px;
}
  .btn-primary{
        background-color:#2952d0;
     }
     
     .btn-primary:hover{
         background-color:#ed236f;
     }

</style>
</head>
<body>
	<div class="container">
		<h1>User Request Form</h1>
		<form
			action="RequestController?username=<%=request.getParameter("username")%>"
			method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="username">Username:</label> <input type="text"
					id="username" name="username"
					value="<%=request.getParameter("username")%>" disabled="disabled">
			</div>
			<div class="form-group">
				<label for="fabric_type">Fabric Type:</label> <input type="text"
					id="fabric_type" name="fabric_type"
					placeholder="e.g., Cotton,silk..." required>
			</div>
			<div class="form-group">
				<label for="sample_quantity">Sample Quantity:</label> <input
					type="number" id="sample_quantity" name="sample_quantity" required>
			</div>
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
				<label for="contact">Contact:</label> <input type="text"
					id="contact" name="contact" required maxlength="10">
			</div>

			<div class="form-group">
				<label for="date">Date:</label> <input type="date" id="date"
					name="date" required>
			</div>

			<button class="btn" name="submit">Submit</button>
			


		</form>
	</div>
</body>
</html>
