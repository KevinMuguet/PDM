<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC  "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>S'inscrire</title>
    </head>
    <body>
        <p>- <%= request.getAttribute("Name")%> ; 
           <%= request.getAttribute("Email") %></p>
           <p> <%= request.getAttribute("Password")%> ; 
           <%= request.getAttribute("Confirm Password") %></p>
    </body>
</html>