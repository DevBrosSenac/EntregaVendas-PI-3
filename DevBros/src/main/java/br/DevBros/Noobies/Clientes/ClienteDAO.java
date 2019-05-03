package br.DevBros.Noobies.Clientes;

import static br.DevBros.Noobies.Utils.ConnectionUtils.obterConexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    //CADASTRO DE CLIENTES
    public static boolean incluirCliente(Cliente c){
        PreparedStatement stmt = null;
        Connection conn = null;
        
        boolean linhasAfetadas = false;
        
        String sql = "INSERT INTO tb_clientes (CPF_CLIENTE, EMAIL_CLIENTE, CPF_CLIENTE, TELEFONE_CLIENTE)"
                     + "VALUES(?, ?, ?, ?)";
        
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
           
            stmt.setLong(1, c.getCpf());
            stmt.setString(2, c.getNome());
            stmt.setLong(3, c.getTelefone());
            stmt.setString(4, c.getEmail());          
            stmt.executeUpdate();
            
        } catch (ClassNotFoundException | SQLException e) {
            linhasAfetadas = false;
            System.out.println("Não foi possível executar" + e);
        } finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    linhasAfetadas = false;
                    System.out.println("Erro ao fechar conexão" + e);
                }
            }
            if(conn != null){
                try {
                    conn.close();
                    linhasAfetadas = true;
                } catch (SQLException e) {
                    linhasAfetadas = false;
                    System.out.println("Erro ao fechar conexão" + e);
                }
            }
        }
        return linhasAfetadas;
    }
    //ALTERAÇÃO DE CLIENTES
    public static void alterarCliente(Cliente c){
        
        PreparedStatement stmt = null;
        Connection conn = null;
        
        String sql = "UPDATE tb_clientes SET NOME_CLIENTE=?, TELEFONE_CLIENTE=?, EMAIL_CLIENTE=? WHERE CPF_CLIENTE= ?";
        
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
                      
            stmt.setString(1, c.getEmail());
            stmt.setLong(2, c.getTelefone());
            stmt.setString(3, c.getNome());
            stmt.setLong(4, c.getCpf());           
            stmt.executeUpdate();
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não foi possível executar" + e);
        } finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão" + e);
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão" + e);
                }
            }
        }   
    }
    //EXCLUSÃO DE CLIENTES
    public static void excluirCliente(Cliente c){
        
        PreparedStatement stmt = null;
        Connection conn = null;
        
        String sql = "DELETE FROM TB_CLIENTES WHERE CPF_CLIENTE = ?";
        
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, c.getCpf());
            stmt.executeUpdate();
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não foi possível executar" + e);
        } finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão" + e);
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão" + e);
                }
            }
        }
        
    }
    //pesquisa de cliente
    public Cliente pesquisarCliente(Cliente c){
        PreparedStatement stmt = null;
        Connection conn = null;
        
        String sql = "SELECT * FROM tb_clientes WHERE CPF_CLIENTE = ?";
        
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            
            stmt.setLong(1, c.getCpf());
            
            ResultSet rs = stmt.executeQuery();
           
            while(rs.next()){
                c.setCpf(rs.getLong("CPF_CLIENTE"));
                c.setNome(rs.getString("NOME_CLIENTE"));
                c.setTelefone(rs.getLong("TELEFONE_CLIENTE"));        
                c.setEmail(rs.getString("EMAIL_CLIENTE"));
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não foi possível executar" + e);
        } finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão" + e);
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão" + e);
                }
            }
        }
        return c;
    }
    //listagem de clientes
    public static List<Cliente> listarClientes(){
        List<Cliente> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        Connection conn = null;
        
        String sql = "SELECT * FROM tb_clientes LIMIT 8";
                
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Cliente cliente = new Cliente();

                cliente.setCpf(rs.getLong("CPF_CLIENTE"));                    
                cliente.setNome(rs.getString("NOME_CLIENTE"));
                cliente.setTelefone(rs.getLong("TELEFONE_CLIENTE"));   
                cliente.setEmail(rs.getString("EMAIL_CLIENTE"));
                
                lista.add(cliente);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não foi possível executar" + e);
        } finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão" + e);
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão" + e);
                }
            }
        }
        
        return lista;
    }
}
