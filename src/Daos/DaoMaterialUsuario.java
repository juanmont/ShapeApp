package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import transfers.MaterialUsuario;
import transfers.TransferException;
import interfaces.daos.IMaterialUsuarioDao;

public class DaoMaterialUsuario implements IMaterialUsuarioDao{

	private MaterialUsuario fillMaterialUsuario(ResultSet objetoEncontrado){
		MaterialUsuario materialUsuario = new MaterialUsuario();
		try {
			materialUsuario.setDia(objetoEncontrado.getDate("dia"));
			materialUsuario.setIdCliente(objetoEncontrado.getString("nick"));
			materialUsuario.setIdMateriales(objetoEncontrado.getInt("id_materiales"));
			materialUsuario.setHorario(objetoEncontrado.getInt("horario"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return materialUsuario;
	}
	
	@Override
	public List<MaterialUsuario> findByNick(Connection connection, String nick) {
		// TODO Auto-generated method stub
		MaterialUsuario clase=null;
		List<MaterialUsuario> claseList=new ArrayList<MaterialUsuario>();
		PreparedStatement buscarName=null;
		ResultSet objetoEncontrado=null;
		try{
			buscarName=connection.prepareStatement("select * from material_usuario where nick like ?");
			//asociamos el valor que queremos buscar
			buscarName.setString(1,nick);
			//ejecutamos la consulta
			objetoEncontrado=buscarName.executeQuery();
			while (objetoEncontrado.next()){
				clase=fillMaterialUsuario(objetoEncontrado);
				claseList.add(clase);
			}
		} catch (TransferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e){
			//	throw new DaoException("Error en la busqueda de ...", e)
		}
		return claseList;
	}

	@Override
	public int insertMaterialUsuario(Connection connection, MaterialUsuario materialUsuario) {
		// TODO Auto-generated method stub
		PreparedStatement insertClase=null;
		int result=0;
		try{
			insertClase=connection.prepareStatement("INSERT INTO material_usuario"
					+ "(id_materiales, dia, horario, nick)"
					+ " VALUES (?,?,?,?)");
			//asociamos el valor que queremos buscar
			insertClase.setInt(1, materialUsuario.getIdMateriales());
			insertClase.setDate(2, materialUsuario.getDia());
			insertClase.setInt(3, materialUsuario.getHorario());
			insertClase.setString(4, materialUsuario.getIdCliente());
			result=insertClase.executeUpdate();
			connection.commit();
		} catch (TransferException e) {
			e.printStackTrace();
		}catch(SQLException e){
			//throw new DaoException("Error en la Insercion");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int borrarMaterialUsuario(Connection connection, MaterialUsuario materialUsuario) {
		// TODO Auto-generated method stub
		PreparedStatement borrarClase=null;
		int result=0;
		try{
			borrarClase=connection.prepareStatement(""
					+ "delete from material_usuario "
					+ "where id_materiales = ? AND dia = ? AND horario = ?");
			//asociamos el valor que queremos buscar
			borrarClase.setInt(1, materialUsuario.getIdMateriales());
			borrarClase.setDate(2, materialUsuario.getDia());
			borrarClase.setInt(3, materialUsuario.getHorario());
			//ejecutamos la consulta
			result=borrarClase.executeUpdate();
			connection.commit();
		} catch (TransferException e) {
			e.printStackTrace();
		}catch(SQLException e){
			//throw new DaoException("Error en la Insercion");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public MaterialUsuario findByFechaAndID(Connection connection, MaterialUsuario materialUsuario) {
		// TODO Auto-generated method stub
		MaterialUsuario clase=null;
		PreparedStatement buscarID=null;
		ResultSet objetoEncontrado=null;
		try{
			buscarID=connection.prepareStatement(""
					+"select * "
					+ "from material_usuario "
					+ "where id_materiales = ? AND dia = ? AND horario = ?");
			//asociamos el valor que queremos buscar
			buscarID.setInt(1, materialUsuario.getIdMateriales());
			buscarID.setDate(2, materialUsuario.getDia());
			buscarID.setInt(3, materialUsuario.getHorario());
			//ejecutamos la consulta
			objetoEncontrado=buscarID.executeQuery();
			if (objetoEncontrado.next())
				clase=fillMaterialUsuario(objetoEncontrado);
		} catch (TransferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e){
			//	throw new DaoException("Error en la busqueda de ...", e)
		}
		return clase;
	}

	@Override
	public List<MaterialUsuario> findByMaterial(Connection connection,
			int material) {
		// TODO Auto-generated method stub
		MaterialUsuario clase=null;
		List<MaterialUsuario> claseList=new ArrayList<MaterialUsuario>();
		PreparedStatement buscarName=null;
		ResultSet objetoEncontrado=null;
		try{
			buscarName=connection.prepareStatement("select * from material_usuario where id_materiales like ?");
			//asociamos el valor que queremos buscar
			buscarName.setInt(1,material);
			//ejecutamos la consulta
			objetoEncontrado=buscarName.executeQuery();
			while (objetoEncontrado.next()){
				clase=fillMaterialUsuario(objetoEncontrado);
				claseList.add(clase);
			}
		} catch (TransferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e){
			//	throw new DaoException("Error en la busqueda de ...", e)
		}
		return claseList;
	}

}
