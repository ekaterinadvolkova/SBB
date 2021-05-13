
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
    <title >Passengers </title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>

<table class="style">
    <caption class="heading">SBB Stations</caption>
    <tr class="left-side">
        <th>ID</th>
        <th style="width: 100%">Station Name</th>
        <th style="width: 100%">Action</th>
    </tr>

    <c:forEach var="station" items="${stationList}">
        <tr>
            <td class="left-side">${station.stationID}</td>
            <td class="title" class="left-side">${station.name}</td>

            <td class="right-side">
                <a href="edit/${station.stationID}">Edit</a>
                <a href="delete/${station.stationID}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<table class="style">
    <tr class="left-side"><th><a href="add/">Add Station</a> </th></tr>
</table>


</body>
</html>
