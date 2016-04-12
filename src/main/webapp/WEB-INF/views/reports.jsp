<%-- 
    Document   : reports
    Created on : 12-Apr-2016, 8:51:40 AM
    Author     : Danny
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %><!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reports</title>
    </head>
    <body>
    <div class="container">
        <h2>Report Generator</h2>
        <form:form modelAttribute="reportForm" method="POST" encoding="utf8">
        <table class="table test">
            <tr>
                <td>Check in date</td>
                <td><form:input path="checkInDate" placeholder="Check In Date"  type="date" /> </td>
            </tr>
            <tr>
                <td>Check out date</td>
                <td><form:input path="checkOutDate" placeholder="Check Out Date" type="date" /></td>
            </tr>
            <tr>
                <td>Lower price range</td>
                <td><form:input path="lowerPricePerNight" placeholder="0.00" type="number" step="0.01" min="0" max="99.99" /></td>
            </tr>
            <tr>
                <td>Upper price range</td>
                <td><form:input path="upperPricePerNight" placeholder="0.00" type="number" step="0.01" min="0" max="99.99" /></td>
            </tr>
            <tr>
                <td>Floor</td>
                <td><form:input path="floor" /></td>
            </tr>
            <tr>
                <td><button type="submit" class="btn btn-primary" name="action" value="continue">Continue</button></td>
                <td></td>
            </tr>
        </table>
        </form:form>
        
        <c:choose>
            <c:when test="${report.size() > 0}">
                <h2>Report</h2>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <td>Account ID</td>
                            <td>Room ID</td>
                            <td>Room name</td>
                            <td>Floor</td>
                            <td>Check in date</td>
                            <td>Check out date</td>
                            <td>Price per night</td>
                            <td>Length of stay</td>
                            <td>Total Cost</td>
                        </tr>
                    </thead>
                    <c:forEach var="booking" items="${report}" varStatus="status">
                        <tr>
                            <td>${booking.accountID}</td>
                            <td>${booking.roomID}</td>
                            <td>${booking.roomName}</td>
                            <td>${booking.floor}</td>
                            <td>${booking.checkInDate}</td>
                            <td>${booking.checkOutDate}</td>
                            <td>$${booking.pricePerNight}</td>
                            <td>${booking.lengthOfStay}</td>
                            <td>$${booking.totalPrice}</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td><strong>Total</strong></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td><strong>$${total}</strong></td>
                    </tr>
                </table>
            </c:when>
            <c:otherwise>
                <p>No bookings matched your search parameters.</p>
            </c:otherwise>
        </c:choose>
    </div>
    </body>
</html>
