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
        <h2>Administrative Area</h2>
       
        <c:if test="${message != null}">
          <p>${message}</p>
          
        </c:if>
        
        

        
        
      <jsp:directive.include file="footer.jsp" />
</body>
</html>