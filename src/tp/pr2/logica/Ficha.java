/**
 * Repesenta la informacion del color de una ficha.
 * El enumerado es utilizado para guardar la informacion de cada posicion de los tableros,
 * por lo que contiene tambien un simbolo para indicar la ausencia de ficha en esa posicion.
 * Tambien se utiliza para el color de un jugador.
 * IMPORTANTE: en la documentacion aparecen una serie de metodos (valueOf, values) 
 * que NO HAY QUE IMPLEMENTAR, sino que son aniadidos automaticamente por el compilador.
 */
package tp.pr2.logica;

public enum Ficha {
	BLANCA, NEGRA, VACIA;
	
	/**
	 * Convierte un tipo de ficha a un string.
	 * @param f - Ficha.
	 * @return Devuleve el string dependiendo del tipo de ficha.
	 */
	public String toString()
	{
		if(this == BLANCA)
			return "blancas";
		else if(this == NEGRA)
			return "negras";
		else if(this == VACIA)
			return "tablas.";
		else return "";
	}
	
	/**
	 * cambia la ficha que se ha introducido por su contrario
	 * @return valor de la ficha cambiada.
	 */
	public Ficha Contraria() {
		if(this== Ficha.BLANCA)
			return Ficha.NEGRA;
		else if(this == Ficha.NEGRA)
			return Ficha.BLANCA;
		else 
			return Ficha.VACIA;
	}
}

