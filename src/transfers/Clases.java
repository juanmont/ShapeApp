package transfers;

import enums.ClaseEnum;
import enums.TipoEnum;


public class Clases {
	
	private String idEntrenador;
	private int id;
	private TipoEnum tipo;
	private ClaseEnum clase;
	
	public ClaseEnum getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = ClaseEnum.valueOf(clase);
	}
	public TipoEnum getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = TipoEnum.valueOf(tipo);
	}
	public String getIdEntrenador() {
		return idEntrenador;
	}
	public void setIdEntrenador(String idEntrenador) {
		this.idEntrenador = idEntrenador;
	}
	public int getId() {
		return id;
	}
	public void setId(int pista) {
		this.id = pista;
	}
	@Override
	public String toString() {
		return "Entrenador: " + idEntrenador + " tipo: " + tipo + " clase: " + clase;
	}
}
