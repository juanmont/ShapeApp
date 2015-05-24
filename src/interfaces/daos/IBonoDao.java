package interfaces.daos;

import java.sql.Connection;
import java.util.List;

import transfers.Bono;

public interface IBonoDao {
	
	List<Bono> findAll(Connection connection);
	public Bono findByNickAndBono(Connection connection, Bono bonoUsuario);
	List<Bono> findByNick(Connection connection, String nick);
 	int insertBonoUsuario(Connection connection, Bono bonoUsuario);
	int borrarBonoUsuario(Connection connection, Bono bonoUsuario);
	List<Bono> findByTipo(Connection connection, String tipo);
	Bono findById(Connection connection, int id);
}
