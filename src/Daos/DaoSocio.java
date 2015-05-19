package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import transfers.Socio;
import transfers.TransferException;
import interfaces.daos.ISocioDao;

public class DaoSocio implements ISocioDao{

	private Socio fillSocio(ResultSet objetoEncontrado){
		Socio socio = new Socio();
		try {
			socio.setApellidos(objetoEncontrado.getString("apellido"));
			socio.setDireccion(objetoEncontrado.getString("direccion"));
			socio.setDNI(objetoEncontrado.getString("DNI"));
			socio.setEmail(objetoEncontrado.getString("email"));
			socio.setNombre(objetoEncontrado.getString("nombre"));
			socio.setPass(objetoEncontrado.getString("pass"));
			socio.setSexo(objetoEncontrado.getString("sexo"));
			socio.setTelefono(objetoEncontrado.getString("tlf"));
			socio.setNick(objetoEncontrado.getString("nick"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return socio;
	}
	
	@Override
	public List<Socio> findByName(Connection connection, String nombre) {
		// TODO Auto-generated method stub
		Socio SocioName=null;
		List<Socio> SocioList=new ArrayList<Socio>();
		PreparedStatement buscarName=null;
		ResultSet objetoEncontrado=null;
		try{
			buscarName=connection.prepareStatement("select * from Socio where nombre like ?");
			//asociamos el valor que queremos buscar
			buscarName.setString(1,nombre);
			//ejecutamos la consulta
			objetoEncontrado=buscarName.executeQuery();
			while (objetoEncontrado.next()){
			   SocioName=fillSocio(objetoEncontrado);
			   SocioList.add(SocioName);
			}
		} catch (TransferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e){
			//	throw new DaoException("Error en la busqueda de ...", e)
		}
		return SocioList;
	}

	@Override
	public int insertSocio(Connection connection, Socio socio) {
		// TODO Auto-generated method stub
		PreparedStatement insertSocio=null;
		int result=0;
		try{
			insertSocio=connection.prepareStatement("INSERT INTO usuario"
					+ "(nombre, apellido, tlf,"
					+ " DNI, Pass, nick, sexo, email, direccion) VALUES"
					+ " (?,?,?,?,?,?,?,?,?)");
			//asociamos el valor que queremos buscar
			insertSocio.setString(1, socio.getNombre());
			insertSocio.setString(2, socio.getApellidos());
			insertSocio.setString(3, socio.getTelefono());
			insertSocio.setString(4, socio.getDNI());
			insertSocio.setString(5, socio.getPass());
			insertSocio.setString(6, socio.getNick());
			insertSocio.setString(7, socio.getSexo().toString());
			insertSocio.setString(8, socio.getEmail());
			insertSocio.setString(9, socio.getDireccion());
			
			result=insertSocio.executeUpdate();
			connection.commit();
			
			insertSocio=connection.prepareStatement("INSERT INTO socio"
			+ "(nick) VALUES "
			+ "(?)");
			insertSocio.setString(1, socio.getNick());

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
	
	public int modificarSocio(Connection connection, Socio socio){
		PreparedStatement insertSocio=null;
		int result=0;
		try{
			insertSocio=connection.prepareStatement("UPDATE usuario "
					+ "SET nombre = ?, apellido = ?, tlf = ?,"
					+ " DNI = ?, Pass = ?, sexo = ?, email = ?, direccion = ?"
					+ " WHERE nick = ?");
			//asociamos el valor que queremos buscar
			insertSocio.setString(1, socio.getNombre());
			insertSocio.setString(2, socio.getApellidos());
			insertSocio.setString(3, socio.getTelefono());
			insertSocio.setString(4, socio.getDNI());
			insertSocio.setString(5, socio.getPass());
			insertSocio.setString(6, socio.getSexo().toString());
			insertSocio.setString(7, socio.getEmail());
			insertSocio.setString(8, socio.getDireccion());
			insertSocio.setString(9, socio.getNick());
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
	public int borrarSocio(Connection connection, String nick) {
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
	public Socio findByNick(Connection connection, String nick) {
		// TODO Auto-generated method stub
		Socio socio=null;
		PreparedStatement buscarDNI=null;
		ResultSet objetoEncontrado=null;
		try{
			buscarDNI=connection.prepareStatement(""
					+"select * "
					+ "from usuario "
					+ "natural join socio "
					+ "where nick = ?");
			//asociamos el valor que queremos buscar
			buscarDNI.setString(1, nick);
			//ejecutamos la consulta
			objetoEncontrado=buscarDNI.executeQuery();
			if (objetoEncontrado.next())
				socio=fillSocio(objetoEncontrado);
		} catch (TransferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e){
			//	throw new DaoException("Error en la busqueda de ...", e)
		}
		return socio;
	}

}
