<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Consulta de clientes</title>
  <link href = "consultarClientes.css" rel = "stylesheet" type = "text/css"/>
</head>

<body>
  <div id="menu">
    <header>
      <div class="menu">
        <div class="titulo">
          <img class="logo" src="https://i.imgur.com/1ayr6NR.png">
          <h1>Noobies</h1>
        </div>
      </div>
    </header>
    <div class="divFuncs">
      <h2>CONSULTAR CLIENTES</h2>  
    </div>
    <div class="ladoTab">
        <div class="pesquisar">
            <h3>Pesquisar cliente:</h3>
            <input class="pesq" type="text" name="pesquisa">
            <button class="buscar">BUSCAR</button>
        </div> 
    </div>
<div class="consultarTable">
  <div class="tabConteudo">
    <table class="tabela">
        <thead>
            <tr class="row">
                <th class="tcpf">CPF</th>
                <th class="tnome">NOME</th>
                <th class="tendereco">ENDEREÇO</th>
                <th class="ttelefone">TELEFONE</th>
                <th class="temail">E-MAIL</th>
            </tr>
        </thead>
        <tbody>
          <c:forEach items="${listaClientes}" var="cliente" >
            <tr class="linhaSec">
                <td><c:out value="${cliente.cpf}" /></td>
                <td><c:out value="${cliente.nome}" /></td>
                <td><c:out value="${cliente.endereco}" /></td>
                <td><c:out value="${cliente.telefone}" /></td>
                <td><c:out value="${cliente.email}" /></td>
                <td>
                    <a class="ancora" href="editarCliente?cpf=<c:out value='${cliente.cpf}'/>">Editar</a>
                    <a class="ancora" href="excluirCliente?cpf=<c:out value='${cliente.cpf}'/>">Deletar</a>
                </td>
            </tr>
        </c:forEach>
      </tbody>      
    </table>
  </div>
</div>
