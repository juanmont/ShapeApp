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
		return "Socio, getNombre()="
				+ getNombre() + ", getApellidos()=" + getApellidos()
				+ ", getDNI()=" + getDNI() + ", getTelefono()=" + getTelefono()
				+ ", getSexo()=" + getSexo() + ", getUsuario()=" + getNick()
				+ ", getContraseña()=" + getPass() + ", getEmail()="
				+ getEmail() + ", getDireccion()=" + getDireccion() + "]";
	}
}
