<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %><html lang="fr">
<!doctype html>
<head>
    <%@include file="bootstrapHeader.jsp"%>
    <%@include file="Menu.jsp"%>
    <title>Ajouter un match</title>
</head>
<body>


<main role="main" class="container">
    <div class="row">
        <div class="col-md-8">
            <h1 class="mb-3">Ajouter un match</h1>
            <form class="needs-validation" method="post" action="AjoutMatch" novalidate>
                <div class="form-group">
                    <label for="tournoi">Tournoi</label>
                    <select class="form-control" id="tournoi" name="tournoi" required>
                        <option value="" disabled selected hidden>Sélectionnez une épreuve</option>
                        <c:forEach var="tournoi" items="${tournois}">
                            <option value="${tournoi.getId()}">${tournoi.getNom()}</option>
                        </c:forEach>
                    </select>
                    <div class="invalid-feedback">
                        Veuillez sélectionner un tournoi.
                    </div>
                </div>
                <div class="form-group">
                    <label for="type">Type</label>
                    <select class="form-control" id="type" name="type" required>
                        <option value="" disabled selected hidden>Sélectionnez une épreuve</option>
                        <c:forEach var="type" items="${types}">
                            <option value="${type}">${type}</option>
                        </c:forEach>
                    </select>
                    <div class="invalid-feedback">
                        Veuillez sélectionner un type.
                    </div>
                </div>
                <div class="form-group">
                    <label for="annee">Type</label>
                    <select class="form-control" id="annee" name="annee" required>
                        <option value="" disabled selected hidden>Sélectionnez une épreuve</option>
                        <c:forEach var="annee" items="${annees}">
                            <option value="${annee}">${annee}</option>
                        </c:forEach>
                    </select>
                    <div class="invalid-feedback">
                        Veuillez sélectionner une année.
                    </div>
                </div>
                    <div class="form-group">
                        <label for="vainqueur">Vainqueur</label>
                        <select class="form-control" id="vainqueur" name="vainqueur" required>
                            <option value="" disabled selected hidden>Sélectionnez un vainqueur</option>
                            <c:forEach var="joueur" items="${joueurs}">
                                <option value="${joueur.getId()}">${joueur.getFullname()}</option>
                            </c:forEach>
                        </select>
                        <div class="invalid-feedback">
                            Veuillez sélectionner un vainqueur.
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="finaliste">Finaliste</label>
                        <select class="form-control" id="finaliste" name="finaliste" required>
                            <option value="" disabled selected hidden>Sélectionnez un finaliste</option>
                            <c:forEach var="joueur" items="${joueurs}">
                                <option value="${joueur.getId()}">${joueur.getFullname()}</option>
                            </c:forEach>
                        </select>
                        <div class="invalid-feedback">
                            Veuillez sélectionner un finaliste.
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