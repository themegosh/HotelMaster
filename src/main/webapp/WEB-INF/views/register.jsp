<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container loginRegister">
    <div class="col-md-4 col-md-offset-4 col-sm-12 ">
        <h3 class="title">Registration</h3>
        <div class="row ">
            <div class="col-sm-12">
                <a href="${pageContext.request.contextPath}/login-facebook" class="btn btn-lg btn-block btnFacebook">
                    <i class="fa fa-facebook"></i><span>Facebook</span>
                </a>
            </div>	
        </div>
        <div class="row loginRegisterOr">
            <div class="col-xs-12">
                <hr class="hrOr">
                <span class="spanOr">or</span>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12">	
                <form:form modelAttribute="userForm" method="POST" enctype="utf8">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                        <form:input path="firstName" placeholder="First Name" value="" class="form-control" />
                        <form:errors path="firstName" element="div"/>
                    </div>
                    <span class="help-block"></span>
                    
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                        <form:input path="lastName" placeholder="Last Name" value="" class="form-control" />
                        <form:errors path="lastName" element="div"/>
                    </div>
                    <span class="help-block"></span>
                    
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-at"></i></span>
                        <form:input path="email" placeholder="Email" value="" class="form-control" />
                        <form:errors path="email" element="div"/>
                    </div>
                    <span class="help-block"></span>
                    
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                        <form:input path="password" placeholder="Password" type="password" value="" class="form-control" />
                        <form:errors path="password" element="div"/>
                    </div>
                    <span class="help-block"></span>
                    
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                        <form:input path="confirmPassword" placeholder="Confirm Password" type="confirmPassword" value="" class="form-control" />
                        <form:errors path="confirmPassword" element="div"/>
                    </div>
                    <span class="help-block"></span>

                    <div class="row">
                        <div class="col-xs-6">
                            <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
                        </div>
                        <div class="col-xs-6">
                            <a href="${pageContext.request.contextPath}/login" class="btn btn-lg btn-default btn-block" type="submit">Login</a>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
        
        
    </div>
</div>
