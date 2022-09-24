<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <title>Taskbuddy</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/style.css" rel="stylesheet">
         <link href="css/bootstrap.min.css" rel="stylesheet">
         <style>
         /*
 * Globals
 */

/* Links */
a,
a:focus,
a:hover {
  color: #fff;
}

/* Custom default button */
.btn-default,
.btn-default:hover,
.btn-default:focus {
  color: #333;
  text-shadow: none; /* Prevent inheritance from `body` */
  background-color: #fff;
  border: 1px solid #fff;
}


/*
 * Base structure
 */

html,
body {
  height: 100%;
  background-color: #333;
}
body {
  color: #fff;
  text-align: center;
  text-shadow: 0 1px 3px rgba(0,0,0,.5);
}

/* Extra markup and styles for table-esque vertical and horizontal centering */
.site-wrapper {
  display: table;
  width: 100%;
  height: 100%; /* For at least Firefox */
  min-height: 100%;
  -webkit-box-shadow: inset 0 0 100px rgba(0,0,0,.5);
          box-shadow: inset 0 0 100px rgba(0,0,0,.5);
}
.site-wrapper-inner {
  display: table-cell;
  vertical-align: top;
}
.cover-container {
  margin-right: auto;
  margin-left: auto;
}

/* Padding for spacing */
.inner {
  padding: 30px;
}


/*
 * Header
 */
.masthead-brand {
  margin-top: 10px;
  margin-bottom: 10px;
}

.masthead-nav > li {
  display: inline-block;
}
.masthead-nav > li + li {
  margin-left: 20px;
}
.masthead-nav > li > a {
  padding-right: 0;
  padding-left: 0;
  font-size: 16px;
  font-weight: bold;
  color: #fff; /* IE8 proofing */
  color: rgba(255,255,255,.75);
  border-bottom: 2px solid transparent;
}
.masthead-nav > li > a:hover,
.masthead-nav > li > a:focus {
  background-color: transparent;
  border-bottom-color: #a9a9a9;
  border-bottom-color: rgba(255,255,255,.25);
}
.masthead-nav > .active > a,
.masthead-nav > .active > a:hover,
.masthead-nav > .active > a:focus {
  color: #fff;
  border-bottom-color: #fff;
}

@media (min-width: 768px) {
  .masthead-brand {
    float: left;
  }
  .masthead-nav {
    float: right;
  }
}


/*
 * Cover
 */

.cover {
  padding: 0 20px;
}
.cover .btn-lg {
  padding: 10px 20px;
  font-weight: bold;
}


/*
 * Footer
 */

.mastfoot {
  color: #999; /* IE8 proofing */
  color: rgba(255,255,255,.5);
}


/*
 * Affix and center
 */

@media (min-width: 768px) {
  /* Pull out the header and footer */
  .masthead {
    position: fixed;
    top: 0;
  }
  .mastfoot {
    position: fixed;
    bottom: 0;
  }
  /* Start the vertical centering */
  .site-wrapper-inner {
    vertical-align: middle;
  }
  /* Handle the widths */
  .masthead,
  .mastfoot,
  .cover-container {
    width: 100%; /* Must be percentage or pixels for horizontal alignment */
  }
}

@media (min-width: 992px) {
  .masthead,
  .mastfoot,
  .cover-container {
    width: 700px;
  }
}

         </style>
    </head>
<body>
<div class="site-wrapper">

      <div class="site-wrapper-inner">

        <div class="cover-container">

          <div class="masthead clearfix">
            <div class="inner">
              <h3 class="masthead-brand">Customer</h3>
             
                <ul class="nav masthead-nav">
                <li class="active"><a href="index.jsp">Home</a></li>
                  <li><a href="practemp.jsp">Gallery</a></li>
                  <li><a href="auth">Sign In</a></li>
                   <li><a href="reg" >SignUp</a></li>
                </ul>
              
            </div>
          </div>

          <div class="inner cover">
            <h1 class="cover-heading">Registration Page</h1>
            <p class="lead">
            <form class="form-horizontal" action="registration">
   			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   			
                 <table>
                <tbody>
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" placeholder="First Name" name="userfirstname" ></td>
                    </tr>
                   
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" placeholder="Last Name" name="userlastname" ></td>
                    </tr>
                      <tr>
                        <td>Gender</td>
                        <td><input type="radio" name="gender" value="male"  >Male</td>
                    </tr>
                     <tr>
                        <td></td>
                        <td><input type="radio" name="gender" value="female" >Female</td>
                    </tr>
		    <tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="email" placeholder="Email" name="email" ></td>
                    </tr>
                    <tr>
                        <td>Mobile</td>
                        <td><input type="text" name="contactno" ></td>
                    </tr>
                     <tr>
                        <td>Address Line1</td>
                        <td><textarea name="address" ></textarea></td>
                    </tr>
                    
                    <tr>
                        <td>Location</td>
                        <td>
                            <select name="location" >
                            <option value="santacruz">santacruz</option>
                            <option value="parle">parle</option>
                            <option value="andheri">andheri</option>
                            <option value="dadar">dadar</option>
                            <option value="matunga">matunga</option>
                            <option value="borivali">borivali</option>
                            <option value="malad">malad</option>
                            </select>
                        </td>
                    </tr>
                    
                    
                     <tr>
                        <td>City</td>
                        <td>
                            <select name="city" >
                            <option value="mumbai">mumbai</option>
                            <option value="pune">pune</option>
                            <option value="malvan">malvan</option>
                            <option value="california">california</option>
                            <option value="washington DC">washington DC</option>
                            <option value="london">london</option>
                            <option value="tokya">tokya</option>
                            </select>
                        </td>
                    </tr>

                     <tr>
                        <td>State</td>
                        <td>
                            <select name="state" >
                            <option value="Maharashtra">Maharashtra</option>
                            <option value="Bhutan">Tamilnadu</option>
                            <option value="Sri-lanka">Karnataka</option>
                            <option value="England">Goa</option>
                            <option value="US">Madhyapradesh</option>
                            </select>
                        </td>
                    </tr>
                     <tr>
                        <td>Pincode</td>
                        <td><input type="text" name="pincode" ></td>
                    </tr>
                    
                    <tr>
                        <td>Country</td>
                        <td>
                            <select name="country" >
                            <option value="India">India</option>
                            <option value="Bhutan">Bhutan</option>
                            <option value="Sri-lanka">Sri-lanka</option>
                            <option value="England">England</option>
                            <option value="US">US</option>
                            <option value="UK">UK</option>
                            <option value="Japan">Japan</option>
                            </select>
                        </td>
                    </tr>
                    
                    
                    
                    <tr>
                        <td>Username</td>
                        <td><input type="text" name="username" ></td>
                    </tr>
                   
                    <tr>
                        <td>Password</td>
                        <td><input type="password" class="form-control" id="inputPassword3" placeholder="Password" name="password"></td>
                    </tr>
                  	
			<tr>
				<td><input type="hidden" name="role" value="2"></td>
			</tr>
			<tr>
			<td colspan="2">
			&nbsp;&nbsp;&nbsp;
			    <input style="font-size:20pt;color:#333333;" type="submit" value="Submit" >
			</td>		    
		     </tr>
			
                </tbody>
		 
            </table>
	    
            </form>
      

          <div class="mastfoot">
            <div class="inner">
              <p>.</p>
            </div>
          </div>

        </div>

      </div>

    </div>
 </div>
    </body>
</html>