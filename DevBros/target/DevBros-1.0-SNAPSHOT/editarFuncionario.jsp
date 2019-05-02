<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          
        <hr>
        <h3 class="h3">ALTERAR FUNCIONÁRIO</h3>
        <hr>
        <div class="infoCad">
          <div id="alterar">
            <div class="user">
              <label>Usuário: </label>
              <input class="usuario" type="text" name="usuario">
            </div>
            <br>
            <div class="pass">
              <label>Senha: </label>
              <input class="senha" type="password" name="senha">
            </div>
            <br>
            <div class="name">
              <label>Nome: </label>
              <input class="nome" type="text" name="nome">
            </div>
            <br>
            <div class="cpf1">
              <label>CPF: </label>
              <input class = "cpf" type="text" name="cpf">
            </div>
            <br>
            <div class="rg1">
              <label>RG: </label>
              <input class="rg" type="text" name="rg">

              <label class = "datanas">Data de nascimento: </label>
              <input class="datanasc" type="date" name="datanasc">
            </div>
            <br>
            <div>
              <label>Filial: </label>
              <input class="filial" type="text" name="filial">

              <label class = "cargo">Cargo: </label>
              <select class="opcoes">
                <option value="Nenhum">Selecionar...</option>
                <option value="Diretor">Diretor</option>
                <option value="Gerente Global">Gerente global</option>
                <option value="Gerente Regional">Gerente regional</option>
                <option value="Vendedor">Vendedor</option>
                <option value="Funcionário">Funcionário</option>
                <option value="Suporte Técnico">Suporte técnico</option>
              </select>
            </div>
            <br>
          </div>
        </div>
        <div class="salvar">
          <button class="save" type="submit">ATUALIZAR</button>
        </div>
      </div>
    </body>
</html>
