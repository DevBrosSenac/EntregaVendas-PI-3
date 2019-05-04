package br.DevBros.Noobies.Clientes;

import br.DevBros.Noobies.Clientes.ClienteDAO;
import br.DevBros.Noobies.Clientes.Cliente;

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

/**
 *
 * @author gabriela.vsmarques
 */
@WebServlet(name = "ConsultarClienteServlet", urlPatterns = {"/consultarclientes"})
public class ConsultarClienteServlet extends HttpServlet {

    private void listaClientes(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ClassNotFoundException {

        List<Cliente> clientes = ClienteDAO.listarClientes();
        request.setAttribute("listaProdutos", clientes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("consultar-clientes.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            listaClientes("GET", request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultarClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            listaClientes("POST", request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultarClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        doGet(request, response);
    }
}
