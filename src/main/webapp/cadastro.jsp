<%@ page import="utils.ConexaoBancoDados" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="entities.Usuario" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Registro de Usuário</title>
    <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN' crossorigin='anonymous'>


</head>
<body>
<h2>Registro de Usuário</h2>

<form action="RegistroServlet" method="post" class="container row g-3">
    <div class="col-12">
        <label for="nome" class="form-label">Nome:</label>
        <input type="text" name="nome" id="nome" class="form-control" required><br>
    </div>

    <div class="col-12">
        <label for="cpf" class="form-label">CPF:</label>
        <input type="text" name="cpf" id="cpf" class="form-control" required><br>
    </div>

    <div class="col-md-6">
        <label for="email" class="form-label">Email:</label>
        <input type="text" name="email" id="email" class="form-control" required><br>
    </div>
    <div class="col-md-6">
        <label for="password" class="form-label">Senha:</label>
        <input type="password" name="password" id="password" class="form-control" required><br>
            <div id="passwordHelpBlock" class="form-text">
                A senha precisa ter entre 8 e 20 caracteres.
            </div>
    </div>
    <div class="col-12">
        <button type="submit" class="btn btn-primary">Registrar</button>
    </div>

</form>
</body>
</html>
