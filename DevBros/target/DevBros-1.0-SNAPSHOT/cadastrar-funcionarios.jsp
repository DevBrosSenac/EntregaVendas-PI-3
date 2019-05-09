<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Cadastrar funcionários</title>
        <link href = "CSS/cadastro-funcionarios.css" rel = "stylesheet" type = "text/css"/>
    </head>
    <body>
        <header>
            <div class="titulo">
                <a href="/DevBros/index.jsp"><img src="https://i.imgur.com/1ayr6NR.png"/></a>
                <h1>Noobies</h1>
            </div>
        </header>
        <center>
            <h1>CADASTRO DE FUNCIONÁRIOS</h1>
            <hr>
        </center>
    <form action="funcionario" method="post">
        <div class="formulario">
            <div>
                <label>Usuário: </label>
                <input class="usuario" type="text" name="user" required value="${funcionario.user}">
                
            </div>
            <br>
            <div>
                <label>Senha: </label>
                <input class="senha" type="password" name="pass" required value="${funcionario.pass}">

            </div>
            <br>
            <div>
                <label>Nome: </label>
                <input class="nome" type="text" name="name" required value="${funcionario.name}">

            </div>
            <br>
            <div>
                <label class = "cpf">CPF: </label>
                <input class = "cpf" type="text" name="CPF" required value="${funcionario.CPF}">

            </div>
            <br>
            <div>
                <label>RG: </label>
                <input class="rg" type="text" name="RG" required value="${funcionario.RG}">
                

                <label class = "datanasc">Data de nascimento: </label>
                <input type="date" name="datebirth" required value="${funcionario.datebirth}">
            </div>
            <br>
            <div>
<!--                <label class="filial">Filial: </label>
                    <select class="filial" name="branch" required value="${funcionario.branch}">
                        <c:forEach var="filial" items="${listaFilial}">
                            <option value="${filial.id}">${filial.nome}</option>
                        </c:forEach>
                    </select>-->
                
                <label class="filial">Filial: </label>
                <select class="filial" name="branch" required value="${funcionario.branch}">
                  <option value="Nenhum">Selecionar...</option>
                  <option value="SP (MATRIZ)">SP (MATRIZ)</option>
                  <option value="Campina Grande">Campina Grande</option>
                  <option value="Joinville">Joinville</option>
                  <option value="Brasília">Brasília</option>
                </select>
                
                <label class = "cargo">Cargo: </label>
                <select class="opcoes" name="typeoffice" required value="${funcionario.typeoffice}">
                  <option value="Nenhum">Selecionar...</option>
                  <option value="Diretor">Diretor</option>
                  <option value="Gerente global">Gerente global</option>
                  <option value="Gerente regional">Gerente regional</option>
                  <option value="Vendedor">Vendedor</option>
                  <option value="Funcionário">Funcionário</option>
                  <option value="Suporte técnico">Suporte técnico</option>
                </select>
            </div>
            <br>
            <button class="cadastrar" type="submit">CADASTRAR</button>
        </div>
    </form>    
    </body>
</html>
