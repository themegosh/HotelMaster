<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container sections-group booking">
        <div class="row">
            <div class="col-md-12 column ui-sortable">

                <div class="page-header">
                    <h1>Enjoy your staying!</h1>
                </div>            
            </div>
            <div class="col-md-12 column ui-sortable">
                <div class="input-group text-center">
                    <a href="${pageContext.request.contextPath}/rooms" class="btn btn-lg btn-default btn-block" type="submit">Book More Rooms</a>
                </div>
            </div>
        </div>
</div>