<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container login">
    <div class="col-md-6 col-md-offset-3 col-sm-12 ">
        <h3 class="title">Login or <a href="${pageContext.request.contextPath}/register">Register</a></h3>
        <div class="row ">
            <div class="col-sm-12">
                <a href="${pageContext.request.contextPath}/login-facebook" class="btn btn-lg btn-block btnFacebook">
                    <i class="fa fa-facebook"></i><span>Facebook</span>
                </a>
            </div>	
        </div>
        <div class="row loginOr">
            <div class="col-xs-12">
                <hr class="hrOr">
                <span class="spanOr">or</span>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12">	
                <form class="loginForm" action="${pageContext.request.contextPath}/login" autocomplete="off" method="POST">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                        <input type="text" class="form-control" name="username" placeholder="Email Address">
                    </div>
                    <span class="help-block"></span>

                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                        <input  type="password" class="form-control" name="password" placeholder="Password">
                    </div>
                    <span class="help-block">Password error</span>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
                </form>
            </div>
        </div>
    </div>
</div>

    