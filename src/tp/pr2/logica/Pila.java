/**
 * Almacena los movimientos realizados hasta un maximo de 10.
 */
package tp.pr2.logica;

public class Pila {
	private int  numUndo;
	private Movimiento[] undoStack;
	
	/**Construye el array donde vamos a guardar los movimientos*/
	public Pila(){
		numUndo=-1;
		undoStack = new Movimiento[10];
	}
	
	/**
	 * Comprueba si se puede decrementar el array, y devuelve el ultimo movimiento para deshacerlo.
	 * @return El movimiento a deshacer.
	 */
	public Movimiento desapila(){
		if(numUndo==-1){
			return null;	
		}
		else{
			Movimiento mov=undoStack[numUndo];
			numUndo--;
			return mov;
		}
	}
	
	/**
	 * Guarda el nuevo movimiento en el array.
	 * Si no hay espacio borra el primer movimiento para poder aniadir uno nuevo al final.
	 * @param columna
	 */
	public void apila(Movimiento mov){
		 if(numUndo>=9){
			 for(int i=0;i<9;i++){
				 undoStack[i]=undoStack[i+1];
			 }
		 }
		 else
			 numUndo++;
		 undoStack[numUndo]=mov; 
	}
	
	/**
	 * Resetea el puntero de la pila de movimientos.
	 */
	public void reset() {
		numUndo = -1;
	}
	
}
