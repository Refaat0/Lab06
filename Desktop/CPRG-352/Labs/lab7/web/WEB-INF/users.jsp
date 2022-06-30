<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style><%@include file="/WEB-INF/style.css"%></style>
    </head>
    <body>
        <header>
            <h1>UserDB</h1>
        </header>


        <main>
            <div class="create-user-container">
                <form action="${pageContext.request.contextPath}/UserServlet" method="post">
                    <label>First Name</label>
                    <input type="text" name="firstName">

                    <label>Last Name</label>
                    <input type="text" name="lastName">

                    <label>Email:</label>
                    <input type="text" name="email">

                    <label>Role:</label>
                    <input type="number" name="role">

                    <label>Is Active:</label>
                    <input type="text" name="isActive">
                    <br>
                    <button class="create-button" name="addBtn">Add User</button>
                </form>
            </div>

            <div class="user-table-container">
                <table>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Role</th>
                        <th>Is active</th>
                        <th>Actions</th>
                    </tr>
                    <c:forEach items="${users}" var="element"> 
                        <tr>
                            <td>${element.firstName}</td>
                            <td>${element.lastName}</td>
                            <td>${element.email}</td>
                            <td>${element.role}</td>
                            <td>${element.active}</td>

                            <td>
                                <form action="${pageContext.request.contextPath}/UserServlet?email=${element.email}" method="post">
                                    <input type='submit' value='Delete' name='deleteBtn'>
                                </form> 
                                <form action="${pageContext.request.contextPath}/UserServlet?email=${element.email}" method="post">
                                    <input type='submit' value='Edit' name='editBtn'>
                                </form>    
                            </td>


                        </tr>
                    </c:forEach>
                </table>
            </div>
        </main>
    </body>
</html>
