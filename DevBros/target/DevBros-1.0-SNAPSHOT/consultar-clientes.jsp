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
              <form action="pesquisaCliente" method="post">
                    <input type="text" name="pesquisa">
                    <c:if test="${not empty erroPesquisa}">
                        <div style="background-color: lightcoral"><c:out value="${erroPesquisa}" /></div>
                    </c:if>
                    <button class="buttonBusca"/>BUSCAR</button>
              </form>
            </div>
            <div id="resto">
                <div class="organizar">
                    <div class="organizarTable">
                        <table class="tabela">
                            <thead>
                                <tr class="linhaPrinc">
                                    <th>ID</th>
                                    <th>CPF</th> 
                                    <th>NOME</th>                                  
                                    <th>TELEFONE</th>
                                    <th>E-MAIL</th>
                                    <th>AÇÕES</th>

                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listaClientes}" var="cliente" >
                                    <tr class="linhaSec">
                                        <td><c:out value="${cliente.codCliente}"/></td>
                                        <td><c:out value="${cliente.nome}" /></td>  
                                        <td><c:out value="${cliente.cpf}" /></td>        
                                        <td><c:out value="${cliente.telefone}" /></td>
                                        <td><c:out value="${cliente.email}" /></td>
                                        <td>
                                            <a class="ancora" href="editarCliente?codCliente=<c:out value='${cliente.codCliente}'/>&nome=<c:out value='${cliente.nome}'/>&cpf=<c:out value='${cliente.cpf}'/>&telefone=<c:out value='${cliente.telefone}'/>&email=<c:out value='${cliente.email}'/>">Editar</a>
                                            <a class="ancora" href="excluirCliente?codCliente=<c:out value='${cliente.codCliente}'/>">Deletar</a>
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