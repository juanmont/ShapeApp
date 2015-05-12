package interfaces.daos;

import java.sql.Connection;
import java.util.List;

import transfers.MaterialUsuario;

public interface IMaterialUsuarioDao {
	
	public MaterialUsuario findByFechaAndID(Connection connection, MaterialUsuario materialUsuario);
	List<MaterialUsuario> findByNick(Connection connection, String nick);
	List<MaterialUsuario> findByMaterial(Connection connection, int material);
 	int insertMaterialUsuario(Connection connection, MaterialUsuario materialUsuario);
	int borrarMaterialUsuario(Connection connection, MaterialUsuario materialUsuario);
	
}
