<%@ page import="beans.User" %>
<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="fr">
<head>
    <%@include file="bootstrapHeader.jsp" %>
    <title>Liste joueurs</title>
    <jsp:include page="Menu.jsp">
        <jsp:param name="searchServlet" value="ListJoueur"/>
    </jsp:include>
</head>
<body>

<main role="main" class="container">

    <div class="starter-template">
        <h1>Liste des joueurs</h1>
        <p class="lead">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
            labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
            aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum
            dolore eu fugiat nulla pariatur.</p>
    </div>

</main><!-- /.container -->
<div class="container">

    <div style="    padding: 1.5rem;    margin-right: 0;    margin-left: 0;    border-width: .2rem;">
        <a href="AjouterJoueur" class="btn btn-primary">Ajouter joueur</a>
    </div>
    <form action="ListJoueur" method="get">
        <div class="form-group">
            <label for="search">Rechercher:</label>
            <input type="text" class="form-control" id="search" name="search"
                   placeholder="Entrez un nom, un prénom ou un ID">
        </div>
        <button type="submit" class="btn btn-primary">Rechercher</button>
    </form>

    <form action="ListJoueur" method="post" id="myForm">
        <div style="padding: 1.5rem; margin-right: 0; margin-left: 0; border-width: .2rem">
            <input type="radio" id="hommes" name="sexe" value="H" ${HommesChecked}>
            <label for="hommes">Hommes</label>

            <input type="radio" id="femmes" name="sexe" value="F" ${FemmesChecked}>
            <label for="femmes">Femmes</label>

            <input type="radio" id="lesdeux" name="sexe" value="T" ${LesDeuxChecked}>
            <label for="lesdeux">Les deux</label>
        </div>
    </form>
    <table class="table">
        <thead>
        <tr>
            <th scope="col" style="width:10%">#</th>
            <th scope="col" style="width:25%">Nom</th>
            <th scope="col" style="width:20%">Prenom</th>
            <th scope="col" style="width:20%">Sexe</th>
            <th scope="col" style="width:20%"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="joueur" items="${joueurs}">
            <tr>
                <th scope="row"><c:out value="${joueur.getId()}"/></th>
                <td><c:out value="${joueur.getNom()}"/></td>
                <td><c:out value="${joueur.getPrenom()}"/></td>
                <td><c:out value="${joueur.getSexe()}"/></td>
                <td>
                    <c:if test="${not empty sessionScope.user and sessionScope.user.getProfil() == 1}">
                        <button type="button" class="btn btn-outline-primary modify"
                                data-id="<c:out value='${joueur.id}'/>">Modifier
                        </button>
                        <button type="button" class="btn btn-outline-warning delete"
                                data-id="<c:out value='${joueur.id}'/>">Supprimer
                        </button>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


<script src="https://code.jquery.com/jquery-3.6.2.min.js"></script>
<%@include file="ScriptFooter.jsp" %>
<script>
    <%@include file="../lib/players/joueursActionListener.js" %>
</script>
<script>
    var login = '<%= ((User)session.getAttribute("user")).getLogin() %>';
</script>

<script>
    <%@include file="../lib/players/DeletPlayer.js" %>
</script>
<script>
    <%@include file="../lib/players/ModifyPlayer.js" %>
</script>
</body>
</html>


