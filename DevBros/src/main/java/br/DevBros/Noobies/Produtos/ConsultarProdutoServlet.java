package br.DevBros.Noobies.Produtos;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ConsultarProdutoServlet", urlPatterns = {"/consultar"})
public class ConsultarProdutoServlet extends HttpServlet {
    
    private void listaProdutos(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ClassNotFoundException {
        
        String valorPesquisa = request.getParameter("pesquisa");
        
        if(valorPesquisa == null || valorPesquisa.equalsIgnoreCase("")){
            List<Produto> produtos = ProdutoDAO.listarProdutos();
            request.setAttribute("listaProdutos", produtos);
        }else{
            List<Produto> produtos;
            try {
                produtos = ProdutoDAO.procurar(valorPesquisa);
                request.setAttribute("listaProdutos", produtos);
            } catch (Exception ex) {
                Logger.getLogger(ConsultarProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
               
        RequestDispatcher dispatcher = request.getRequestDispatcher("consultar-produtos.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            listaProdutos("GET", request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultarProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            listaProdutos("POST", request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultarProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        doGet(request, response);
    }
    
    
}
