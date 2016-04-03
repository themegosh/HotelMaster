<%-- 
    Document   : contactSuccess
    Created on : 2-Apr-2016, 9:49:18 PM
    Author     : GEORGE
--%>
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
                    <td>${contactForm.name}</td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td>${contactForm.email}</td>
                </tr>
                <tr>
                    <td>Subject</td>
                    <td>${contactForm.subject}</td>
                </tr>
                <tr>
                    <td>Message:</td>
                    <td>${contactForm.message}</td>
                </tr>

            </table>
        </div>
</div>
