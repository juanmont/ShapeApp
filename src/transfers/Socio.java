package transfers;

public class Socio extends Usuario{
	
	public Socio(){
		// TODO Auto-generated constructor stub
	}
	
	public Socio(String nick){
		super(nick);
	}
	

	@Override
	public String toString() {
		return "Usuario: " + getNick() + " , Nombre: " + getNombre() + " , apellidos: "+ getApellidos();				
	}
	
}
