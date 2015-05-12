package interfaces.daos;

import java.sql.Connection;
import java.util.List;

import transfers.BonoUsuario;

public interface IBonoUsuarioDao {
	
	public BonoUsuario findByNickAndBono(Connection connection, BonoUsuario bonoUsuario);
	List<BonoUsuario> findByNick(Connection connection, String nick);
 	int insertBonoUsuario(Connection connection, BonoUsuario bonoUsuario);
	int borrarBonoUsuario(Connection connection, BonoUsuario bonoUsuario);
	
}
