/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.DevBros.Noobies.Funcionario;

import java.awt.BorderLayout;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author priscyla.poliveira
 */
@WebServlet(name = "CadastrarFuncionarioServlet", urlPatterns = {"/funcionario"})
public class CadastroFuncionarioServlet extends HttpServlet {

    protected void incluirFuncionario(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Funcionario func = new Funcionario();
        
        func.setUsuario(request.getParameter("user"));
        func.setSenha(request.getParameter("pass"));
        func.setNome(request.getParameter("name"));
        func.setCpf(Long.parseLong(request.getParameter("CPF")));
        func.setRg(Integer.parseInt(request.getParameter("RG")));
        func.setDataNascimento(Date.valueOf(request.getParameter("datebirth")));
        func.setFilial(request.getParameter("branch"));
        func.setCargo(request.getParameter("typeoffice"));
        
        boolean linhasAfetadas = FuncionarioDAO.incluirFuncionario(func);
  
        if(linhasAfetadas){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/lista");
            dispatcher.forward(request, response);
        }else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrar-funcionarios.jsp");
            dispatcher.forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
        incluirFuncionario("GET", request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        incluirFuncionario("POST", request, response);
    }
}
