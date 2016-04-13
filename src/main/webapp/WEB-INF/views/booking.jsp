<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container sections-group booking">
    
        <div class="row">
            <div class="col-md-12 column ui-sortable">

                <div class="page-header">
                    <h1>Review Booking Details</h1>
                </div>            
            </div>
        </div>
    <form:form>
        <div class="row" style="padding-bottom: 10px;">
            <div class="col-sm-12" style="border: solid black 2px; padding: 0 20px 20px 20px;">
                <h3>Here your booking information</h3>
                <table>
                    <tr>
                        <td>
                            Check-in Date: 
                        </td>
                        <td>
                            <strong><c:out value="${booking.getStartDate()}"/></strong>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Check-out Date: 
                        </td>
                        <td>
                            <strong><c:out value="${booking.getEndDate()}"/></strong>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Number of Guests: 
                        </td>
                        <td>
                            <strong><c:out value="${booking.getNumGuests()}"/></strong>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Number of Nights: 
                        </td>
                        <td>
                            <strong><c:out value="${booking.getNumNights()}"/></strong>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Total Cost: 
                        </td>
                        <td>
                            <strong>$<c:out value="${booking.getTotalCost()}"/></strong>
                        </td>
                    </tr>
                </table>

            </div>
        </div>
        <div class="row">
            <div class="col-xs-4">
                <button class="btn btn-lg btn-primary btn-block" type="submit">Confirm</button>
            </div>
            <div class="col-xs-4">
                <a href="" class="btn btn-lg btn-default btn-block" type="submit">Edit</a>
            </div>
            <div class="col-xs-4">
                <a href="" class="btn btn-lg btn-default btn-block" type="submit">Cancel</a>
            </div>
        </div>
    </form:form>
</div>