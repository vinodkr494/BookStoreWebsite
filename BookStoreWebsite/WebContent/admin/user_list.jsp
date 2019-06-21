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
          
          <a href="list_books">
            <img src="../images/MenuIcons/bookstack.png" alt="" width="40px"/>
          Books
          </a> ||
          
          <a href="list_customers">
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
          <h4>Users Management</h4>
       
        <div align="center">
        
        
          
           <c:if test="${message != null }" >
            <p>${message}</p>
           </c:if>
       
        	
        	<a href="user_form.jsp">New User</a>
        	
        </div>
        <hr width="60%"/>
        <table border="1" style="width= 60%;">
           <thead>
           	<tr>
           	  <th width="10%">Index</th>
           	  <th width="10%">ID</th>
           	  <th width="20%">Email</th>
           	  <th width="20%">Full Name</th>
           	  <th width="20%">Password</th>
           	  <th>Action</th>
           	</tr>
           </thead>
           <tbody>
           
            <c:forEach var="users" items="${userList}" varStatus="status">
            
	            <tr>
	            
	              <td width="10%">${(status.index) + 1}</td>
	           	  <td width="10%">${users.userId}</td>
	           	  <td width="20%">${users.email}</td>
	           	  <td width="20%">${users.fullName}</td>
	           	   <td width="20%">${users.password}</td>
	           	  <td>
	           	       <a href="edit_user?id=${users.userId}">Edit</a> || 
	           	       <a href="delete_user?id=${users.userId}">Delete</a>
	           	  </td>
	            </tr>
            
            
            </c:forEach>
            
           </tbody>
        </table>
        

        
        </div> 
        
        
      <jsp:directive.include file="footer.jsp" />
</body>
</html>