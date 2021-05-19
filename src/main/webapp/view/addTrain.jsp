<jsp:useBean id="timetableItemDTO" scope="request" class="com.javaschool.ev.dto.TimetableItemDTO"/>
<jsp:useBean id="trainDTO" scope="request" class="com.javaschool.ev.dto.TrainDTO"/>

<%@ page contentType="text/html;charset=UTF-8" %>
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


    <title>Add</title>

</head>
<body>
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
<c:url value="staff/trains/add" var="add"/>
<c:url value="staff/trains/edit" var="edit"/>

<c:set value="POST" var="POST"/>
<main>
    <div class="container pt-5">

        <form class="style" action="staff/trains/add" name="train" method="POST">

            <p><label for="trainID"></label><input type="number" name="trainID" id="trainID" value="${trainDTO.trainID}"
                                                   hidden>
            <p><label for="number"></label><input type="number" name="number" id="number" placeholder="number"
                                                  value="${trainDTO.number}">
            <p><label for="availableSeats"></label><input type="number" name="availableSeats"
                                                          id="availableSeats"
                                                          placeholder="availableSeats"
                                                          value="${trainDTO.availableSeats}">

            <div class="input-group mb-3">
                <label for="occurence">
                    <select name="occurence" class="form-select" id="occurence">
                        <option value="DAILY">every day</option>
                        <option value="WEEKLY">every week</option>
                        <option value="MONTHLY">every month</option>
                    </select>
                </label>
            </div>

            <div class="mb-3">
                <label for="departureDate" class="form-label">Departure Date</label>
                <div class="input-group mb-3">
                    <input type="text" value="${trainDTO.departureDate}" class="form-control" id="departureDate"
                           data-mask="99-99-9999" placeholder="dd-MM-yyyy" inputmode="date">
                    <span class="input-group-text"><i class="bi bi-calendar-date"></i></span>
                </div>
            </div>

            <p>Timetable</p>
            <div id="stations-container"></div>

            <template id="station-item">
                <div class="row mb-3">
                    <div class="col">
                        <label>
                            <input type="text" placeholder="Station" class="form-control"
                                   value="${timetableItemDTO.stationName}">
                        </label>
                    </div>

                    <div class="col">
                        <label class="input-group">
                            <input type="time" class="form-control" placeholder="HH-MM"
                                   value="${timetableItemDTO.departureTime}">
                        </label>
                    </div>
                </div>
            </template>

            <p>
                <button type="button" class="btn btn-info" id="add-station">Add station</button>
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