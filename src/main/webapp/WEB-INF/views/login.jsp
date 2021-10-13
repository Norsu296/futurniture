<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>Futurniture - logowanie</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@400;700&display=swap" rel="stylesheet">

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>


    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/login.css" />
</head>
<body class="text-center">
<main class="form-signin" >
    <form method="post" action="/login">
        <h1 class="h3 mb-3 fw-normal">Zaloguj się</h1>
        <div class="mb-4 text-danger">
            <c:if test="${SPRING_SECURITY_LAST_EXCEPTION.message == 'Bad credentials'}">Błędny login lub hasło</c:if>
        </div>

        <div class="form-floating">
            <input type="text" class="form-control" name="username" id="floatingInput" placeholder="Wprowadź login">
            <label for="floatingInput">Login</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" name="password" id="floatingPassword" placeholder="Wprowadź hasło">
            <label for="floatingPassword">Hasło</label>
        </div>

        <button class="w-100 btn btn-lg btn-primary" type="submit">Zaloguj</button>
        <p class="mt-5 mb-3 text-muted">&copy; 2021</p>
    </form>
</main>



</body>
</html>
