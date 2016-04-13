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

<div class="container sections-group booking">
    
        <div class="row">
            <div class="col-md-12 column ui-sortable">

                <div class="page-header">
                    <h1>Edit Booking Details</h1>
                </div>            
            </div>
        </div>
    <form:form modelAttribute="bookingEdit" method="POST" enctype="utf8">
        <div class="row" style="padding-bottom: 10px;">
            <div class="col-sm-12" style="border: solid black 2px; padding: 0 20px 20px 20px;">
                <h3>Here your booking information</h3>
                <table>
                    <tr>
                        <td>
                            Check-in Date: 
                        </td>
                        <td>
                            <form:input path="startDate" placeholder="Check-in Date" value="${booking.getStartDate()}" min="${currDate}" type="date" class="form-control" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Check-out Date: 
                        </td>
                        <td>
                            <form:input path="endDate" placeholder="Check-out Date" value="${booking.getEndDate()}" min="${tmrwDate}" type="date" class="form-control" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Number of Guests: 
                        </td>
                        <td>
                            <form:select name="ddlGuests" path="numGuests" class="form-control selectWidth">
                                <c:forEach items="${numGuests}" var="val">
                                    <form:option value="${val.key}" selected="${booking.getNumGuests() eq val.key ? 'selected' : ' '}"/> 
                                </c:forEach>
                            </form:select>
                            <form:errors class="formError" path="numGuests" element="strong"/>
                        </td>
                    </tr>
                </table>

            </div>
        </div>
        <div class="row">
            <div class="col-xs-6">
                <button class="btn btn-lg btn-primary btn-block" type="submit">Save</button>
            </div>
            <div class="col-xs-6">
                <a href="${pageContext.request.contextPath}/rooms/${room.getRoomViewURL()}/book" class="btn btn-lg btn-default btn-block" type="submit">Cancel</a>
            </div>
        </div>
    </form:form>
</div>