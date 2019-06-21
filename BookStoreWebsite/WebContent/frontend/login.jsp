<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

	     <jsp:directive.include file="header.jsp" />
	     <br />
	     
	     <div align="center">
		     	<form action="">
		           Email :   <input type="text" name="email" placeholder="email"/><br /><br />
		            Password :  <input type="password"  name="password" placeholder="password"/><br /><br />
		              <input type="submit" name="login" value="Login" />
	        
	      		  </form> 
	     </div>
         
        
       
        
      <jsp:directive.include file="footer.jsp" />

</body>
</html>