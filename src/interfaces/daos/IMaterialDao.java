package interfaces.daos;

import java.sql.Connection;
import java.util.List;

import transfers.Material;

public interface IMaterialDao {
	
	public Material findById(Connection connection, int id);
	List<Material> findByTipo(Connection connection, String categoria);
	int insertMaterial(Connection connection, Material material);
	int borrarMaterial(Connection connection, int id);
	
}
