/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.DevBros.Noobies.Funcionario;

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

/**
 *
 * @author sunse
 */
@WebServlet(name = "ListarFuncionarioServlet", urlPatterns = {"/lista"})
public class ListarFuncionarioServlet extends HttpServlet {

    private void listaFuncionarios(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        
        List<Funcionario> funcionarios = FuncionarioDAO.listarFuncionarios();
        request.setAttribute("listaFuncionarios", funcionarios);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listar-funcionarios.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            listaFuncionarios("GET", request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ListarFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            listaFuncionarios("POST", request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ListarFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        doGet(request, response);
    }

}