package tp.pr2.control;

import tp.pr2.logica.Partida;
import tp.pr2.logica.TipoJuego;

/**
 * Clase con los metodos para ejecutar el comando jugar.
 * cambia el tipo de juego al que vamos a jugar y se lo indica al controlador.
 */
public class ComandoJugar implements Comando{
	private Partida partida;
	private TipoJuego tipoJuego;
	private Controlador control;

	
	public ComandoJugar(Partida partida, Controlador control) {
		this.partida = partida;
		tipoJuego = null;
		this.control = control;
	}
	@Override
	public boolean analiza(String cmd) {
		String[] s = cmd.split(" ");
		if(s.length == 2)
		{
			if(s[0].equalsIgnoreCase("jugar")) 
			{
				tipoJuego = TipoJuego.fromParam(s[1]);
				return true;
			}
		}
		return false;
	}

	@Override
	public void ejecuta(TipoJuego tipoJuego) {
		partida.reset(this.tipoJuego.reglas());
		System.out.println("Partida reiniciada.");
		control.setTipoJuego(this.tipoJuego);
	}

}
