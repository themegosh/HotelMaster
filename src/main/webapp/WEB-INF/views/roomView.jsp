<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container sections-group">
    
    <div class="row">
        <div class="col-md-12 column ui-sortable">
               
            <div class="page-header">
                <h1> hello </h1>
                <h1><c:out value="${room.getRoomName()}"/></h1>
            </div>
            
        </div>
    </div>
    
</div>