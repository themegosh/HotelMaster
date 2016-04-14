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
    </head>
    <body>
        
        
        <div>
        
            <h1>Room Manager</h1>
            
            <table class="table table-striped">
                <thead>
                    <tr>
                        <td>ID</td> 
                        <td>Name</td>
                        <td>Floor</td>
                        <td>Price per night</td>
                        <td>Max no. of guests</td>
                        <td>Features</td>
                        <td></td>
                    </tr>
                </thead>
                <tr>
                    <td></td>
                    <form:form modelAttribute="roomForm" method="POST" encoding="utf8">
                        <td><form:input path="roomName" placeholder=""/></td>
                        <td><form:input path="floor" placeholder=""/></td>
                        <td><form:input path="pricePerNight" placeholder=""/></td>
                        <td><form:input path="maxGuests" placeholder=""/></td>
                        <td class="featuresDropdown">
                            <div class="col-lg-12">
                            <div class="button-group">
                                <button id="btnDrop" type="button" class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-cog"></span> Select Features <span class="caret"></span></button>
                                <ul class="dropdown-menu">
                                    <c:forEach var="feature" items="${features}" varStatus="i">
                                        <li style="padding-left: 5px;"><form:checkbox id="${feature}" value="${feature}" path="featuresTest"/> <label for="${feature}"><c:out value="${feature}"/></label></li>
                                    </c:forEach>
                                </ul>
                            </div>
                            </div>
                        </td>
                        <td><button type="submit" class="btn btn-success" name="action" value="add">Add</button></td>
                    </form:form>
                </tr>
                <c:forEach var="room" items="${roomList}" varStatus="status">
                    <tr>            
                        <form:form modelAttribute="roomForm" method="POST" encoding="utf8">
                            <td><input class="borderlessInput" type="text" name="roomID" value="${room.roomID}"/></td>
                            <td><input class="borderlessInput" type="text" name="roomName" value="${room.roomName}"/></td>
                            <td><input class="borderlessInput" type="text" name="floor" value="${room.floor}"/></td>
                            <td>$<input class="borderlessInput" type="number" name="pricePerNight" step="0.01" value="${room.pricePerNight}" min="0" max="99.99"/></td>
                            <td><input class="borderlessInput" type="number" name="maxGuests" value="${room.maxGuests}" min="1" max="9"/></td>
                            <td class="featuresDropdown">
                                <div class="col-lg-12">
                                    <div class="button-group">
                                        <button id="btnDrop" type="button" class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-cog"></span> Select Features <span class="caret"></span></button>
                                        <ul class="dropdown-menu">
                                            <c:forEach var="feature" items="${room.features}" varStatus="i">
                                                <c:choose>
                                                    <c:when test="${feature.value}">
                                                        <li style="padding-left: 5px;"><form:checkbox id="${feature.key}" value="${feature}" path="featuresTest" checked="checked"/><label for="${feature.key}"><c:out value="${feature.key}"/></label></li>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <li style="padding-left: 5px;"><form:checkbox id="${feature.key}" value="${feature}" path="featuresTest" checked=""/><label for="${feature.key}"><c:out value="${feature.key}"/></label></li>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </div>
                            </td>
                            <td>
                                <button type="submit" class="btn btn-primary" name="action" value="edit">Save</button> &nbsp;
                                <button type="submit" class="btn btn-danger" name="action" value="delete">Delete</button> 
                            </td>
                        </form:form>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
