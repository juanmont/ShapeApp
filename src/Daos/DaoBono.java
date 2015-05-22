package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import transfers.Bono;
import transfers.TransferException;
import interfaces.daos.IBonoDao;

public class DaoBono implements IBonoDao{

	private Bono fillBono(ResultSet objetoEncontrado){
		Bono bono = new Bono();
		try {
			bono.setId(objetoEncontrado.getInt("id"));
			bono.setBono(objetoEncontrado.getString("tipo"));
			bono.setMeses(objetoEncontrado.getInt("meses"));
			bono.setPrecio(objetoEncontrado.getDouble("precio"));
			bono.setNick(objetoEncontrado.getString("nick"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bono;
	}
	
	public List<Bono> findAll(Connection connection){
		Bono clase=null;
		List<Bono> claseList=new ArrayList<Bono>();
		PreparedStatement buscarName=null;
		ResultSet objetoEncontrado=null;
		try{
			buscarName=connection.prepareStatement("select * from bono");
			//ejecutamos la consulta
			objetoEncontrado=buscarName.executeQuery();
			while (objetoEncontrado.next()){
				clase=fillBono(objetoEncontrado);
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
	public List<Bono> findByTipo(Connection connection, String tipo) {
		// TODO Auto-generated method stub
		Bono clase=null;
		List<Bono> claseList=new ArrayList<Bono>();
		PreparedStatement buscarName=null;
		ResultSet objetoEncontrado=null;
		try{
			buscarName=connection.prepareStatement("select * from bono where tipo like ?");
			//asociamos el valor que queremos buscar
			buscarName.setString(1,tipo);
			//ejecutamos la consulta
			objetoEncontrado=buscarName.executeQuery();
			while (objetoEncontrado.next()){
				clase=fillBono(objetoEncontrado);
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
	public Bono findById(Connection connection, int id) {
		// TODO Auto-generated method stub
		Bono clase=null;
		PreparedStatement buscarID=null;
		ResultSet objetoEncontrado=null;
		try{
			buscarID=connection.prepareStatement(""
					+"select * "
					+ "from bono "
					+ "where id = ?");
			//asociamos el valor que queremos buscar
			buscarID.setInt(1, id);
			//ejecutamos la consulta
			objetoEncontrado=buscarID.executeQuery();
			if (objetoEncontrado.next())
				clase=fillBono(objetoEncontrado);
		} catch (TransferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e){
			//	throw new DaoException("Error en la busqueda de ...", e)
		}
		return clase;
	}
	
	public List<Bono> findByNick(Connection connection, String nick) {
		// TODO Auto-generated method stub
		Bono clase=null;
		List<Bono> claseList=new ArrayList<Bono>();
		PreparedStatement buscarName=null;
		ResultSet objetoEncontrado=null;
		try{
			buscarName=connection.prepareStatement("select * from bono where nick like ?");
			//asociamos el valor que queremos buscar
			buscarName.setString(1,nick);
			//ejecutamos la consulta
			objetoEncontrado=buscarName.executeQuery();
			while (objetoEncontrado.next()){
				clase=fillBono(objetoEncontrado);
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
	public int insertBonoUsuario(Connection connection, Bono bono) {
		// TODO Auto-generated method stub
		PreparedStatement insertClase=null;
		int result=0;
		try{
			insertClase=connection.prepareStatement("INSERT INTO bono"
					+ "(nick, meses, precio, tipo)"
					+ " VALUES (?, ?, ?, ?)");
			//asociamos el valor que queremos busca
			insertClase.setString(1, bono.getNick());
			insertClase.setInt(2, bono.getMeses());
			insertClase.setDouble(3, bono.getPrecio());
			insertClase.setString(4, bono.getBono().toString());
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
	public int borrarBonoUsuario(Connection connection, Bono bonoUsuario) {
		// TODO Auto-generated method stub
		PreparedStatement borrarClase=null;
		int result=0;
		try{
			borrarClase=connection.prepareStatement(""
					+ "delete from usuario_bono "
					+ "where id = ? AND nick = ?");
			//asociamos el valor que queremos buscar
			borrarClase.setInt(1, bonoUsuario.getId());
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
	public Bono findByNickAndBono(Connection connection, Bono bono) {
		// TODO Auto-generated method stub
		Bono clase=null;
		PreparedStatement buscarID=null;
		ResultSet objetoEncontrado=null;
		try{
			buscarID=connection.prepareStatement(""
					+"select * "
					+ "from bono "
					+ "where id = ? AND nick = ?");
			//asociamos el valor que queremos buscar
			buscarID.setInt(1, bono.getId());
			buscarID.setString(2, bono.getNick());
			//ejecutamos la consulta
			objetoEncontrado=buscarID.executeQuery();
			if (objetoEncontrado.next())
				clase=fillBono(objetoEncontrado);
		} catch (TransferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e){
			//	throw new DaoException("Error en la busqueda de ...", e)
		}
		return clase;
	}

}
