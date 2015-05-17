package Main;

import java.sql.Connection;

import VentanaGrafica.VentanaInicio;
import VentanaGrafica.VentanaPrincipal;
import Daos.Conexion;

public class Main {
	
	static VentanaInicio login;
	Connection con;
	
	public static void main(String[] args){
		Connection con = Conexion.obtenerConexion();
		new VentanaPrincipal(con);
	}
	
}

