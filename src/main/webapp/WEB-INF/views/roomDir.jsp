<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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