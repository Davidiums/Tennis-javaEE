<%@ page import="beans.User" %>
<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="fr">
<head>
    <!-- Required meta tags -->
    <%--    <meta charset="utf-8">--%>
    <%--    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">--%>

    <!-- Bootstrap CSS -->
    <%@include file="bootstrapHeader.jsp" %>
    <title>Liste épreuve</title>
    <jsp:include page="Menu.jsp">
        <jsp:param name="searchServlet" value="Epreuves" />
    </jsp:include>
</head>
<body>

<main role="main" class="container">

    <div class="starter-template">
        <h1>Liste des épreuves</h1>
        <p class="lead">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
            labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
            aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum
            dolore eu fugiat nulla pariatur.</p>
    </div>

</main><!-- /.container -->
<div class="container">

    <div style="    padding: 1.5rem;    margin-right: 0;    margin-left: 0;    border-width: .2rem;">
        <a href="AjouterEpreuve" class="btn btn-primary">Ajouter Epreuve</a>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col" style="width:10%">#</th>
            <th scope="col" style="width:25%">Tournois</th>
            <th scope="col" style="width:20%">Année</th>
            <th scope="col" style="width:20%">Type</th>
            <th scope="col" style="width:20%"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="epreuve" items="${epreuves}">
            <tr>
                <th scope="row"><c:out value="${epreuve.getId()}"/></th>
                <td><c:out value="${epreuve.getTournoi().getNom()}"/></td>
                <td><c:out value="${epreuve.getAnnee()}"/></td>
                <td><c:out value="${epreuve.getType()}"/></td>
<%--                <td>--%>
<%--                    <c:if test="${not empty sessionScope.user and sessionScope.user.getProfil() == 1}">--%>
<%--                        <button type="button" class="btn btn-outline-primary modify" data-id="<c:out value='${joueur.id}'/>">Modifier--%>
<%--                        </button>--%>
<%--                        <button type="button" class="btn btn-outline-warning delete" data-id="<c:out value='${joueur.id}'/>">Supprimer--%>
<%--                        </button>--%>
<%--                    </c:if>--%>
<%--                </td>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


<script src="https://code.jquery.com/jquery-3.6.2.min.js"></script>
<%@include file="ScriptFooter.jsp" %>
</body>
</html>


