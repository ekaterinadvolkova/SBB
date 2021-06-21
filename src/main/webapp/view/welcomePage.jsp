<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Swiss Federal Railways</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/res/frontend/css/bootstrap.min.css">
    <link rel="stylesheet" href="${contextPath}/res/frontend/css/bootstrap-icons.css">
    <link rel="stylesheet" href="${contextPath}/res/frontend/css/template.styles.css">
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
                    <a class="nav-link" href="${contextPath}/staff/">Staff</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<main>
    <form:form method="GET" name="welcomeForm" modelAttribute="welcome">
        <div class="container">
            <div class="p-5 mb-4 bg-light rounded-3">
                <div class="container-fluid py-5">
                    <h1 class="display-5 fw-bold mb-5">Welcome to Swiss Federal Railways!</h1>
                    <section>
                        <h2 class="mb-3">Select Station</h2>
                        <form class="d-flex">
                            <form:select path="selectedStation" onchange="this.form.submit()">
                                <form:options items="${welcome.stationNames}"/>
                            </form:select>

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
                        <th>Route</th>
                        <th>Departure Time</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:set var="userId" value="<%=request.getParameter(\"userId\")%>"/>

                    <c:forEach var="train" items="${welcome.trains}">
                        <tr>
                            <td>${train.number}</td>
                            <td>${train.trainName}</td>
                            <c:if test="${fn:length(train.timetable)>0}">
                                <td>${train.timetable.get(0).departureDateTime}</td>
                            </c:if>
                            <td>
                                <div class="btn-group">
                                    <a href="${contextPath}/tickets/${userId}/${train.trainId}" type="button"
                                       class="btn btn-sm btn-outline-primary"
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
    </form:form>

</main>
<script src="${contextPath}/res/frontend/js/inputmask.js"></script>
<script src="${contextPath}/res/frontend/js/bootstrap.bundle.min.js"></script>
<script src="${contextPath}/res/frontend/js/scripts.js"></script>

</body>
</html>
