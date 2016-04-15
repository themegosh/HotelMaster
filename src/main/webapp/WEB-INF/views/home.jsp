<%-- 
    Document   : home
    Created on : 7-Apr-2016, 12:27:41 PM
    Author     : Trevor
--%>

<%@page import="java.util.Date"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  

<c:set var="now" value="<%=new java.util.Date()%>" />
<c:set var="tomorrow" value="<%=new Date(new Date().getTime() + 60*60*24*1000)%>"/>
<fmt:formatDate var="currDate" pattern="yyyy-MM-dd" value="${now}" />
<fmt:formatDate var="tmrwDate" pattern="yyyy-MM-dd" value="${tomorrow}"/>

<!DOCTYPE html>

<!-- Search Bar -->
<div id="searchContainer" class="container-fluid">
    <div class="col-xs-offset-3 col-xs-6">
        <form:form modelAttribute="searchParams" action="${pageContext.request.contextPath}/rooms" method="POST" enctype="utf8">
            <div class="col-xs-12">
                <div class="col-xs-3">
                    <label>Number of Guests</label>
                </div>
                <div class="col-xs-3">
                    <label>Price Range</label>
                </div>
                <div class="col-xs-3">
                    <label>Check In</label>
                </div>
                <div class="col-xs-3">
                    <label>Check Out</label>
                </div>
            </div>

            <div class="col-xs-12">
                <div class="col-xs-3">
                    <form:select class="form-control selectWidth" path="numOfGuests">
                        <form:option value="1" label="1"/>
                        <form:option value="2" label="2"/>
                        <form:option value="3" label="3"/>
                        <form:option value="4" label="4"/>
                        <form:option value="5" label="5"/>
                        <form:option value="6" label="6"/>
                        <form:option value="7" label="7"/>
                        <form:option value="8" label="8"/>
                        <form:option value="9" label="9"/>
                    </form:select>
                    <form:errors class="formError" path="numOfGuests" element="strong"/>
                </div>
                <div class="col-xs-3">
                    <form:select class="form-control selectWidth" path="range">
                        <form:option value="0-39" label="$0-$39.99"/>
                        <form:option value="40-79" label="$40-$79.99"/>
                        <form:option value="80-119" label="$80-$119.99"/>
                        <form:option value="120+" label="$120+"/>
                    </form:select>
                    <form:errors class="formError" path="numOfGuests" element="strong"/>
                </div>
                <div class="col-xs-3">
                    <form:input path="checkInDate" placeholder="Check In Date" value="${currDate}" min="${currDate}" type="date" class="form-control selectWidth" />
                    <form:errors class="formError" path="checkInDate" element="strong"/>
                </div>
                <div class="col-xs-3">
                    <form:input path="checkOutDate" placeholder="Check Out Date" value="${tmrwDate}" min="${tmrwDate}"  type="date" class="form-control selectWidth" />
                    <form:errors class="formError" path="checkOutDate" element="strong"/>
                </div>
            </div>

            <div id="searchBtnDiv" class="col-xs-2"><br/>
                <button class="btn btn-primary btn-block" type="submit">Search</button>
            </div>
        </form:form>
    </div>
</div>

<!-- Image Gallery -->
<div class="container">  
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <c:forEach var="photo" items="${photoList}" varStatus="loop">
                <li data-target="#myCarousel" data-slide-to="${loop.index}"
                <c:choose>
                    <c:when test="${loop.index == 0}">
                        class="active"
                    </c:when>   
                </c:choose>
                ></li>
            </c:forEach>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <c:forEach var="photo" items="${photoList}" varStatus="loop">
                <div class="item 
                <c:choose>
                    <c:when test="${loop.index == 0}">
                        active
                    </c:when>
                </c:choose>
                ">
                <img class="img-responsive" src="/getPhoto?ID=${photo.imageID}" alt="Hotel Room Image">
                </div>
            </c:forEach>
        </div>

        <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>