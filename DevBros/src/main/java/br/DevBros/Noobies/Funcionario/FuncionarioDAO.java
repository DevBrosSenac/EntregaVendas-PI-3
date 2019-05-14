/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.DevBros.Noobies.Funcionario;

import static br.DevBros.Noobies.Utils.ConnectionUtils.obterConexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author priscyla.poliveira
 */
public class FuncionarioDAO {
    
    public static boolean incluirFuncionario(Funcionario f){
        PreparedStatement stmt = null;
        Connection conn = null;
        
        boolean linhasAfetadas = false;
        
        String sql = "INSERT INTO tb_funcionarios (LOGIN_SIST, SENHA_SIST, NOME_FUNCIONARIO, CPF_FUNCIONARIO, RG_FUNCIONARIO, DATA_NASCIMENTO, FILIAL_FUNCIONARIO, CARGO_FUNCIONARIO)"
                     + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, f.getUsuario());
            stmt.setString(2, f.getSenha());
            stmt.setString(3, f.getNome());
            stmt.setLong(4, f.getCpf());
            stmt.setInt(5, f.getRg());
            stmt.setDate(6, new Date(f.getDataNascimento().getTime()));
            stmt.setString(7, f.getFilial());
            stmt.setString(8, f.getCargo());
            
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
    
    public static void alterarFuncionario(Funcionario f){
        
        PreparedStatement stmt = null;
        Connection conn = null;
        
        String sql = "UPDATE tb_funcionarios SET LOGIN_SIST=?, SENHA_SIST=?, FILIAL_FUNCIONARIO=?, CARGO_FUNCIONARIO=? WHERE COD_FUNCIONARIO=?";
        
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, f.getUsuario());
            stmt.setString(2, f.getSenha());
            stmt.setString(3, f.getFilial());
            stmt.setString(4, f.getCargo());
            stmt.setInt(5, f.getId());
            
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
    
    public static void desativarFuncionario(Funcionario f){
        
        PreparedStatement stmt = null;
        Connection conn = null;
        
        String sql = "DELETE FROM tb_funcionarios WHERE COD_FUNCIONARIO=?";
        
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, f.getId());
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
    
    public static Funcionario pesquisar(Funcionario f){
        PreparedStatement stmt = null;
        Connection conn = null;
        
        String sql = "SELECT * FROM tb_funcionarios WHERE COD_FUNCIONARIO=?";
        
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, f.getId());
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                f.setId(rs.getInt("COD_FUNCIONARIO"));
                f.setUsuario(rs.getString("LOGIN_SIST"));
                f.setSenha(rs.getString("SENHA_SIST"));
                f.setNome(rs.getString("NOME_FUNCIONARIO"));
                f.setCpf(rs.getLong("CPF_FUNCIONARIO"));
                f.setRg(rs.getInt("RG_FUNCIONARIO"));
                f.setDataNascimento(new Date(rs.getDate("DATA_NASCIMENTO").getTime()));
                f.setFilial(rs.getString("FILIAL_FUNCIONARIO"));
                f.setCargo(rs.getString("CARGO_FUNCIONARIO"));
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
        return f;
    }
    
    public static List<Funcionario> listarFuncionarios(){
        List<Funcionario> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        Connection conn = null;
        
        String sql = "SELECT * FROM tb_funcionarios";
                
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Funcionario func = new Funcionario();
                func.setId(rs.getInt("COD_FUNCIONARIO"));
                func.setUsuario(rs.getString("LOGIN_SIST"));
                func.setSenha(rs.getString("SENHA_SIST"));
                func.setNome(rs.getString("NOME_FUNCIONARIO"));
                func.setCpf(rs.getLong("CPF_FUNCIONARIO"));
                func.setRg(rs.getInt("RG_FUNCIONARIO"));
                func.setDataNascimento(new Date(rs.getDate("DATA_NASCIMENTO").getTime()));
                func.setFilial(rs.getString("FILIAL_FUNCIONARIO"));
                func.setCargo(rs.getString("CARGO_FUNCIONARIO"));
                
                lista.add(func);
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
    
    public static Funcionario consultarFuncionario(Funcionario f) {
        
        //List<Funcionario> listaFuncionario = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        
        String sql = "SELECT * FROM tb_funcionarios WHERE NOME_FUNCIONARIO LIKE='%"+f.getNome()+"%'";       
        
        try{
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, f.getNome());
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Funcionario func = new Funcionario();
                func.setId(rs.getInt("COD_FUNCIONARIO"));
                func.setNome(rs.getString("NOME_FUNCIONARIO"));
                func.setCpf(rs.getLong("CPF_FUNCIONARIO"));
                func.setRg(rs.getInt("RG_FUNCIONARIO"));
                func.setFilial(rs.getString("FILIAL_FUNCIONARIO"));
                func.setCargo(rs.getString("CARGO_FUNCIONARIO"));
                
                //listaFuncionario.add(func);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não foi possível executar" + e);
        } finally {
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
        return f;
    }
}