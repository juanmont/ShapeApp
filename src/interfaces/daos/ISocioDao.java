package interfaces.daos;

import java.sql.Connection;
import java.util.List;

import transfers.Socio;

public interface ISocioDao {

	List<Socio> findByName(Connection connection, String nombre);
	int insertSocio(Connection connection, Socio Socio);
	int borrarSocio(Connection connection, String nick);
	Socio findByNick(Connection connection, String nick);
}
