package transfers;

public class Entrenador extends Usuario{

	private double sueldo;
	private String horaEntrada;
	private String horaSalida;
	
	public Entrenador(){
		
	}
	
	public Entrenador(String nick){
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
	
	public String toString(){
		return "Usuario: " + getNick() + " , Nombre: " + getNombre() + " , apellidos: "+ getApellidos() +
				" , Sueldo: " + getSueldo();	
	}
}
