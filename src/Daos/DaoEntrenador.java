package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import transfers.Entrenador;
import transfers.TransferException;
import interfaces.daos.IEntrenadorDao;

public class DaoEntrenador implements IEntrenadorDao{

	private Entrenador fillEntrenador(ResultSet objetoEncontrado){
		Entrenador entrenador = new Entrenador();
		try {
			entrenador.setApellidos(objetoEncontrado.getString("apellido"));
			entrenador.setDireccion(objetoEncontrado.getString("direccion"));
			entrenador.setDNI(objetoEncontrado.getString("DNI"));
			entrenador.setEmail(objetoEncontrado.getString("email"));
			entrenador.setNombre(objetoEncontrado.getString("nombre"));
			entrenador.setPass(objetoEncontrado.getString("pass"));
			entrenador.setSexo(objetoEncontrado.getString("sexo"));
			entrenador.setTelefono(objetoEncontrado.getString("tlf"));
			entrenador.setNick(objetoEncontrado.getString("nick"));
			entrenador.setHoraEntrada(objetoEncontrado.getString("entrada"));
			entrenador.setHoraSalida(objetoEncontrado.getString("salida"));
			entrenador.setSueldo(objetoEncontrado.getDouble("sueldo"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entrenador;
	}
	
	@Override
	public List<Entrenador> findByName(Connection connection, String nombre) {
		// TODO Auto-generated method stub
		Entrenador entrenador=null;
		List<Entrenador> entrenadorList=new ArrayList<Entrenador>();
		PreparedStatement buscarName=null;
		ResultSet objetoEncontrado=null;
		try{
			buscarName=connection.prepareStatement("select * from entrenador where nombre like ?");
			//asociamos el valor que queremos buscar
			buscarName.setString(1,nombre);
			//ejecutamos la consulta
			objetoEncontrado=buscarName.executeQuery();
			while (objetoEncontrado.next()){
			   entrenador=fillEntrenador(objetoEncontrado);
			   entrenadorList.add(entrenador);
			}
		} catch (TransferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e){
			//	throw new DaoException("Error en la busqueda de ...", e)
		}
		return entrenadorList;
	}
	
	public int modificarEntrenador(Connection connection, Entrenador entrenador){
		PreparedStatement updateUsuario=null;
		PreparedStatement updateAdmin=null;
		int result=0;
		try{
			updateUsuario=connection.prepareStatement("UPDATE usuario "
					+ "SET nombre = ?, apellido = ?, tlf = ?,"
					+ " DNI = ?, Pass = ?, sexo = ?, email = ?, direccion = ?"
					+ " WHERE nick = ?");
			//asociamos el valor que queremos buscar
			updateUsuario.setString(1, entrenador.getNombre());
			updateUsuario.setString(2, entrenador.getApellidos());
			updateUsuario.setString(3, entrenador.getTelefono());
			updateUsuario.setString(4, entrenador.getDNI());
			updateUsuario.setString(5, entrenador.getPass());
			updateUsuario.setString(6, entrenador.getSexo().toString());
			updateUsuario.setString(7, entrenador.getEmail());
			updateUsuario.setString(8, entrenador.getDireccion());
			updateUsuario.setString(9, entrenador.getNick());
			result=updateUsuario.executeUpdate();
			connection.commit();
			updateAdmin=connection.prepareStatement("UPDATE entrenador "
					+ "SET entrada = ?, salida = ?, sueldo = ? "
					+ "WHERE nick = ?");
			updateAdmin.setString(1, entrenador.getHoraEntrada());
			updateAdmin.setString(2, entrenador.getHoraSalida());
			updateAdmin.setDouble(3, entrenador.getSueldo());
			updateAdmin.setString(4, entrenador.getNick());
		} catch (TransferException e) {
			e.printStackTrace();
		}catch(SQLException e){
			//throw new DaoException("Error en la Insercion");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insertEntrenador(Connection connection, Entrenador entrenador) {
		// TODO Auto-generated method stub
		PreparedStatement insertSocio=null;
		int result=0;
		try{
			insertSocio=connection.prepareStatement("INSERT INTO usuario"
					+ "(nombre, apellido, tlf,"
					+ " DNI, Pass, nick, sexo, email, direccion) VALUES"
					+ " (?,?,?,?,?,?,?,?,?)");
			//asociamos el valor que queremos buscar
			insertSocio.setString(1, entrenador.getNombre());
			insertSocio.setString(2, entrenador.getApellidos());
			insertSocio.setString(3, entrenador.getTelefono());
			insertSocio.setString(4, entrenador.getDNI());
			insertSocio.setString(5, entrenador.getPass());
			insertSocio.setString(6, entrenador.getNick());
			insertSocio.setString(7, entrenador.getSexo().toString());
			insertSocio.setString(8, entrenador.getEmail());
			insertSocio.setString(9, entrenador.getDireccion());
			
			result=insertSocio.executeUpdate();
			connection.commit();
			
			insertSocio=connection.prepareStatement("INSERT INTO entrenador"
			+ "(nick, entrada, salida, sueldo) VALUES "
			+ "(?,?,?,?)");
			insertSocio.setString(1, entrenador.getNick());
			insertSocio.setString(2, entrenador.getHoraEntrada());
			insertSocio.setString(3, entrenador.getHoraSalida());
			insertSocio.setDouble(4, entrenador.getSueldo());
			//ejecutamos la consulta
			result=insertSocio.executeUpdate();
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
	public int borrarEntrenador(Connection connection, String nick) {
		// TODO Auto-generated method stub
		PreparedStatement borrarSocio=null;
		int result=0;
		try{
			borrarSocio=connection.prepareStatement(""
					+ "delete from usuario "
					+ "where nick = ?");
			//asociamos el valor que queremos buscar
			borrarSocio.setString(1, nick);
			//ejecutamos la consulta
			result=borrarSocio.executeUpdate();
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
	public Entrenador findByNick(Connection connection, String nick) {
		// TODO Auto-generated method stub
		Entrenador entrenador=null;
		PreparedStatement buscarDNI=null;
		ResultSet objetoEncontrado=null;
		try{
			buscarDNI=connection.prepareStatement(""
					+"select * "
					+ "from usuario "
					+ "natural join entrenador "
					+ "where nick = ?");
			//asociamos el valor que queremos buscar
			buscarDNI.setString(1, nick);
			//ejecutamos la consulta
			objetoEncontrado=buscarDNI.executeQuery();
			if (objetoEncontrado.next())
				entrenador=fillEntrenador(objetoEncontrado);
		} catch (TransferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e){
			//	throw new DaoException("Error en la busqueda de ...", e)
		}
		return entrenador;
	}

}
