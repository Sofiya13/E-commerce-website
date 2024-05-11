<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Merienda" rel="stylesheet">
    <style>
      
        body {
            font-family: Merienda;
            position: relative;
            margin: 0; 
            overflow: -x; 
        }

        body::before {
            content: "";
            background-image: url('https://images.pexels.com/photos/14237008/pexels-photo-14237008.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1');
            background-repeat: no-repeat;
            background-size: cover;
            background-attachment: fixed; 
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 116%;
            opacity: 0.4; 
            z-index: -1;
        }

        .logo-section {
            margin-top: 30px;
            opacity: 1;
            padding: 50px;
            text-align: center;
            height: 75vh
        }

        .login-section {
            opacity: 1;
            color: #2F3C7E;
            padding-top: 100px;
            text-align: center;
            font-size: 20px;
        }

        .login-button {
            background-color: #FBEAEB;
            color: #2F3C7E;
            border: thick;
            padding: 10px 20px;
            font-size: 22px;
            border-radius: 5px;
            cursor: pointer;
        }

        .login-button:hover {
            background-color: #2F3C7E;
            color: white;
        }

h1{
color:  #2F3C7E;}
@keyframes advancedTextAnimation {
    0% {
        transform: translate(50px, 0);
        color: #2F3C7E;
    }
  
    100% {
        transform: translate(70px, 50px);
        color: #3498DB;
    }
}




#heading {
    font-size: 40px;
    animation: advancedTextAnimation 2s  infinite;
}



        .button-86 {
            font-family: "Austhind", sans-serif;
            all: unset;
            width: 100px;
            height: 30px;
            font-size: 16px;
            background: transparent;
            border: none;
            position: relative;
            color: #f0f0f0;
            cursor: pointer;
            z-index: 1;
            padding: 10px 20px;
            display: flex;
            align-items: center;
            justify-content: center;
            white-space: nowrap;
            user-select: none;
            -webkit-user-select: none;
            touch-action: manipulation;
        }

        .button-86::after,
        .button-86::before {
            content: '';
            position: absolute;
            bottom: 0;
            right: 0;
            z-index: -99999;
            transition: all .4s;
        }

        .button-86::before {
            transform: translate(0%, 0%);
            width: 100%;
            height: 100%;
            background: #2F3C7E;
            border-radius: 10px;
        }

        .button-86::after {
            transform: translate(10px, 10px);
            width: 35px;
            height: 35px;
            background: #ffffff15;
            backdrop-filter: blur(5px);
            -webkit-backdrop-filter: blur(5px);
            border-radius: 50px;
        }

        .button-86:hover::before {
            transform: translate(5%, 20%);
            width: 110%;
            height: 110%;
        }

        .button-86:hover::after {
            border-radius: 10px;
            transform: translate(0, 0);
            width: 100%;
            height: 100%;
        }

        .button-86:active::after {
            transition: 0s;
            transform: translate(0, 5%);
        }
        .about-section{
        color: #2F3C7E;
        font-size: 23px;
        }
        
         .navbar-nav .nav-link {
        font-weight: bold;
    }
    .img-fluid{
    height: 95%;
    }
   
    </style>
</head>
<body>
    
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <img src="images/logo1.png" alt="Logo" width="100" height="50" style="border-radius: 70%;">
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#about">About</a> 
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Services</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="contact.jsp">Contact</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

  
            <div> <h1 id="heading" style="text-align: center; margin-bottom: 20px; margin-top: 40px; fo">Welcome to SAP - Your Personalized Clothes Printing Destination!</h1></div>
    
    <div class="container mt-4">
        <div class="container" >
        <div class="row">
            <div class="col-md-6 logo-section">
                <img src="images/hs logo.png" alt="Organization Logo" width="550" height="377" style="border-radius: 70%;">
            </div>
            
            <div class="col-md-6 login-section" id="about"> 
                <h2 style="font-weight: 39px; color: black;">Login to Your Account</h2>
                <p>At SAP, We believe that your clothing should be a canvas for self-expression. That's why we're here to transform your wardrobe into a stunning showcase of your unique style.</p>
                <ul>
                    <li>Design your own custom clothing items.</li>
                    <li>Showcase your creativity and unique style.</li>
                    <li>Choose from a wide range of clothing options.</li>
                    <li>Express yourself like never before through fashion.</li>
                </ul>
                <p>Join us today and start creating clothing that truly represents you!</p>
                <div class="row">
                    <div class="col-md-6" style="margin-left: 150px;">
                        <a href="Login.jsp" class="button-86" role="button">Login</a>
                    </div>
                    <div class="col-md-6"  style=" margin-left: 350px; margin-top: -50px; ">
                        <a href="Registration.jsp" class="button-86" role="button">Sign Up</a>
                    </div>
                </div>
            </div>
<section id="about" class="about-section">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h2 style="text-align: center; color: black">About Us</h2>
                <p >
                    At SAP , We are dedicated to revolutionizing the world of fashion by offering personalized clothes printing services. We understand that clothing is more than just fabric; it's an expression of your identity, creativity, and style.
                </p>
                <p>
                    Our mission is to empower individuals and businesses to create unique and custom clothing that reflects their personality and values. Whether you're looking to design custom t-shirts, hoodies, or promotional apparel for your brand, we've got the tools and expertise to bring your ideas to life.
                </p>
                <p>
                    With a commitment to quality, creativity, and customer satisfaction, SAP is your go-to destination for all your personalized clothing needs. Join us in making fashion a canvas for self-expression.
                </p>
            </div>
            <div class="col-md-6">
                <img src="https://tse1.mm.bing.net/th?id=OIP.vvOJtgpqAP0hfilcmIrcigHaFj&pid=Api&P=0&h=180" alt="About Us Image" class="img-fluid" height="100p%" width="100%">
            </div>
        </div>
    </div>
</section>
            
        </div>
    </div>
</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
