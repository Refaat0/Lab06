<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="ShoppingList" method="POST">
            <label>Username:</label>
            <input type="text" name="username" value="">
            <input type="submit" name="action" value="register">
        </form>
        <p>${errorMsg}</p>
    </body>
</html>
