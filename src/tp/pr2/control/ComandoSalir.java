package tp.pr2.control;

import tp.pr2.logica.TipoJuego;
/**
 * Clase con los metodos para ejecutar el comando salir.
 * Sale de la ejecucion de la partida.
 */
public class ComandoSalir implements Comando{

	@Override
	public boolean analiza(String cmd) {
		if(cmd.equalsIgnoreCase("salir")) 
			return true;
		return false;
	}

	@Override
	public void ejecuta(TipoJuego tipoJuego) {
		System.exit(0);
	}

}
