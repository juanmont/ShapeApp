package Logica;

import java.sql.Connection;
import java.util.ArrayList;

import enums.UsuarioEnum;
import transfers.Admin;
import transfers.Entrenador;
import transfers.Funcionario;
import transfers.Socio;
import transfers.Usuario;

public interface FachadaUsuarios {
		
	public boolean bajaUsuario(Socio s, Admin ad, Funcionario f);
		
	public ArrayList<Usuario> listaUsuarios();
	
	public Funcionario tipoUsuarioFuncionario(Connection c, String user, String pass);

	public Socio tipoUsuarioSocio(Connection c, String user, String pass);
	
	public Admin tipoUsuarioAdmin(Connection c, String user, String pass);
	
	public boolean altaUsuario(Socio s, Admin ad, Funcionario f, Entrenador entrenador);

	public Usuario verUsuario(Socio s, Admin ad, Funcionario f);

	public boolean modificarUsuario(Socio s, Admin ad, Funcionario f);
}
