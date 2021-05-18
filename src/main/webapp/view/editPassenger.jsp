<%--<%@ page contentType="text/html; charset=UTF-8" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%--<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>--%>
<%--    <c:choose>--%>
<%--        <c:when test="${empty passenger.passengerID}">--%>
<%--            <title>Add</title>--%>
<%--        </c:when>--%>
<%--        <c:otherwise>--%>
<%--            <title>Edit</title>--%>
<%--        </c:otherwise>--%>
<%--    </c:choose>--%>
<%--</head>--%>
<%--<body>--%>



<%--<form class="style" action="${(empty passenger.passengerID) ? add : edit}" name="passenger" method="POST">--%>
<%--    <c:choose>--%>
<%--    <c:when test="${!empty passenger.passengerID}">--%>
<%--    <p class="heading">Edit passenger</p>--%>
<%--        <p><input type="hidden" name="passengerID" id="passengerID"  value="${passenger.passengerID}" >--%>
<%--    </c:when>--%>
<%--    <c:otherwise>--%>
<%--    <p class="heading">Add new passenger</p>--%>
<%--    </c:otherwise>--%>
<%--    </c:choose>--%>

<%--    <p><input type="text" name="firstName" id="firstName" placeholder="firstName" value="${passenger.firstName}" maxlength="50" required autofocus pattern="^[^\s]+(\s.*)?$">--%>
<%--    <p><input type="text" name="lastName" id="lastName" placeholder="lastName" value="${passenger.lastName}" maxlength="50" required autofocus pattern="^[^\s]+(\s.*)?$">--%>
<%--    <fmt:formatDate value="${bean.date}" pattern="dd-MM-yyyy"/>--%>
<%--    <p><input class ="input" type="date" name="birthDate" id="birthDate" placeholder="birthDate" value="${passenger.birthDate}" maxlength="50" required autofocus pattern="^[^\s]+(\s.*)?$">--%>
<%--    <p>--%>
<%--        <c:set value="add" var="add"/>--%>
<%--        <c:set value="editPassenger" var="edit"/>--%>
<%--        <input type="submit" value="${(empty passenger.firstName && empty passenger.lastName && empty passenger.birthDate) ? add : edit}">--%>
<%--    </p>--%>
<%--    <p class="heading"><a href="${pageContext.request.contextPath}/">Go back</a> </p>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Swiss Federal Railways</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <base href="../">
    <link rel="stylesheet" href="./res/frontend/css/bootstrap.min.css">
    <link rel="stylesheet" href="./res/frontend/css/bootstrap-icons.css">
    <link rel="stylesheet" href="./res/frontend/css/template.styles.css">


        <c:choose>--%>
            <c:when test="${empty passenger.passengerID}">
                <title>Add</title>
            </c:when>
            <c:otherwise>
                <title>Edit</title>
            </c:otherwise>
        </c:choose>
</head>
<body>

<nav class="navbar navbar-expand-sm navbar-dark bg-dark" aria-label="Third navbar example">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.html">Swiss Federal Railways</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample03" aria-controls="navbarsExample03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarsExample03">
            <ul class="navbar-nav me-auto mb-2 mb-sm-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="index.html">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="timetable.html">Timetable</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="staff.html">Staff</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<main>
    <div class="d-flex flex-row-reverse">
        <section class="pt-5 flex-fill container-fluid">
            <h2>Stations</h2>

            <table class="table">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Station Name</th>
                    <th>Action</th>
                </tr>
                </thead>

                <tbody>

                <c:forEach var="station" items="${stationList}">

                    <tr>
                        <td>${station.stationID}</td>
                        <td>${station.name}</td>
                        <td>
                            <div class="btn-group">
                                <a href="staff/stations/edit/${station.stationID}" type="button" class="btn btn-sm btn-outline-secondary" title="Edit">
                                    <i class="bi bi-pencil"></i>
                                </a>
                                <a href="staff/stations/delete/${station.stationID}" type="button" class="btn btn-sm btn-outline-danger" title="Delete">
                                    <i class="bi bi-trash"></i>
                                </a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>


                </tbody>

                <tfoot>
                <tr>
                    <td colspan="5">
                        <a href="staff/stations/add" class="btn btn-outline-primary">Add Station</a>
                    </td>
                </tr>
                </tfoot>
            </table>
        </section>

        <div class="d-flex flex-column flex-shrink-0 p-3 bg-light" style="width: 280px;">
            <a href="staff/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
                <span class="fs-4">Staff page</span>
            </a>
            <hr>
            <ul class="nav nav-pills flex-column mb-auto">

                <li>
                    <a href="staff/" class="nav-link active">
                        View stations
                    </a>
                </li>

                <li class="nav-item">
                    <a href="staff/trains/" class="nav-link ">
                        View trains
                    </a>
                </li>

                <li class="nav-item">
                    <a href="staff/passengers/" class="nav-link ">
                        View passengers
                    </a>
                </li>

            </ul>
        </div>
    </div>
</main>
<script src="./res/frontend/js/inputmask.js"></script>
<script src="./res/frontend/js/bootstrap.bundle.min.js"></script>
<script src="./res/frontend/js/scripts.js"></script>

</body></html>


