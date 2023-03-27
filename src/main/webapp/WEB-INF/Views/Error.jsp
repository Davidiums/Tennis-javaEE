<%@ page import="beans.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="fr">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>

    <%@include file="bootstrapHeader.jsp" %>
    <title>Erreur 500</title>
    <%@include file="Menu.jsp" %>
</head>
<body>
<div class="exceptions"></div>
    <c:out value="${exception}"/>
</body>
<%@include file="ScriptFooter.jsp" %>
<script>
</script>