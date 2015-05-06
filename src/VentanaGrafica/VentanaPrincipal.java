package VentanaGrafica;

import javax.swing.JFrame;

import Control.ControladorAlquilerCompra;
import Control.ControladorClases;
import Control.ControladorInstalaciones;
import Control.ControladorMateriales;
import Control.ControladorUsuarios;

public class VentanaPrincipal extends JFrame{
	ControladorAlquilerCompra controlAlquilerCompra;
	ControladorMateriales controlMateriales;
	ControladorClases controlClases;
	ControladorInstalaciones controlInstalaciones;
	ControladorUsuarios controlUsuarios;
	VentanaInicio login;
	
	public VentanaPrincipal(ControladorAlquilerCompra controlAlqComp, ControladorMateriales controlMat,
			ControladorClases controlCla, ControladorInstalaciones controlInst, ControladorUsuarios controlUsu){
		
		login = new VentanaInicio();
		controlAlquilerCompra = controlAlqComp;
		controlMateriales = controlMat;
		controlClases = controlCla;
		controlInstalaciones = controlInst;
		controlUsuarios = controlUsu;
		this.add(login);
		this.pack();
	}

}
