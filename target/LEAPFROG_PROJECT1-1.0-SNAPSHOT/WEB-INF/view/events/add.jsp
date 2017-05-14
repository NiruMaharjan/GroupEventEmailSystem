<%@include  file="../../assets/header.jsp"%>

<div class="page-header">
    Add Event
</div>
user_id=${sessionScope.loggedin}
<div class="row" style=" border-radius: 5px; width:70%;
    background-color:  #eee;
    padding: 40px;">
   

    <form class="form-horizontal" method="post" action="">
        <fieldset>

            <!-- Form Name -->
            <legend></legend>

            <!-- Text input-->
            
            
            <div class="form-group">
                <label class="col-md-4 control-label" for="eventname">Event Title</label>  
                <div class="col-md-4">
                    <input id="eventname" name="eventname" placeholder="Create Event name" class="form-control input-md" required="" type="text">
                    <span class="help-block"> </span>  
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="textinput">Event Description</label>  
                <div class="col-md-4">
                    <textarea name="description" id="description" placeholder="Event Description" class="form-control input-md" required="" type="text"></textarea>
                    <span class="help-block"> </span>  
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="textinput">Start Date</label>  
                <div class="col-md-4">
                    <input id="startdate" name="startdate" placeholder="MM/DD/YYY" class="form-control input-md" required="" type="text">
                    <span class="help-block"> </span>  
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="textinput">End Date</label>  
                <div class="col-md-4">
                    <input id="code" name="enddate" placeholder="MM/DD/YYY" class="form-control input-md" required="" type="text">
                    <span class="help-block"> </span>  
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="textinput">Invite</label>  
                <div class="col-md-4">
                    <input id="invite" name="invite" class="form-control input-md" required="" type="checkbox">
                    <span class="help-block"> </span>  
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="textinput">Status</label>  
                <div class="col-md-4">
                    <input id="status" name="status"  class="form-control input-md" required="" type="checkbox">
                    <span class="help-block"> </span>  
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="singlebutton"> </label>
                <div class="col-md-4">
                    <button id="register" name="register" class="btn btn-success">Save Event</button>
                      <button id="singlebutton" name="singlebutton" class="btn btn-primary">Reset</button>
                </div>

            </div>
            <input type="hidden" name="user_id" value="${sessionScope.loggedin}" />

        </fieldset>
    </form>

</div>

<%@include  file="../../assets/footer.jsp"%>