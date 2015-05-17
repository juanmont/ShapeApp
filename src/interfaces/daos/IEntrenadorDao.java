package interfaces.daos;

import java.sql.Connection;
import java.util.List;

import transfers.Entrenador;

public interface IEntrenadorDao {

	List<Entrenador> findByName(Connection connection, String nombre);
	int insertEntrenador(Connection connection, Entrenador entrenador);
	int borrarEntrenador(Connection connection, String nick);
	Entrenador findByNick(Connection connection, String nick);
	int modificarEntrenador(Connection connection, Entrenador entrenador);
}
