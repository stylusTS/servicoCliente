package servicoCliente;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
	
	public String retorno(long TRANS_ID, 
			              long TRANS_CUST_ID, 
			              long TRANS_ACC_ID, 
			              double TRANS_VALUE, 
			              String TRANS_DATE, 
			              String TRANS_DESCRIPTION) throws SQLException, ClassNotFoundException {
			
	
	    //Class.forName("com.mysql.jdbc.Driver"); // "carregar" o driver, de tal maneira que o Java saiba que ele existe, obrigatório!	
		//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdservico", "root", "1234");
		
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@10.28.36.10:1521:bdodi", "ODI_USER", "odi12345");
		
		Statement statement = connection.createStatement();	
		
		String sql = "INSERT INTO FINANCE.FINANCIAL_TRANSACTION (TRANS_ID, TRANS_CUST_ID, TRANS_ACC_ID, TRANS_DATE, TRANS_DESCRIPTION, TRANS_VALUE)"+
		"VALUES(" + TRANS_ID + "," + TRANS_CUST_ID + "," +  TRANS_ACC_ID + ",TO_DATE('" +  TRANS_DATE + "', 'DD/MM/YYYY'), '" + TRANS_DESCRIPTION + "'," + TRANS_VALUE + ")";
		
		//String sql = "INSERT INTO FINANCE.FINANCIAL_TRANSACTION (TRANS_ID, TRANS_CUST_ID, TRANS_ACC_ID, TRANS_DATE, TRANS_DESCRIPTION, TRANS_VALUE) VALUES(9876543210,33,33, TO_DATE('10/10/1029', 'DD/MM/YYYY'), 'dddd', 33.0)";
		
		try {		  		
		statement.execute(sql);
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			return "Erro de conexão";
			
		}
		
//		boolean resultado = statement.execute("select * from produto");
//		ResultSet resultSet = statement.getResultSet();
//		resultSet.next();		
//		String nome = resultSet.getString("nome");		
//      System.out.println(nome);
//      resultSet.close();   
		
		
		statement.close();
		connection.close();
		
		return "Registro inserido com sucesso";	
			
		
	}

}
