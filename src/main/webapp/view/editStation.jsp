
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <c:choose>
        <c:when test="${empty station.name}">
            <title>Add</title>
        </c:when>
        <c:otherwise>
            <title>Edit</title>
        </c:otherwise>
    </c:choose>
</head>
<body>

<c:url value="/staff/stations/add" var="add"/>
<c:url value="/staff/stations/edit" var="edit"/>

<form class="style" action="${(empty station.name) ? add : edit}" name="station" method="POST">
    <c:choose>
        <c:when test="${!empty station.name}">
            <p class="heading">Edit station</p>
            <input style="display: none" type="text" name="stationID" value="${station.stationID}">
        </c:when>
        <c:otherwise>
            <p class="heading">Add new station</p>
        </c:otherwise>
    </c:choose>
    <p><input type="text" name="name" id="name" placeholder="name" value="${station.name}" maxlength="50" required autofocus pattern="^[^\s]+(\s.*)?$">

    <p>
        <c:set value="add" var="add"/>
        <c:set value="edit" var="edit"/>
        <input type="submit" value="${(empty passenger.firstName && empty passenger.lastName && empty passenger.birthDate) ? add : edit}">
    </p>
    <p class="heading"><a href="${pageContext.request.contextPath}/">Go back</a> </p>
</form>


</body>
</html>
