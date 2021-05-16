<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <title>Add train</title>

</head>
<body>
<c:url value="/staff/trains/add" var="add"/>

<c:set value="POST" var="POST"/>

<form class="style" action="add" name="train" method="POST">

    <p class="heading">Add new train</p>
    <p><input type="number" name="number" id="number" placeholder="number" value="${train.number}" maxlength="50" required autofocus pattern="^[^\s]+(\s.*)?$">
    <p><input type="availableSeats" name="availableSeats" id="availableSeats" placeholder="availableSeats" value="${train.availableSeats}" maxlength="50" required autofocus pattern="^[^\s]+(\s.*)?$">
    <p><input type="text" name="occurence" id="occurence" placeholder="occurence" value="${train.occurence}" maxlength="50" required autofocus pattern="^[^\s]+(\s.*)?$">

    <p>
        <c:set value="add" var="add"/>
        <input type="submit" value="add">
    </p>
    <p class="heading"><a href="${pageContext.request.contextPath}/">Go back</a> </p>
</form>


</body>
</html>
