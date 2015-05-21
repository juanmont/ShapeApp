package Control;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection;

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
import transfers.Entrenador;
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
	

	public void altaUsuario(Socio socio, Admin admin, Funcionario funcionario, Entrenador entrenador) {
		usuarios.altaUsuario(socio, admin, funcionario, entrenador);
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
	
	public ArrayList<Entrenador> listaEntrenador() {
			return usuarios.getListaEntrenador();
	}
	
	public ArrayList<Socio> listaSocios() {
		return usuarios.getListaSocio();
	}
	
	public ArrayList<Funcionario> listaFuncionarios() {
		return usuarios.getListaFuncionario();
	}
	
	public ArrayList<Admin> listaAdmin() {
		return usuarios.getListaAdmin();
	}

	public void borrarUsuario(Usuario socio, UsuarioEnum tipo) {
		if(tipo == UsuarioEnum.Socio)
			usuarios.bajaUsuario(((Socio)socio), ((Admin)null), ((Funcionario)null), ((Entrenador)null));
		else if(tipo == UsuarioEnum.Admin)
			usuarios.bajaUsuario(((Socio)null), ((Admin)socio), ((Funcionario)null), ((Entrenador)null));
		else if(tipo == UsuarioEnum.Funcionario)
			usuarios.bajaUsuario(((Socio)null), ((Admin)null), ((Funcionario)socio), ((Entrenador)null));
		else if(tipo == UsuarioEnum.Entrenador)
			usuarios.bajaUsuario(((Socio)null), ((Admin)null), ((Funcionario)null), ((Entrenador)socio));
		// TODO Auto-generated method stub
		
	}

}
