<%-- 
    Document   : reports
    Created on : 12-Apr-2016, 8:51:40 AM
    Author     : Danny
--%>

<%@page import="java.util.Date"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  

<c:set var="now" value="<%=new java.util.Date()%>" />
<c:set var="tomorrow" value="<%=new Date(new Date().getTime() + 60*60*24*1000)%>"/>
<fmt:formatDate var="currDate" pattern="yyyy-MM-dd" value="${now}" />
<fmt:formatDate var="tmrwDate" pattern="yyyy-MM-dd" value="${tomorrow}"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reports</title>
    </head>
    <body>
    <div class="container adminContainer">
        <h2 class="text-center">Report Generator</h2>
        <form:form modelAttribute="reportForm" method="POST" encoding="utf8">
        <table class="table test table-striped">
            <tr>
                <td>Check in date</td>
                <td><form:input class="form-control selectWidth" path="checkInDate" placeholder="Check In Date" value="${currDate}" type="date" /> </td>
            </tr>
            <tr>
                <td>Check out date</td>
                <td><form:input class="form-control selectWidth" path="checkOutDate" placeholder="Check Out Date" value="${tmrwDate}" type="date" /></td>
            </tr>
            <tr>
                <td>Lower price range</td>
                <td><form:input class="form-control selectWidth" path="lowerPricePerNight" placeholder="0.00" type="number" step="0.01" min="0" max="9999.99" /></td>
            </tr>
            <tr>
                <td>Upper price range</td>
                <td><form:input class="form-control selectWidth" path="upperPricePerNight" placeholder="0.00" type="number" step="0.01" min="0" max="9999.99" /></td>
            </tr>
            <tr>
                <td>Floor</td>
                <td>
                    <form:select class="form-control selectWidth" path="floor">
                        <form:options items="${floors}" />                        
                    </form:select>
                </td>
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
