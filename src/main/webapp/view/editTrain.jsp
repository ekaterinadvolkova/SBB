
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <c:choose>
        <c:when test="${empty train.number && empty train.availableSeats && empty train.bookedSeats && empty train.occurence}">
            <title>Add</title>
        </c:when>
        <c:otherwise>
            <title>Edit</title>
        </c:otherwise>
    </c:choose>
</head>
<body>
<c:url value="/staff/trains/add" var="add"/>
<c:url value="/staff/trains/edit" var="edit"/>

<c:set value="POST" var="POST"/>
<c:set value="PUT" var="PUT"/>
<form class="style" action="${(empty train.trainID) ? add : edit}" name="train" method="POST">

    <c:choose>
        <c:when test="${!empty train.number && !empty train.availableSeats && !empty train.occurence}">
            <p class="heading">Edit train</p>

        </c:when>
        <c:otherwise>
            <p class="heading">Add new train</p>
        </c:otherwise>
    </c:choose>
    <p><input type="number" name="trainID" id="trainID"  value="${train.trainID}" disabled>
    <p><input type="number" name="number" id="number" placeholder="number" value="${train.number}" maxlength="50" required autofocus pattern="^[^\s]+(\s.*)?$">
    <p><input type="availableSeats" name="availableSeats" id="availableSeats" placeholder="availableSeats" value="${train.availableSeats}" maxlength="50" required autofocus pattern="^[^\s]+(\s.*)?$">
    <p><input type="text" name="occurence" id="occurence" placeholder="occurence" value="${train.occurence}" maxlength="50" required autofocus pattern="^[^\s]+(\s.*)?$">

    <p>
        <c:set value="add" var="add"/>
        <c:set value="edit" var="edit"/>
        <input type="submit" value="${(empty train.trainID) ? add : edit}">
    </p>
    <p class="heading"><a href="${pageContext.request.contextPath}/">Go back</a> </p>
</form>


</body>
</html>
