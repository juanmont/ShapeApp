package tp.pr2.control;

import java.util.Scanner;

import tp.pr2.logica.Movimiento;
import tp.pr2.logica.MovimientoComplica;
import tp.pr2.logica.MovimientoConecta4;
import tp.pr2.logica.Partida;
import tp.pr2.logica.TipoJuego;

/**
 * Clase con los metodos para ejecutar el comando poner C4 o poner CO.
 * Realiza las llamadas necesarias para poner la ficha en la posicion indicada por el usuario.
 */
public class ComandoPoner implements Comando {
	private Partida partida;
	private Scanner in;
	private Movimiento mov;

	
	public ComandoPoner(Partida partida, Scanner in) {
		this.partida = partida;
		this.in = in;
	}

	@Override
	public boolean analiza(String cmd) {
		if(cmd.equalsIgnoreCase("poner")) 
			return true;
		return false;
	}

	@Override
	public void ejecuta(TipoJuego tipoJuego) {
		int i = 0;
		System.out.print("Introduce la columna: ");
		if (in.hasNextInt()) {
			i = in.nextInt();
			in.nextLine();
			if (tipoJuego == TipoJuego.C4)
				mov = new MovimientoConecta4(i, partida.getTurno());
			else
				mov = new MovimientoComplica(i, partida.getTurno());

			if (!partida.ejecutaMovimiento(mov)){
				System.err.println("Movimiento incorrecto");
			}
		}
	}
}
	

