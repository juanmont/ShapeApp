/**
 * Implementacion de las reglas del Conecta 4.
 * Se deben implementar todos los metodos del interfaz, ademas del constructor.
 */
package tp.pr2.logica;

public class ReglasConecta4 extends ReglasJuegoAbstracta{

	public ReglasConecta4(){
		super();
	}
	
	@Override
	public Ficha hayGanador(Movimiento ultimoMovimiento, Tablero t) {
		int col = ultimoMovimiento.getDonde();
		int fila = t.buscaFila(col)+1;
		if(comprueba(col,fila,t))
			return ultimoMovimiento.getJugador();
		else return Ficha.VACIA;
	}

	@Override
	public Tablero iniciaTablero() {
		return new Tablero(7,6);
	}
	/**
	 * Pone la ficha a blanca cuando se empieza un nuevo juego.
	 */
	@Override
	public Ficha jugadorInicial() {
		return Ficha.BLANCA;
	}

	@Override
	public boolean tablas(Ficha ultimoEnPoner, Tablero t) {
		
		for(int i=1; i<=t.getAncho();i++)
		{
			if(t.getCasilla(i, 1)== Ficha.VACIA)
				return false;
		}
		return true;
		
	}

	@Override
	public Ficha siguienteTurno(Ficha ultimoEnPoner, Tablero t) {
		 
			return ultimoEnPoner.Contraria();
	}

}
