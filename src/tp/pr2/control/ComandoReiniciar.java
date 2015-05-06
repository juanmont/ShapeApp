package tp.pr2.control;

import tp.pr2.logica.Partida;
import tp.pr2.logica.TipoJuego;
/**
 * Clase con los metodos para ejecutar el comando reiniciar C4 o reiniciar CO.
 */
public class ComandoReiniciar implements Comando{
	
	private Partida partida;
	
	public ComandoReiniciar(Partida partida)
	{
		this.partida = partida;
	}
	
	@Override
	public boolean analiza(String cmd) {
		if(cmd.equalsIgnoreCase("reiniciar")) 
			return true;
		return false;
	}
	
	@Override
	public void ejecuta(TipoJuego tipoJuego) {
		//!! ¿No se pueden reiniciar partidas de Complica?
		if (tipoJuego == TipoJuego.C4)
			partida.reset(tipoJuego.reglas());
		if (tipoJuego == TipoJuego.CO)
			partida.reset(tipoJuego.reglas());

		System.out.println("Partida reiniciada.");
		
	}

}
