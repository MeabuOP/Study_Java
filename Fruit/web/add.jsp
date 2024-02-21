<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Fruit</title>
    </head>
    <body>
    <center>
        <h2>Add Fruit</h2>
        <form action="AddServlet" method="post">
            <label for="fruitName">Name:</label>
            <input type="text" id="fruitName" name="fruitName" required><br><br>

            <label for="description">Description:</label><br>
            <textarea id="description" name="description" rows="4" cols="50" required style="resize: none"></textarea><br><br>

            <label for="price">Price:</label>
            <input type="text" id="price" name="price" required pattern="[0-9]+(\.[0-9]+)?" title="Please enter a valid number">
            <span id="price-error" style="color: red; display: none;">Please enter a valid number</span><br><br>


            <button type="submit">Submit</button>
        </form>
        <br>
        <a href="welcome.jsp">Back to Fruit Table</a>
    </center>
</body>
</html>
