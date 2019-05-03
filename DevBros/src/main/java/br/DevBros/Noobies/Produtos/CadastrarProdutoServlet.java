package br.DevBros.Noobies.Produtos;

import br.DevBros.Noobies.Produtos.ProdutoDAO;
import br.DevBros.Noobies.Produtos.Produto;
import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CadastrarProdutoServlet", urlPatterns = {"/CadastrarProduto"})
public class CadastrarProdutoServlet extends HttpServlet {
    
    protected void processRequest(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        Produto produto = new Produto();
        
        // RECUPERA INFORMACOES DA REQUISICAO
        produto.setNomeProd(request.getParameter("nome"));
        produto.setDescProd(request.getParameter("descricao"));
        produto.setValorCompra(Float.parseFloat(request.getParameter("valorCompra")));
        produto.setValorVenda(Float.parseFloat(request.getParameter("valorVenda")));
        produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
        produto.setCategoria(request.getParameter("categoria"));
        
        boolean linhasAfetadas = ProdutoDAO.incluirProduto(produto);
        
        if(linhasAfetadas){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/consultar");
            dispatcher.forward(request, response);
        }else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrar-produtos.jsp");
            dispatcher.forward(request, response);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest("GET",request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest("POST",request, response);
    }
    
    
}
