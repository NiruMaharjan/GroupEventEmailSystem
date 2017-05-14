<%-- 
    Document   : index
    Created on : Apr 17, 2017, 3:36:39 PM
    Author     : Lenovo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <script src="${SITE_URL}/assets/js/jquery.js" type="text/javascript"></script>

        <style>
            ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
                background-color: #333;
                text-decoration: none;
            }

            li {
                float: left;
            }

            li a {
                display: block;
                color: white;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
                text-decoration-line: none;
            }

            li a:hover {
                background-color: #111;
            }
        </style>
    </head>
    <body style="background-color: #eee">
        <div class="container">

            <ul>
                <li><a class="active" href="${SITE_URL}/event" style="font-weight: bolder">Home</a></li>
                <li><a href="${SITE_URL}/email" style="font-weight: bolder">Email List</a></li>
                <li><a href="${SITE_URL}/eventmaillistcontroller" style="font-weight: bolder"> Event Mail List</a></li>
                <li><a href="${SITE_URL}/invite" style="font-weight: bolder">Invite</a></li>
              
                <li style="float:right"><a href="${SITE_URL}/logout" style="font-weight: bolder">Logout</a></li>
                  <li style="float:right"><a href="${SITE_URL}/event" style="font-weight: bolder">${sessionScope.name}</a></li>
            </ul>

                userid=${sessionScope.loggedin}
                username=${sessionScope.name};
            <div class="page-header">
                <h1 style="color:green; font-weight: bolder">Event Manager</h1>
            </div>
                
               
               
                      
            <div class="pull-right">
                <a href="${SITE_URL}/event/add" class="btn btn-primary btn-sm" style="font-size: 10px; font-style: normal">
                    <span class="glyphicon glyphicon-plus"></span>Add Event
                </a>
            </div>
            <br/>   <br/>   


            <table class="table  table-bordered table-stripped table-hover" style="border:1px solid black">
                <tr >
                    <th style="color:green">Event id</th>
                    <th style="color:green"> Event Title</th>
                    <th style="color:green">Description</th>
                    <th style="color:green">added Date</th>
                    <th style="color:green">Start Date</th>
                    <th style="color:green">End Date</th>
                    <th style="color:green">Invite   </th>
                    <th style="color:green">status</th>
                    <th style="color:green">Action</th>



                </tr>
                <c:forEach var="event" items="${requestScope.events}">
                    <tr>
                        <td style="color:purple">${event.id}</td>
                        <td>${event.title}</td>
                        <td>${event.description}</td>
                        <td>${event.added_date}</td>
                        <td>${event.start_date}</td>
                        <td>${event.end_date}</td>
                        <td>
                            <c:choose>
                                <c:when test="${event.invite}">
                                    <span class="label label-success">Active</span> 
                                </c:when>
                                <c:otherwise>
                                    <span class="label label-danger">Inactive</span>
                                </c:otherwise>

                            </c:choose>

                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${event.status}">
                                    <span class="label label-success">Active</span>

                                </c:when>
                                <c:otherwise>
                                    <span class="label label-danger">Inactive</span>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <a href="${SITE_URL}/event/edit?id=${event.id}" class="btn btn-success btn-xs"><span class="glyphicon glyphicon-pencil"></span></a>
                            <a href="${SITE_URL}/event/delete?id=${event.id}" class="btn btn-danger btn-xs" onclick="return confirm('Are you sure to delete? ')"><span class="glyphicon glyphicon-trash"></span></a>
                            <a href="${SITE_URL}/multipleEmailController/sendEmail?id=${event.id}" class="btn btn-success btn-xs"><span> email</span></a>
                        </td>
                    </tr>
                </c:forEach>






            </table>
    </body>

</html>
