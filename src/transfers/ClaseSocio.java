package transfers;

public class ClaseSocio {
	private int id_clase;
	private String nick;
	public int getId_clase() {
		return id_clase;
	}
	public void setId_clase(int id_clase) {
		this.id_clase = id_clase;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	@Override
	public String toString() {
		return "ClaseSocio [id_clase=" + id_clase + ", nick=" + nick + "]";
	}
	
}
