<%-- 
    Document   : register
    Created on : Apr 18, 2017, 9:56:24 AM
    Author     : Lenovo
--%>

<%@include  file="../../assets/header.jsp"%>


<div class="row" style=" border-radius: 5px; width:70%;
    background-color:  #eee;
    padding: 40px;">
    <h2 style="align:center"> Registration Form</h2> 

    <form class="form-horizontal" method="post" action="">
        <fieldset>

            <!-- Form Name -->
            <legend></legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="textinput">User Name</label>  
                <div class="col-md-4">
                    <input id="username" name="username" placeholder="Create your User Name" class="form-control input-md" required="" type="text">
                    <span class="help-block"> </span>  
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="textinput">Password</label>  
                <div class="col-md-4">
                    <input id="password" name="password" placeholder="Enter password" class="form-control input-md" required="" type="password">
                    <span class="help-block"> </span>  
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="textinput">Confirm Password</label>  
                <div class="col-md-4">
                    <input id="cpassword" name="cpassword" placeholder="Confirm password" class="form-control input-md" required="" type="password">
                    <span class="help-block"> </span>  
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="textinput">Reactivation code</label>  
                <div class="col-md-4">
                    <input id="code" name="code" placeholder="Reactivation code" class="form-control input-md" required="" type="text">
                    <span class="help-block"> </span>  
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="textinput">Email</label>  
                <div class="col-md-4">
                    <input id="email" name="email" placeholder="Enter email" class="form-control input-md" required="" type="email">
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
                    <button id="register" name="register" class="btn btn-success">Register</button>
                      <button id="singlebutton" name="singlebutton" class="btn btn-primary">Reset</button>
                </div>

            </div>

        </fieldset>
    </form>

</div>

<%@include  file="../../assets/footer.jsp"%>