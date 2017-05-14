<%-- 
    Document   : AddEmail
    Created on : Apr 23, 2017, 8:04:34 PM
    Author     : Lenovo
--%>

<%@include  file="../../assets/header.jsp"%>
<div class="page-header">
    <h1>Add Email</h1>
</div>

<form class="form-horizontal" method="post" action="">
        <fieldset>

            <!-- Form Name -->
            <legend></legend>

            <!-- Text input-->
              <div class="form-group">
                <label class="col-md-4 control-label" for="name">Enter name</label>  
                <div class="col-md-4">
                    <input id="name" name="name" placeholder="Enter name" class="form-control input-md" required=""  type="text">
                    <span class="help-block"> </span>  
                </div>
            </div>
             
            
            
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">Enter Email</label>  
                <div class="col-md-4">
                    <input id="email" name="email" placeholder="Enter Email" class="form-control input-md" required="" type="text">
                    <span class="help-block"> </span>  
                </div>
            </div>

            <!-- Text input-->
           

           
            
            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="singlebutton"> </label>
                <div class="col-md-4">
                    <button id="register" name="register" class="btn btn-success">Save </button>
                      <button id="singlebutton" name="singlebutton" class="btn btn-primary">Reset</button>
                </div>

            </div>
            <input type="hidden" name="user_id" value="${sessionScope.loggedin}" />

        </fieldset>
    </form>


<%@include  file="../../assets/footer.jsp"%>