package transfers;

import java.sql.Date;



public class MaterialUsuario {
	
	private String idCliente;
	private int idMateriales;
	private Date dia;
	private int horario;
	
	
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdMateriales() {
		return idMateriales;
	}
	public void setIdMateriales(int idMateriales) {
		this.idMateriales = idMateriales;
	}
	public Date getDia() {
		return dia;
	}
	public void setDia(Date dia) {
		this.dia = dia;
	}
	public int getHorario() {
		return horario;
	}
	public void setHorario(int tipo) {
		this.horario = tipo;
	}
	
	
}
