<!DOCTYPE html>
<html>
<head>
  <title>Error Page</title>
  <style>
  
    body {
      font-family: Inter,sans-serif;
      margin: 0;
      padding: 0;
      background-color: gray;
    }

    .container {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    .error-card {
     background-color: #fff;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
    margin-top: -10vh;
    padding: 34px;
    border-radius: 12px;
    text-align: center;
    }

    .error-card h1 {
      font-size: 35px;
      margin-bottom: 30px;
    }

    .error-card p {
      font-size: 18px;
      margin-bottom: 20px;
    }

    .error-card button {
      padding: 10px 20px;
      font-size: 16px;
      background-color:  #2F3C7E;;
      color: beige;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }   
    
   
  </style>
</head>
<body>
  <div class="container">
    <div class="error-card">
      <h1>Oops, something went wrong!</h1>
      <h3>Please, Check the input you have given!!</h3>
      <button>
      <a href="Login.jsp" style="color: #A9A654">Go back to the previous page</a>
      </button>
    </div>
  </div>
 
</body>
</html>