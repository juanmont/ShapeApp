package Daos;

@SuppressWarnings("serial")
public class DaoException  extends RuntimeException{
     /**
    * @author Jaime Boixad�s Mart�nez
    * @since 11/04/2015
    * @version 1.0
    */
	public DaoException(String mensaje){
		super(mensaje);
		
	}
	 /**
    * @author Jaime Boixad�s Mart�nez
    * @since 11/04/2015
    * @version 1.0
    */
	public DaoException(String mensaje, Throwable error){
		super(mensaje, error);
		
	}
	
}
