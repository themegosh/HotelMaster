<%-- 
    Document   : loginSuccess
    Created on : 26-Mar-2016, 11:29:54 PM
    Author     : mathe_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Connected to Facebook</title>
    </head>
    <body>
        <h2>Successfully connected to Facebook!</h2>
        <h3>Hello, <span th:text="${facebookProfile.name}">Some User</span>!</h3>
            <p>
                You are now connected to your Facebook account.
                Click <a href="/">here</a> to see some entries from your Facebook feed.
            </p>
    </body>
</html>
