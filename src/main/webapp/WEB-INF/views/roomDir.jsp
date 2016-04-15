<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
                    <form:select path="numOfGuests">
                        <form:option value="1" label="1"/>
                        <form:option value="2" label="2"/>
                        <form:option value="3" label="3"/>
                        <form:option value="4" label="4"/>
                    </form:select>
                    <form:errors class="formError" path="numOfGuests" element="strong"/>
                </div>
                <div class="col-xs-3">
                    <form:select path="range">
                        <form:option value="0-39" label="$0-$39.99"/>
                        <form:option value="40-79" label="$40-$79.99"/>
                        <form:option value="80-119" label="$80-$119.99"/>
                        <form:option value="120+" label="$120+"/>
                    </form:select>
                    <form:errors class="formError" path="numOfGuests" element="strong"/>
                </div>
                <div class="col-xs-3">
                    <form:input path="checkInDate" placeholder="Check In Date" value="" type="date" class="form-control" />
                    <form:errors class="formError" path="checkInDate" element="strong"/>
                </div>
                <div class="col-xs-3">
                    <form:input path="checkOutDate" placeholder="Check Out Date" value="" type="date" class="form-control" />
                    <form:errors class="formError" path="checkOutDate" element="strong"/>
                </div>
            </div>

            <div id="searchBtnDiv" class="col-xs-3">
                <button class="btn btn-lg btn-primary btn-block" type="submit">Search</button>
            </div>
        </form:form>
    </div>
</div>

<div class="container sections-group">
    
    <div class="row">
        <div class="col-md-12 column ui-sortable">
            
            <div class="page-header">
                <h1>Rooms</h1>
            </div>
        </div>
    </div>
    <div class="row directory"> 
        
        <c:forEach var="room" items="${roomList}">
        <div class="col-md-4 column ui-sortable roomBlock">
            <div class="wrappers">
            <h3><c:out value="${room.getRoomName()}"/></h3>
            <div class="roomPreview">
                <img src="/resources/img/room_photo.jpg"/> <!-- Get photo from DB -->
            </div>
                <a style="float: right;" href="${pageContext.request.contextPath}/rooms/${room.getRoomViewURL()}" class="btn btn-primary">Details</a>
                <p class="priceLabel">Just $<strong><c:out value="${room.getPricePerNight()}"/></strong> per night</p>
                <hr>
                <h4><i class="fa fa-users"></i> Max <strong><c:out value="${room.getMaxGuests()}"/></strong> guests</h4>
                <hr>
                <ul class="feature-list list-unstyled">
                    <c:forEach var="feature" items="${room.features}">
                        <c:choose>
                            <c:when test="${feature.value}">
                                <li><i class="fa fa-check"></i>${feature.key}</li>
                            </c:when>
                        </c:choose>
                    </c:forEach>    
                </ul>
            </div>
            
        </div>
            
        
        </c:forEach>
        
    </div>
    
    
    
</div>