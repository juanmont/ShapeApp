package transfers;

public class Admin extends Usuario{

	private double sueldo;
	private String horaEntrada;
	private String horaSalida;
	
	public Admin(){
		
	}
	
	public Admin(String nick){
		super(nick);	
	}
	
	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public String getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	@Override
	public String toString() {
		return "Admin [sueldo=" + sueldo + ", horaEntrada=" + horaEntrada
				+ ", horaSalida=" + horaSalida + ", getNombre()=" + getNombre()
				+ ", getApellidos()=" + getApellidos() + ", getDNI()="
				+ getDNI() + ", getTelefono()=" + getTelefono()
				+ ", getSexo()=" + getSexo() + ", getNick()=" + getNick()
				+ ", getPass()=" + getPass() + ", getEmail()=" + getEmail()
				+ ", getDireccion()=" + getDireccion() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
