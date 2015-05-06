package tp.pr2.logica;

/**
 * Almacena la información de un tablero rectangular.
 * El tamaño se fija en el momento de la construcción,
 * y contiene métodos para acceder a la información de cada celda y para colocar fichas.
 */
public class Tablero {
	private Ficha [][] tablero;
	private int ancho = 1;
	private int alto = 1;
	/**
	 * Construye un tablero vacio.
	 * @param tx - Tamanio en la coordenada x (o numero de columnas).
	 * @param ty - Tamanio en la coordenada y (o numero de filas).
	 */
	public Tablero (int tx, int ty){
		if(tx>0 && ty>0){
		this.alto = ty;
		this.ancho = tx;}
		tablero = new Ficha[ancho][alto];
		reset();
	}
	
	/**
	 * Metodo para obtener el ancho del tablero.
	 * @return Numero de fila del tablero.
	 */
	public int getAncho(){
		return ancho;
	}
	
	/**
	 * M�todo para obtener el alto del tablero.
	 * @return Número de columna del tablero.
	 */
	public int getAlto(){
		return alto;
	}
	
	/**
	 * M�todo para acceder a la informacion de una casilla o celda concreta.
	 * @param x - Numero de columna (1..ancho).
	 * @param y - Numero de fila (1..alto).
	 * @return Informacion de la casilla. Si la casilla no es v�lida, devuelve Ficha.VACIA
	 */
	public Ficha getCasilla(int x, int y){
		if(x>ancho || y>alto || x<1 || y<1)
			return Ficha.VACIA;
		return tablero[x-1][y-1];	
	}
	
	/**
	 * Permite especificar el nuevo contenido de una casilla. Tambien puede utilizarse para quitar una ficha
	 * @param x - Numero de columna (1..ancho).
	 * @param y - Numero de fila (1..alto).
	 * @param color - Color de la casilla. Si se indica Ficha.VACIA, la celda quedaria sin ficha.
	 */
	public void setCasilla(int x, int y, Ficha color) {
		if (!(x > ancho || y > alto || x < 1 || y < 1))
			tablero[x - 1][y - 1] = color;
	}
	
	/**
	 * Busca la primera posicion que este vacia en la fila que este selecccionada.
	 * @param En que fila quiero introducir la ficha.
	 * @return Primera fila vacia en la columna.
	 */
	public int buscaFila(int x) {
		int y = this.alto;
		boolean encontrado = false;
		while (y > 0 && encontrado == false) {
			if (tablero[x - 1][y - 1] == Ficha.VACIA)
				encontrado = true;
			else
				y--;
		}
		return y;
	}
	
	/**
	 * Recorre el tablero, colocando fichas vacias en cada posicion.
	 */
	public void reset() {
		for (int i = 0; i < ancho; i++) {
			for (int j = 0; j < alto; j++) {
				this.tablero[i][j] = Ficha.VACIA;
			}
		}
	}
	
	/**
	 * Dibuja el tablero(usamos la clase StringBuilder).
	 * @return Devuelve el tablero modificado.
	 */
	public String toString() {

		StringBuilder tablero = new StringBuilder();
		
		for (int i = 0; i < alto; i++) {
			tablero.append("|");
			for (int j = 0; j < ancho; j++) {
				tablero.append(PintaFicha(this.tablero[j][i]));
			}
			tablero.append("|" + "\n");
		}
		
		tablero.append("+");
		for (int i = 0; i < ancho; i++) {
			tablero.append("-");
		}
		tablero.append("+" + "\n" + " ");
		
		for (int i = 0; i < ancho; i++) {
			tablero.append(i + 1);
		}
		
		return tablero.toString();
	}
	
	/**
	 * Transforma el enumerado en string
	 * @param fi De tipo ficha
	 * @return El string correspondiente.
	 */
	private String PintaFicha(Ficha fi)
	{
		if(fi == Ficha.BLANCA)
			return "O";
		else if(fi== Ficha.NEGRA)
			return "X";
		else if (fi == Ficha.VACIA)
			return " ";
		else 
			return "E";
	}

}

