/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.DevBros.Noobies.Funcionario;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AtualizarFuncionariosServlet", urlPatterns = {"/atualizar"})
public class AtualizarFuncionariosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String usuario = request.getParameter("user");
        String senha = request.getParameter("pass");
        String cargo = request.getParameter("branch");
        String filial = request.getParameter("typeoffice");
        
        Funcionario func = new Funcionario(id, usuario, senha, cargo, filial); 
        FuncionarioDAO.alterarFuncionario(func);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/lista");
        dispatcher.forward(request, response);
    }

}
