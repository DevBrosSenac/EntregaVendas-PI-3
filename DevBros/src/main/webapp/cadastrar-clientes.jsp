<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Cadastro de clientes</title>
        <link rel="stylesheet" href="CSS/cadastro-clientes.css" type = "text/css">
    </head>
    <body>
        <header>
            <div class="titulo">               
                <a href="/DevBros/index.jsp"><img src="img/logo-simple.png"/></a>
                <h2>Noobies</h2>
            </div>
        </header>
    <center>
        <div class="divClientes">
             <h2 class="h2">Cadastro de Clientes</h2>
        </div>
        <hr>
        <div class="formulario">
            <form action="CadastrarCliente" method="post">
                
                <div class="divNome">
                    <label>Nome: </label>
                </div>
                <div class="divNomeInput">
                    <input class="nome" type="text" name="nome" required>
                    <c:if test="${not empty erroNome}">
                        <div style="background-color: lightcoral"><c:out value="${erroNome}" /></div>
                    </c:if>
                </div>
                <br>
                <div class="divCPF">
                    <label>CPF: </label>
                </div>
                <div class="divCPFInput">
                    <input class = "cpf" type="text" name="cpf" required>
                    <c:if test="${not empty erroCPF}">
                        <div style="background-color: lightcoral"><c:out value="${erroCPF}" /></div>
                    </c:if>                
                </div>
                <br>
                <div class="divEndereco">
                    <label>Endereço: </label>
                </div>
                <div class="divEnderecoInput">
                    <input class="endereco" type="text" name="address">
                    <c:if test="${not empty erroEndereco}">
                        <div style="background-color: lightcoral"><c:out value="${erroEndereco}" /></div>
                    </c:if>
                </div>
                <br>
                <div class="divTelefone">
                    <label>Telefone: </label>
                </div>
                <div class="divTelefoneInput">
                    <input class="telefone" type="text" name="fone">
                    <c:if test="${not empty erroTelefone}">
                        <div style="background-color: lightcoral"><c:out value="${erroTelefone}" /></div>
                    </c:if>
                </div>
                <br>
                <div class="divEmail">
                     <label>E-mail: </label>
                </div>
                <div class="divEmailInput">
                    <input class="email" type="text" name="email">
                    <c:if test="${not empty erroEmail}">
                        <div style="background-color: lightcoral"><c:out value="${erroEmail}" /></div>
                    </c:if>
                </div>
                
                <div class="divBotao">
                    <button type="reset">Limpar</button>
                    <button type="submit">Cadastrar</button>
            </form>
        </div>
    </div>
        <div class ="divVoltar" >
            <a href="/DevBros/index.jsp"><button type="button">Voltar</button></a>
        </div>
</center>
</body>
</html>
