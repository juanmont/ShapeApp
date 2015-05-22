package interfaces.daos;

import java.sql.Connection;
import java.util.List;

import transfers.Bono;

public interface IBonoDao {
	
	List<Bono> findAll(Connection connection);
	List<Bono> findByTipo(Connection connection, String tipo);
	Bono findById(Connection connection, int id);
	Bono findByNickAndBono(Connection connection, Bono bono);
	int borrarBonoUsuario(Connection connection, Bono bonoUsuario);
	int insertBonoUsuario(Connection connection, Bono bono);
}
