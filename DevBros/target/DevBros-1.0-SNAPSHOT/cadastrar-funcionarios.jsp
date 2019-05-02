<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Cadastrar funcion�rios</title>
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
            <h1>CADASTRO DE FUNCION�RIOS</h1>
            <hr>
        </center>
    <form action="funcionario" method="post">
        <div class="formulario">
            <div>
                <label>Usu�rio: </label>
                <input class="usuario" type="text" name="user" required>
                
            </div>
            <br>
            <div>
                <label>Senha: </label>
                <input class="senha" type="password" name="pass" required>

            </div>
            <br>
            <div>
                <label>Nome: </label>
                <input class="nome" type="text" name="name" required>

            </div>
            <br>
            <div>
                <label class = "cpf">CPF: </label>
                <input class = "cpf" type="text" name="CPF" required>

            </div>
            <br>
            <div>
                <label>RG: </label>
                <input class="rg" type="text" name="RG" required>
                

                <label class = "datanasc">Data de nascimento: </label>
                <input type="date" name="datebirth" required value="${funcionario.datebirth}">
            <br>
            <div>
                <label class="filial">Filial: </label>
                <input class="filial" type="text" name="branch" required value="${funcionario.branch}">

                <label class = "cargo" name="office">Cargo: </label>
                <select class="opcoes" name="typeoffice" required>
                  <option value="Nenhum">Selecionar...</option>
                  <option value="Diretor">Diretor</option>
                  <option value="Gerente global">Gerente global</option>
                  <option value="Gerente regional">Gerente regional</option>
                  <option value="Vendedor">Vendedor</option>
                  <option value="Funcion�rio">Funcion�rio</option>
                  <option value="Suporte t�cnico">Suporte t�cnico</option>
                </select>
            </div>
            <br>
        </div>
      <button class="cadastrar" type="submit">CADASTRAR</button>
    </form>
    </body>
</html>
