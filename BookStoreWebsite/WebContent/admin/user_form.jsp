<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=ISO-8859-1">
<title>NTSE Book Store Website</title>
</head>
<body>
    
     
         <jsp:directive.include file="header.jsp" />
         
        <div align="center">
          <h4>Welcome Admin  <a href="logout">Logout</a></h4>
          
         
          
          <a href="list_user">
              <div align="center">
              	 <img src="../images/MenuIcons/users.png" alt="" width="40px"/>
              Users
           
             
         </a> ||
          <a href="list_categories">
          	  <img src="../images/MenuIcons/category.png" alt="" width="40px"/>
          Categories
          </a> ||
          
          <a href="list_book">
            <img src="../images/MenuIcons/bookstack.png" alt="" width="40px"/>
          Books
          </a> ||
          
          <a href="list_customer">
            <img src="../images/MenuIcons/customer.png" alt="" width="40px"/>
          Customers
          </a> ||
          
          <a href="list_reviews">
            <img src="../images/MenuIcons/review.png" alt="" width="40px"/>
          Reviews
          </a> ||
          <a href="list_orders">
            <img src="../images/MenuIcons/order.png" alt="" width="40px"/>
          Orders
          </a> 
          
          </div>
          <br /><br />
        <h2>
        
	        <c:if test="${user != null}">
	        	Edit User
	        </c:if>
	        <c:if test="${user == null}">
	        	Create User
	        </c:if>
        
       </h2>
        
        <hr width="60%"/>
        
        <div align="center">
          	 
		        	<c:if test="${user != null}">
			        	 <form action="update_user"  method="post" onsubmit="return validateFormInput()"> 
			        	 <input type="hidden" value="${user.userId}" name="userId" /> 
			        </c:if>
			        <c:if test="${user == null}">
			        	 <form  action="create_user"  method="post" onsubmit="return validateFormInput()">  
		          </c:if>
               
                 
                  
                  		 <table>
                   
                   			<tr>
                 					<td>Full Name</td>
                 					<td><input type="text" id="fullname" name="fullname" placeholder="Enter Full Name" value="${user.fullName}" /></td>
                   			</tr>
                   		
                   			<tr>
                 					<td>Email</td>
                 					<td><input type="text" id="email" name="email" placeholder="Enter Email" value="${user.email}"/></td>
                   			</tr>
                   		
                   			<tr>
                 					<td>Password</td>
                 					<td><input type="password" id="password" name="password" placeholder="Enter Password" value="${user.password}"/></td>
                   			</tr>
                   		
                   			<tr>
                 					<td colspan="2" align="center"><input type="submit" name="submit" value="Save"/> <input type="reset" value="Reset" /></td>
                 					
                   			</tr>
                   </table>
                  </form>
        
        </div>

      <jsp:directive.include file="footer.jsp" />
</body>
</html>

<script>

function validateFormInput(){
	
	var fieldEmail = document.getElementById('email');
	var fieldFullName = document.getElementById('fullname');
	var fieldPassword = document.getElementById('password');
	
	
	if(fieldEmail.value.length == 0){
		alert("email field required");
		fieldEmail.focus();
		return false;
	}
	
	if(fieldFullName.value.length == 0){
		alert("FullName field required");
		fieldEmail.focus();
		return false;
	}
	
	if(fieldPassword.value.length == 0){
		alert("Password field required");
		fieldEmail.focus();
		return false;
	}
	
	return true;
}

</script>