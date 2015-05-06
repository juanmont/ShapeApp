/**
 * Enumerado con los tipos de juego soportados que facilita distintas implementaciones.
 * No se obliga a los alumnos a hacerlo (no aparece en la documentación).
 */
package tp.pr2.logica;

public enum TipoJuego {
	C4(new ReglasConecta4()), CO(new ReglasComplica());	
	private ReglasJuego reglas;
	
	/**
	 * contructor privador que asigna las reglas a cada tipo de juego.
	 * @param reglas - reglas de cadas tipo de juego.
	 */
	private TipoJuego(ReglasJuego reglas)
	{
		this.reglas = reglas;
	}
	/**
	 * Devuelve el tipo de juego a partir de la cadena del parámetro.
	 * @param param
	 * @return null si es incorrecto.
	 */
	public static TipoJuego fromParam(String param){
		if(param.equalsIgnoreCase("C4"))
			return C4;
		else if(param.equalsIgnoreCase("CO"))
			return CO;
		else return null;
	}
	
	/**
	 * @return - Devuelve el objeto con las reglas del juego asociadas.
	 */
	public ReglasJuego reglas(){
		return reglas;
	}
}
