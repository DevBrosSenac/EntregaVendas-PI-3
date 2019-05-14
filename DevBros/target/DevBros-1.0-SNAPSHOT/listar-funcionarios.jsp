<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Consulta de funcionários</title>
  <link href = "CSS/listar-funcionarios.css" rel = "stylesheet" type = "text/css"/>
</head>

<body>
  <div id="menu">
    <header>
      <div class="menu">
        <div class="titulo">
          <a href="/DevBros/index.jsp"><img src="https://i.imgur.com/1ayr6NR.png"/></a>
          <h1>Noobies</h1>
        </div>
      </div>
    </header>
    <div class="divFuncs">
      <h2>CONSULTAR FUNCIONÁRIOS</h2>
      <hr>
    </div>
  </div>
  <div id="espacador">
    
  </div>
</div>
<div class="consultarTable">
    <div class="ladoTab">
    <div class="pesquisar">
        <!--Pesquisar funcionário: <input class="pesq" type="text" name="pesquisa">
       <a var="funcionario" class="ancoraB" href="pesquisar?nome=${funcionario.getNome()}">                                   
            <button class="buscar">BUSCAR</button>
         </a>-->
        <form action="pesquisar" method="post">
            Pesquisar funcionário: <input class="pesq" type="text" name="pesquisa" id="pesquisa">
            <button class="buscar">BUSCAR</button>
        </form>
    </div> 
  </div>
  <div class="tabConteudo">
    <table id="tabelafunc" class="tabela">
        <thead>
            <tr class="row">
                <th class="tid">ID</th>
                <th class="tnome">NOME</th>
                <th class="tcpf">CPF</th>
                <th class="trg">RG</th>
                <th class="tfilial">FILIAL</th>
                <th class="tcargo">CARGO</th>
                <th class="tacoes">AÇÕES</th>
              </tr>
        </thead>
        <tbody id="body">
           <c:forEach items="${listaFuncionarios}" var="funcionario">
                <tr class="conteudo">
                    <td><c:out value="${funcionario.id}"/></td>
                    <td><c:out value="${funcionario.nome}"/></td>
                    <td><c:out value="${funcionario.cpf}"/></td>
                    <td><c:out value="${funcionario.rg}"/></td>
                    <td><c:out value="${funcionario.filial}"/></td>
                    <td><c:out value="${funcionario.cargo}"/></td>
                    <td>
                        <a class="ancora" href="editar?id=${funcionario.id}">                                   
                            <button class="edit">EDITAR</button>
                        </a>
                        <a class="ancora" href="desativar?id=${funcionario.id}">
                            <button class="delete">DELETAR</button>
                        </a>
                    </td>
                </tr>
            </c:forEach> 
        </tbody>
    </table>
  </div>
</div>

</body>
</html>
