<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <div class="panel panel-default">
        <div class="panel-body">
            <h2>Login</h2>
            <!--
                Error message is shown if login fails.
            -->
            <c:if test="${param.error eq 'bad_credentials'}">
                <div class="alert alert-danger alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    Login Failed
                </div>
            </c:if>
            <!-- Specifies action and HTTP method -->
            <form action="${pageContext.request.contextPath}/login/authenticate" method="POST" role="form">
                <!-- Add CSRF token -->
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <div class="row">
                    <div id="form-group-email" class="form-group col-lg-4">
                        <label class="control-label" for="user-email">Email:</label>
                        <!-- Add username field to the login form -->
                        <input id="user-email" name="username" type="text" class="form-control"/>
                    </div>
                </div>
 
                <div class="row">
                    <div id="form-group-password" class="form-group col-lg-4">
                        <label class="control-label" for="user-password">Password:</label>
                        <!-- Add password field to the login form -->
                        <input id="user-password" name="password" type="password" class="form-control"/>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-lg-4">
                        <!-- Add submit button -->
                        <button type="submit" class="btn btn-default">Submit</button>
                    </div>
                </div>
            </form>
            <div class="row">
                <div class="form-group col-lg-4">
                    <!-- Add create user account link -->
                    <a href="${pageContext.request.contextPath}/user/register">Register</a>
                </div>
            </div>
        </div>
    </div>
    <!-- Social Sign In Buttons -->
    <div class="panel panel-default">
        <div class="panel-body">
            <h2>Sign in with Facebook</h2>
            <div class="row social-button-row">
                <div class="col-lg-4">
                    <!-- Add Facebook sign in button -->
                    <a href="${pageContext.request.contextPath}/login-facebook"><button class="btn btn-facebook"><i class="icon-facebook"></i> | Sign in with Facebook</button></a>
                </div>
            </div>
        </div>
    </div>