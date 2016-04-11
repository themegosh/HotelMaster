<%-- 
    Document   : room
    Created on : 2-Apr-2016, 9:27:41 PM
    Author     : Danny
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<div class="container">
    <style>
        .borderlessInput {
            border: none;
            background-color: transparent;
            font-family: inherit;
            font-size: inherit;
        }

    </style>
    <script>
        $('table td tr input').click(
        function(e) {
            e.preventDefault(); // prevent the default action
            e.stopPropagation(); // stop the click from bubbling
            $(this).closest('input').find('.borderlessInput').removeClass('borderlessInput');
            $(this).parent().addClass('borderlessInput');
        });
    </script>

    <h1>Account Manager</h1>

    <div>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>First Name</th> 
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Account Level</th>
                    <th></th>
                </tr>
            </thead>
                <tr>


                </tr>
            <c:forEach var="account" items="${accountsList}" varStatus="status">
                <tr>
                    <form:form modelAttribute="accountForm" method="POST" enctype="utf8">
                        <td><form:input path="firstName" placeholder="First Name" value="${account.firstName}" class="borderlessInput" /></td>
                        <td><form:input path="lastName" placeholder="Last Name" value="${account.lastName}" class="borderlessInput" /></td>
                        <td><form:input path="email" placeholder="Email" value="${account.email}" class="borderlessInput" /></td>
                        <td>Administrator <input type="checkbox" name="accessLevel" ${account.accountLevel == 'ADMIN' ? "checked='checked'" : ""} /> </td>
                        <td>
                            <button type="submit" class="btn btn-primary" name="save">Save</button> &nbsp;
                            <button type="submit" class="btn btn-danger" name="delete">Delete</button> 
                        </td>
                    </form:form>
                </tr>
        </c:forEach>
        </table>
    </div>
</div>