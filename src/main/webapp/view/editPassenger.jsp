<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <c:choose>
        <c:when test="${empty passenger.firstName && empty passenger.lastName && empty passenger.birthDate}">
            <title>Add</title>
        </c:when>
        <c:otherwise>
            <title>Edit</title>
        </c:otherwise>
    </c:choose>
</head>
<body>

<c:url value="/staff/passengers/add" var="add"/>
<c:url value="/staff/passengers/edit" var="edit"/>

<form class="style" action="${(empty passenger.firstName && empty passenger.lastName && empty passenger.birthDate) ? add : edit}" name="passenger" method="POST">
    <c:choose>
    <c:when test="${!empty passenger.firstName && !empty passenger.lastName && !empty passenger.birthDate}">
    <p class="heading">Edit passenger</p>
    <input type="hidden" name="id" value="${passenger.passengerID}">
    </c:when>
    <c:otherwise>
    <p class="heading">Add new passenger</p>
    </c:otherwise>
    </c:choose>
    <p><input type="text" name="firstName" id="firstName" placeholder="firstName" value="${passenger.firstName}" maxlength="50" required autofocus pattern="^[^\s]+(\s.*)?$">
    <p><input type="text" name="lastName" id="lastName" placeholder="lastName" value="${passenger.lastName}" maxlength="50" required autofocus pattern="^[^\s]+(\s.*)?$">
    <fmt:formatDate value="${bean.date}" pattern="dd-MM-yyyy"/>
    <p><input class ="input" type="date" name="birthDate" id="birthDate" placeholder="birthDate" value="${passenger.birthDate}" maxlength="50" required autofocus pattern="^[^\s]+(\s.*)?$">
    <p>
        <c:set value="add" var="add"/>
        <c:set value="editPassenger" var="edit"/>
        <input type="submit" value="${(empty passenger.firstName && empty passenger.lastName && empty passenger.birthDate) ? add : edit}">
    </p>
    <p class="heading"><a href="${pageContext.request.contextPath}/">Go back</a> </p>
</form>
</body>
</html>
