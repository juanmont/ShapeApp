package Logica;

import java.sql.Connection;

import enums.UsuarioEnum;
import transfers.Usuario;

public interface FachadaUsuarios {
	
	public boolean altaUsuario(Usuario usuario);
	
	public void modificarUsuario();
	
	public boolean bajaUsuario();
	
	public Usuario verUsuario();
	
	public void listaUsuarios();
	
	public UsuarioEnum tipoUsuario(Connection con, String user, String pass);
}
