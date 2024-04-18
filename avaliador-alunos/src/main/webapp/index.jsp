<%@ page
        contentType="text/html;charset=UTF-8"
        language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<html>
<body>

<h2>LOGAR NO SISTEMA</h2>

<form action="login" method="post">
    <label for="email">
        <b>Login</b>
    </label>
    <input id="email" type="email" placeholder="email" name="email" required>
    </br>

    <label for="senha">
        <b>Senha</b>
    </label>
    <input id="senha" type="password" placeholder="senha" name="senha" required>
    </br>

    <input type="submit" value="LOGAR" name="login">
</form>

<c:if test="${not empty erro}">
    <h2>${erro} </h2>
</c:if>


</body>
</html>
