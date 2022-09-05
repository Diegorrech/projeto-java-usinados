package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TesteConexaoMySQL {
	public static void main(String[] args) {
		Connection conexao = null;
		
		try {
			//Indicação da conexão com o MySQL através do protocolo JDBC
			//além do IP do servidor (localhost)
			//usuário para autenticação (root)
			//senha do usuário root
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/bd_registro?" +
 "user=root&password=06857594902");
		    
		    System.out.println("Conexão realizada com sucesso.");
		    
		    //Configuração do comando SQL a ser executado no banco de dados
		    String sql = "SELECT name_client FROM cliente;";
		    
		    //Criação do Statement para execução de comandos SQL e preparação para execução
		    //O método preparedStatement é utilizado para enviar na conexão o comando SQL 
		    //e fazer o vínculo do comando com a conexão
		    Statement comando = conexao.prepareStatement(sql);
		    
		    //Criação do ResultSet para armazenar o retorno do banco de dados
		    //Após a criação é requisitado a execução efetiva do comando no
		    //banco de dados pelo método exeuteQuery()
		    ResultSet retorno = comando.executeQuery(sql);
		    
			//Verificação do retorno e leitura dos dados
			while(retorno.next()){ //Enquanto o retorno possuir linhas
				//Imprime o valor presente no campo name_client da tabela cliente
				System.out.println(retorno.getString("name_client"));
		    }
		    
		} catch (SQLException ex) {
			//Caso ocorram erros na tentativa de conexão com o MySQL
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}

	}
}


