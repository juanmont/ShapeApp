package interfaces.daos;

import java.sql.Connection;
import java.util.List;

import transfers.Clases;

public interface IClaseDao {

	List<Clases> findByCategoria(Connection connection, String categoria);
	int insertClase(Connection connection, Clases clase);
	int borrarClase(Connection connection, String id);
	Clases findById(Connection connection, int id);
}
