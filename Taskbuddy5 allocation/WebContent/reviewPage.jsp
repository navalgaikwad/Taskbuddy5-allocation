<!DOCTYPE html>
<%@page import="org.hibernate.Session"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Task Buddy </title>
    <meta name="viewport" content="width-device-width,initial-scale=1.0">
<link rel="stylesheet" href="css/blueberry.css"/>
 
 <link href="css/bootstrap.min.css" rel="stylesheet">


    

    <link href="css/carousel.css" rel="stylesheet">
<style type="text/css">
div.wrappertype
{
border: solid black 2px; 
width:770px;
height: 300px;
position: absolute;
margin-top:550px; /*  450px initially */ 
margin-left:280px;
text-align:center;
top:0;bottom: 0;left: 0;right: 0;
<!--background-color:#11719A-->; 
border-radius:10px;
font-style: italic;
font-size:40px;
text-decoration: none;
text-align:center;
list-style-type:none; 
}

div.type
{
/* border: solid black 2px  */
text-align:  center;
width: 500px;
height:200px;
margin-left:120px;
margin-top:80px;  
text-decoration: none; 
list-style-type:none;

}
table {
    border-collapse: collapse;
    width: 100%;
}

thead, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

thead {
    background-color: #52658C;
    color: white;
}

</style>
<script src="js/jquery.min.js"></script>
<script src="jquery.blueberry.js"></script>
<script>
    $(windows).load(function(){
        $('.blueberry').blueberry();

    });
</script>
</head>
<body>
 <header>
            <a href="#" id="logo" style="color:white;font-size:400%;font-family: sans-serif;">Task Buddy</a>
            <nav>
                <a href="#" id="menu-icon"></a>
                <ul>
                   <li>
                       <a href="index.jsp" class="current" style="color:white; margin-left:50px;width: 220px; font-size:15px;font-family: sans-serif;">Home</a>
                   </li>
                   
                       <li><a href="RegistrationCustomer Tasker.jsp" style="color:white; margin-left:50px;width: 220px;font-size:15px;font-family: sans-serif;">Tasker</a></li>
                     
                       <li><a href="practemp.jsp" style="color:white; margin-left:50px;width: 220px; font-size:15px;font-family: sans-serif;">Gallery</a></li>
                       <%String username=(String )session.getAttribute("username"); %>
                       <%if((username==null)){ %>
                        <li><a href="reg" style="color:white; margin-left:50px;width: 220px; font-size:15px;font-family: sans-serif;">SignUp</a></li>
                        <%} %>
                        <!--  <li><a href="reg" >Login</a></li>
                         <li><a href="reg" >Logout</a></li> -->
                         <%if((username==null)){ %>
                         <li><a href="auth" style="color:white; margin-left:50px;width: 220px;font-size:15px;font-family: sans-serif;">Login</a></li>
                         <%
                         }
                         else{
                        	 %>
                        <li><a href="viewProfile" style="color:white; margin-left:50px;width: 220px;font-size:15px;font-family: sans-serif;">hello,${sessionScope.username}</a>
                        <li><a href="logout" style="color:white; margin-left:50px;width: 220px;font-size:15px;font-family: sans-serif;">Logout</a></li>
                        <%	 
                         }
                         %> 
                          <%
                         	if(session.getAttribute("pendingCount")!=null)
                         	{
                         		int pendingCount=(int)session.getAttribute("pendingCount"); 
		                         %>
		                         <%if(pendingCount!=0||session.getAttribute("pendingCount")!=null){ %>
		                         <li><a href="pendingTasks" style="color:white; margin-left:50px;width: 220px;font-size:15px;font-family: sans-serif;">Pending Tasks(${pendingCount})</a></li>
		                         <%}else{ %>
		                         <li><a href="pendingTasks" style="color:white; margin-left:50px;width: 220px;font-size:15px;font-family: sans-serif;">Pending Tasks(0)</a></li>
		                         <%}
                         	} 
		                         %>
                
              </ul>
            </nav>
    </header>
    <br>
    <br>
    <br>
    <br>
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img class="first-slide" src="images/plumber.jpg" alt="First slide">
          <!-- <div class="container">
            <div class="carousel-caption">
              <h1>Plumbing</h1>
              <p>Book best Professional plumbing Service </p>
              <p><a class="btn btn-lg btn-primary" href="#" role="button">Sign up today</a></p>
            </div>
          </div> -->
        </div>
        <div class="item">
          <img class="second-slide" src="images/Carpenter-work-6.jpg" alt="Second slide">
          <!-- <div class="container">
            <div class="carousel-caption">
              <h1>Carpenter</h1>
              <p>Experienced carpenters and professional carpentery services,woodworking in company @ resonable rate</p>
              <p><a class="btn btn-lg btn-primary" href="/project/practemp.jsp" role="button">Learn more</a></p>
            </div>
          </div> -->
        </div>
        <div class="item">
          <img class="third-slide" src="images/limo-driver.jpg" alt="Third slide">
          <!-- <div class="container">
            <div class="carousel-caption">
              <h1>Driver</h1>
              <p>>Experienced driver and professional driver services</p>
              <p><a class="btn btn-lg btn-primary" href="/project/practemp.jsp" role="button">Browse gallery</a></p>
            </div>
          </div> -->
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div><!-- /.carousel -->


<br>

<div class="container marketing">
<%-- <sf:form action="task"> --%>
   
      <div class="row">
        <div class="col-lg-4">

 
<%-- <c:forEach var="item" items="${requestScope.catlist}" >

 
<a class="type"   data-toggle="tooltip" title="Choose Tasker Catrgory You Want "  style="color:black ; font-weight:bolder;  " 
href="menu1?type=${item}" name="${item}">${item}<br/></a>

 </c:forEach> --%>
 </div>
</div>
          
          <%-- <sf:radiobuttons var="b" items="${catlist}" path="category"/> --%>
     
          
 
        <table>
        <thead>
        <tr>
        	<td> <b>customer</b> </td>
        	<td> <b>review</b> </td>
        	<td> <b>rating</b> </td>
        <tr>
        </thead>
     	<tbody>
     	
         <c:forEach var="item" items="${requestScope.reviews}">
        	    <tr>
        	<td> ${item.customer} </td><td> ${item.review} </td><td> ${item.rating} </td>
        		</tr>
         </c:forEach>
         </tbody>
         
         </table> 
        <!--  dont remove -->
       
         
<div class="rock">
    


    <section>
        <img src="images/9.png" alt="Tasker"/>
        <h1>Best Tasker Arround</h1>
        <p></p>
    </section>
    <div class="dream">
        
    
     <section>
        <img src="images/21.png" alt="Location"/>
        <h1>Location</h1>
        <p> </p>
    </section>
    </div>
     <section>
        <img src="images/13.png" alt="Check-In"/>
        <h1>Check-In</h1>
        <p></p>
    </section>

</div>
<br><br><br>
    <div class="clear"></div>
    <article>
         <img src="images/melbourne-electricians.jpg" alt="Check-In"/>
    </article>
    <aside>
        <h2>Our Tasker</h2>
         <ul class="gym">
             <li><h3>Plumber</h3></li>
             <li><h3>Electrician</h3></li>
             <li><h3>Mover</h3></li>
             <li><h3>Drivers</h3></li>
             <li><h3>Carpenter</h3></li>
              <li><h3>Welding</h3></li>
         </ul>
    </aside>
    <br><br><br>
    <div class="clear"></div>
    <section>
        
        <h1>Post Ad</h1>
        <img src="images/Carpenter-work-6.jpg" alt="Post"/>
        <p>Tasker can add post</p>
    </section>

     <section>
        
        <h1>Be Tasker</h1>
        <img src="images/plumber.jpg" alt="Tasker"/>
        <p>Grab the opportunity to be a Tasker</p>
    </section>

     <section>
        
        <h1>Our services</h1>
        <img src="images/limo-driver.jpg" alt="Services"/>
        <p>Our best Service around till now</p>
    </section>
    <footer>
        <section>
            <h3><b>The tasker</b></h3>
            <p><b>0987665543</b></p><br><br>
            A/p-Sunbeam,<br>
            market yard,<br>
            pune-416606 <br>
        </section>
        <h3>Connect with Us</h3>
        <ul class="social">
            <li><a href="#"><img src="images/18.png"/></a></li>
            <li><a href="#"><img src="images/19.png"/></a></li>
            
        </ul>
        <section>
            
        </section>





    </footer>
    <footer>
        
    </footer>
     <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="js/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>
    <script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
    </script>


</body>
</html>