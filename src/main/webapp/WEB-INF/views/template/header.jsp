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
                    <li class="active"> <!-- Dynamic class -->
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
                    
                    <li class="dropdown">
                        <c:choose>
                            <c:when test="${sessionScope['scopedTarget.bookingSession'].booking.roomID > '0'}">
                                <a href="/rooms/${sessionScope['scopedTarget.bookingSession'].booking.bookingURL}/book" class="dropdown-toggle" role="button" aria-haspopup="true" aria-expanded="false"><i class="fa fa-home"></i> View Bookings</a>
                            </c:when>
                            <c:otherwise>
                                <a href="/rooms" class="dropdown-toggle" role="button" aria-haspopup="true" aria-expanded="false"><i class="fa fa-home"></i> Book a Room</a>
                            </c:otherwise>
                        </c:choose>
                    </li>
                    
                    <c:choose>
                        <c:when test="${sessionScope['scopedTarget.accountSession'].account.id > '0'}">
                            <c:if test="${sessionScope['scopedTarget.accountSession'].account.isAdmin() == 'true'}">
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Admin Tools <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="/admin/accounts">Manage Users</a></li>
                                        <li><a href="/admin/photos">Manage Photos</a></li>
                                        <li><a href="/admin/rooms">Manage Rooms</a></li>
                                        <li><a href="/admin/reports">Generate Reports</a></li>
                                    </ul>
                                </li>
                            </c:if>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle nav-login-dropdown" data-toggle="dropdown">
                                    <img class="img-circle" src="<c:out value="${sessionScope['scopedTarget.accountSession'].account.getProfilePicUrl()}"/>?width=40&height=40" />
                                    <strong><c:out value="${sessionScope['scopedTarget.accountSession'].account.getFirstName()}" /></strong>
                                </a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <div class="navbar-login">
                                            <div class="row">
                                                <div class="col-lg-4">
                                                    <p class="text-center">
                                                        <img class="img-circle" src="<c:out value="${sessionScope['scopedTarget.accountSession'].account.getProfilePicUrl()}"/>?width=87&height=87" />
                                                    </p>
                                                </div>
                                                <div class="col-lg-8">
                                                    <p class="text-left"><strong><c:out value="${sessionScope['scopedTarget.accountSession'].account.getFirstName()}" /> <c:out value="${sessionScope['scopedTarget.accountSession'].account.getLastName()}" /></strong></p>
                                                    <p class="text-left small"><c:out value="${sessionScope['scopedTarget.accountSession'].account.getEmail()}" /></p>
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
                                                        <a href="${logoutUrl}" class="btn btn-primary btn-block">Log Out</a>
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
        <c:if test="${notificationService.getNotifications().size() > 0}" >
            <c:forEach items="${notificationService.getNotifications()}" var="notification"> 
                <div class="alert ${notification.getAlertClass()} alert-dismissible fade in" role="alert">
                    <div class="container">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button> 
                        <strong>${notification.title}</strong> ${notification.message}
                    </div>
                </div>
            </c:forEach>
            ${notificationService.clear()}
        </c:if>
                    