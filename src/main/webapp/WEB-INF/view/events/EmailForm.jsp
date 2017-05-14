<%-- 
    Document   : EmailForm
    Created on : Apr 24, 2017, 8:41:39 AM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Send Event Invitation</h1>
        <form method="post" >
            <div class="form-group">
                <label class="col-md-4 control-label" for="from">From</label>  
                <div class="col-md-4">
                    <input id="from" name="from" placeholder="nmaharjan417@gmail.com" class="form-control input-md" required="" type="text" value="nmaharjan417@gmail.com">
                    <span class="help-block"> </span>  
                </div>
            </div>
             <div class="form-group">
                <label class="col-md-4 control-label" for="to">From</label>  
                <div class="col-md-4">
                    <input id="to" name="to" placeholder="Enter recipients address" class="form-control input-md" required="" type="text" >
                    <span class="help-block"> </span>  
                </div>
            </div>
        </form>
    </body>
</html>
