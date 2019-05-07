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
            <form>
                <div class="divNome">
                    <p>ID do Produto:</p>
                </div>
                <div class="divNomeInput">
                    <input name="codProduto" type="text" disabled>
                </div>
                <br>
                <div class="divNome">
                    <p>Nome do Produto:</p>
                </div>
                <div class="divNomeInput">
                    <input name="nome" type="text" required disabled>
                </div>
                <br>
                <div class="divValorCV">
                    <p>Valor de Compra:</p>
                    <p>Valor de venda:</p>
                </div>
                <div class="divValoresInput">
                    <input name="valorCompra" type="text" required>
                    <input name="valorVenda" type="text" required>
                </div>
                <br><br>
                <div class="divBotao">
                    <button type="reset">Limpar</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <button type="submit">Alterar</button>
                </div>
            </form>
            <div class="espacadorFinal"></div>
        </div>
    </body>
</html>
