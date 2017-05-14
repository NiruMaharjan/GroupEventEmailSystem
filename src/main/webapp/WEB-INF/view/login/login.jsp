<%-- 
    Document   : login
    Created on : Apr 17, 2017, 10:41:16 AM
    Author     : Lenovo
--%>

<%@include  file="../../assets/header.jsp"%>


    <div >
    <form  action="" class="form-group" method="post">
        <fieldset>
            <legend><h1>Login Form</h1></legend>
            <c:if test="${param.error!=null}">
               <div class="alert alert-danger alert-dismissible fade in" role="alert"> 
                   <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                   <strong>Invalid username password</strong>  </div>
               
            </c:if>

            <div class="row">
                
                <label  for="username" class="col-md-1"> User Name</label>
                <div class="col-md-4" >
                    <input type="text" class="form-control" name="username" id="username" placeholder="username"  required="required">
                </div>
            </div>
            <div class="row">
                <label for="password" class="col-md-1">Password</label>
                <div class="col-md-4">
                    <input type="password" class="form-control" name="password" id="password" placeholder="Password" class="col-md-4" required="required">
                </div>
            </div>
            <br/>
           

            <button type="submit" class="btn btn-success">Login</button>&nbsp;
            <button type="reset" class="btn btn-default">Reset</button>
            <br/><br/>
            
             <a href="${SITE_URL}/register">If you are not loggedin.Register here</a>
    </form>
    </div>

        <%@include  file="../../assets/footer.jsp"%>