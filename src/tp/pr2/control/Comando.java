package tp.pr2.control;

import tp.pr2.logica.TipoJuego;

//!! ¿Qué representa esta interfaz?
/**
 *	Interfaz con los metodos que van ha tener en comun, las clases que hereden de ella.
 */
public interface Comando {
	
	/**
	 * Analiza dado un string, si coincide con este comando.
	 * @param cmd - string con el que compara.
	 */
	public boolean analiza(String cmd);
	
	/**
	 * Ejecuta el comado introducido.
	 * @param tipoJuego - Tipo de juego al que se esta jugando.
	 */
	public void ejecuta(TipoJuego tipoJuego);

}
