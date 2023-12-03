<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gerenciamento de Fazendas</title>
    <link rel="stylesheet" href="./style/reset.css">
    <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN' crossorigin='anonymous'>
    <style>
        .hidden {
            display: none;
        }

        .nav-link {
            cursor: pointer;
        }
    </style>
</head>
<body class="container mx-auto p-xl-5">
<h1>Gerenciamento de Fazendas</h1>

<nav class="navbar container">
    <ul class="nav justify-content-center">
        <li class="nav-item"><button class="nav-link" onclick="mostrarConteudo('criarFazenda')">Criar Nova Fazenda</button></li>
        <li class="nav-item"><button class="nav-link" onclick="mostrarConteudo('listarFazendas')">Listar Fazendas</button></li>
        <li class="nav-item"><button class="nav-link" onclick="mostrarConteudo('buscarFazendaPorId')">Buscar Fazenda</button></li>
        <li class="nav-item"><button class="nav-link" onclick="mostrarConteudo('editarFazenda')">Editar Fazenda</button></li>
        <li class="nav-item"><button class="nav-link" onclick="mostrarConteudo('deletarFazenda')">Deletar Fazenda</button></li>
    </ul>
</nav>

<div id="criarFazenda" class="container">
    <h2>Criar Nova Fazenda</h2>
    <form action="CadastroFazendaServlet" method="post" class="container">
        <label for="nome" class="form-label">Nome:</label>
        <input type="text" id="nome" name="nome" class="form-control" required>

        <label for="areaTotal" class="form-label">Área Total:</label>
        <input type="number" id="areaTotal" name="areaTotal" class="form-control" required>

        <label for="logradouro" class="form-label">Logradouro:</label>
        <input type="text" id="logradouro" name="logradouro" class="form-control" required><br>

        <label for="numero" class="form-label">Número:</label>
        <input type="number" id="numero" name="numero" class="form-control" required><br>

        <label for="bairro" class="form-label">Bairro:</label>
        <input type="text" id="bairro" name="bairro" class="form-control" required><br>

        <label for="cidade" class="form-label">Cidade:</label>
        <input type="text" id="cidade" name="cidade" class="form-control" required><br>

        <button type="submit" value="Criar Fazenda" class="btn btn-primary">Criar Fazenda</button>
    </form>
</div>

<div id="listarFazendas" class="hidden">
    <h2>Listar Fazendas</h2>
    <!-- Formulário para chamar o ListarFazendasServlet -->
    <form action="ListarFazendasServlet" method="get">
        <button type="submit" class="btn btn-primary">Listar Todas as Fazendas</button>
    </form>
</div>

<div id="buscarFazendaPorId" class="hidden">
    <h2>Buscar Fazenda por ID</h2>
    <form action="BuscarFazendaPorIdServlet" method="get">
        <label for="idBuscar" class="form-label" class="form-label">ID da Fazenda:</label>
        <input type="number" name="idBuscar" id="idBuscar" class="form-control" required><br>

        <button type="submit" value="Buscar Fazenda" class="btn btn-primary">Buscar Fazenda</button>
    </form>
</div>

<div id="editarFazenda" class="hidden">
    <h2>Editar Fazenda</h2>
    <form action="EditarFazendaServlet" method="post">
        <label for="id" class="form-label">ID da Fazenda a Editar:</label>
        <input type="number" name="id" id="id"  class="form-control"required>

        <label for="novoNome" class="form-label">Novo Nome:</label>
        <input type="text" name="novoNome" id="novoNome" class="form-control" required>

        <label for="novaAreaTotal" class="form-label">Nova Área Total:</label>
        <input type="number" name="novaAreaTotal" id="novaAreaTotal" class="form-control" required><br>

        <button type="submit" value="Editar Fazenda" class="btn btn-primary">Editar Fazenda</button>
    </form>
</div>

<div id="deletarFazenda" class="hidden">
    <h2>Deletar Fazenda</h2>
    <form action="DeletarFazendaPorIdServlet" method="post">
        <label for="idDeletar" class="form-label">ID da Fazenda a Deletar:</label>
        <input type="number" name="idDeletar" id="idDeletar" class="form-control" required><br>

        <button type="submit" value="Deletar Fazenda" class="btn btn-primary">Deletar Fazenda</button>
    </form>
</div>

<script>
    function mostrarConteudo(conteudoId) {
        var conteudos = document.querySelectorAll('div');
        conteudos.forEach(function(conteudo) {
            conteudo.classList.add('hidden');
        });

        var conteudoAtivo = document.getElementById(conteudoId);
        if (conteudoAtivo) {
            conteudoAtivo.classList.remove('hidden');
        }
    }
</script>

</body>
</html>
