package transfers;

import enums.SexoEnum;


public class Usuario {
	
	private String nombre;
	private String apellidos;
	private String DNI;
	private String telefono;
	private SexoEnum sexo; 
	private String nick;
	private String pass;
	private String email;
	private String direccion;
	
	public String getNombre() {
		return nombre;
	}
	
	public Usuario(){
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(String nick){
		this.nick = nick;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public SexoEnum getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = SexoEnum.valueOf(sexo);
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public void rellenaDatos(Usuario user){
		this.direccion = user.direccion;
		this.apellidos = user.direccion;
		this.DNI = user.DNI;
		this.email = user.email;
		this.nick = user.nick;
		this.pass = user.pass;
		this.sexo = user.sexo;
		this.telefono = user.telefono;
		this.nombre = user.nombre;
	}
}
