<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Produto</title>
        <link href="CSS/editar-produtos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header>
            <div>
                <a href="/DevBros/index.jsp"><img src="img/logo-simple.png"/></a>
                <h1>Noobies</h1>
            </div>
        </header>
        <br>
        <center><h1>Alterar Produto</h1></center>
        <br>
        <hr>
        <div>
            <form action="CadastrarProduto" method="post">
                <div class="divDescricao">
                    <p>ID do Produto:</p>
                </div>
                <div class="divDescricaoTxtArea">
                    <input value="${codProduto}" name="idProduto" type="text">
                    <c:if test="${not empty erroDescricao}">
                        <div style="background-color: lightcoral"><c:out value="${erroDescricao}" /></div>
                    </c:if>
                </div>
                <div class="divNome">
                    <p>Nome do Produto:</p>
                </div>
                <div class="divNomeInput">
                    <input value="${nome}" name="nome" type="text" required>
                    <c:if test="${not empty erroNome}">
                        <div style="background-color: lightcoral"><c:out value="${erroNome}" /></div>
                    </c:if>
                </div>

                <div class="divValorCV">
                    <p>Valor de Compra:</p>
                    <p>Valor de venda:</p>
                </div>
                <div class="divValoresInput">
                    <input value="${valorCompra}" name="valorCompra" type="text" required>
                    <c:if test="${not empty erroValorCompra}">
                        <div style="background-color: lightcoral"><c:out value="${erroDescricao}" /></div>
                    </c:if>                    
                    <input value="${valorVenda}" name="valorVenda" type="text" required>
                    <c:if test="${not empty erroValorVenda}">
                        <div style="background-color: lightcoral"><c:out value="${erroDescricao}" /></div>
                    </c:if>
                </div>
                    <div class="divQTDCAT" id="divQTDCAT">
                    <p>Quantidade:</p>
                    <p>Categoria:</p>
                </div>
                <div class="divQTDCATInput" id="divQTDCATInput">
                    <input value="${quantidade}" name="quantidade" type="text" required>
                    <c:if test="${not empty erroQuantidade}">
                        <div style="background-color: lightcoral"><c:out value="${erroDescricao}" /></div>
                    </c:if>
                    <select name="categoria">
                        <option value="">Selecione uma Categoria...</option>
                        <option value="PS4">PS4</option>
                        <option value="XBOX-ONE">XBOX ONE</option>
                        <option value="SWITCH">Nintendo Switch</option>
                        <option value="TABULEIRO">Tabuleiro</option>
                        <option value="PC">PC</option>
                    </select>
                    <c:if test="${not empty erroCategoria}">
                        <div style="background-color: lightcoral"><c:out value="${erroDescricao}" /></div>
                    </c:if>
                </div>
                <br><br><br>
                <div class="divBotao">
                    <button type="reset">Limpar</button>
                    <button type="submit">Cadastrar</button>
            </form>
        </div>
    </body>
</html>
