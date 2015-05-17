package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import transfers.Clases;
import transfers.TransferException;
import interfaces.daos.IClaseDao;

public class DaoClase implements IClaseDao{

	private Clases fillClase(ResultSet objetoEncontrado){
		Clases clase = new Clases();
		try {
			clase.setId(objetoEncontrado.getInt("id"));
			clase.setIdEntrenador(objetoEncontrado.getString("id_entrenador"));
			clase.setTipo(objetoEncontrado.getString("clase"));
			clase.setClase(objetoEncontrado.getString("tipo"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clase;
	}
	
	@Override
	public List<Clases> findByCategoria(Connection connection, String categoria) {
		// TODO Auto-generated method stub
		Clases clase=null;
		List<Clases> claseList=new ArrayList<Clases>();
		PreparedStatement buscarName=null;
		ResultSet objetoEncontrado=null;
		try{
			buscarName=connection.prepareStatement("select * from clase where clase like ?");
			//asociamos el valor que queremos buscar
			buscarName.setString(1,categoria);
			//ejecutamos la consulta
			objetoEncontrado=buscarName.executeQuery();
			while (objetoEncontrado.next()){
				clase=fillClase(objetoEncontrado);
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
	public int insertClase(Connection connection, Clases clase) {
		// TODO Auto-generated method stub
		PreparedStatement insertClase=null;
		int result=0;
		try{
			insertClase=connection.prepareStatement("INSERT INTO clase"
					+ "(id_entrenador, id, clase, tipo)"
					+ " VALUES (?,?,?,?)");
			//asociamos el valor que queremos buscar
			insertClase.setString(1, clase.getIdEntrenador());
			insertClase.setInt(2, clase.getId());
			insertClase.setString(3, clase.getTipo().toString());
			insertClase.setString(4, clase.getClase().toString());
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
	public int borrarClase(Connection connection, String id) {
		// TODO Auto-generated method stub
		PreparedStatement borrarClase=null;
		int result=0;
		try{
			borrarClase=connection.prepareStatement(""
					+ "delete from clase "
					+ "where id = ?");
			//asociamos el valor que queremos buscar
			borrarClase.setString(1, id);
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
	public Clases findById(Connection connection, int id) {
		// TODO Auto-generated method stub
		Clases clase=null;
		PreparedStatement buscarID=null;
		ResultSet objetoEncontrado=null;
		try{
			buscarID=connection.prepareStatement(""
					+"select * "
					+ "from clase "
					+ "where id = ?");
			//asociamos el valor que queremos buscar
			buscarID.setInt(1, id);
			//ejecutamos la consulta
			objetoEncontrado=buscarID.executeQuery();
			if (objetoEncontrado.next())
				clase=fillClase(objetoEncontrado);
		} catch (TransferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e){
			//	throw new DaoException("Error en la busqueda de ...", e)
		}
		return clase;
	}

}
