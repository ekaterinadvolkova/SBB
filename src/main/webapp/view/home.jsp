<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>

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
          <a class="nav-link" href="login">Sign in</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="register">Register</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
<main>
  <div class="container">
    <div class="p-5 mb-4 bg-light rounded-3">
      <div class="container-fluid py-5">
        <h1 class="display-5 fw-bold mb-5">Welcome to SBB!</h1>
        <h3 class="display-5 mb-5">Sign in</h3>

        <p>
          Tip: Logging in makes buying tickets and travelcards much quicker because your details
          are already stored.
        </p>

      </div>
      <tr>
        <td colspan="5">
          <a href="login" class="btn btn-outline-primary">Private Customer</a>
        </td>
      </tr>
      <td colspan="5">
        <a href="login" class="btn btn-outline-primary">Business Customer</a>
      </td>
    </div>

    <table align="center">
      <tr>
        <td><a href="register">Create new SwissPass Login</a>
        </td>
      </tr>
      <tr>
        <td><a href="login">Forgotten your Password?</a>
        </td>
      </tr>
    </table>

</main>
<script src="./res/frontend/js/inputmask.js"></script>
<script src="./res/frontend/js/bootstrap.bundle.min.js"></script>
<script src="./res/frontend/js/scripts.js"></script>
</body>

</html>

