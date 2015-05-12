package transfers;

import enums.TipoEnum;


public class Clases {
	
	private String idEntrenador;
	private int id;
	private TipoEnum tipo;
	
	
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
}
