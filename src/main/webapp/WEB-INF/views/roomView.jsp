<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container sections-group">
    
    <div class="row">
        <div class="col-md-12 column ui-sortable">
               
            <div class="page-header">
                <h1><c:out value="${room.getRoomName()}"/></h1>
            </div>            
        </div>
    </div>
    <div class="row">
        <div class="col-sm-4 float-right">
            
            <p style="width: 100%; border: solid red 2px; text-align: center;"> FORM </p>
            <form:form type="submit">
                
            </form:form>
            
        </div>
        <div class="col-sm-8" style="border: solid blue 2px;">
             <p style="text-align: center;"> CONTENT </p>
             
             <div class="room-photo">
                 <img src="/resources/img/room_photo.jpg"/>
             </div>
             
             <div class="room-content-title">
                 <h4>Super cozy <u><c:out value="${room.getRoomName()}"/></u> just for $<strong><c:out value="${room.getPricePerNight()}"/> per night</strong></h4>
             </div>
             
             <div class="room-info">
                 <ul class="feature-list list-unstyled">
                     <li><i class="fa fa-check"></i>Features</li>
                    <li><i class="fa fa-check"></i>Max <strong><c:out value="${room.getMaxGuests()}"/></strong> guests</li>
                 </ul>
             </div>
             
             <div class="room-description">
                 <p>One morning, when Gregor Samsa woke from troubled dreams, he found himself transformed in his bed into a horrible vermin. 
                    He lay on his armour-like back, and if he lifted his head a little he could see his brown belly, 
                    slightly domed and divided by arches into stiff sections.</p>

                <p>The bedding was hardly able to cover it and seemed ready to slide off any moment. 
                    His many legs, pitifully thin compared with the size of the rest of him, waved about helplessly as he looked. 
                    "What's happened to me? " he thought. It wasn't a dream.</p>

                <p>His room, a proper human room although a little too small, lay peacefully between its four familiar walls. 
                    A collection of textile samples lay spread out on the table - 
                    Samsa was a travelling salesman - and above it there hung a picture that he had recently cut out of 
                    an illustrated magazine and housed in a nice, gilded frame. It showed a lady fitted out with a fur hat 
                    and fur boa who sat upright, raising a heavy fur muff that covered the whole of her lower arm towards the viewer. 
                    Gregor then turned to look out the window at the dull weather. Drops</p>
             </div>    
             
            <div class="featured-rooms">
                <c:forEach var="i" begin="1" end="2">
                    <div style="width: 40%; margin-right: 10px; float: left; padding: 20px;">
                        <img src="/resources/img/room_photo.jpg" style="width: 50%; float: left;"/>
                        <p style="padding-left: 20px;"><strong>Batman's Cave</strong></p>
                    </div>
                </c:forEach>
            </div>
             
        </div>
    </div>
    
</div>