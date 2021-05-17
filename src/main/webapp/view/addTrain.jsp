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
<fmt:formatDate value="${bean.date}" pattern="dd-MM-yyyy"/>

<form class="style" action="add" name="train" method="POST">

    <p class="heading">Add new train</p>
    <p><input type="number" name="number" id="number" placeholder="number" value="${train.number}" maxlength="50" required autofocus pattern="^[^\s]+(\s.*)?$">
    <p><input type="availableSeats" name="availableSeats" id="availableSeats" placeholder="availableSeats" value="${train.availableSeats}" maxlength="50" required autofocus pattern="^[^\s]+(\s.*)?$">
    <p><input type="text" name="occurence" id="occurence" placeholder="occurence" value="${train.occurence}" maxlength="50" required autofocus pattern="^[^\s]+(\s.*)?$">


    <p><input type="date" name="firstDate" id="firstDate" placeholder="firstDate" value="${train.firstDate}" maxlength="50" required autofocus pattern="^[^\s]+(\s.*)?$">


    <c:forEach var="station" items="${train.stations}">${station},
    </c:forEach>')">
        <c:forEach var="station" items="${train.stations}" varStatus="loop">
            <input type="text" name="station" id="station" placeholder="station" value="${train.station}">
            <c:set value="add" var="add"/>
            <input type="submit" value="add station">
        <c:if test="${!loop.last}">,&nbsp;</c:if>
    </c:forEach>


    <p>
        <c:set value="add" var="add"/>
        <input type="submit" value="add">
    </p>
    <p class="heading"><a href="${pageContext.request.contextPath}/">Go back</a> </p>
</form>


</body>
</html>
