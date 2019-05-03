package servicoCliente;

import java.sql.SQLException;

import javax.jws.WebMethod;
import javax.jws.WebService;



@WebService
public class consultaWS {
	
	@WebMethod
	public String consulta() throws ClassNotFoundException, SQLException{
		    
		Conexao con = new Conexao();
		return con.retorno();
		
	}

}
