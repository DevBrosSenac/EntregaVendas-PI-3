/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.DevBros.Noobies.Produtos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sunse
 */
@WebServlet(name = "ExcluirProdutoServlet", urlPatterns = {"/excluirProd"})
public class ExcluirProdutoServlet extends HttpServlet {

    protected void excluirProduto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("codProduto"));
        
        Produto prod = new Produto(id);
        boolean retorno = ProdutoDAO.excluirProduto(prod);
        if(retorno){
            response.sendRedirect("consultar");
        }else{
            response.sendRedirect("consultar-produto.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        excluirProduto(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        excluirProduto(request, response);
    }

}
