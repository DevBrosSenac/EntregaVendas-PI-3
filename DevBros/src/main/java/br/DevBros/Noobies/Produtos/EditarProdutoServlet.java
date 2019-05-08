/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.DevBros.Noobies.Produtos;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author victor.maoliveira
 */
@WebServlet(name = "EditarProdutoServlet", urlPatterns = {"/editarProd"})
public class EditarProdutoServlet extends HttpServlet {

    private void editarProduto(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ClassNotFoundException {
        
        int codProduto = Integer.parseInt(request.getParameter("codProduto"));
        String nome = request.getParameter("nome");
        double valorCompra = Double.parseDouble(request.getParameter("valorCompra"));
        double valorVenda = Double.parseDouble(request.getParameter("valorVenda"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        String categoria = request.getParameter("categoria");
      
        RequestDispatcher dispatcher = request.getRequestDispatcher("editarProduto.jsp");
        /*request.setAttribute("codProduto", codProduto);
        request.setAttribute("nome", nome);
        request.setAttribute("valorCompra", valorCompra);
        request.setAttribute("valorVenda", valorVenda);
        request.setAttribute("quantidade", quantidade);
        request.setAttribute("categoria", categoria);*/
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            editarProduto("GET", request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultarProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            editarProduto("POST", request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultarProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        doGet(request, response);
    }
}
