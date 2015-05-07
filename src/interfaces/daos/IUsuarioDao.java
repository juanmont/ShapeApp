package interfaces.daos;

import java.sql.Connection;
import java.util.List;

import transfers.Usuario;

public interface IUsuarioDao {
	
	List<Usuario> findByName(Connection connection, String nombre);
	int insertUsuario(Connection connection, Usuario Usuario);
	int borrarUsuario(Connection connection, Usuario usuario);
	Usuario findByNick(Connection connection, String nick);
}
