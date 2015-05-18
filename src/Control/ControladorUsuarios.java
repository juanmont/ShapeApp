package Control;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Daos.DaoAdmin;
import Daos.DaoFuncionario;
import Daos.DaoSocio;
import Logica.FachadaUsuarios;
import Logica.SubSistemaUsuarios;
import VentanaGrafica.VentanaAdministrador;
import VentanaGrafica.VentanaFuncionario;
import VentanaGrafica.VentanaInicio;
import VentanaGrafica.VentanaPrincipal;
import VentanaGrafica.VentanaUsuario;
import enums.UsuarioEnum;
import transfers.Admin;
import transfers.Funcionario;
import transfers.Socio;
import transfers.Usuario;

public class ControladorUsuarios {

	private Connection c;
	private VentanaPrincipal vp;
	private VentanaInicio v;
	private VentanaAdministrador va;
	private VentanaFuncionario vf;
	private VentanaUsuario vu;
	private ControladorAlquilerCompra controlAlquilerCompra;
	private ControladorMateriales controlMateriales;
	private ControladorClases controlClases;
	private ControladorInstalaciones controlInstalaciones;
	private UsuarioEnum tipo;
	private String nombre;
	private String nick;
	private FachadaUsuarios usuarios;
	//private JFrame frame;
	
	/**
	 * Constructora del controlador.
	 * 
	 * @param vadmin - interfaz de ls ventana de login para actualizarla según convenga.
	 * @param con - Conexion a la BD.
	 */	
	public ControladorUsuarios(
			Connection con) {
		this.c = con;
		usuarios = new SubSistemaUsuarios(c);
	}
	

	public void altaUsuario(Usuario socio) {
		// TODO Auto-generated method stub
		
	}

	public UsuarioEnum login(String user, String pass) {
		if(usuarios.tipoUsuarioAdmin(c, user, pass) != null)
			return UsuarioEnum.Admin;
		else if(usuarios.tipoUsuarioSocio(c, user, pass) != null)
			return UsuarioEnum.Socio;
		else if(usuarios.tipoUsuarioFuncionario(c, user, pass) != null)
			return UsuarioEnum.Funcionario;
		return null;
	}
	
	public String getNick(){
		return nick;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public ArrayList<Usuario> listaUsuario(UsuarioEnum tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	public void borrarUsuario(Object o) {
		// TODO Auto-generated method stub
		
	}

}
