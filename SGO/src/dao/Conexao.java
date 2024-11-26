
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
    
    //Atributo de conexão com o banco de dados
    private Connection conexao;
    
    // url de conexão
    private String url = "jdbc:mysql://localhost:3306/sgo";
    
    // usuário do banco
    private String user = "root";
    
    // senha do usuário
    private String senha = "root";
    
    // driver para conexão
    private String driver = "com.mysql.cj.jdbc.Driver";
    
    
    /**
     * @return true - a conexão foi realizada
     */
    public boolean conectar(){
        try{
            
            // comando para abrir a biblioteca do MySql
            Class.forName(driver);
            
            // tentar a conexão
            conexao = DriverManager.getConnection(url, user, senha);
            System.out.println("Conectado");
            
            // fechar a conexão
            conexao.close();
            
        }catch(SQLException e){
            System.out.println("Erro ao conectar ao banco: "+e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println("Driver não encontrado: "+e.getMessage());
        }
        return true;
    }
    
    public boolean desconectar(){
        try {
            if(this.conexao.isClosed()==false){
                this.conexao.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao desconectar ao banco: "+ e.getMessage());
        }
        System.out.println("Desconectou com o banco de dados"); 
        return true;
    }
    
}
