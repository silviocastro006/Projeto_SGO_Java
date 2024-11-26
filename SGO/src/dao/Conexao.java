
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Conexao {
    
    // ============ Atributos Conexão ============
    
    // url de conexão
    private static final String url = "jdbc:mysql://localhost:3306/sgo";
    
    // usuário do banco
    private static final String user = "root";
    
    // senha do usuário
    private static final String senha = "root";
    
    // driver para conexão
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    
    
    // ============ Metodos Conexão ============
    
    // Método para pegar o resultado da conexão do banco
    public static Connection getConexao(){
        try {
            
            Class.forName(driver);
            return (Connection) DriverManager.getConnection(url,user,senha);
            
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro na conexão do banco: "+e.getMessage());
        }
    }
    
    // Método sobrecarga para fechar a conexão do banco
    public static void fecharConexao(Connection conn){
        if(conn != null){ // se existir conexão
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException("Ocorreu um erro no fechamento da conexão: "+e.getMessage());
            }
        }
    }
    
    
    // Método sobrecarga para fechar a conexão do banco e do PreparedStatement
    public static void fecharConexao(Connection conn, PreparedStatement stmt){
        if(stmt != null){ // se existir conexão
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException("Ocorreu um erro no fechamento da conexão: "+e.getMessage());
            }
        }
            fecharConexao(conn);
    }
    
    
    // Método sobrecarga para fechar a conexão do banco, PreparedStatement e ResultSet
    public static void fecharConexao(Connection conn, PreparedStatement stmt, ResultSet rs){
        if(rs != null){ // se existir conexão
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException("Ocorreu um erro no fechamento da conexão: "+e.getMessage());
            }
        }
            fecharConexao(conn, stmt);
    }
}
