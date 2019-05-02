package br.DevBros.Noobies.Produtos;

import static br.DevBros.Noobies.Utils.ConnectionUtils.obterConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public static boolean incluirProduto(Produto produto){

        //Abrir conexao e deixa ela null
        PreparedStatement stmt = null;
        Connection conn = null;
        
        boolean linhasAfetadas = false;
        
        //Preparar string sql
        String sql = "INSERT INTO produtos (nome, descricao, valorCompra, "
                + "valorVenda, quantidade, categoria)"
                + "VALUES (?, ?, ?, ?, ?, ?)";
        
        //Obtem conexão para SQL workbench
        try{
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNomeProd());
            stmt.setString(2, produto.getDescProd());
            stmt.setDouble(3, produto.getValorCompra());
            stmt.setDouble(4, produto.getValorVenda());
            stmt.setInt(5, produto.getQuantidade());  
            stmt.setString(6, produto.getCategoria());         

            // 2) Executar SQL
            stmt.executeUpdate();
        } 
        catch (SQLException ex){
            linhasAfetadas = false;
            System.out.println("Não foi possível executar. SQL Exception");
        } 
        catch (ClassNotFoundException ex){
            linhasAfetadas = false;
            System.out.println("Não foi possível executar. ClassNotFound EXception");
        } finally{
            if (stmt != null){
                try{
                    stmt.close();
                } 
                catch (SQLException ex){
                    linhasAfetadas = false;
                    System.out.println("Erro ao fechar stmt.");
                }
            }
            if (conn != null){
                try{
                    conn.close();
                    linhasAfetadas = true;
                } 
                catch (SQLException ex){
                    linhasAfetadas = false;
                    System.out.println("Erro ao fechar conn.");
                }
            }
        }
    return linhasAfetadas;
}
        
    public static boolean excluirProduto(Produto produto){
        PreparedStatement stmt = null;
        Connection conn = null;
        boolean verdade = false;
        //Preparar string sql
        String sql = "DELETE FROM produtos WHERE ID = ?";//INSERIR VARIÁVEL COM ID
        
        //Obtem conexão para SQL workbench
        try{
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, produto.getCodProduto());
            stmt.executeUpdate();
        } 
        
        catch (SQLException ex) {
            System.out.println("Não foi possível executar. SQL Exception");
            verdade = false;
        } 
        catch (ClassNotFoundException ex) {
            System.out.println("Não foi possível executar. ClassNotFound EXception");
            verdade = false;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                    verdade = true;
                } 
                catch (SQLException ex) {
                    System.out.println("Erro ao fechar stmt.");
                    verdade = false;
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                    verdade = true;
                } 
                catch (SQLException ex) {
                    System.out.println("Erro ao fechar conn.");
                    verdade = false;
                }
            }
        }
        return verdade;
    }
    public static void editarProduto(Produto produto){
        //Abrir conexao e deixa ela null
        PreparedStatement stmt = null;
        Connection conn = null;
        
        //Preparar string sql
        String sql = "UPDATE produtos SET nome = ?, decricao = ?, valorCompra = ?, valorVenda = ?, quantidade = ?"
                + "WHERE id = ?";
        
        //Obten conexão para SQL workbench
        try{
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNomeProd());
            stmt.setString(2, produto.getDescProd());
            stmt.setDouble(3, produto.getValorCompra());
            stmt.setDouble(4, produto.getValorVenda());
            stmt.setInt(5, produto.getQuantidade());
            stmt.setInt(6, produto.getCodProduto());

            // 2) Executar SQL
            stmt.executeUpdate();
        } 
        catch (SQLException ex){
            System.out.println("Não foi possível executar. SQL Exception");
        } 
        catch (ClassNotFoundException ex){
            System.out.println("Não foi possível executar. ClassNotFound EXception");
        } finally{
            if (stmt != null){
                try{
                    stmt.close();
                } 
                catch (SQLException ex){
                    System.out.println("Erro ao fechar stmt.");
                }
            }
            if (conn != null){
                try{
                    conn.close();
                } 
                catch (SQLException ex){
                    System.out.println("Erro ao fechar conn.");
                }
            }
        }
    }
    public static void consultarProduto(Produto produto){
        //Abrir conexao e deixa ela null
        PreparedStatement stmt = null;
        Connection conn = null;
        
        //Preparar string sql
        String sql = "SELECT * FROM produtos WHERE id = ?";
        
        //Obten conexão para SQL workbench
        try{
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNomeProd());
            stmt.setString(2, produto.getDescProd());
            stmt.setDouble(3, produto.getValorCompra());
            stmt.setDouble(4, produto.getValorVenda());
            stmt.setInt(5, produto.getQuantidade());           
            stmt.setInt(6, produto.getCodProduto());
            
            // 2) Executar SQL
            stmt.executeUpdate();
        } 
        catch (SQLException ex){
            System.out.println("Não foi possível executar. SQL Exception");
        } 
        catch (ClassNotFoundException ex){
            System.out.println("Não foi possível executar. ClassNotFound EXception");
        } finally{
            if (stmt != null){
                try{
                    stmt.close();
                } 
                catch (SQLException ex){
                    System.out.println("Erro ao fechar stmt.");
                }
            }
            if (conn != null){
                try{
                    conn.close();
                } 
                catch (SQLException ex){
                    System.out.println("Erro ao fechar conn.");
                }
            }
        }
    }
    
    public static List<Produto> listarProdutos(){
        List<Produto> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        Connection conn = null;
        
        String sql = "SELECT * FROM produtos";
                
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Produto prod = new Produto();
                prod.setCodProduto(rs.getInt("id"));
                prod.setNomeProd(rs.getString("nome"));
                prod.setValorCompra(rs.getDouble("valorCompra"));
                prod.setValorVenda(rs.getDouble("valorVenda"));
                prod.setQuantidade(rs.getInt("quantidade"));
                
                lista.add(prod);
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
