package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import transfers.InstalacionUsuario;
import transfers.TransferException;
import interfaces.daos.IInstalacionUsuarioDao;

public class DaoInstalacionUsuario implements IInstalacionUsuarioDao{

	private InstalacionUsuario fillMaterialUsuario(ResultSet objetoEncontrado){
		InstalacionUsuario instalacionUsuario = new InstalacionUsuario();
		try {
			instalacionUsuario.setDia(objetoEncontrado.getDate("dia"));
			instalacionUsuario.setIdClase(objetoEncontrado.getInt("id_clase"));
			instalacionUsuario.setNick(objetoEncontrado.getString("nick"));
			instalacionUsuario.setNumInstalacion(objetoEncontrado.getInt("instalacion"));
			instalacionUsuario.setHorario(objetoEncontrado.getInt("horario"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return instalacionUsuario;
	}
	
	
	@Override
	public List<InstalacionUsuario> findByNick(Connection connection, String nick) {
		// TODO Auto-generated method stub
		InstalacionUsuario clase=null;
		List<InstalacionUsuario> claseList=new ArrayList<InstalacionUsuario>();
		PreparedStatement buscarName=null;
		ResultSet objetoEncontrado=null;
		try{
			buscarName=connection.prepareStatement("select * from instalacion_usuario where nick like ?");
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
	public int insertInstalacionUsuario(Connection connection, InstalacionUsuario instalacionUsuario) {
		// TODO Auto-generated method stub
		PreparedStatement insertClase=null;
		int result=0;
		try{
			insertClase=connection.prepareStatement("INSERT INTO instalacion_usuario"
					+ "(id_clase, dia, horario, nick, instalacion)"
					+ " VALUES (?,?,?)");
			//asociamos el valor que queremos buscar
			insertClase.setInt(1, instalacionUsuario.getIdClase());
			insertClase.setDate(2, instalacionUsuario.getDia());
			insertClase.setInt(3, instalacionUsuario.getHorario());
			insertClase.setString(4, instalacionUsuario.getNick());
			insertClase.setInt(5, instalacionUsuario.getNumInstalacion());
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
	public int borrarInstalacionUsuario(Connection connection, InstalacionUsuario instalacionUsuario) {
		// TODO Auto-generated method stub
		PreparedStatement borrarClase=null;
		int result=0;
		try{
			borrarClase=connection.prepareStatement(""
					+ "delete from instalacion_usuario "
					+ "where instalacion = ? AND dia = ? AND horario = ?");
			//asociamos el valor que queremos buscar
			borrarClase.setInt(1, instalacionUsuario.getNumInstalacion());
			borrarClase.setDate(2, instalacionUsuario.getDia());
			borrarClase.setInt(3, instalacionUsuario.getHorario());
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
	public InstalacionUsuario findByFechaAndID(Connection connection, InstalacionUsuario instalacionUsuario) {
		// TODO Auto-generated method stub
		InstalacionUsuario clase=null;
		PreparedStatement buscarID=null;
		ResultSet objetoEncontrado=null;
		try{
			buscarID=connection.prepareStatement(""
					+"select * "
					+ "from instalacion_usuario "
					+ "where instalacion = ? AND dia = ? AND horario = ?");
			//asociamos el valor que queremos buscar
			buscarID.setInt(1, instalacionUsuario.getNumInstalacion());
			buscarID.setDate(2, instalacionUsuario.getDia());
			buscarID.setInt(3, instalacionUsuario.getHorario());
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
	public List<InstalacionUsuario> findByInstalacion(Connection connection,
			int instalacion) {
		// TODO Auto-generated method stub
		InstalacionUsuario clase=null;
		List<InstalacionUsuario> claseList=new ArrayList<InstalacionUsuario>();
		PreparedStatement buscarName=null;
		ResultSet objetoEncontrado=null;
		try{
			buscarName=connection.prepareStatement("select * from instalacion_usuario where instalacion like ?");
			//asociamos el valor que queremos buscar
			buscarName.setInt(1,instalacion);
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
