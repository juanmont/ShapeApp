package tp.pr2.control;

import tp.pr2.logica.Partida;
import tp.pr2.logica.TipoJuego;

/**
 * Clase con los metodos para ejecutar el comando deshacer.
 * realiza la llamada para deshacer el ultimo movimiento realizado.
 */
public class ComandoDeshacer implements Comando{
	private Partida partida;
	
	public ComandoDeshacer(Partida partida) {
		this.partida = partida;
	}

	
	@Override
	public boolean analiza(String cmd) {
		if(cmd.equalsIgnoreCase("deshacer")) 
			return true;
		return false;
	}

	@Override
	public void ejecuta(TipoJuego tipoJuego) {
		if (!partida.undo())
			System.err.println("Imposible deshacer.");
	}

}
