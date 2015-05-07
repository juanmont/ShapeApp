package transfers;

@SuppressWarnings("serial")
public class TransferException extends RuntimeException{
	
    /**
    * @author Jaime Boixadós Martínez
    * @since 11/04/2015
    * @version 1.0
    */
	public TransferException(String mensaje){
		super(mensaje);
		
	}
	 /**
    * @author Jaime Boixadós Martínez
    * @since 11/04/2015
    * @version 1.0
    */
	public TransferException(String mensaje, Throwable error){
		super(mensaje, error);
		
	}

}
