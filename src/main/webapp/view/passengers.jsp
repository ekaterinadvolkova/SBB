<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Passengers Data STAFF ONLY </title>
</head>
<body>
<h2>SBB Passengers</h2>
<h2><a href="${pageContext.request.contextPath}/editPassenger">Edit or Add Passenger</a> </h2>
<table>
    <tr>
        <th>Passenger ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Birth Date</th>
        <th>Action</th>
    </tr>
    <c:forEach var="passenger" items="${passengerList}">
        <tr>
            <td>${passenger.passengerID}</td>
            <td>${passenger.firstName}</td>
            <td>${passenger.lastName}</td>
            <td>${passenger.birthDate}</td>
            <td>
                <a href="editPassenger/${passenger.passengerID}">Edit</a>
                <a href="deletePassenger/${passenger.passengerID}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<c:url value="/editPassenger" var="add"/>
<a href="${add}">Add new Passenger</a>
</body>
</html>