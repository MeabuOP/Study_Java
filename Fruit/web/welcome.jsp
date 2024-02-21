<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Model.*" %>
<%@ page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h2>Fruit Table</h2>
        <form action="NewServlet" method="post">
            <input type="text" name="fruitName"> 
            <button>Find</button>
        </form>
        <br>
        <a href="add.jsp"><button>Create</button></a>
        <br><br>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th colspan="2">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:set var="fruitList" value="${requestScope.fruitList}"/>
                <c:forEach items="${requestScope.fruitList}" var="fruit"></c:forEach>
                <c:if test="${empty fruitList}">
                    <tr>
                        <td colspan="6">No fruits available.</td>
                    </tr>
                </c:if>
                <c:if test="${not empty fruitList}">
                    <c:forEach items="${fruitList}" var="fruit">
                        <tr>
                            <td>${fruit.productId}</td>
                            <td>${fruit.productName}</td>
                            <td>${fruit.description}</td>
                            <td>${fruit.price}</td>
                            <td><a href="DeleteServlet?productID=${fruit.productId}">Delete</a></td>
                            <td><a href="UpdateServlet?productID=${fruit.productId}">Update</a></td>
                        </tr>
                    </c:forEach>
                </c:if>
            </tbody>
        </table>                    
    </center>
</body>
</html>
