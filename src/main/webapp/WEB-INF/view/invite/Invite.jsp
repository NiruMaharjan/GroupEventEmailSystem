<%-- 
    Document   : Invite
    Created on : Apr 25, 2017, 12:30:32 PM
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
        
        <div>
            <input type="hidden" name="user_id" id="userid" value="${sessionScope.loggedin}"/>
        </div>
        <div class="form-group">
            <div class="form-group">
                <label class="col-md-4 control-label" for="event">Event Title</label>  
                <div class="col-md-4">
                    <select name="event_id" class="form-control">
                        <option value="">Select Event Title</option>
                        <c:forEach var="event" items="${requestScope.events}">
                            <option value="${event.id}">${event.title}</option>

                        </c:forEach>


                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="from">From</label>  
                <div class="col-md-4">
                    <input id="from" name="from" placeholder="enter email" class="form-control input-md" required="" value="${sessionScope.useremail}" type="email">
                    <span class="help-block"> </span>  
                </div>
            </div>





            <div class="form-group">
                <label class="col-md-4 control-label" for="to">To</label>  
                <div class="col-md-4">
                    <select name="email_id_no" class="form-control">
                        <option value="">Select Email Address</option>
                        <c:forEach var="email" items="${requestScope.emails}">
                            <option value="${email.id}">${email.email_id}</option>

                        </c:forEach>


                    </select>
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
                    <button type="submit" id="register" name="register" class="btn btn-success">Send Email</button>
                    <button type="reset" id="singlebutton" name="singlebutton" class="btn btn-primary">Reset</button>
                </div>

            </div>
            <input type="hidden" name="user_id" value="${sessionScope.loggedin}" />

    </fieldset>
</form>

</body>
<script>
    $(document).on("ready", function () {
        alert("hello");
    });

</script>
</html>
