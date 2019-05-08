package br.DevBros.Noobies.Clientes;

import br.DevBros.Noobies.Produtos.*;
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

@WebServlet(name = "EditarClienteServlet", urlPatterns = {"/editarCliente"})
public class EditarClienteServlet extends HttpServlet {

    private void editarCliente(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ClassNotFoundException {
        
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
      
        RequestDispatcher dispatcher = request.getRequestDispatcher("editarProduto.jsp");
        request.setAttribute("nome", nome);
        request.setAttribute("telefone", telefone);
        request.setAttribute("cpf", cpf);
        request.setAttribute("email", email);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            editarCliente("GET", request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultarProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            editarCliente("POST", request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultarProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        doGet(request, response);
    }
}
