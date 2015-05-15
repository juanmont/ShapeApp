package interfaces.daos;

import java.sql.Connection;
import java.util.List;

import transfers.Instalaciones;

public interface IInstalacionesDao {

	List<Instalaciones> findByTipo(Connection connection, String tipo);
	int insertInstalacion(Connection connection, Instalaciones instalacion);
	int borrarInstalacion(Connection connection, int numero);
	Instalaciones findByNumero(Connection connection, int numero);
	int modificarInstalacion(Connection connection, Instalaciones instalacion);
}
