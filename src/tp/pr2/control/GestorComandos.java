package tp.pr2.control;

/**
 * Clase que gestiona los comandos. analiza si la llamada al comando ha sido correcta y en caso de que exista
 * el comando lo ejecuta.
 */
import java.util.Scanner;

import tp.pr2.logica.Partida;
import tp.pr2.logica.TipoJuego;

public class GestorComandos {
	
	private Comando[] comandos;
	private int numComandos;
	private TipoJuego tipojuego;

	/**
	 * Constructora de la clase.
	 * @param partida - Partida sobre la que ejecutaremos los comandos.
	 * @param in - Escaner del teclado.
	 * @param control - Controlador.
	 */
	public GestorComandos(Partida partida, Scanner in,Controlador control) {
	numComandos = 5;
	comandos = new Comando[numComandos];
	/**Introducimos cada uno de los comandos en la lista de comandos.*/
	comandos[0] = new ComandoPoner(partida,in);
	comandos[1] = new ComandoDeshacer(partida);
	comandos[2] = new ComandoReiniciar(partida);
	comandos[3] = new ComandoJugar(partida,control);
	comandos[4] = new ComandoSalir();
	}
	/**
	 * Guarda el tipo de juego en la clase.
	 * @param tipo - Tipo de juego.
	 */
	public void setTipoJuego(TipoJuego tipo){
		tipojuego = tipo;
	}
	
	/**
	 * Comprueba si el comando introducido existe y lo ejecuta.
	 * @param cmd - Comando introduucido por el usuario.
	 * @return Si se a podido ejecutar o no.
	 */
	public boolean ejecuta(String cmd) {
		boolean ok = false;
		int cont = 0;
		while (cont < numComandos && ok == false) {
			if (comandos[cont].analiza(cmd)){
				ok = true;
				comandos[cont].ejecuta(tipojuego);
			}
			cont++;
		}
			return ok;
	}
}
