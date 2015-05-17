package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import transfers.Admin;
import transfers.TransferException;
import interfaces.daos.IAdminDao;

public class DaoAdmin implements IAdminDao{

	private Admin fillAdmin(ResultSet objetoEncontrado){
		Admin admin = new Admin();
		try {
			admin.setApellidos(objetoEncontrado.getString("apellido"));
			admin.setDireccion(objetoEncontrado.getString("direccion"));
			admin.setDNI(objetoEncontrado.getString("DNI"));
			admin.setEmail(objetoEncontrado.getString("email"));
			admin.setNombre(objetoEncontrado.getString("nombre"));
			admin.setPass(objetoEncontrado.getString("pass"));
			admin.setSexo(objetoEncontrado.getString("sexo"));
			admin.setTelefono(objetoEncontrado.getString("tlf"));
			admin.setNick(objetoEncontrado.getString("nick"));
			admin.setHoraEntrada(objetoEncontrado.getString("entrada"));
			admin.setHoraSalida(objetoEncontrado.getString("salida"));
			admin.setSueldo(objetoEncontrado.getDouble("sueldo"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;
	}
	
	@Override
	public List<Admin> findByName(Connection connection, String nombre) {
		// TODO Auto-generated method stub
		Admin admin=null;
		List<Admin> adminList=new ArrayList<Admin>();
		PreparedStatement buscarName=null;
		ResultSet objetoEncontrado=null;
		try{
			buscarName=connection.prepareStatement("select * from admin where nombre like ?");
			//asociamos el valor que queremos buscar
			buscarName.setString(1,nombre);
			//ejecutamos la consulta
			objetoEncontrado=buscarName.executeQuery();
			while (objetoEncontrado.next()){
			   admin=fillAdmin(objetoEncontrado);
			   adminList.add(admin);
			}
		} catch (TransferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e){
			//	throw new DaoException("Error en la busqueda de ...", e)
		}
		return adminList;
	}
	
	public int modificarAdmin(Connection connection, Admin admin){
		PreparedStatement updateUsuario=null;
		PreparedStatement updateAdmin=null;
		int result=0;
		try{
			updateUsuario=connection.prepareStatement("UPDATE usuario "
					+ "SET nombre = ?, apellido = ?, tlf = ?,"
					+ " DNI = ?, Pass = ?, sexo = ?, email = ?, direccion = ?"
					+ " WHERE nick = ?");
			//asociamos el valor que queremos buscar
			updateUsuario.setString(1, admin.getNombre());
			updateUsuario.setString(2, admin.getApellidos());
			updateUsuario.setString(3, admin.getTelefono());
			updateUsuario.setString(4, admin.getDNI());
			updateUsuario.setString(5, admin.getPass());
			updateUsuario.setString(6, admin.getSexo().toString());
			updateUsuario.setString(7, admin.getEmail());
			updateUsuario.setString(8, admin.getDireccion());
			updateUsuario.setString(9, admin.getNick());
			result=updateUsuario.executeUpdate();
			connection.commit();
			updateAdmin=connection.prepareStatement("UPDATE admin "
					+ "SET entrada = ?, salida = ?, sueldo = ? "
					+ "WHERE nick = ?");
			updateAdmin.setString(1, admin.getHoraEntrada());
			updateAdmin.setString(2, admin.getHoraSalida());
			updateAdmin.setDouble(3, admin.getSueldo());
			updateAdmin.setString(4, admin.getNick());
		} catch (TransferException e) {
			e.printStackTrace();
		}catch(SQLException e){
			//throw new DaoException("Error en la Insercion");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insertAdmin(Connection connection, Admin admin) {
		// TODO Auto-generated method stub
		PreparedStatement insertSocio=null;
		int result=0;
		try{
			insertSocio=connection.prepareStatement("INSERT INTO usuario"
					+ "(nombre, apellido, tlf,"
					+ " DNI, Pass, nick, sexo, email, direccion) VALUES"
					+ " (?,?,?,?,?,?,?,?,?)");
			//asociamos el valor que queremos buscar
			insertSocio.setString(1, admin.getNombre());
			insertSocio.setString(2, admin.getApellidos());
			insertSocio.setString(3, admin.getTelefono());
			insertSocio.setString(4, admin.getDNI());
			insertSocio.setString(5, admin.getPass());
			insertSocio.setString(6, admin.getNick());
			insertSocio.setString(7, admin.getSexo().toString());
			insertSocio.setString(8, admin.getEmail());
			insertSocio.setString(9, admin.getDireccion());
			
			result=insertSocio.executeUpdate();
			connection.commit();
			
			insertSocio=connection.prepareStatement("INSERT INTO admin"
			+ "(nick, entrada, salida, sueldo) VALUES "
			+ "(?,?,?,?)");
			insertSocio.setString(1, admin.getNick());
			insertSocio.setString(2, admin.getHoraEntrada());
			insertSocio.setString(3, admin.getHoraSalida());
			insertSocio.setDouble(4, admin.getSueldo());
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
	public int borrarAdmin(Connection connection, String nick) {
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
	public Admin findByNick(Connection connection, String nick) {
		// TODO Auto-generated method stub
		Admin admin=null;
		PreparedStatement buscarDNI=null;
		ResultSet objetoEncontrado=null;
		try{
			buscarDNI=connection.prepareStatement(""
					+"select * "
					+ "from usuario "
					+ "natural join admin "
					+ "where nick = ?");
			//asociamos el valor que queremos buscar
			buscarDNI.setString(1, nick);
			//ejecutamos la consulta
			objetoEncontrado=buscarDNI.executeQuery();
			if (objetoEncontrado.next())
				admin=fillAdmin(objetoEncontrado);
		} catch (TransferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e){
			//	throw new DaoException("Error en la busqueda de ...", e)
		}
		return admin;
	}

}
