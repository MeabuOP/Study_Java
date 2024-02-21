<%@ page import="Model.Student" %>
<jsp:useBean id="studentBean" class="Model.Student" scope="request"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Student Information</title>
    </head>
    <body>

        <h1>Student Information</h1>

        <%-- Set properties of the studentBean --%>
        <% studentBean.setName("John Doe"); %>
        <% studentBean.setCode("12345"); %>

        <p>Name: <%= studentBean.getName() %></p>
        <p>Code: <%= studentBean.getCode() %></p>

        <%-- Set properties using <jsp:setProperty> --%>
        <jsp:setProperty name="studentBean" property="name" value="Cong Minh"/>
        <jsp:setProperty name="studentBean" property="name" value="abcdef"/>
        <p>Name: <jsp:getProperty name="studentBean" property="name"/></p>
        <p>Code: <jsp:getProperty name="studentBean" property="code"/></p>

    </body>
</html>
