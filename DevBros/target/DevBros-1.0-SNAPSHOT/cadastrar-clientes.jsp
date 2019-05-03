<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html>
	<head>
		<meta charset="UTF-8">
    <title>Cadastro de clientes</title>
    <link href = "cadastroClientes.css" rel = "stylesheet" type = "text/css"/>
	</head>

	<body>
        <header>
      <div class="titulo">
        <img class="logo" src="https://i.imgur.com/1ayr6NR.png">
        <h1>Noobies</h1>
      </div>
    </header>
  <center>
    <h1 class="h1">CADASTRO DE CLIENTES</h1>
    <hr>
    <div class="formulario">
      <div>
        <label>Nome: </label>
        <input class="nome" type="text" name="nome">
      </div>
      <br>
      <div>
        <label class = "cpf">CPF: </label>
        <input class = "cpf" type="text" name="cpf">
      </div>
      <br>
      <div>
        <label>Endereço: </label>
        <input class="endereco" type="text" name="address">
      </div>
      <br>
      <div>
        <label>Telefone: </label>
        <input class="telefone" type="text" name="fone">
      </div>
      <br>
      <div>
        <label>E-mail: </label>
        <input class="email" type="text" name="email">
      </div>
    </div>
      <button type="submit">CADASTRAR</button>
    </center>
	</body>
</html>
