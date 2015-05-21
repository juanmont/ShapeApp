package transfers;

import enums.TipoEnum;
import enums.DisponibilidadEnum;
import enums.PistaEnum;


public class Instalaciones {
	
	private int numero;
	private TipoEnum tipo;
	private PistaEnum pista;
	private DisponibilidadEnum disponibilidad;
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public TipoEnum getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = TipoEnum.valueOf(tipo);
	}

	public PistaEnum getPista() {
		return pista;
	}

	public void setPista(String pista) {
		this.pista = PistaEnum.valueOf(pista);
	}

	public DisponibilidadEnum getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = DisponibilidadEnum.valueOf(disponibilidad);
	}
	
	public String toString(){
		return "Numero: " + numero + " , tipo: " + tipo.toString();	
	}
}
