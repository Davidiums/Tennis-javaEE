<%@ page import="beans.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="bootstrapHeader.jsp"%>
    <title>Gestions utilisateurs</title>
    <%@include file="Menu.jsp"%>
    <script>
        let login = '<%= ((User)session.getAttribute("user")).getLogin() %>';
    </script>

</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th scope="col" style="width:10%">#</th>
        <th scope="col" style="width:15%">Login</th>
        <th scope="col" style="width:10%">Mot de passe</th>
        <th scope="col" style="width:10%">Role</th>
        <th scope="col" style="width:20%"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="utilisateur" items="${utilisateurs}">
        <c:set var="roleText" value="${utilisateur.getProfil() == 1 ? 'Admin' : 'Utilisateur'}" />
        <tr>
            <th scope="row"><c:out value="${utilisateur.getId()}"/></th>
            <td><c:out value="${utilisateur.getLogin()}"/></td>
            <td>*********</td>
            <td><c:out value="${roleText}"/></td>
            <td>
                <button type="button" class="btn btn-outline-primary modify" data-id="<c:out value='${utilisateur.id}'/>">Modifier</button>
                <button type="button" class="btn btn-outline-warning delete" data-id="<c:out value='${utilisateur.id}'/>">Supprimer</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
    <button type="button" class="btn btn-outline-success" id="create">Créer</button>


</body>
</html>
<script><%@include file="../lib/utilisateurs/User.js"%></script>
<script><%@include file="../lib/utilisateurs/UserUpdate.js"%></script>
<script><%@include file="../lib/utilisateurs/UserDelete.js"%></script>
<script><%@include file="../lib/utilisateurs/UserCreate.js"%></script>

<%@include file="ScriptFooter.jsp"%>
