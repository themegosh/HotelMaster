<%-- 
    Document   : contact
    Created on : 27-Mar-2016, 2:25:33 PM
    Author     : GEORGE
--%>

<div class="sections_group">
    <div class="section cont-map-section" style="border: 1px dashed black;" id="where" data-id="#where">
        <h1>Map</h1>
    </div>
    <div align="center">
        <form:form action="contact" method="post" commandName="contactForm">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Please fulfill the form below</h2></td>
                </tr>
                <tr>
                    <td>Your Name:</td>
                    <td><form:input path="name" /></td>
                </tr>
                <tr>
                    <td>E-mail:</td>
                    <td><form:input path="email" /></td>
                </tr>
                <tr>
                    <td>Subject:</td>
                    <td><form:input path="subject" /></td>
                </tr>
                <tr>
                    <td>Message:</td>
                    <td><form:textarea path="message" rows="5" cols="30" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Register" /></td>
                </tr>
            </table>
        </form:form>
    </div>
   
</div>