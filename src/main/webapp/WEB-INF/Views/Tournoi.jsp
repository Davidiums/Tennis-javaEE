<%@ page import="beans.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="fr">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <%@include file="bootstrapHeader.jsp" %>
    <jsp:include page="Menu.jsp">
        <jsp:param name="searchServlet" value="Tournois" />
    </jsp:include>
    <title>Tournois</title>
</head>
<body>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col" style="width:10%">#</th>
            <th scope="col" style="width:25%">Nom</th>
            <th scope="col" style="width:10%">Code</th>
            <th scope="col" style="width:30%"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="tournoi" items="${tournois}">
            <tr>
                <th scope="row"><c:out value="${tournoi.getId()}"/></th>
                <td><c:out value="${tournoi.getNom()}"/></td>
                <td><c:out value="${tournoi.getCode()}"/></td>
                <td>
                    <c:if test="${not empty sessionScope.user and sessionScope.user.getProfil() == 1}">
                        <button type="button" class="btn btn-outline-primary modify"
                                data-id="<c:out value='${tournoi.id}'/>">Modifier
                        </button>
                        <button type="button" class="btn btn-outline-warning delete"
                                data-id="<c:out value='${tournoi.id}'/>">Supprimer
                        </button>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<%@include file="ScriptFooter.jsp" %>
<c:if test="${not empty sessionScope.user and sessionScope.user.getProfil() == 1}">
    <script>
        let login = '<%= ((User)session.getAttribute("user")).getLogin() %>';
    </script>
    <script>
        <%@include file="../lib/tournois/ModifyTournoi.js" %>
    </script>
    <script>
        <%@include file="../lib/tournois/DeleteTournoi.js" %>
    </script>
    <script>
        <%@include file="../lib/tournois/TournoiJS.js" %>
    </script>
</c:if>

</html>
