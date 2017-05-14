<%-- 
    Document   : EventMailList
    Created on : Apr 29, 2017, 10:39:10 PM
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
                <li><a class="active" href="${SITE_URL}/event">Home</a></li>
                <li><a href="${SITE_URL}/email">Email List</a></li>
                <li><a href="${SITE_URL}/eventmaillistcontroller"> Event Mail List</a></li>
                <li><a href="${SITE_URL}/invite">Invite</a></li>
              
                <li style="float:right"><a href="${SITE_URL}/logout">Logout</a></li>
                  <li style="float:right"><a href="${SITE_URL}/event">${sessionScope.name}</a></li>
            </ul>
            <table class="table table-bordered table-stripped table-hover">
                <tr>
                    <th>Event Mail List ID </th>
                    <th>Event Name</th>
                    <th>Email Address</th>
                    <th>Invite Date</th>
                    <th>Confirm</th>
                </tr>
                <c:forEach  var="eml" items="${requestScope.eventmaillist}">
                <tr>
                    <td>${eml.id}</td>
                    <td>${eml.event.title}</td>
                    <td>${eml.email.email_id}</td>
                    <td>${eml.invite_date}</td>
                    <td>
                       nnn
                    </td>
                </tr>
                </c:forEach>
            </table>