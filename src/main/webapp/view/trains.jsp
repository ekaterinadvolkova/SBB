
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Trains</title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<table class="style">
    <caption class="heading">SBB Trains</caption>
    <tr class="left-side">
        <th>ID</th>
        <th style="width: 100%">Number</th>
        <th style="width: 100%">Seats</th>
        <th>Occurence</th>
        <th> </th>
    </tr>

    <c:forEach var="train" items="${trainList}">
    <tr>
        <td class="left-side">${train.trainID}</td>
        <td class="title" class="left-side">${train.number}</td>
        <td class="title"class="left-side">${train.availableSeats}</td>
        <td class="right-side">${train.occurence} </td>
        <td class="right-side">
            <a href="edit/${train.trainID}">Edit</a>
            <a href="delete/${train.trainID}">Delete</a>
        </td>
    </tr>
    </c:forEach>
</table>
<table class="style">
    <tr><td><a href="add/">Add Train</a> </td></tr>
</table>
</body>
</html>
