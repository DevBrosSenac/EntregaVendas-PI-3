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
        
        String sql = "INSERT INTO funcionarios (usuario, senha, nome, cpf, rg, dataNascimento, filial, cargo)"
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
        
        String sql = "UPDATE funcionarios SET usuario=?, senha=?, nome=?, cpf=?, rg=?, dataNascimento=?"
                + "filial=?, cargo=? WHERE ID = ?";
        
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, f.getUsuario());
            stmt.setString(2, f.getSenha());
            stmt.setString(3, f.getNome());
            stmt.setLong(4, f.getCpf());
            stmt.setInt(5, f.getRg());
            stmt.setDate(6, f.getDataNascimento());
            stmt.setString(7, f.getFilial());
            stmt.setString(8, f.getCargo());
            stmt.setInt(9, f.getId());
            
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
        
        String sql = "DELETE FROM funcionarios WHERE id = ?";
        
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
    
    public Funcionario pesquisar(Funcionario f){
        PreparedStatement stmt = null;
        Connection conn = null;
        
        String sql = "SELECT * FROM funcionarios WHERE id = ?";
        
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, f.getId());
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                f.setId(rs.getInt("id"));
                f.setUsuario(rs.getString("usuario"));
                f.setSenha(rs.getString("senha"));
                f.setNome(rs.getString("nome"));
                f.setCpf(rs.getLong("cpf"));
                f.setRg(rs.getInt("rg"));
                f.setDataNascimento(new Date(rs.getDate("dataNascimento").getTime()));
                f.setFilial(rs.getString("filial"));
                f.setCargo(rs.getString("cargo"));
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
        
        String sql = "SELECT * FROM funcionarios";
                
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Funcionario func = new Funcionario();
                func.setId(rs.getInt("id"));
                func.setUsuario(rs.getString("usuario"));
                func.setSenha(rs.getString("senha"));
                func.setNome(rs.getString("nome"));
                func.setCpf(rs.getLong("cpf"));
                func.setRg(rs.getInt("rg"));
                func.setDataNascimento(new Date(rs.getDate("dataNascimento").getTime()));
                func.setFilial(rs.getString("filial"));
                func.setCargo(rs.getString("cargo"));
                
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
}
