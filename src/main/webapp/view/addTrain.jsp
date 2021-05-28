<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

        <form class="style" action="${add}" name="trainDTO" object="${trainDTO}" method="POST">

            <h1>Add Train</h1>
            <p class="mt-5" action="staff/trains/add/" name="trainDTO" method="POST">


            <div class="mb-3">
                <label class="form-label" value="${trainDTO.number}">Train Number</label>
                <input class="form-control" id="number" name="number" var="trainDTO.number">
                <fmt:parseNumber var="number" type="number" value="${trainDTO.number}"/>
            </div>

            <p>
                <label for="availableSeats">
                    <input type="number" name="availableSeats" id="availableSeats" placeholder="seats"
                           var="${trainDTO.availableSeats}"/>
                    <fmt:parseNumber var="availableSeats" type="number" value="${trainDTO.availableSeats}"/>
                </label>
            </p>

            <div class="input-group mb-3">
                <label for="occurence">
                    <select name="occurence" class="form-select" id="occurence">
                        <option value="DAILY">every day</option>
                        <option value="WEEKLY">every week</option>
                        <option value="MONTHLY">every month</option>
                    </select>
                </label>
            </div>

            <%--            <div class="mb-3">--%>
            <%--                <label for="departureDate" class="form-label">Departure Date</label>--%>
            <%--                <div class="input-group mb-3">--%>
            <%--                    <input name="departureDate" type="date" value="${trainDTO.departureDate}"--%>
            <%--                           class="form-control" id="departureDate"--%>
            <%--                           data-mask="99-99-9999" placeholder="dd-MM-yyyy" inputmode="date"/>--%>
            <%--                    <span class="input-group-text"><i class="bi bi-calendar-date"></i></span>--%>
            <%--                </div>--%>
            <%--            </div>--%>

            <p>Timetable</p>
            <div id="stations-container"></div>
            <template id="station-item">
                <div class="row mb-3">

                    <div class="col">
                        <input type="text" name="stationName" placeholder="Station" class="form-control"
                               value="${trainDTO.timetable.add(timeTableItemDTO.stationName)}" id="stationName">

                    </div>

                    <div class="col">
                        <input type="time" placeholder="Station" class="form-control"
                               name="departureTime" id="departureTime"
                               value="${trainDTO.timetable.add(timeTableItemDTO.departureTime)}">
                    </div>

                </div>
            </template>

            <p>
                <button type="button" class="btn btn-info" id="add-station"> Add station</button>
            </p>


            <p>
                <button type="submit" class="btn btn-primary">Add Train</button>
            </p>
        </form>
    </div>
</main>


<script src="./res/frontend/js/inputmask.js"></script>
<script src="./res/frontend/js/bootstrap.bundle.min.js"></script>
<script src="./res/frontend/js/scripts.js"></script>

</body>
</html>
