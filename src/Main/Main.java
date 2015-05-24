package Main;

import java.sql.Connection;

import enums.BonoEnum;
import enums.DisponibilidadEnum;
import enums.PistaEnum;
import enums.TipoEnum;
import transfers.Bono;
import transfers.Instalaciones;
import VentanaGrafica.VentanaInicio;
import VentanaGrafica.VentanaPrincipal;
import Daos.Conexion;
import Logica.SubSistemaAlquilerCompra;
import Logica.SubSistemaInstalaciones;

public class Main {
	
	public static void main(String[] args){
		Connection con = Conexion.obtenerConexion();
		new VentanaPrincipal(con);
		/*SubSistemaAlquilerCompra sub = new SubSistemaAlquilerCompra(con);
		Bono bonoU = new Bono();
		bonoU.setBono(BonoEnum.GIMNASIO.toString());
		bonoU.setMeses(2);
		bonoU.setNick("julia18");
		bonoU.setPrecio(13);
		sub.compraAbonoGim(bonoU);*/
		
	}
	
}

