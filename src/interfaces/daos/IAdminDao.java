package interfaces.daos;

import java.sql.Connection;
import java.util.List;

import transfers.Admin;

public interface IAdminDao {

	List<Admin> findByName(Connection connection, String nombre);
	int insertAdmin(Connection connection, Admin admin);
	int borrarAdmin(Connection connection, String nick);
	Admin findByNick(Connection connection, String nick);
	int modificarAdmin(Connection connection, Admin admin);
}
