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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bono;
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
	public int insertBono(Connection connection, Bono bono) {
		// TODO Auto-generated method stub
		PreparedStatement insertClase=null;
		int result=0;
		try{
			insertClase=connection.prepareStatement("INSERT INTO bono"
					+ "(id, tipo, meses, precio)"
					+ " VALUES (?,?,?,?)");
			//asociamos el valor que queremos buscar
			insertClase.setInt(1, bono.getId());
			insertClase.setString(2, bono.getBono().toString());
			insertClase.setInt(3, bono.getMeses());
			insertClase.setDouble(4, bono.getPrecio());
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
	public int borrarBono(Connection connection, int id) {
		// TODO Auto-generated method stub
		PreparedStatement borrarClase=null;
		int result=0;
		try{
			borrarClase=connection.prepareStatement(""
					+ "delete from bono "
					+ "where id = ?");
			//asociamos el valor que queremos buscar
			borrarClase.setInt(1, id);
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

}
