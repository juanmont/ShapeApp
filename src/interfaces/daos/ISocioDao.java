package interfaces.daos;

import java.sql.Connection;
import java.util.List;

import transfers.Socio;

public interface ISocioDao {

	public List<Socio> findAll(Connection connection);
	List<Socio> findByName(Connection connection, String nombre);
	int insertSocio(Connection connection, Socio Socio);
	int borrarSocio(Connection connection, String nick);
	Socio findByNick(Connection connection, String nick);
	public int modificarSocio(Connection connection, Socio socio);
}
