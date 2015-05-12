package Main;

import java.sql.Connection;

import VentanaGrafica.VentanaInicio;
import VentanaGrafica.VentanaPrincipal;
import enums.SexoEnum;
import transfers.Admin;
import transfers.Material;
import transfers.Socio;
import Control.ControladorAlquilerCompra;
import Control.ControladorClases;
import Control.ControladorInstalaciones;
import Control.ControladorMateriales;
import Control.ControladorUsuarios;
import Daos.Conexion;
import Daos.DaoAdmin;
import Daos.DaoMaterial;
import Daos.DaoSocio;

public class Main {
	
	static VentanaInicio login;
	Connection con;
	
	public static void main(String[] args){
		Connection con = Conexion.obtenerConexion();
		new VentanaPrincipal(con);
	}
	
}

