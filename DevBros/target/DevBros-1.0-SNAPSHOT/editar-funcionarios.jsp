<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Editar funcionários</title>
        <link href = "CSS/editar-funcionarios.css" rel = "stylesheet" type = "text/css"/>
    </head>
    <body>
        <header>
            <div class="titulo">
                <a href="/DevBros/index.jsp"><img src="https://i.imgur.com/1ayr6NR.png"/></a>
                <h1>Noobies</h1>
            </div>
        </header>
        <center>
            <h1>EDITAR FUNCIONÁRIOS</h1>
            <hr>
        </center>
    <form action="editar" method="get">
        <div class="formulario">
            <div>
                <label>ID: </label>
                <input class="funcid" type="text" name="id" readonly value="${funcionario.getId()}">
                
                <label class="nome">Nome: </label>
                <input class="nome" type="text" name="nome" readonly value="${funcionario.getNome()}">
            </div>
            <div>
                <label>Usuário: </label>
                <input class="usuario" type="text" name="user" required value="${funcionario.getUsuario()}">
            </div>
            <br>
            <div>
                <label>Senha: </label>
                <input class="senha" type="password" name="pass" required value="${funcionario.getSenha()}">
            </div>
            <br>
            <div>
                <label class="filial">Filial: </label>
<!--                <input type="text" name="branch" required value="${funcionario.getFilial()}">-->
                <select class="filial" name="branch" required value="${funcionario.getFilial()}">
                  <option value="${funcionario.getFilial()}" required>${funcionario.getFilial()}</option>
                  <option value="SP (MATRIZ)">SP (MATRIZ)</option>
                  <option value="Campina Grande">Campina Grande</option>
                  <option value="Joinville">Joinville</option>
                  <option value="Brasília">Brasília</option>
                </select>
                <br>
                <label class = "cargo">Cargo: </label>
<!--                <input type="text" name="typeoffice" required value="${funcionario.getCargo()}">-->
                <select class="opcoes" name="typeoffice" required value="${funcionario.getCargo()}">
                  <option value="${funcionario.getCargo()}" required>${funcionario.getCargo()}</option>
                  <option value="Diretor">Diretor</option>
                  <option value="Gerente global">Gerente global</option>
                  <option value="Gerente regional">Gerente regional</option>
                  <option value="Vendedor">Vendedor</option>
                  <option value="Funcionário">Funcionário</option>
                  <option value="Suporte técnico">Suporte técnico</option>
                </select>
            </div>
            <br>
        </div>
    <div class="cadastrar">
        <button type="submit">ALTERAR</button>
    </div>
    </form>
    </body>
</html>