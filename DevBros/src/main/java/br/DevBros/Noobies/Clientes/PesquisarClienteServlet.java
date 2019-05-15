package br.DevBros.Noobies.Clientes;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet(name = "PesquisarClienteServlet", urlPatterns = {"/pesquisaCliente"})
public class PesquisarClienteServlet extends HttpServlet {

    private void listarClientes(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ClassNotFoundException {
        
       
        String valorPesquisa = request.getParameter("pesquisa");
        
        List<Cliente> clientes = ClienteDAO.consultarCliente(valorPesquisa);
        request.setAttribute("listaClientes",null);
        request.setAttribute("listaClientes", clientes);
            
               
        RequestDispatcher dispatcher = request.getRequestDispatcher("consultar-clientes.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            listarClientes("GET", request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultarClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            listarClientes("POST", request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultarClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        doGet(request, response);
    }

}
