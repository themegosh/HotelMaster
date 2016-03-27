<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<ul style="list-style:none;line-height:28px;">

    <li><spring:url value="/home" var="homeUrl" htmlEscape="true" />
        <a href="${homeUrl}">Home</a>
    </li>

    <li><spring:url value="/login" var="loginUrl" htmlEscape="true" />
        <a href="${loginUrl}">Login</a>
    </li>

</ul>
