<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<header>
     <!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <spring:url value="/home" var="homeUrl" htmlEscape="true" />
                <a class="navbar-brand" href="${homeUrl}">Hotel Master</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="active">
                        <a href="${homeUrl}">Home</a>
                    </li>
                    <li><spring:url value="/contact" var="contactUrl" htmlEscape="true" />
                        <a href="${contactUrl}">Contact Us</a>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <c:choose>
                        <c:when test="${accountSession.getId() > '0'}">
                            <li>
                                <a href="#">
                                    Welcome back, <span><c:out value="${accountSession.getFirstName()}" /></span>
                                </a>
                            </li>
                        </c:when>    
                        <c:otherwise>
                            <li><spring:url value="/login" var="loginUrl" htmlEscape="true" />
                                <a href="${loginUrl}">Login</a>
                            </li>
                            <li><spring:url value="/register" var="registerUrl" htmlEscape="true" />
                                <a href="${registerUrl}">Register</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                    
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </nav>
</header>
