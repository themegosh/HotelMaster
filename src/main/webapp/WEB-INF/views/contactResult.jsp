<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="sections_group">
    <div class="section cont-map-section" style="border: 1px dashed black;" id="where" data-id="#where">
        <h1>Map</h1>
    </div>
    <div align="center">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Yaaay!</h2></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <h3>Thank you for contacting us! We will get back to you shortly.</h3>
                    </td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><c:out value="${contactForm.getName()}" /></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td>${contactForm.getEmail()}</td>
                </tr>
                <tr>
                    <td>Subject</td>
                    <td>${contactForm.getSubject()}</td>
                </tr>
                <tr>
                    <td>Message:</td>
                    <td>${contactForm.getMessage()}</td>
                </tr>

            </table>
        </div>
</div>
