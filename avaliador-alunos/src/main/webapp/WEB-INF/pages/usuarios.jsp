<%@ page
        contentType="text/html;charset=UTF-8"
        language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<jsp:useBean id="dao" class="br.csi.dao.UsuarioDAO"/>

<html>
<head>
    <title>Usuarios</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <h1>CADASTRO USUÁRIOS</h1>

    <form method="post" action="usuarios">
        <label for="nome">Nome: </label>
        <input type="text" name="nome" id="nome" value="123">
        <br>
        <label for="email">Email: </label>
        <input type="email" name="email" id="email" value="123@456">
        <br>
        <label for="senha">Senha: </label>
        <input type="password" name="senha" id="senha" value="123">

        <button type="submit">Enviar</button>
    </form>

    <table>
        <th>Nome</th>
        <th>Email</th>
        <th>Ativo</th>
        <c:forEach var = "usuario" items="${dao.usuarios}">
            <tr>
                <td>${usuario.nome}</td>
                <td>${usuario.email}</td>
                <td>${usuario.ativo}</td>
            </tr>
        </c:forEach>
    </table>


</body>
</html>
