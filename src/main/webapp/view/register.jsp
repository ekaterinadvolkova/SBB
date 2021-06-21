<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<html>

<head>
    <title>Registration</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <base href="../../">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/res/frontend/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/res/frontend/css/bootstrap-icons.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/res/frontend/css/template.styles.css">
</head>

<body>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark" aria-label="Third navbar example">
    <div class="container-fluid">
        <a class="navbar-brand" href="${contextPath}/welcomePage">Swiss Federal Railways</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample03"
                aria-controls="navbarsExample03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarsExample03">
            <ul class="navbar-nav me-auto mb-2 mb-sm-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="${contextPath}/welcomePage">Home</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/welcomePage/staff">Staff</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<main>
    <div class="container pt-5">
        <c:set var="contextPath" value="<%=request.getContextPath()%>"/>
        <form:form class="style" id="registerForm" modelAttribute="user" action="${contextPath}/registerProcess"
                   method="POST">

            <table align="center">
                <h1>Register in SBB</h1>
                <h5>Create SwissPass login</h5>
                <tr>
                    <td>
                        <form:label class="form-control" path="username">Username</form:label>
                    </td>
                    <td>
                        <form:input class="form-control" path="username" name="username" id="username"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label class="form-control" path="password">Password</form:label>
                    </td>
                    <td>
                        <form:password class="form-control" path="password" name="password" id="password"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label class="form-control" path="firstname">FirstName</form:label>
                    </td>
                    <td>
                        <form:input class="form-control" path="firstname" name="firstname" id="firstname"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label class="form-control" path="lastname">LastName</form:label>
                    </td>
                    <td>
                        <form:input class="form-control" path="lastname" name="lastname" id="lastname"/>
                    </td>
                </tr>

                <tr>
                    <td>
                        <form:label class="form-control" path="birthdate">Birthday</form:label>
                    </td>
                    <td>
                            <%--                <form:input path="birthdate" name="birthdate" id="birthdate"/>--%>
                        <fmt:formatDate value="${bean.date}" pattern="dd-MM-yyyy"/>
                        <input type="date" value="${user.birthdate}" class="form-control" id="birthdate"
                               name="birthdate">
                    </td>
                </tr>


                <tr>
                    <td></td>
                    <td>
                        <form:button id="register" class="btn btn-primary" name="register">Register</form:button>
                    </td>
                </tr>
                <tr></tr>

            </table>
        </form:form>
    </div>
</main>

<script src="<%=request.getContextPath()%>/res/frontend/js/inputmask.js"></script>
<script src="<%=request.getContextPath()%>/res/frontend/js/bootstrap.bundle.min.js"></script>
<script src="<%=request.getContextPath()%>/res/frontend/js/scripts.js"></script>

</body>

</html>
