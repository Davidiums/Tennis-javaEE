<%@ page import="beans.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="fr">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>

    <%@include file="bootstrapHeader.jsp" %>
    <title>Tournois</title>
    <jsp:include page="Menu.jsp">
        <jsp:param name="searchServlet" value="Matchs" />
    </jsp:include>
</head>
<body>


<main role="main" class="container">

    <div class="starter-template">
        <h1>Liste des matchs</h1>

    </div>
<%--    <label for="annee">Année</label>--%>
<%--    <select id="annee">--%>
<%--        <c:forEach var="annee" items="${listeAnnee}">--%>
<%--            <option value="${escapeHtml(annee)}">${escapeHtml(annee)}</option>--%>
<%--        </c:forEach>--%>
<%--    </select>--%>


        <table class="table">
            <thead>
            <tr>
                <th scope="col" style="width:5%">#Match</th>
                <th scope="col" style="width:15%">Tournois</th>
                <th scope="col" style="width:15%">Vainqueur</th>
                <th scope="col" style="width:15%">Finaliste</th>
                <th scope="col" style="width:5%">Type</th>
                <th scope="col" style="width:5%">#Epreuve</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="match" items="${matchs}">
                <tr>
                    <th scope="row"><c:out value="${match.getId()}"/></th>
                    <td><c:out value="${match.getEpreuve().getTournoi().getNom()} ${match.getEpreuve().getAnnee()} "/></td>
                    <td><c:out value="${match.getVainqueur().getFullname()}"/></td>
                    <td><c:out value="${match.getFinaliste().getFullname()}"/></td>
                    <td><c:out value="${match.getEpreuve().getType()}"/></td>
                    <td><c:out value="${match.getEpreuve().getId()}"/></td>
                    <td>
<%--                        <c:if test="${not empty sessionScope.user and sessionScope.user.getProfil() == 1}">--%>
<%--                            <button type="button" class="btn btn-outline-warning delete" data-id="<c:out value='${match.getId()}'/>">Supprimer--%>
<%--                            </button>--%>
<%--                        </c:if>--%>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
</main>
</body>
<%@include file="ScriptFooter.jsp" %>

<c:if test="${not empty sessionScope.user and sessionScope.user.getProfil() == 1}">
<script>
    let login = '<%= ((User)session.getAttribute("user")).getLogin() %>';
</script>
<script>
    <%@include file="../lib/Matchs/ModifyMatch.js" %>
</script>
<script>
    <%@include file="../lib/Matchs/DeleteMatch.js" %>
</script>
<script>
    <%@include file="../lib/Matchs/MatchJS.js" %>
</script>
</c:if>
