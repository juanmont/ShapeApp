package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import transfers.Instalaciones;
import transfers.TransferException;
import interfaces.daos.IInstalacionesDao;

public class DaoInstalaciones implements IInstalacionesDao{

	private Instalaciones fillInstalacion(ResultSet objetoEncontrado){
		Instalaciones instalacion = new Instalaciones();
		try {
			instalacion.setNumero(objetoEncontrado.getInt("numero"));
			instalacion.setDisponibilidad(objetoEncontrado.getString("horario"));
			instalacion.setPista(objetoEncontrado.getString("pista"));
			instalacion.setTipo(objetoEncontrado.getString("tipo"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return instalacion;
	}
	
	public List<Instalaciones> findAll(Connection connection) {
		// TODO Auto-generated method stub
		Instalaciones clase=null;
		List<Instalaciones> claseList=new ArrayList<Instalaciones>();
		PreparedStatement buscarName=null;
		ResultSet objetoEncontrado=null;
		try{
			buscarName=connection.prepareStatement("select * from instalaciones");
			//ejecutamos la consulta
			objetoEncontrado=buscarName.executeQuery();
			while (objetoEncontrado.next()){
				clase=fillInstalacion(objetoEncontrado);
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
	public List<Instalaciones> findByTipo(Connection connection, String categoria) {
		// TODO Auto-generated method stub
		Instalaciones clase=null;
		List<Instalaciones> claseList=new ArrayList<Instalaciones>();
		PreparedStatement buscarName=null;
		ResultSet objetoEncontrado=null;
		try{
			buscarName=connection.prepareStatement("select * from instalaciones where tipo like ?");
			//asociamos el valor que queremos buscar
			buscarName.setString(1,categoria);
			//ejecutamos la consulta
			objetoEncontrado=buscarName.executeQuery();
			while (objetoEncontrado.next()){
				clase=fillInstalacion(objetoEncontrado);
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
	public int insertInstalacion(Connection connection, Instalaciones instalacion) {
		// TODO Auto-generated method stub
		PreparedStatement insertClase=null;
		int result=0;
		try{
			insertClase=connection.prepareStatement("INSERT INTO instalaciones"
					+ "(numero, pista, tipo, horario)"
					+ " VALUES (?,?,?,?)");
			//asociamos el valor que queremos buscar
			insertClase.setInt(1, instalacion.getNumero());
			insertClase.setString(2, instalacion.getPista().toString());
			insertClase.setString(3, instalacion.getTipo().toString());
			insertClase.setString(4, instalacion.getDisponibilidad().toString());
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
	
	public int modificarInstalacion(Connection connection, Instalaciones instalacion){
		PreparedStatement insertSocio=null;
		int result=0;
		try{
			insertSocio=connection.prepareStatement("UPDATE instalaciones "
					+ "SET pista = ?, tipo = ?, horario = ?"
					+ " WHERE numero = ?");
			//asociamos el valor que queremos buscar
			insertSocio.setString(1, instalacion.getPista().toString());
			insertSocio.setString(2, instalacion.getTipo().toString());
			insertSocio.setString(3, instalacion.getDisponibilidad().toString());
			insertSocio.setInt(4, instalacion.getNumero());
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
	public int borrarInstalacion(Connection connection, int numero) {
		// TODO Auto-generated method stub
		PreparedStatement borrarClase=null;
		int result=0;
		try{
			borrarClase=connection.prepareStatement(""
					+ "delete from instalaciones "
					+ "where numero = ?");
			//asociamos el valor que queremos buscar
			borrarClase.setInt(1, numero);
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
	public Instalaciones findByNumero(Connection connection, int numero) {
		// TODO Auto-generated method stub
		Instalaciones clase=null;
		PreparedStatement buscarID=null;
		ResultSet objetoEncontrado=null;
		try{
			buscarID=connection.prepareStatement(""
					+"select * "
					+ "from instalaciones "
					+ "where numero = ?");
			//asociamos el valor que queremos buscar
			buscarID.setInt(1, numero);
			//ejecutamos la consulta
			objetoEncontrado=buscarID.executeQuery();
			if (objetoEncontrado.next())
				clase=fillInstalacion(objetoEncontrado);
		} catch (TransferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e){
			//	throw new DaoException("Error en la busqueda de ...", e)
		}
		return clase;
	}

}
