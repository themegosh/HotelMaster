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
                    <li><spring:url value="/rooms" var="roomsDir" htmlEscape="true" />
                        <a href="${roomsDir}">Rooms</a>
                    </li>
                    <li><spring:url value="/contact" var="contactUrl" htmlEscape="true" />
                        <a href="${contactUrl}">Contact Us</a>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <c:choose>
                        <c:when test="${accountSession.getId() > '0'}">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle nav-login-dropdown" data-toggle="dropdown">
                                    <img class="img-circle" src="<c:out value="${accountSession.getProfilePicUrl()}"/>?width=40&height=40" />
                                    <strong><c:out value="${accountSession.getFirstName()}" /></strong>
                                </a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <div class="navbar-login">
                                            <div class="row">
                                                <div class="col-lg-4">
                                                    <p class="text-center">
                                                        <img class="img-circle" src="<c:out value="${accountSession.getProfilePicUrl()}"/>?width=87&height=87" />
                                                    </p>
                                                </div>
                                                <div class="col-lg-8">
                                                    <p class="text-left"><strong><c:out value="${accountSession.getFirstName()}" /> <c:out value="${accountSession.getLastName()}" /></strong></p>
                                                    <p class="text-left small"><c:out value="${accountSession.getEmail()}" /></p>
                                                    <c:if test="${accountSession.getClass().getName() == 'hotelmaster.account.Admin'}">
                                                        <p class="text-left">
                                                            <spring:url value="/admin" var="adminUrl" htmlEscape="true" />
                                                            <a href="${adminUrl}" class="btn btn-primary btn-block btn-sm">Admin Panel</a>
                                                        </p>
                                                    </c:if>
                                                    
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <div class="navbar-login navbar-login-session">
                                            <div class="row">
                                                <div class="col-lg-12">
                                                    <p><spring:url value="/logout" var="logoutUrl" htmlEscape="true" />
                                                        <a href="${logoutUrl}" class="btn btn-danger btn-block">Log Out</a>
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
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
                    
