package servicoCliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
	
	public String retorno() throws SQLException, ClassNotFoundException {
			
	
	    Class.forName("com.mysql.jdbc.Driver"); // "carregar" o driver, de tal maneira que o Java saiba que ele existe, obrigatório!!
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdservico", "root", "1234");
		Statement statement = connection.createStatement();	
		
		boolean resultado = statement.execute("select * from produto");
		ResultSet resultSet = statement.getResultSet();
		resultSet.next();
		String nome = resultSet.getString("nome");
		
		//System.out.println(nome);
		
		resultSet.close();
		statement.close();
		connection.close();
		
		return nome;	
			
		
	}

}
