<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="sections_group">
    <div class="section cont-map-section" style="border: 1px dashed black;" id="where" data-id="#where">
        <h1>Map</h1>
    </div>
    <div class="container contactForm">
    <div class="col-md-4 col-md-offset-4 col-sm-12 ">
        <div class="col-xs-12">	
            <h1>Contact Us</h1>
        <form:form modelAttribute="contactForm" method="POST" enctype="utf8">
                
                <form:errors class="formError" path="name">
                    <c:set var="inputError" value="inputErrorCls"/>
                </form:errors>
            
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                    <form:input path="name" placeholder="Full Name" class="form-control ${inputError}"/>
                </div>
                
                
                <form:errors class="formError" path="email">
                    <c:set var="inputError" value="inputErrorCls"/>
                </form:errors>
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
                    <form:input path="email" placeholder="Email" class="form-control ${inputError}"/>
                </div>
                
                <form:errors class="formError" path="subject">
                    <c:set var="inputError" value="inputErrorCls"/>
                </form:errors>
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-hashtag"></i></span>
                    <form:input path="subject" placeholder="Subject" class="form-control ${inputError}"/>
                </div>
                
                <form:errors class="formError" path="message">
                    <c:set var="inputError" value="inputErrorCls"/>
                </form:errors>
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-pencil"></i></span>
                    <form:textarea path="message" rows="5" cols="30" placeholder="Type your message here" class="form-control ${inputError}"/>
                </div>
                
                <div class="input-group">
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
                </div>
                
        </form:form>
        </div>
    </div>
    </div>
   
</div>