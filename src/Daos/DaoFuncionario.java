package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import transfers.Funcionario;
import transfers.TransferException;
import interfaces.daos.IFuncionarioDao;

public class DaoFuncionario implements IFuncionarioDao{

	private Funcionario fillAdmin(ResultSet objetoEncontrado){
		Funcionario admin = new Funcionario();
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
	public List<Funcionario> findByName(Connection connection, String nombre) {
		// TODO Auto-generated method stub
		Funcionario admin=null;
		List<Funcionario> adminList=new ArrayList<Funcionario>();
		PreparedStatement buscarName=null;
		ResultSet objetoEncontrado=null;
		try{
			buscarName=connection.prepareStatement("select * from funcionario where nombre like ?");
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

	@Override
	public int insertAdmin(Connection connection, Funcionario admin) {
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
			
			insertSocio=connection.prepareStatement("INSERT INTO funcionario"
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
	
	public int modificarFuncionario(Connection connection, Funcionario funcionario){
		PreparedStatement updateUsuario=null;
		PreparedStatement updateAdmin=null;
		int result=0;
		try{
			updateUsuario=connection.prepareStatement("UPDATE usuario "
					+ "SET nombre = ?, apellido = ?, tlf = ?,"
					+ " DNI = ?, Pass = ?, sexo = ?, email = ?, direccion = ?"
					+ " WHERE nick = ?");
			//asociamos el valor que queremos buscar
			updateUsuario.setString(1, funcionario.getNombre());
			updateUsuario.setString(2, funcionario.getApellidos());
			updateUsuario.setString(3, funcionario.getTelefono());
			updateUsuario.setString(4, funcionario.getDNI());
			updateUsuario.setString(5, funcionario.getPass());
			updateUsuario.setString(6, funcionario.getSexo().toString());
			updateUsuario.setString(7, funcionario.getEmail());
			updateUsuario.setString(8, funcionario.getDireccion());
			updateUsuario.setString(9, funcionario.getNick());
			result=updateUsuario.executeUpdate();
			connection.commit();
			updateAdmin=connection.prepareStatement("UPDATE funcionario "
					+ "SET entrada = ?, salida = ?, sueldo = ? "
					+ "WHERE nick = ?");
			updateAdmin.setString(1, funcionario.getHoraEntrada());
			updateAdmin.setString(2, funcionario.getHoraSalida());
			updateAdmin.setDouble(3, funcionario.getSueldo());
			updateAdmin.setString(4, funcionario.getNick());
		} catch (TransferException e) {
			e.printStackTrace();
		}catch(SQLException e){
			//throw new DaoException("Error en la Insercion");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Funcionario findByNick(Connection connection, String nick) {
		// TODO Auto-generated method stub
		Funcionario admin=null;
		PreparedStatement buscarDNI=null;
		ResultSet objetoEncontrado=null;
		try{
			buscarDNI=connection.prepareStatement(""
					+"select * "
					+ "from usuario "
					+ "natural join funcionario "
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
