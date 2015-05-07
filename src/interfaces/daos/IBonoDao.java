package interfaces.daos;

import java.sql.Connection;
import java.util.List;

import transfers.Bono;

public interface IBonoDao {

	List<Bono> findByTipo(Connection connection, String tipo);
	int insertBono(Connection connection, Bono bono);
	int borrarBono(Connection connection, int id);
	Bono findById(Connection connection, int id);
}
