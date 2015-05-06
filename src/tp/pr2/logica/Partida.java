/**
 * Clase para representar la información de una partida.
 * Se encarga de almacenar el estado del tablero, a quién le toca, si ya hay un ganador, etc.,
 * así como la lista de movimientos que se han ido realizando para poder deshacerlos.
 * La partida guarda al menos los 10 últimos movimientos.
 */
package tp.pr2.logica;

public class Partida {

	private ReglasJuego reglas;
	private Tablero tab;
	private boolean terminada;
	private Ficha turno;
	private Ficha ganador;
	private Pila pila;
	
	/**
	 * Construye una partida nueva.
	 * @param reglas -  Reglas del juego que se utilizaran durante la partida 
	 * (al menos hasta que se ejecute reset).
	 */
	public Partida(ReglasJuego reglas){
		pila = new Pila();
		this.reglas = reglas;
		reset(reglas);
	}
	
	/**
	 * Reinicia la partida en curso. Esta operacion no puede deshacerse. Gracias al parametro,
	 * permite cambiar el tipo de juego al que se juega.
	 * @param reglas -  Las reglas del juego a utilizar a partir de ahora.
	 */
	public void reset(ReglasJuego reglas){
		tab = reglas.iniciaTablero();
		this.reglas = reglas;
		pila.reset();
		terminada = false;
		turno = Ficha.BLANCA;
		ganador = Ficha.VACIA;
	}
	
	/**
	 * 
	 * @param mov - Movimiento a ejecutar. Se asume que el movimiento es compatible con las reglas de la partida que se esta jugando 
	 * (si se esta jugando a Conecta 4, el tipo de movimiento es Conecta 4, etc.).
	 * En caso contrario, el comportamiento es indeterminado.
	 * @return true si se puede efectuar el movimiento. Es un error intentar colocar una ficha del jugador que no tiene el turno,
	 * cuando la partida esta terminada, columna llena, ...
	 */
	public boolean ejecutaMovimiento(Movimiento mov){
		if(mov.getJugador() == turno && !terminada)
		{
		if(mov.ejecutaMovimiento(tab)){
			pila.apila(mov);
			turno = reglas.siguienteTurno(turno, tab);
			Ficha f = reglas.hayGanador(mov, tab);
			if(f != Ficha.VACIA || reglas.tablas(turno, tab)){
				ganador = f;
				terminada = true;
				}
			return true;
		}
		else 
			return false;
		}
		else return false;
	}
	
	/**
	 * Deshace el ultimo movimiento ejecutado.
	 * @return true si se pudo deshacer.
	 */
	public boolean undo(){
		Movimiento mov = pila.desapila();
		if(mov != null){
			mov.undo(tab);
			turno = reglas.siguienteTurno(turno, tab);
			return true;}
		return false;
	}
	
	/**
	 * Devuelve el color del jugador al que le toca poner.
	 * @return Color del jugador, o Ficha.VACIA si la partida ha terminado.
	 */
	public Ficha getTurno(){
		return turno;
	}
	
	/**
	 * Devuelve el color del ganador. Solo valido si la partida ya ha terminado (isTerminada() == true).
	 * @return Color del ganador. Si la partida termina en tablas, Ficha.VACIA. Si la partida no ha terminado aun, el resultado es indeterminado.
	 */
	public Ficha getGanador(){
		return ganador;
	}
	
	/**
	 * Metodo para saber si la partida ha concluido ya o no.
	 * @return true si la partida ha acabado.
	 */
	public boolean isTerminada(){
		return terminada;	
	}
	
	/**
	 * Método de acceso al tablero. Dependiendo de como se haga la implementacion del resto de clases 
	 * (principalmente de la clase Controlador), es posible que no se utilice para nada en la practica. 
	 * Sin embargo, es necesario implementarlo para poder ejecutar los test de unidad.
	 * @return Estado del tablero actual.
	 */
	public Tablero getTablero(){
		return tab;
	}

	public String toString() {
		return tab.toString();
	}
}

