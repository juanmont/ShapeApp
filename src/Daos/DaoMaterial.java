package Daos;

import interfaces.daos.IMaterialDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import transfers.Material;
import transfers.TransferException;

public class DaoMaterial implements IMaterialDao{
	
	private Material fillMaterial(ResultSet objetoEncontrado) {
		Material material=new Material();
		try {
			material.setId(objetoEncontrado.getInt("id"));
			material.setTipo(objetoEncontrado.getString("tipo"));
			material.setNombre(objetoEncontrado.getString("nombre"));
			material.setDescripcion(objetoEncontrado.getString("descripcion"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return material;
	}
	
	public Material findById(Connection connection, int id) { 
		Material material=new Material();
        PreparedStatement buscarName=null; 
        ResultSet objetoEncontrado=null; 
        try{ 
            buscarName=connection.prepareStatement("select * from material where id = ?"); 
            //asociamos el valor que queremos buscar 
            buscarName.setInt(1,id); 
            //ejecutamos la consulta 
            objetoEncontrado=buscarName.executeQuery(); 
            if (objetoEncontrado.next()){ 
            	material=fillMaterial(objetoEncontrado); 
            } 
        } catch (TransferException e) { 
            // TODO Auto-generated catch block 
            e.printStackTrace(); 
        }catch(SQLException e){ 
            //  throw new DaoException("Error en la busqueda de ...", e) 
        } 
        return material; 
	}
	
	public List<Material> findByTipo(Connection connection, String categoria) {
		// TODO Auto-generated method stub
		Material clase=null;
		List<Material> claseList=new ArrayList<Material>();
		PreparedStatement buscarName=null;
		ResultSet objetoEncontrado=null;
		try{
			buscarName=connection.prepareStatement("select * from material where tipo like ?");
			//asociamos el valor que queremos buscar
			buscarName.setString(1,categoria);
			//ejecutamos la consulta
			objetoEncontrado=buscarName.executeQuery();
			while (objetoEncontrado.next()){
				clase=fillMaterial(objetoEncontrado);
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
	public int insertMaterial(Connection connection, Material material) {
		// TODO Auto-generated method stub
		PreparedStatement insertClase=null;
		int result=0;
		try{
			insertClase=connection.prepareStatement("INSERT INTO material"
					+ "(id, descripcion, tipo, nombre)"
					+ " VALUES (?,?,?,?)");
			//asociamos el valor que queremos buscar
			insertClase.setInt(1, material.getId());
			insertClase.setString(2, material.getDescripcion());
			insertClase.setString(3, material.getTipo().toString());
			insertClase.setString(4, material.getNombre());
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
	public int borrarMaterial(Connection connection, int id) {
		// TODO Auto-generated method stub
		PreparedStatement borrarClase=null;
		int result=0;
		try{
			borrarClase=connection.prepareStatement(""
					+ "delete from material "
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
}
