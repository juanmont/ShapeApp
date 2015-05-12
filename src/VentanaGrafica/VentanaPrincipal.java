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
	
	/**
	 * Este es el contructor de la clase
	 * @param controlAlqComp
	 * @param controlMat
	 * @param controlCla
	 * @param controlInst
	 * @param controlUsu
	 */
	public VentanaPrincipal(ControladorAlquilerCompra controlAlqComp, ControladorMateriales controlMat,
			ControladorClases controlCla, ControladorInstalaciones controlInst, ControladorUsuarios controlUsu){
	
		controlAlquilerCompra = controlAlqComp;
		controlMateriales = controlMat;
		controlClases = controlCla;
		controlInstalaciones = controlInst;
		controlUsuarios = controlUsu;
		login = new VentanaInicio(controlUsuarios);
		
		this.add(login);
		this.pack();
	}

}
