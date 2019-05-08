package servicoCliente;


import java.sql.SQLException;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class consultaWS {
	
	@WebMethod
	public String consulta(long TRANS_ID, long TRANS_CUST_ID, long TRANS_ACC_ID, double TRANS_VALUE, String TRANS_DATE, String TRANS_DESCRIPTION) throws ClassNotFoundException, SQLException{
		    
		Conexao con = new Conexao();
		return con.retorno(TRANS_ID, TRANS_CUST_ID, TRANS_ACC_ID, TRANS_VALUE, TRANS_DATE, TRANS_DESCRIPTION );
		
	}

}
