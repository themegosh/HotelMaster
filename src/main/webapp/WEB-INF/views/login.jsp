<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<script>
    $(document).ready(function() {
        $('.loginAnchor').addClass('active');
    });
</script>

<div class="container loginRegister">
    <div class="col-md-4 col-md-offset-4 col-sm-12 ">
        <h3 class="title">Login</h3>
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
                <form:form modelAttribute="loginForm" method="POST" enctype="utf8">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                        <form:input path="email" placeholder="Email" value="" class="form-control" />
                    </div>
                    <form:errors class="formError" path="email" element="strong"/>
                    <span class="help-block"></span>

                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                        <form:input path="password" placeholder="Password" type="password" value="" class="form-control" />
                    </div>
                    <form:errors class="formError" path="password" element="strong"/>
                    <span class="help-block"></span>
                    <div class="row">
                        <div class="col-xs-6">
                            <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
                        </div>
                        <div class="col-xs-6">
                            <a href="${pageContext.request.contextPath}/register" class="btn btn-lg btn-default btn-block" type="submit">Register</a>
                        </div>
                    </div>
                    <form:errors class="formError" element="strong"/>
                </form:form>
            </div>
        </div>
    </div>
</div>

    