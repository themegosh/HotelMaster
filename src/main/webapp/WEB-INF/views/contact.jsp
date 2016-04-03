<%-- 
    Document   : contact
    Created on : 27-Mar-2016, 2:25:33 PM
    Author     : GEORGE
--%>

<div class="sections_group">
    <div class="section cont-map-section" style="border: 1px dashed black;" id="where" data-id="#where">
        <h1>Map</h1>
    </div>
    <div class="section cont-form-section" style="border: 1px dashed black;" id="contact-form" data-id="#contact-form">
        <h1>Contact Form</h1>
        <form:form method="post" action="contactSuccess.jsp">
 
        <table>
            <tr>
                <td><form:label path="firstname">First Name</form:label></td>
                <td><form:input path="firstname" /></td> 
            </tr>
            <tr>
                <td><form:label path="lastname">Last Name</form:label></td>
                <td><form:input path="lastname" /></td>
            </tr>
            <tr>
                <td><form:label path="email">Email</form:label></td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td><form:label path="phone">Telephone</form:label></td>
                <td><form:input path="phone" /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Contact Submitted"/>
                </td>
            </tr>
        </table>  
     
</form:form>
    </div>
    <div class="section cont-add-section" style="border: 1px dashed black;" id="add-info" data-id="#add-info">
        <h1>Additional Info</h1>
    </div>
   
</div>