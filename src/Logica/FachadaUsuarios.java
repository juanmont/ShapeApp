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
		
	public boolean bajaUsuario(Socio s, Admin ad, Funcionario f, Entrenador e);
		
	public ArrayList<Admin> getListaAdmin();
	
	public ArrayList<Socio> getListaSocio();
	
	public ArrayList<Funcionario> getListaFuncionario();
	
	public ArrayList<Entrenador> getListaEntrenador();
	
	public UsuarioEnum tipoUsuario(Connection con, String user, String pass);

	public boolean altaUsuario(Socio s, Admin ad, Funcionario f, Entrenador e);

	public Usuario verUsuario(Socio s, Admin ad, Funcionario f, Entrenador e);

	public boolean modificarUsuario(Socio s, Admin ad, Funcionario f, Entrenador e);

	public Funcionario tipoUsuarioFuncionario(Connection c, String user, String pass);

	public Socio tipoUsuarioSocio(Connection c, String user, String pass);

	public Admin tipoUsuarioAdmin(Connection c, String user, String pass);
}
