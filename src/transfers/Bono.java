package transfers;

import enums.BonoEnum;

public class Bono {
	private int id;
	private BonoEnum bono;
	private int meses;
	private double precio;
	private String nick;
	
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BonoEnum getBono() {
		return bono;
	}
	public void setBono(String bono) {
		this.bono = BonoEnum.valueOf(bono);
	}
	
	public int getMeses() {
		return meses;
	}
	public void setMeses(int meses) {
		this.meses = meses;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Bono [id=" + id + ", bono=" + bono + ", meses=" + meses
				+ ", precio=" + precio + "]";
	}
}
