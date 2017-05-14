<%-- 
    Document   : InviteAllAtOnce
    Created on : May 1, 2017, 2:52:00 PM
    Author     : Lenovo
--%>

<%@page import="com.leapfrog.lfaproject.entity.Event"%>
<%@include  file="../../assets/header.jsp"%>
<div class="page-header">
    <h1>Invite for an event</h1>
</div>
user_id=${sessionScope.loggedin};
<form class="form-horizontal" method="post" action="">
    <fieldset>

        <!-- Form Name -->
        <legend></legend>

        <!-- Text input-->
        
        <input type="hidden" name="eventid" value="${requestScope.event.id}"/>
            <input type="hidden" name="eventid" value="${sessionScope.loggedin}"/>
        <div class="form-group">
            <label class="col-md-4 control-label" for="event">Event Title</label>  
            <div class="col-md-4">
                <input id="eventname" name="eventname" placeholder="Event Title" class="form-control input-md" required=""  type="text"   value="${requestScope.event.title}">
                <span class="help-block"> </span>  
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="from">From</label>  
            <div class="col-md-4">
                <input id="from" name="from" placeholder="enter email" class="form-control input-md" required="" rel="${requestScope.id}" value="${sessionScope.useremail}" type="email">
                <span class="help-block"> </span>  
            </div>
        </div>





       
        <div class="form-group">
            <label class="col-md-4 control-label" for="subject">Subject</label>  
            <div class="col-md-4">
                <input id="subject" name="subject" placeholder="Enter Subject" class="form-control input-md" required="" type="text">
                <span class="help-block"> </span>  
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="message">Message</label>  
            <div class="col-md-4">
                <textarea name="message" id="message" placeholder="Message" class="form-control input-md" required="" type="text"></textarea>
                <span class="help-block"> </span>  
            </div>
        </div>



        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textinput">Confirm</label>  
            <div class="col-md-4">
                <input id="confirm" name="confirm" class="form-control input-md" required="" type="checkbox">
                <span class="help-block"> </span>  
            </div>
        </div>


        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"> </label>
            <div class="col-md-4">
                <button type="submit" id="sendEmail" name="sendEmail" class="btn btn-success">Send Email</button>
                <button type="reset" id="singlebutton" name="singlebutton" class="btn btn-primary">Reset</button>
            </div>

        </div>
       

    </fieldset>
</form>

</body>

</html>
