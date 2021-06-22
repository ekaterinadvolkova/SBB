<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login | SwissPass</title>
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
        <form:form class="style" id="loginForm" modelAttribute="login" action="${contextPath}/loginProcess"
                   method="post">
            <table align="center">


                <h1>Log in to SBB</h1>

                <h5>SwissPass is the key to mobility and leisure</h5>
                <tr>
                    <div class="mb-3">
                        <label class="form-label" value="${user.username}">Username</label>
                        <input type="text" value="${user.username}" class="form-control" path="username" id="username"
                               name="username"
                               placeholder="Type here ...">
                    </div>
                </tr>

                <tr>
                    <div class="mb-3">
                        <label class="form-label" value="${user.password}">Password</label>
                        <input type="password" value="${user.password}" class="form-control" path="password" id="password"
                               name="password"
                               placeholder="Type here ...">
                    </div>
                </tr>

                <tr>
                    <input type="checkbox" name="rememberMe">
                    <label> Keep me logged in</label>

                    <td align="left">
                        <form:form method="POST" modelAttribute="login" class="style">
                            <form:button class="btn btn-primary" type="submit"
                                         id="login" name="login">Login</form:button>
                        </form:form>

                    </td>

                </tr>

                <tr></tr>

            </table>
        </form:form>
        <table align="center">

            <tr>
                <td style="font-style: italic; color: red;">${message}</td>
            </tr>
        </table>

        <table align="center">

            <tr>
                <td><a href="${contextPath}/register">Create new SwissPass Login</a>
                </td>
            </tr>
            <tr>
                <td><a href="${contextPath}/">Forgotten your Password?</a>
                </td>
            </tr>
        </table>

    </div>
</main>

<script src="<%=request.getContextPath()%>/res/frontend/js/inputmask.js"></script>
<script src="<%=request.getContextPath()%>/res/frontend/js/bootstrap.bundle.min.js"></script>
<script src="<%=request.getContextPath()%>/res/frontend/js/scripts.js"></script>

</body>

</html>