<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Consulta de Produtos</title>
        <link rel="stylesheet" href="CSS/consultar-produtos.css">
        <link rel="shortcut icon" href="img/logo.png" type="image/x-icon">
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
            <h2>CONSULTA DE PRODUTOS</h2>
        </div>
        <div class="pesquisaExc">
                <h4>Pesquisa</h4>
                <form action="pesquisaProduto" method="post">
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
                                <th>NOME</th>
                                <th>V.COMPRA</th>
                                <th>V.VENDA</th>
                                <th>QUANTIDADE</th>
                                <th>CATEGORIA</th>
                                <th>AÇÕES</th>
                            </tr>
                        </thead>
                        <tbody>
                           <c:forEach items="${listaProdutos}" var="produto" >
                                <tr class="linhaSec">
                                    <td><c:out value="${produto.codProduto}" /></td>
                                    <td><c:out value="${produto.nomeProd}" /></td>
                                    <td><c:out value="${produto.valorCompra}" /></td>
                                    <td><c:out value="${produto.valorVenda}" /></td>
                                    <td><c:out value="${produto.quantidade}" /></td>
                                    <td><c:out value="${produto.categoria}" /></td>
                                    <td>
                                        <a class="ancora" href="editarProd?codProduto=<c:out value='${produto.codProduto}'/>">Editar</a>
                                        <a class="ancora" href="excluirProd?codProduto=<c:out value='${produto.codProduto}'/>">Deletar</a>
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