<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="servlets.SportClass" %>

<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Gutim Template">
    <meta name="keywords" content="Gutim, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Gutim | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900&display=swap"
        rel="stylesheet">
        
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    
    
    <style>
        .center-container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
    </style>
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Header Section Begin -->
    <header class="header-section">
        <div class="container">
            <div class="logo">
                <a href="./index.html">
                    <img src="img/logo.png" alt="">
                </a>
            </div>
            <div class="nav-menu">
                <%
        // Check if the session has user_name and user_email attributes
        
        Object userId = session.getAttribute("userId");
        Object isAdmin = session.getAttribute("isAdmin");
        
        

        if (userId != null) {
            // User is logged in, display their information
    %>
            <nav class="mainmenu mobile-menu">
            
                    <ul>
                        <li class="active"><a href="./index.jsp">Home</a></li>
                        <li><a href="./about-us.jsp">About</a></li>
                        <li><a href="./redirect_classes.jsp">Classes</a></li>
                        <li><a href="./gallery.jsp">Gallery</a></li>
                        <li><a href="./contact.jsp">Contacts</a></li>
                        <li><a href="./my_classes.jsp">My Classes</a></li>
                    </ul>
                </nav>
                <a href="Logout" class="primary-btn signup-btn">Log out</a>
    <%
        }else if (isAdmin != null){
        	
        	
        	
     %>
     
     			 <nav class="mainmenu mobile-menu">
     			 
            
                    <ul>
                        <li class="active"><a href="./index.jsp">Home</a></li>
                        <li><a href="./add_sport.jsp">Add Classes</a></li>
                        <li><a href="./redirect_classes.jsp">Classes</a></li>
                    </ul>
                </nav>
                <a href="Logout" class="primary-btn signup-btn">Log out</a>
     
     
     
     <%
    
        } else {
            // User is not logged in, display a login link
    %>
            <nav class="mainmenu mobile-menu">
                    <ul>
                        <li class="active"><a href="./index.jsp	">Home</a></li>
                        <li><a href="./about-us.jsp">About</a></li>
                        <li><a href="./redirect_classes.jsp">Classes</a></li>
                        <li><a href="./gallery.jsp">Gallery</a></li>
                        <li><a href="./contact.jsp">Contacts</a></li>
                    </ul>
                </nav>
                <a href="sign_in.jsp" class="primary-btn signup-btn">Sign In</a>
    <%
        }
    %>
            </div>
            <div id="mobile-menu-wrap"></div>
        </div>
    </header>
    <!-- Header End -->

    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb/classes-breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb-text">
                        <h2>Edit Sport</h2>
                        <div class="breadcrumb-option">
                            <a href="./index.html"><i class="fa fa-home"></i> Home</a>
                            <span>Edit Sport</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <div class="center-container">
        <div class="container">
            <h2 class="mb-4">Edit Sport</h2>
            <form action="EditSportServlet" method="post">
            
            	<input type="hidden" name="id" value="<%= request.getParameter("id") %>">
                <div class="form-group">
                    <label for="name">Sport Name:</label>
                    <input type="text" class="form-control" id="name" name="name" required>
                </div>

                <div class="form-group">
                    <label for="cost">Cost:</label>
                    <input type="number" class="form-control" id="cost" name="cost" required>
                </div>

                <div class="form-group">
                    <label for="coach">Coach:</label>
                    <input type="text" class="form-control" id="coach" name="coach" required>
                </div>

                <div class="form-group">
                    <label for="time">Time:</label>
                    <input type="text" class="form-control" id="time" name="time" required>
                </div>

                <div class="form-group">
                    <label for="numberOfPlaces">Number of Places:</label>
                    <input type="number" class="form-control" id="numberOfPlaces" name="numberOfPlaces" required>
                </div>

                <div class="form-group">
                    <label for="rating">Rating:</label>
                    <input type="number" class="form-control" id="rating" name="rating" required>
                </div>

                <button type="submit" class="btn btn-primary">Add Sport</button>
            </form>
        </div>
    </div>



    <!-- Footer Section Begin -->
    <footer class="footer-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-4">
                    <div class="contact-option">
                        <span>Phone</span>
                        <p>(123) 118 9999 - (123) 118 9999</p>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="contact-option">
                        <span>Address</span>
                        <p>72 Kangnam, 45 Opal Point Suite 391</p>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="contact-option">
                        <span>Email</span>
                        <p>contactcompany@Gutim.com</p>
                    </div>
                </div>
            </div>
            <div class="subscribe-option set-bg" data-setbg="img/footer-signup.jpg">
                <div class="so-text">
                    <h4>Subscribe To Our Mailing List</h4>
                    <p>Sign up to receive the latest information </p>
                </div>
                <form action="#" class="subscribe-form">
                    <input type="text" placeholder="Enter Your Mail">
                    <button type="submit"><i class="fa fa-send"></i></button>
                </form>
            </div>
            <div class="copyright-text">
                <ul>
                    <li><a href="#">Term&Use</a></li>
                    <li><a href="#">Privacy Policy</a></li>
                </ul>
                <p>&copy;<p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p></p>
                <div class="footer-social">
                    <a href="#"><i class="fa fa-facebook"></i></a>
                    <a href="#"><i class="fa fa-twitter"></i></a>
                    <a href="#"><i class="fa fa-instagram"></i></a>
                    <a href="#"><i class="fa fa-dribbble"></i></a>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.magnific-popup.min.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>
</body>

</html>