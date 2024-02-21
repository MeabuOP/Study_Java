<%-- 
    Document   : hello
    Created on : Jan 16, 2024, 8:41:33 AM
    Author     : ASUS
--%>

<%@page import = "Model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            Student s = (Student) request.getAttribute("student");
            if (s!=null){
                out.println("Hello " + s.getName() + "_" + s.getCode());
            }
            else{
        %>
        
        <form action="StudentServlet" method="post">
            Student name <input type="text" name="name"><br>
            Code <input type="text" name="code"><br>
            <button type="submit">Submit</button>
        <%}%></form> 
    </body>
</html>
