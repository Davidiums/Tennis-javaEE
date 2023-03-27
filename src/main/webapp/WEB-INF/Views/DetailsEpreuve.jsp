<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Détails de l'épreuve</title>
</head>
<body>
<h1>Détails de l'épreuve</h1>
<table>
    <tr>
        <td>Id :</td>
        <td><c:out value="${epreuve.id}" /></td>
    </tr>
    <tr>
        <td>Année :</td>
        <td><c:out value="${epreuve.annee}" /></td>
    </tr>
    <tr>
        <td>Type :</td>
        <td><c:out value="${epreuve.typeEpreuve}" /></td>
    </tr>
    <tr>
        <td>Tournoi :</td>
        <td>
            <label>
                <select name="tournoiId">
                    <c:forEach items="${tournois}" var="tournoi">
                        <option value="${tournoi.id}">${tournoi.nom}</option>
                    </c:forEach>
                </select>
            </label>
        </td>
    </tr>
</table>
<form:form method="post" action="supprimerEpreuve">
    <input type="hidden" name="id" value="${epreuve.id}" />
    <input type="submit" value="Supprimer" />
</form:form>
<form:form method="get" action="modifierEpreuve">
    <input type="hidden" name="id" value="${epreuve.id}" />
    <input type="submit" value="Modifier" />
</form:form>
</body>
</html>