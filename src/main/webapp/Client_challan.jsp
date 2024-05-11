<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Merienda'
	rel='stylesheet'>
<style>
body {
	background-image:url('https://tse4.mm.bing.net/th?id=OIP.3mx0o0bILDARyrR_ytJW2gHaEo&pid=Api&P=0&h=180');
       background-size: cover; /* Set the background size to cover the full page */
    background-repeat: no-repeat; 
	font-family: Merienda;
}

.container {
	background-color: #FBEAEB;
	padding: 40px;
	border-radius: 20px;
	box-shadow: 0 0 25px #0ef;
	width: 55%;
}

label {
	font-size: 23px;
	margin:10px;
}

.container h2 {
	text-align: center;
	margin-bottom: 30px;
	color: #2F3C7E;
}

.form-control {
	border-radius: 10px;
	border: 1px solid #ccc;
}

.form-control:focus {
	border-color: #007bff;
	box-shadow: 0 0 25px #0ef;
}


.btn-primary {
	background-color: #2F3C7E;
	border-color: #007bff;
	transition: background-color 0.3s, border-color 0.3s, box-shadow 0.3s;
	  margin-left: 290px;
	  margin-top:13px;
	 padding: 10px;
	 padding-left: 50px;
	 padding-right: 45px;
	
	 font-size: 19px;
}

.btn-primary:hover {
	background-color: #FBEAEB;
	color: #2F3C7E;
	border-color: #1A2250;
}

.btn-primary:focus {
	box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
}
</style>
<title>Challan Form</title>
</head>
<body>
	<div class="container mt-5">
		<h2 class="mb-4">Challan Form</h2>
		<form action="ChallanServlet" method="post">
			<input type="hidden" name="username"
				value="<%=request.getParameter("username")%>">
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="from">From: </label> <input type="text"
						class="form-control" id="from" name="from"
						value="<%=request.getParameter("username")%>" disabled="disabled">
				</div>
				<div class="form-group col-md-6">
					<label for="to">To:</label> <input type="text" class="form-control"
						id="to" name="to" value="Admin" disabled="disabled">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-4">
					<label for="quantity">Quantity:</label> <input type="number"
						class="form-control" id="quantity" name="quantity" required>
				</div>
				<div class="form-group col-md-4">
					<label for="productDetails">Product Details:</label> <input
						type="text" class="form-control" id="productDetails"
						name="productDetails" required>
				</div>
				<div class="form-group col-md-4">
					<label for="rate">Rate:</label> <input type="number"
						class="form-control" id="rate" name="rate" required>
				</div>
			</div>
			<div class="form-group">
				<label for="finalAmount">Final Amount:</label> <input type="number"
					class="form-control" id="finalAmount" name="finalAmount" required>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>			
		</form>
	</div>
	<script>
    const quantityInput = document.getElementById('quantity');
    const rateInput = document.getElementById('rate');
    const finalAmountInput = document.getElementById('finalAmount');

    // Function to update the final amount when quantity or rate changes
    function updateFinalAmount() {
        const quantity = parseFloat(quantityInput.value);
        const rate = parseFloat(rateInput.value);
        const finalAmount = quantity * rate;
        
        // Update the final amount input field with the calculated result
        finalAmountInput.value = isNaN(finalAmount) ? '' : finalAmount.toFixed(2);
    }

    quantityInput.addEventListener('input', updateFinalAmount);
    rateInput.addEventListener('input', updateFinalAmount);
</script>
</body>
</html>
