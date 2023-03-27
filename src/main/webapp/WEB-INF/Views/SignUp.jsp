<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %><html lang="fr">
<html lang="fr">
<head>
    <!-- Required meta tags -->
<%--    <meta charset="utf-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">--%>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >
    <link rel="stylesheet" type ="text/css" href="../signin.css">

    <title>Inscription</title>
</head>
<body style="background-color:#000000 ;">
<form class="form-signin" method="post" action="SignUp" >
    <img class="mb-4" src="../logo.png" alt="">
    <h1 class="h3 mb-3 font-weight-normal" style="color:#FFF;">Please sign up</h1>
    <label for="inputEmail" class="sr-only" >Email address</label>
    <input type="email" id="inputEmail" name="txtLogin" class="form-control" placeholder="Addresse mail" required autofocus>
    <label for="inputPassword" class="sr-only" >Password</label>
    <input type="password" id="inputPassword" name="txtPassword" class="form-control" placeholder="Mot de passe" required>
    <label for="inputConfirmPassword" class="sr-only" >Confirm password</label>
    <input type="password" id="inputConfirmPassword" name="txtConfirmPassword" class="form-control" placeholder="Mot de passe" required>
    <div class="checkbox mb-3" style="color:#FFF ;">

        <button class="btn btn-lg btn-primary btn-block" style="background-color:#ff750b; border-color:#FFF;" type="submit">Sign in</button>
    </div>
</form>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<%@include file="ScriptFooter.jsp"%>
</body>
</html>

