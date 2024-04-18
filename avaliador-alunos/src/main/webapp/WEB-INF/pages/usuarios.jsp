<%@ page
        contentType="text/html;charset=UTF-8"
        language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<html>
<head>
    <title>Usuarios</title>
</head>
<body>
    <h1>CADASTRO USUÁRIOS</h1>
    <table>
        <tr>Nome</tr>
        <tr>Email</tr>
        <tr>Ativo</tr>
<c:forEach var = "usuario" items="${UsuarioDAO.getusuario}">
    <tr>
        <td>${usuario.nome}</td>
        <td>${usuario.email}</td>
        <td>${usuario.ativo}</td>
    </tr>
</c:forEach>
    </table>
</body>
</html>
