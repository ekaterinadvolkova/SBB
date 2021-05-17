
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Timetables</title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>

<table class="style">
    <caption class="heading">SBB Trains</caption>
    <tr class="left-side">
        <th>ID</th>
        <th style="width: 100%">Station</th>
        <th style="width: 100%">Departure</th>
        <th style="width: 100%">Route</th>
        <th>Route</th>
        <th> </th>
    </tr>

    <c:forEach var="timetable" items="${timetableList}">
    <tr>
        <td class="left-side">${timetable.timetableID}</td>
        <td class="title" class="left-side">${timetable.stationID}</td>
        <td class="title"class="left-side">${timetable.departureTime}</td>
        <td class="right-side">${timetable.routeID} </td>
        <td class="right-side">
            <a href="edit/${timetable.timetableID}">Edit</a>
            <a href="delete/${timetable.timetableID}">Delete</a>
        </td>
    </tr>
    </c:forEach>


</body>
</html>
