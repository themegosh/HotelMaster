<%-- 
    Document   : room
    Created on : 2-Apr-2016, 9:27:41 PM
    Author     : Danny
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrator Room Manager</title>
    </head>
    <body>
        <h1>Room Manager</h1>
        
        <form method="POST" role="form">
            <label for="room_name">Room name: </label>
            <input id="room_name" type="text" name="roomName" /> <br />
            
            <label for="room_floor">Floor: </label>
            <input id="room_floor" type="text" name="floor"/> <br />
            
            <label for="room_price">Price per night: </label>
            <input id="room_price" type="number" name="price"/> <br />
            
            <label for="room_max_guests">Max number of guests: </label>
            <input id="room_max_guests" type="number" name="maxGuests"/> <br />
            
            <button type="submit" name="add">Add</button> &nbsp;
            <button type="submit" name="delete">Delete</button> &nbsp; 
            <button type="submit" name="edit">Edit</button> 
        </form>>
    </body>
</html>
