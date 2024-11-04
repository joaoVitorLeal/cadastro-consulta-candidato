package br.com.sistemaeleicao.banco.de.dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  Classe responsável por gerenciar a conexão com o banco de dados, incluindo a abertura
 * e o fechamento das conexões.
 * Pode ser utilizada em todas as operações que exigem acesso ao banco de dados.
 * 
 * @author joaoleal
 */

public class ConexaoBancoDados implements ConstantesDB{
    
    // Método para conectar ao DB
    public static Connection conectar(){
        Connection conn = null;
        try {
            Class.forName(DRV);
            
            conn = DriverManager.getConnection(
                    ConstantesDB.URL,
                    ConstantesDB.USER,
                    ConstantesDB.PASSWORD             
            );    
            
            System.out.println("\nConexão ao banco de dados estabelecida com sucesso.");       
        } catch (ClassNotFoundException cnfe){
            System.err.println("\nDriver não encontrado: " + cnfe.getMessage());
        } catch (SQLException sqle){
            System.err.println("\nErro ao conectar ao banco de dados: ");
            System.err.println("Código de erro: " + sqle.getErrorCode());
            System.err.println("Descrição: " + sqle.getMessage() + "\n");
            
        }
        
        return conn;
    }
    
    // Método para encerrar conexao com o DB 
    public static void desconectar(Connection conn){
        if(conn != null){
            try {
                conn.close();
                System.out.println("\nConexão com o banco de dados encerrada.");
            } catch (SQLException sqle){
                System.err.println("\nErro ao encerrar a conexão: " + sqle.getMessage());
                System.err.println("\nCódigo de erro: " + sqle.getErrorCode());
                System.err.println("\nDescrição: " + sqle.getMessage());
            }
        }
    }
}
