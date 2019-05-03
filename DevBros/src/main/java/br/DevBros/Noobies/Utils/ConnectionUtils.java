
package br.DevBros.Noobies.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    
    public static Connection obterConexao() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");  
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/DB_LOJA_NOOBIES?useTimezone=true&serverTimezone=UTC","root","");
        
        return con;
    }
    
}
