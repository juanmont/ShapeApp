/**
 * Clase que implementa el movimiento para el juego del Conecta 4.
 * Se deben implementar los métodos abstractos de la clase padre.
 */

package tp.pr2.logica;

public class MovimientoConecta4 extends Movimiento {
	/**
	 * Constructor del objeto.
	 * @param donde - Columna en la que se colocara la ficha
	 * @param color -  Color de la ficha que se pondra (o jugador que pone).
	 */
	public MovimientoConecta4(int donde, Ficha color){
		super(donde,color);
	}
	@Override
	public Ficha getJugador(){
		return color;
	}
	
	@Override
	public boolean ejecutaMovimiento(Tablero tab) {
		if(tab.getAncho()>=donde && donde>0){
			int fila = tab.buscaFila(donde);
			if(fila>0){
				tab.setCasilla(donde,fila,color);
				return true;
			}
		}
			return false;
	}

	@Override
	public void undo(Tablero tab) {
	tab.setCasilla(donde, tab.buscaFila(donde)+1, Ficha.VACIA);	
	}
	/**
	 * Devuleve la columna en la que se encuentra el movimiento.
	 * @return donde - Columna en la que se encuentra el movimiento.
	 */
	public int getDonde(){
		return donde;
	}

}
