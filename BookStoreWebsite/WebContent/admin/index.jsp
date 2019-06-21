<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        
        <hr width="60%"/>
        <h2>Quick Action</h2>
        <hr  width="60%"/>
        <div align="center">
        	<a href="create_book">New Book</a> ||
        	<a href="create_user">New User</a> ||
        	<a href="create_category">New Category</a> ||
        	<a href="create_customer">New Customer</a>
        	
        </div>
        
        <hr width="60%"/>
        <h2>Recent Sales</h2>
       
         <hr width="60%"/>
        <h2>Recent Review</h2>
        
        
         <hr width="60%"/>
        <h2>Statistic</h2>
        
        </div> 
        
        
      <jsp:directive.include file="footer.jsp" />
</body>
</html>