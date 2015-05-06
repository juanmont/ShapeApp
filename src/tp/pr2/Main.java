package tp.pr2;

import java.util.Scanner;

import tp.pr2.control.Controlador;
import tp.pr2.logica.Partida;
import tp.pr2.logica.ReglasConecta4;
import tp.pr2.logica.ReglasJuego;

public class Main {
	/**
	 * Metodo principal de la aplicacion.
	 * @param args - Argumentos pasados a la aplicacion. No se utilizan.
	 */
	public static void main(String[] args) {
		ReglasJuego reglas = new ReglasConecta4();
		Partida partida = new Partida(reglas);
		Scanner in = new Scanner(System.in);
		Controlador controlador = new Controlador(partida, in);
		controlador.run();
		
	}
}

