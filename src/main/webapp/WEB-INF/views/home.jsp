<%-- 
    Document   : home
    Created on : 7-Apr-2016, 12:27:41 PM
    Author     : Trevor
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>

<div class="container-fluid">
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <c:forEach var="photo" items="${photoList}" varStatus="status">
                <c:choose>
                    <c:when test="${status.count == 1}">
                        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                        </c:when>
                        <c:otherwise>
                        <li data-target="#myCarousel" data-slide-to="${status.count}"></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <c:forEach var="photo" items="${photoList}" varStatus="status">
                <c:choose>
                    <c:when test="${status.count == 1}">
                        <div class="item active">
                        </c:when>
                        <c:otherwise>
                            <div class="item">
                            </c:otherwise>
                        </c:choose>
                        <img src="/getPhoto?ID=${photo.imageID}" alt="placeholder">
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
    <span class="help-block"></span>

<div class="container">
    <div class="col-xs-offset-3 col-xs-6" id="searchContainer">
        <form:form modelAttribute="searchParams" action="${pageContext.request.contextPath}/rooms" method="POST" enctype="utf8">
            <div class="input-group col-xs-12">
                <div class="col-xs-6">
                    <form:label path="numOfGuests" for="ddlGuests">Number of Guests:</form:label>&nbsp;
                    <form:select name="ddlGuests" path="numOfGuests">
                        <form:option value="1" label="1"/>
                        <form:option value="2" label="2"/>
                        <form:option value="3" label="3"/>
                        <form:option value="4" label="4"/>
                    </form:select>
                    <form:errors class="formError" path="numOfGuests" element="strong"/>
                </div>
            </div> 
            <span class="help-block"></span>

            <div class="input-group col-xs-12">
                <div class="col-xs-6">
                    <form:label path="checkInDate">Check In:</form:label>
                    <form:input path="checkInDate" placeholder="Check In Date" value="" type="date" class="form-control" />
                    <form:errors class="formError" path="checkInDate" element="strong"/>
                </div>

                <div class="col-xs-6">
                    <form:label path="checkOutDate">Check Out:</form:label>
                    <form:input path="checkOutDate" placeholder="Check Out Date" value="" type="date" class="form-control" />
                    <form:errors class="formError" path="checkOutDate" element="strong"/>
                </div>
            </div>
            <span class="help-block"></span>

            <div class="col-xs-3">
                <button class="btn btn-lg btn-primary btn-block" type="submit">Search</button>
            </div>

        </form:form>
    </div>
</div>
</div>