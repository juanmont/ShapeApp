package tp.pr2.logica;

public class ReglasComplica extends ReglasJuegoAbstracta{

	public ReglasComplica()
	{
		super();
	}

	@Override
	public Ficha hayGanador(Movimiento ultimoMovimiento, Tablero t) {
		int col = ultimoMovimiento.getDonde();
		int contBlancas = 0;
		int contNegras = 0;
		for(int i= 1; i<=t.getAlto(); i++)
		{
			if(comprueba(col,i,t)){
				if(t.getCasilla(col,i) == Ficha.BLANCA)
					contBlancas++;
				else if(t.getCasilla(col,i) == Ficha.NEGRA)
					contNegras++;}
				
		}
		if(contBlancas > 0 && contNegras == 0)
			return Ficha.BLANCA;
		else if(contNegras > 0 && contBlancas == 0)
			return Ficha.NEGRA;
		else
			return Ficha.VACIA;
	}
	
	@Override
	public Tablero iniciaTablero() {
		return new Tablero(4,7);
	}

	@Override
	public Ficha jugadorInicial() {
		return Ficha.BLANCA;
	}

	@Override
	public boolean tablas(Ficha ultimoEnPoner, Tablero t) {
		return false;
	}

	@Override
	public Ficha siguienteTurno(Ficha ultimoEnPoner, Tablero t) {
		return ultimoEnPoner.Contraria();
	}
}
