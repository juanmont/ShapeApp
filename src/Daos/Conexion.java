package Daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

public class Conexion{

	private static DataSource dataSource = null;
	private static Connection conection=null;
	private static Conexion conexion=null;//instancia de la clase
	
	//declaracion de constantes
	private static final String DRIVER_NAME="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost/polideportivo_is";//2206 es el puerto por defecto,
																		//no hace falta ponerlo, pero esta bien hacerlo
	private static final String USER="is";
	private static final String PASSWORD="is";

    /** Constructor de la conexión
    * @author Jaime Boixad�s Mart�nez
    * @since 11/04/2015
    * @version 1.0
    */
	private Conexion(){
		
		try {
			//cargamos el driver
			Class.forName(DRIVER_NAME);
			//obtenemos la conexion
			conection=DriverManager.getConnection(URL, USER, PASSWORD);
			//autocomit a false para manejar las transacciones
			conection.setAutoCommit(false);		
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Método de clase que retorna la conexion a la BD
	 * @author Jaime Boixad�s Mart�nez
	 * @date 11-04-2015
	 * @return Connection, conexion a la BD
	 */
	public static Connection obtenerConexion(){
		
		Connection newConnection = null;
		
		if(Conexion.dataSource == null)
			{
				// Modo mono-hilo
				if(Conexion.conection == null)
				{
					if (conexion==null){
						conexion=new Conexion();
					}
				}
					
				newConnection = Conexion.conection;
			}
			else
			{
					// Modo web
					newConnection = getConnectionFromDataSource();
			}
		return newConnection;
		
	}
	/** 
    * @author Jaime Boixad�s Mart�nez
    * @since 11/04/2015
    * @version 1.0
    */
	private static Connection getConnectionFromDataSource() {
		Connection conection = null;
		
		try
		{
			conection = dataSource.getConnection();
		}
		catch(Exception ex) 
		{
			throw new DaoException("Error al acceder a la BBDD. Intentelo más tarde.", ex);
		}
			
		return conection;

	}

     /**
    * @author Jaime Boixad�s Mart�nez
    * @since 11/04/2015
    * @version 1.0
    */
	public static void setDataSource(DataSource dataSource)
	{
		Conexion.dataSource = dataSource;
	}
    /**
    * @author Jaime Boixad�s Mart�nez
    * @since 11/04/2015
    * @version 1.0
    */
	public static void freeConnection(Connection conn) 
	{
		if(dataSource == null)
		{
	// Si no hay pool de conexiones no es necesario liberar la conexión
				// estoy funcionando en modo de hilo único.
		}
		else
		{
			Conexion.closeConnection(conection);
		}
	}


	private static void closeConnection(Connection conection2) {
		// TODO Auto-generated method stub
		
	}

	

}
