/**
 * Clase que implementa el movimiento para el juego del Complica.
 * Se deben implementar los métodos abstractos de la clase padre.
 */
package tp.pr2.logica;

public class MovimientoComplica extends Movimiento{
	private Ficha guardada;
	public MovimientoComplica(int i, Ficha turno) {
		super(i,turno);
		guardada = Ficha.VACIA;
	}

	@Override
	public Ficha getJugador() {
		return color;
	}

	@Override
	public boolean ejecutaMovimiento(Tablero tab) {
		if (tab.getAncho() >= donde && donde > 0) {
			int fila = tab.buscaFila(donde);
			if (tab.getCasilla(donde, 1) != Ficha.VACIA) {
				guardada = desplazaAbajo(donde, tab);
				tab.setCasilla(donde, 1, color);
				return true;
			} else {
				if (fila > 0) {
					tab.setCasilla(donde, fila, color);
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Desplaza todas las fichas de una columna, desde la posicion mas baja, una posicion hacia abajo.
	 * @param col - Columna a desplazar.
	 * @param t - Tablero sobre el que desplazar.
	 * @return La ficha que se va a borrar por la parte de abajo.
	 */
	private Ficha desplazaAbajo(int col, Tablero t) {
		Ficha guardada = t.getCasilla(col, t.getAlto());
		for (int i = t.getAlto(); i > 1; i--)
			t.setCasilla(col, i, t.getCasilla(col, i - 1));
		return guardada;
	}

	/**
	 * Desplaza todas las fichas de una columna, desde la posicion mas alta, una posicion hacia arriba.
	 * @param col - Columna a desplazar.
	 * @param t - Tablero sobre el que desplazar.
	 */
	private void desplazaArriba(int col, Tablero t) {
		for (int i = 1; i < t.getAlto(); i++)
			t.setCasilla(col, i, t.getCasilla(col, i + 1));
	}

	@Override
	public void undo(Tablero tab) {
		if (guardada != Ficha.VACIA) {
			desplazaArriba(donde, tab);
			tab.setCasilla(donde, tab.getAlto(), guardada);
		} else
			tab.setCasilla(donde, tab.buscaFila(donde) + 1, Ficha.VACIA);
	}

	@Override
	public int getDonde() {
		return donde;
	}

}
