package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import transfers.ClaseSocio;
import transfers.TransferException;
import interfaces.daos.IClaseSocioDao;

public class DaoClaseSocio implements IClaseSocioDao{

	private ClaseSocio fillClaseSocio(ResultSet objetoEncontrado){
		ClaseSocio clase = new ClaseSocio();
		try {
			clase.setId_clase(objetoEncontrado.getInt("id_clase"));
			clase.setNick(objetoEncontrado.getString("nick"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clase;
	}
	
	@Override
	public List<ClaseSocio> findByNick(Connection connection, String nick) {
		// TODO Auto-generated method stub
		ClaseSocio clase=null;
		List<ClaseSocio> claseList=new ArrayList<ClaseSocio>();
		PreparedStatement buscarName=null;
		ResultSet objetoEncontrado=null;
		try{
			buscarName=connection.prepareStatement("select * from clase_socio where nick like ?");
			//asociamos el valor que queremos buscar
			buscarName.setString(1,nick);
			//ejecutamos la consulta
			objetoEncontrado=buscarName.executeQuery();
			while (objetoEncontrado.next()){
				clase=fillClaseSocio(objetoEncontrado);
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
	public int insertClaseSocio(Connection connection, ClaseSocio clase) {
		// TODO Auto-generated method stub
		PreparedStatement insertClase=null;
		int result=0;
		try{
			insertClase=connection.prepareStatement("INSERT INTO clase_socio"
					+ "(id_clase, nick)"
					+ " VALUES (?,?)");
			//asociamos el valor que queremos buscar
			insertClase.setInt(1, clase.getId_clase());
			insertClase.setString(2, clase.getNick());
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
	public int borrarClaseSocio(Connection connection, ClaseSocio claseSocio) {
		// TODO Auto-generated method stub
		PreparedStatement borrarClase=null;
		int result=0;
		try{
			borrarClase=connection.prepareStatement(""
					+ "delete from clase_socio "
					+ "where id_clase = ? AND nick = ?");
			//asociamos el valor que queremos buscar
			borrarClase.setInt(1, claseSocio.getId_clase());
			borrarClase.setString(2, claseSocio.getNick());
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
	public ClaseSocio findById(Connection connection, ClaseSocio claseSocio) {
		// TODO Auto-generated method stub
		ClaseSocio clase=null;
		PreparedStatement buscarID=null;
		ResultSet objetoEncontrado=null;
		try{
			buscarID=connection.prepareStatement(""
					+"select * "
					+ "from clase_socio "
					+ "where id_clase = ? AND nick = ?");
			//asociamos el valor que queremos buscar
			buscarID.setInt(1, claseSocio.getId_clase());
			buscarID.setString(2, claseSocio.getNick());
			//ejecutamos la consulta
			objetoEncontrado=buscarID.executeQuery();
			if (objetoEncontrado.next())
				clase=fillClaseSocio(objetoEncontrado);
		} catch (TransferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e){
			//	throw new DaoException("Error en la busqueda de ...", e)
		}
		return clase;
	}

}
