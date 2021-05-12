<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title >Passengers </title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>

<fmt:formatDate value="${bean.date}" pattern="dd-MM-yyyy"/>
<table class="style">
    <caption class="heading">SBB Passengers</caption>
    <tr>
        <th class="left-side">ID</th>
        <th style="width: 100%" class="cental-side">First Name</th>
        <th style="width: 100%" class="cental-side">Last Name</th>
        <th>Birth Date</th>
        <th>Action</th>
    </tr>
    <c:forEach var="passenger" items="${passengerList}">
        <tr>
            <td class="left-side">${passenger.passengerID}</td>
            <td class="title" class="left-side">${passenger.firstName}</td>
            <td class="title"class="left-side">${passenger.lastName}</td>
            <td  type="date" class="left-side">${passenger.birthDate}</td>
            <td class="right-side">
                <a href="editPassenger/${passenger.passengerID}">Edit</a>
                <a href="deletePassenger/${passenger.passengerID}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<c:url value="/editPassenger" var="add"/>
<p class="heading"> <a href="${add}">Add Passenger</a> </p>
</body>
</html>