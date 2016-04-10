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
    <img src="resources/img/hotelNew.png" class="img-responsive" alt="hotel">
    <div class="row">
        <div class="col-xs-12">
            <form:form modelAttribute="searchResult" method="POST" enctype="utf8">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                    <%--<form:input path="maxguests" placeholder="MaxGuests" value="" class="form-control" />--%>
                </div>
                <%--<form:errors class="formError" path="email" element="strong"/>--%>
                <div class="row">
                    <div class="col-xs-6">
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
                    </div>
                </div>
                <%--<form:errors class="formError" element="strong"/>--%>
            </form:form>
        </div>
    </div>
</div>

<div class="container">
    
    <h1>Gallery</h1>
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