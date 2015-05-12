package Control;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Daos.DaoAdmin;
import Daos.DaoFuncionario;
import Daos.DaoSocio;
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
	private SubSistemaUsuarios usuarios;
	private UsuarioEnum tipo;
	private String nombre;
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
		this.vp = new VentanaPrincipal(c);
	}
	
	public ControladorUsuarios(
			Connection con, VentanaPrincipal p) {
		this.c = con;
		this.vp = p;
	}

	public void altaUsuario(Usuario socio) {
		// TODO Auto-generated method stub
		
	}

	public void login(String user, String pass) {
		
		usuarios = new SubSistemaUsuarios();
		
		tipo = usuarios.tipoUsuario(c, user, pass);
		
		if (tipo != null) {	
			if(tipo == UsuarioEnum.Admin){
				//this.v.cerrar();
				
				//this.vp.dispose();
				//this.v.setFrame(false);
				this.va = new VentanaAdministrador(c, controlAlquilerCompra, controlMateriales, controlClases, controlInstalaciones, this);
				//this.frame = new JFrame("Ventana Administrador");
				this.vp.setSize(600, 500);
				this.vp.SetVisibleLogin(false);
				this.vp.add(va);
				this.vp.setVisible(true);
				/*this.frame.setSize(600, 500);
				this.frame.add(va);
				this.frame.setVisible(true);*/
				//va.setVisible(true);
			
			}else if(tipo == UsuarioEnum.Funcionario){
				//this.v.cerrar();
					
				//this.v.setFrame(false);
					
				this.vf = new VentanaFuncionario(c, controlAlquilerCompra, controlMateriales, controlClases, controlInstalaciones, this);
				this.vp.setSize(600, 500);
				this.vp.add(vf);
				this.vp.setVisible(true);
					
			}else if(tipo == UsuarioEnum.Socio){
				
				//this.v.cerrar();
					
				//this.v.setVisible(false);
				nombre = user;
				this.vu = new VentanaUsuario(c, controlAlquilerCompra, controlMateriales, controlClases, controlInstalaciones, this);
				this.vp.setSize(550, 400);
				this.vp.add(vu);
				this.vp.setVisible(true);
				
			}
		} else {
			JOptionPane.showMessageDialog(null,  "Error: Contraseña incorrecta.","", JOptionPane.ERROR_MESSAGE);
		}
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
