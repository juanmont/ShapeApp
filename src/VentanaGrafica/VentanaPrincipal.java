package VentanaGrafica;

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
		controlUsuarios = new ControladorUsuarios(con, this);
		controlInstalaciones = new ControladorInstalaciones(c);
		controlClases = new ControladorClases();
		controlMateriales = new ControladorMateriales();
		controlAlquilerCompra = new ControladorAlquilerCompra();
		login = new VentanaInicio(con, controlUsuarios);
		this.setVisible(true);
		this.add(login);
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void SetVisibleLogin(boolean entrada){
		this.login.setVisible(entrada);
	}
	

}
