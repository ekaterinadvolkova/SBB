<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Swiss Federal Railways</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./res/frontend/css/bootstrap.min.css">
    <link rel="stylesheet" href="./res/frontend/css/bootstrap-icons.css">
    <link rel="stylesheet" href="./res/frontend/css/template.styles.css">
</head>
<body>

<nav class="navbar navbar-expand-sm navbar-dark bg-dark" aria-label="Third navbar example">
    <div class="container-fluid">
        <a class="navbar-brand" href="/SBB_war/">Swiss Federal Railways</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample03"
                aria-controls="navbarsExample03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarsExample03">
            <ul class="navbar-nav me-auto mb-2 mb-sm-0">
                <li class="nav-item">
                    <a class="nav-link" href="timetables/">Timetable</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="tickets/">Tickets</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="staff/">Staff</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<main>
    <div class="container">
        <div class="p-5 mb-4 bg-light rounded-3">
            <div class="container-fluid py-5">
                <h1 class="display-5 fw-bold mb-5">Welcome to Swiss Federal Railways!</h1>
                <section>
                    <h2 class="mb-3">Search for train</h2>
                    <form class="d-flex">
                        <input class="form-control me-2" type="search" placeholder="From, to, date, ...">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </section>
            </div>
        </div>

        <section>
            <h2>Trains</h2>
            <table class="table">
                <thead>
                <tr>
                    <th>Train Number</th>
                    <th>Direction</th>

                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="train" items="${trainList}">
                    <tr>
                        <td>${train.number}</td>
                        <td>${train.trainName}</td>

                        <td>
                            <div class="btn-group">
                                <a href="buy-ticket.html" type="button" class="btn btn-sm btn-outline-primary"
                                   title="Buy ticket">
                                    <i class="bi bi-bag"></i>
                                    Buy ticket
                                </a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </section>
    </div>

</main>
<script src="./res/frontend/js/inputmask.js"></script>
<script src="./res/frontend/js/bootstrap.bundle.min.js"></script>
<script src="./res/frontend/js/scripts.js"></script>

</body>
</html>