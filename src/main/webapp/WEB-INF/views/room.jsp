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

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrator Room Manager</title>
        
        <!--
            JUST IGNORE THIS STUFF FOR THE TIME BEING.
        -->
        <style>
            .borderlessInput {
                border: none;
                outline: none;
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
        
    </head>
    <body>
        <h1>Room Manager</h1>
        
        <div>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <td>ID</td> 
                        <td>Name</td>
                        <td>Floor</td>
                        <td>Price per night</td>
                        <td>Max no. of guests</td>
                        <td></td>
                    </tr>
                </thead>
                    <tr>
                        
                        <form:form action="addRoom" method="post" modelAttribute="room">
                            <!-- If I remove the form:input tag apache tiles won't complain -->
                            <form:input path="roomName"/>                            
                        </form:form>
                    </tr>
                <c:forEach var="room" items="${roomList}" varStatus="status">
                    <tr>
                        <td>${room.roomID}</td>
                        <td><input class="borderlessInput" type="text" name="${room.roomName}" value="${room.roomName}"/></td>
                        <td><input class="borderlessInput" type="text" name="${room.floor}" value="${room.floor}"/></td>
                        <td>$<input class="borderlessInput" type="number" name="${room.pricePerNight}" value="${room.pricePerNight}" min="0"/></td>
                        <td><input class="borderlessInput" type="number" name="${room.maxGuests}" value="${room.maxGuests}" min="1" max="9"/></td>
                        <td>
                            <button type="submit" class="btn btn-default" name="edit">Edit</button> &nbsp;
                            <button type="submit" class="btn btn-default" name="delete">Delete</button> 
                        </td>
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
</html>
