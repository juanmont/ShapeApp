package VentanaGrafica;

import java.awt.BorderLayout;
import java.sql.Connection;

import javax.swing.JFrame;

import transfers.Socio;
import Control.ControladorAlquilerCompra;
import Control.ControladorClases;
import Control.ControladorInstalaciones;
import Control.ControladorMateriales;
import Control.ControladorUsuarios;
import Daos.Conexion;

public class VentanaPrincipal extends JFrame{
	ControladorAlquilerCompra controlAlquilerCompra;
	ControladorMateriales controlMateriales;
	ControladorClases controlClases;
	ControladorInstalaciones controlInstalaciones;
	ControladorUsuarios controlUsuarios;
	VentanaInicio login;
	Connection con;
	
	public VentanaPrincipal(Connection c) {
		// TODO Auto-generated constructor stub
		this.con = c;
		controlUsuarios = new ControladorUsuarios(con);
		controlInstalaciones = new ControladorInstalaciones(c);
		controlClases = new ControladorClases();
		controlMateriales = new ControladorMateriales();
		controlAlquilerCompra = new ControladorAlquilerCompra();
		login = new VentanaInicio(this,con, controlUsuarios);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		this.add(login, BorderLayout.CENTER);
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void SetVisibleLogin(boolean entrada){
		this.login.setVisible(entrada);
	}
	
	public void cambiaVentanaAdmin(){
		VentanaAdministrador vAdmin = new VentanaAdministrador(con, controlAlquilerCompra, controlMateriales, 
				controlClases, controlInstalaciones, controlUsuarios);
		login.setVisible(false);
		this.add(vAdmin, BorderLayout.CENTER);
		vAdmin.setVisible(true);
	}
	

}
