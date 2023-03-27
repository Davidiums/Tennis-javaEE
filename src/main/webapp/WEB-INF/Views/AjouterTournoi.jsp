<%@ page language="java" contentType="text/html; charset=UTF-8" %><html lang="fr">
<!doctype html>
<html lang="fr">
<head>
    <%@include file="bootstrapHeader.jsp"%>
    <%@include file="Menu.jsp"%>
    <title>Ajouter un tournoi</title>
</head>
<body>


<main role="main" class="container">
    <div class="row">
        <div class="col-md-8">
            <h1 class="mb-3">Ajouter un tournoi</h1>
            <form class="needs-validation" method="post" action="AjoutTournoi" novalidate>
                <div class="mb-3">
                    <label for="nom">Nom</label>
                    <input type="text" class="form-control" id="nom" name="txtnom" maxlength="20" required>
                    <div class="invalid-feedback">
                        Veuillez saisir un nom de tournoi valide (20 caractères maximum).
                    </div>
                </div>
                <div class="mb-3">
                    <label for="code">Code</label>
                    <input type="text" class="form-control" id="code" name="txtcode" maxlength="2" required>
                    <div class="invalid-feedback">
                        Veuillez saisir un code de tournoi valide (2 caractères maximum).
                    </div>
                </div>
                <hr class="mb-4">
                <button class="btn btn-primary btn-lg btn-block" type="submit">Ajouter</button>
            </form>
        </div>
    </div>
</main>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<%@include file="ScriptFooter.jsp"%>
</body>
</html>
