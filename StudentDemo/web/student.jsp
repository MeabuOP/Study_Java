<%-- 
    Document   : student
    Created on : Jan 18, 2024, 10:02:50 AM
    Author     : ASUS
--%>
<%@page import="myPack.Student"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--
    <%@include  %>
--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Student Demo 2!</h1>
        <form action="StudentServlet" method="post">
            Number of Students: <input type="number" name="student_number" min="0" max="10" value="0"> <button name="buttonAction" value="generate">Generate</button> <button name="buttonAction" value="add">Add</button>
            <table>

                <%
                ArrayList<Student> studentList = (ArrayList<Student>) request.getAttribute("studentList");
            
                if (studentList != null && studentList.size() != 0){
                %>
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                    <td>Gender</td>
                    <td>DOB</td>
                    <td></td>
                </tr>
                <%
                    int size = studentList.size();
                    for (int i = 0; i < size; i++){
                        Student s = studentList.get(i);
                        SimpleDateFormat formatter = new SimpleDateFormat("MMM d, yyyy");
                        String Dob = formatter.format(s.getDob());
                %>
                        <tr>
                            <td><%= s.getID() %></td>
                            <td><%= s.getName() %></td>
                            <td><%= s.isGender() %></td>
                            <td><%= Dob %></td>
                            <td>
                                <button type="submit" name="buttonAction" value="<%= "update_" + i %>">Update</button>
                            </td>
                            <td>
                                <button type="submit" name="buttonAction" value="<%= "delete_" + i %>">Delete</button>
                            </td>                            
                        </tr>
                <%
                    }
                }
                %>
            </table>
        </form>
    </body>
</html>
