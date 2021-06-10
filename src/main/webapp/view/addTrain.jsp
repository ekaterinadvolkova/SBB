<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Swiss Federal Railways</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <base href="../../">
    <link rel="stylesheet" href="./res/frontend/css/bootstrap.min.css">
    <link rel="stylesheet" href="./res/frontend/css/bootstrap-icons.css">
    <link rel="stylesheet" href="./res/frontend/css/template.styles.css">
</head>
<body>
<c:url value="/staff/stations/edit" var="edit"/>
<c:set value="POST" var="POST"/>

<nav class="navbar navbar-expand-sm navbar-dark bg-dark" aria-label="Third navbar example">
    <div class="container-fluid">
        <a class="navbar-brand" href="./">Swiss Federal Railways</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample03"
                aria-controls="navbarsExample03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarsExample03">
            <ul class="navbar-nav me-auto mb-2 mb-sm-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="./">Home</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="staff/">Staff</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<main>

    <div class="container pt-5">
        <%--@elvariable id="train" type="java"--%>
        <form:form method="POST" modelAttribute="train" class="style">
            <h3>Add Train</h3>
            <p class="mt-5" action="staff/trains/add/" name="train" method="POST">

            <div class="mb-3">
                <label class="form-label" value="${train.number}">Train Number</label>
                <fmt:formatNumber value="${train.number}" var="formattedTrainNumber"/>
                <form:input path="number" class="form-control" id="trainNumber" name="trainNumber"
                            var="${formattedTrainNumber}"/>
            </div>

            <p>
                <label for="availableSeats">
                    <fmt:formatNumber value="${train.availableSeats}" var="formattedAvailableSeats"/>
                    <form:input path="availableSeats" type="number" name="availableSeats" id="availableSeats"
                                placeholder="seats"
                                var="${formattedAvailableSeats}"/>
                </label>
            </p>

            <section class="pt-5 flex-fill container-fluid">
                <h4>Timetable</h4>

                <table class="table">
                    <thead>
                    <tr>
                        <th>Station Name</th>
                        <th>Departure Time</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach var="timeTableItem" items="${train.timetable}" varStatus="loop">
                        <tr>
                            <td>
                                <form:input path="timetable[${loop.index}].stationName"
                                            value="${timeTableItem.stationName}"/>
                            </td>
                            <td>
                                <form:input path="timetable[${loop.index}].departureDateTime"
                                            value="${timeTableItem.departureDateTime}"/>
                                    <%--                                <fmt:parseDate value="${timeTableItem.departureTime}" pattern="yyyy-MM-dd KK:mm" var="localDepartureDateTime"/>--%>
                            </td>
                            <td>
                                <div class="btn-group">
                                        <%--                                    <a href="staff/trains/edit/${train.trainId}" type="button"--%>
                                    <a href="staff/trains/" type="button"
                                       class="btn btn-sm btn-outline-secondary" title="Edit">
                                        <i class="bi bi-pencil"></i>
                                    </a>
                                        <%--                                    <a href="staff/train/delete/${train.trainId}" type="button"--%>
                                    <a href="staff/trains/" type="button"
                                       class="btn btn-sm btn-outline-danger" title="Delete">
                                        <i class="bi bi-trash"></i>
                                    </a>


                                </div>
                            </td>
                        </tr>
                    </c:forEach>


                    </tbody>

                    <tfoot>
                        <%--
                                            <tr>
                                                <td colspan="5">
                                                    <a href="staff/trains/addTimetableItem" class="btn btn-outline-primary">Add Timetable Item</a>
                                                </td>
                                            </tr>
                        --%>
                    <%! %>

                        <%--@elvariable id="train" type="java"--%>
                    <form:form method="POST" modelAttribute="train" class="style">
                        <form:button type="submit" class="btn btn-primary"
                                     name="addTimetableItem">Add Timetable Item</form:button>
                    </form:form>
                    </tfoot>
                </table>
            </section>
            <p>
                <form:button type="submit" class="btn btn-primary" name="addTrain">Add Train</form:button>
            </p>
        </form:form>
    </div>
</main>

<script src="./res/frontend/js/inputmask.js"></script>
<script src="./res/frontend/js/bootstrap.bundle.min.js"></script>
<script src="./res/frontend/js/scripts.js"></script>

</body>
</html>
