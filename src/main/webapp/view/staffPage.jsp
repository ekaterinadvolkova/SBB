
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Staff</title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>

<table class="style">
    <caption class="heading">Staff Page</caption>
    <tr><td><a href="passengers/">View Passengers</a></td></tr>
    <tr><td><a href="trains/">View trains</a></td></tr>
    <tr><th>View passengers on the Train</th></tr>
    <tr><th><a href="stations/">View stations</a></th></tr>
    <tr><th><a href="editStation/">Add station</a></th></tr>
    <tr><td><a href="trains/add/">Add train</a></td></tr>
</table>
</body>
</html>
