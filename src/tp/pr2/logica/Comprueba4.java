package tp.pr2.logica;

public abstract class Comprueba4 implements ReglasJuego {

	@Override
	public abstract Ficha hayGanador(Movimiento ultimoMovimiento, Tablero t);

	@Override
	public abstract Tablero iniciaTablero();

	@Override
	public abstract Ficha jugadorInicial();

	@Override
	public abstract boolean tablas(Ficha ultimoEnPoner, Tablero t);

	@Override
	public abstract Ficha siguienteTurno(Ficha ultimoEnPoner, Tablero t);
	
	protected boolean comprueba(int col, int fila,Tablero t)
	{
		if(enRaya(col,fila,1,0,t))
			return true;
		else if(enRaya(col,fila,0,1,t))
			return true;
		else if(enRaya(col,fila,1,-1,t))
			return true;
		else if(enRaya(col,fila,-1,-1,t))
			return true;
		else return false;
	}

	
	private boolean enRaya(int x, int y, int incX, int incY,Tablero tablero)
	{
		int cont = 0;
		int xAux = x;
		int yAux = y;
		boolean salir = false;
		while(cont < 3 && salir == false)
		{
				if(tablero.getCasilla(xAux, yAux)==tablero.getCasilla(xAux-incX, yAux-incY))
				{
					xAux -= incX;
					yAux -= incY;
					cont++;
				}
				else salir = true;
		}
		
		xAux = x;
		yAux = y;
		salir = false;
		while(cont < 3 && salir == false)
		{
				if(tablero.getCasilla(xAux, yAux)==tablero.getCasilla(xAux+incX, yAux+incY))
				{
					xAux += incX;
					yAux += incY;
					cont++;
				}
				else salir = true;
		}
		
		return cont == 3;
	}

	
}
