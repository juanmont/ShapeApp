package Logica;

import java.sql.Connection;
import java.util.ArrayList;

import enums.UsuarioEnum;
import transfers.Admin;
import transfers.Funcionario;
import transfers.Socio;
import transfers.Usuario;

public interface FachadaUsuarios {
		
	public boolean bajaUsuario(Socio s, Admin ad, Funcionario f);
		
	public ArrayList<Usuario> listaUsuarios();
	
	public UsuarioEnum tipoUsuario(Connection con, String user, String pass);

	public boolean altaUsuario(Socio s, Admin ad, Funcionario f);

	public Usuario verUsuario(Socio s, Admin ad, Funcionario f);

	public boolean modificarUsuario(Socio s, Admin ad, Funcionario f);
}
