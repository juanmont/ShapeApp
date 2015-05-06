package tp.pr2.control;

import java.util.Scanner;

import tp.pr2.logica.Ficha;
import tp.pr2.logica.Partida;
import tp.pr2.logica.TipoJuego;

public class Controlador {
	private Partida partida;
	private Scanner in;
	private TipoJuego tipoJuego;
	private GestorComandos gestorCmd;

	/**
	 * Controlador de la clase.
	 * 
	 * @param partida - Partida a la que se jugara, configurada con el juego al que 
	 * hay que jugar en la invocacion a run().
	 * @param in - Scanner que hay que utilizar para pedirle la información al
	 * usuario.
	 */
	public Controlador(Partida partida, Scanner in) {
		this.partida = partida;
		this.in = in;
		tipoJuego = TipoJuego.C4;
		gestorCmd = new GestorComandos(partida,in,this);
	}
	
	public TipoJuego getTipoDeJuego(){
		return tipoJuego;
	}

	/**
	 * Metodo sobre el que se ejecuta la partida. Encargado de ejecutar los
	 * comandos y de sacar el tablero y los mensajes por pantalla.
	 */
	public void run() {
		/** El turno empieza vacio.*/
		Ficha ganador = Ficha.VACIA;
		Ficha turno = Ficha.VACIA;
		/** Imprime por pantalla el tablero.*/
		System.out.println(partida.toString());
		/**
		 * Comprobar y ejecutara los comandos introducidos hata que la partida termine.
		 */
		while (!partida.isTerminada()) {

			turno = partida.getTurno();

			System.out.println("\nJuegan " + turno.toString());
			System.out.print("Qué quieres hacer? ");

			gestorCmd.setTipoJuego(tipoJuego);
			if (!gestorCmd.ejecuta(in.nextLine()))
				System.err.println("No te entiendo.");

			System.out.println(partida.toString());
		}
		/**
		 * Mostrara el ganador o partida en tablas.
		 */
		ganador = partida.getGanador();
		if (ganador != Ficha.VACIA)
			System.out.println("\nGanan las " + ganador.toString());
		else
			System.out.println("\nPartida terminada en "
					+ ganador.toString());

	}

	//!! publico?
	public void setTipoJuego(TipoJuego tipoJuego) {
		this.tipoJuego = tipoJuego;
	}

}
