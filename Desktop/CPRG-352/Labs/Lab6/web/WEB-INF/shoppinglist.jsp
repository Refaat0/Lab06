<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <header>
            <h1>Shopping List</h1>
            <p>Hello, ${usersname} <a href="?logout" action="log">Logout</a></p>   
        </header>

        <main>
            <h3>List</h3>
            <form method="post" action="ShoppingList">
                <label>Add Item:</label>
                <input type="text" name="item" value="" >
                <input type="submit" name="action" value="add">
            </form>

            <c:forEach var="item" items="${items}">
                <label>${item}</label>
                <input type="radio" value="${item}" name="item">
                <br>
            </c:forEach>

            <form method="post" action="ShoppingList">
                <input type="submit" name="action" value="delete">
            </form>
        </main>
    </body>
</html>
