package interfaces.daos;

import java.sql.Connection;
import java.util.List;

import transfers.InstalacionUsuario;

public interface IInstalacionUsuarioDao {
	
	public List<InstalacionUsuario> findByClase(Connection connection, int claseId);
	public InstalacionUsuario findByFechaAndID(Connection connection, InstalacionUsuario instalacionUsuario);
	List<InstalacionUsuario> findByNick(Connection connection, String nick);
	List<InstalacionUsuario> findByInstalacion(Connection connection, int instalacion);
 	int insertInstalacionUsuario(Connection connection, InstalacionUsuario instalacionUsuario);
	int borrarInstalacionUsuario(Connection connection, InstalacionUsuario instalacionUsuario);	
}
