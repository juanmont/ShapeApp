package transfers;

public class BonoUsuario {
	private int bonoId;
	private String nick;
	public int getBonoId() {
		return bonoId;
	}
	public void setBonoId(int bonoId) {
		this.bonoId = bonoId;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	@Override
	public String toString() {
		return "BonoUsuario [bonoId=" + bonoId + ", nick=" + nick + "]";
	}
}
