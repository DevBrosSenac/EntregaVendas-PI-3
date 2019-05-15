package br.DevBros.Noobies.Clientes;

import br.DevBros.Noobies.Clientes.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ExcluirClienteServlet", urlPatterns = {"/excluirCliente"})
public class ExcluirClienteServlet extends HttpServlet {

    protected void excluirCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id  = Integer.parseInt(request.getParameter("codCliente"));
        
        Cliente c = new Cliente(id);
        boolean retorno = ClienteDAO.excluirCliente(c);
        if(retorno){
            response.sendRedirect("consultarclientes");
        }else{
            response.sendRedirect("consultar-cliente.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        excluirCliente(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        excluirCliente(request, response);
    }

}
