<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Passengers</title>
</head>
<body>

<h2>SBB Passengers</h2>

<h2><a href="${pageContext.request.contextPath}/editPassenger">Edit Passenger</a> </h2>

<table>
    <tr>
        <th>Passenger ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Birth Date</th>
    </tr>
    <c:forEach var="film" items="${passengerList}">
        <tr>
            <td>${passenger.passengerID}</td>
            <td>${passenger.firstName}</td>
            <td>${passenger.lastName}</td>
            <td>${passenger.birthDate}</td>
            <td>
                <a href="/editPassenger/${passenger.passengerID}">Edit</a>
                <a href="/deletePassenger/${passenger.passengerID}">Delete</a>
            </td>
        </tr>
    </c:forEach>

</table>

<h2>Add Passenger</h2>
<c:url value="/add" var="add"/>
<a href="${add}">Add new Passenger</a>

</body>
</html>