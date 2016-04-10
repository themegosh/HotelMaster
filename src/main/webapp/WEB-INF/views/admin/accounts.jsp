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

        <!--
            JUST IGNORE THIS STUFF FOR THE TIME BEING.
        -->
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
  
        <h1>Room Manager</h1>
        
        <div>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>First Name</th> 
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Administrator</th>
                        <th></th>
                    </tr>
                </thead>
                    <tr>
                        
                        
                    </tr>
                <c:forEach var="account" items="${accountsList}" varStatus="status">
                    <tr>
                        <form:form modelAttribute="accountForm" method="POST" enctype="utf8">
                            <td><form:input path="firstName" placeholder="First Name" name="${account.firstName}" value="${account.firstName}" class="borderlessInput" /></td>
                            <td><input class="borderlessInput" type="text" name="${account.lastName}" value="${account.lastName}"/></td>
                            <td><input class="borderlessInput" type="text" name="${account.email}" value="${account.email}"/></td>
                            <td><input class="borderlessInput" type="checkbox" name="${account.email.getClass()}" value="${account.getClass()}" min="1"/> &nbsp; Admin</td>
                            <td>
                                <button type="submit" class="btn btn-default" name="save">Save</button> &nbsp;
                                <button type="submit" class="btn btn-default" name="delete">Delete</button> 
                            </td>
                        </form:form>
                    </tr>
            </c:forEach>
            </table>
        </div>
            
        <!--
        <form method="POST" role="form">
            <label for="room_name">Room name: </label>
            <input id="room_name" type="text" name="roomName" /> <br />
            
            <label for="room_floor">Floor: </label>
            <input id="room_floor" type="text" name="floor"/> <br />
            
            <label for="room_price">Price per night: </label>
            <input id="room_price" type="number" name="price"/> <br />
            
            <label for="room_max_guests">Max number of guests: </label>
            <input id="room_max_guests" type="number" name="maxGuests" min="1" max="8"/> <br />
            
            <button type="submit" name="add">Add</button> &nbsp;
            <button type="submit" name="delete">Delete</button> &nbsp; 
            <button type="submit" name="edit">Edit</button> 
        </form>>
        -->
    </body>