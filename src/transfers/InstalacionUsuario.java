package transfers;

import java.sql.Date;

public class InstalacionUsuario {
	private int numInstalacion;
	private String nick;
	private Date dia;
	private int horario;
	private int idClase;
	
	public int getNumInstalacion() {
		return numInstalacion;
	}
	public void setNumInstalacion(int numInstalacion) {
		this.numInstalacion = numInstalacion;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
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
	public void setHorario(int horario) {
		this.horario = horario;
	}
	public int getIdClase() {
		return idClase;
	}
	public void setIdClase(int idClase) {
		this.idClase = idClase;
	}
}
