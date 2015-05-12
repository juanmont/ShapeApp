package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import transfers.BonoUsuario;
import transfers.TransferException;
import interfaces.daos.IBonoUsuarioDao;

public class DaoBonoUsuario implements IBonoUsuarioDao{

	private BonoUsuario fillClaseSocio(ResultSet objetoEncontrado){
		BonoUsuario bonoUsuario = new BonoUsuario();
		try {
			bonoUsuario.setBonoId(objetoEncontrado.getInt("id"));
			bonoUsuario.setNick(objetoEncontrado.getString("nick"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bonoUsuario;
	}
	
	@Override
	public List<BonoUsuario> findByNick(Connection connection, String nick) {
		// TODO Auto-generated method stub
		BonoUsuario clase=null;
		List<BonoUsuario> claseList=new ArrayList<BonoUsuario>();
		PreparedStatement buscarName=null;
		ResultSet objetoEncontrado=null;
		try{
			buscarName=connection.prepareStatement("select * from usuario_bono where nick like ?");
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
	public int insertBonoUsuario(Connection connection, BonoUsuario bono) {
		// TODO Auto-generated method stub
		PreparedStatement insertClase=null;
		int result=0;
		try{
			insertClase=connection.prepareStatement("INSERT INTO usuario_bono"
					+ "(id, nick)"
					+ " VALUES (?,?)");
			//asociamos el valor que queremos buscar
			insertClase.setInt(1, bono.getBonoId());
			insertClase.setString(2, bono.getNick());
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
	public int borrarBonoUsuario(Connection connection, BonoUsuario bonoUsuario) {
		// TODO Auto-generated method stub
		PreparedStatement borrarClase=null;
		int result=0;
		try{
			borrarClase=connection.prepareStatement(""
					+ "delete from usuario_bono "
					+ "where id = ? AND nick = ?");
			//asociamos el valor que queremos buscar
			borrarClase.setInt(1, bonoUsuario.getBonoId());
			borrarClase.setString(2, bonoUsuario.getNick());
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
	public BonoUsuario findByNickAndBono(Connection connection, BonoUsuario claseSocio) {
		// TODO Auto-generated method stub
		BonoUsuario clase=null;
		PreparedStatement buscarID=null;
		ResultSet objetoEncontrado=null;
		try{
			buscarID=connection.prepareStatement(""
					+"select * "
					+ "from clase_socio "
					+ "where id_clase = ? AND nick = ?");
			//asociamos el valor que queremos buscar
			buscarID.setInt(1, claseSocio.getBonoId());
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
