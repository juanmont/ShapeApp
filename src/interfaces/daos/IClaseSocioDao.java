package interfaces.daos;

import java.sql.Connection;
import java.util.List;

import transfers.ClaseSocio;

public interface IClaseSocioDao {

	List<ClaseSocio> findByNick(Connection connection, String nick);
	int insertClaseSocio(Connection connection, ClaseSocio claseSocio);
	int borrarClaseSocio(Connection connection, ClaseSocio claseSocio);
	ClaseSocio findById(Connection connection, ClaseSocio claseSocio);
}
