<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Consulta de Clientes</title>
        <link rel="stylesheet" href="CSS/consultar-clientes.css">
    </head>
    <body>
        
        <div id="fixed">
            <header>
                <div>
                    <a href="/DevBros/index.jsp"><img src="img/logo-simple.png"/></a>
                    <h1>Noobies</h1>
                </div>
            </header>
            
            
            <div class="divProds">
                <h2>Consulta de Clientes</h2>
            </div>
            <div class="pesquisaExc">
                <h4>Pesquisa</h4>
                <form action="">
                    <input type="text" name="pesquisa">
                    <button class="buttonBusca"/>BUSCAR</button>
                </form>
            </div>
            <div id="resto">
                <div class="organizar">
                    <div class="organizarTable">
                        <table class="tabela">
                            <thead>
                                <tr class="linhaPrinc">
                                    <th class="tnome">NOME</th>
                                    <th class="tcpf">CPF</th>
                                    <th class="tendereco">ENDEREÇO</th>
                                    <th class="ttelefone">TELEFONE</th>
                                    <th class="temail">E-MAIL</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listaClientes}" var="cliente" >
                                    <tr class="linhaSec">
                                        <td><c:out value="${cliente.nome}" /></td>
                                        <td><c:out value="${cliente.cpf}" /></td>
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
            </div>
        </body>
</html>