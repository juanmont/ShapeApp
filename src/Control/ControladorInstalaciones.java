package Control;

import java.sql.Connection;
import java.util.ArrayList;

import Logica.FachadaInstalaciones;
import Logica.SubSistemaInstalaciones;
import enums.PistaEnum;
import transfers.Instalaciones;

public class ControladorInstalaciones {

	Connection c;
	FachadaInstalaciones instalaciones;
	Instalaciones ins;
	
	public ControladorInstalaciones(Instalaciones insta) {
		this.ins = insta;
	}
	
	public ControladorInstalaciones(Connection con) {
		this.c = con;
	}

	public ArrayList<Instalaciones> listaInstalaciones() {
		// TODO Auto-generated method stub
		return instalaciones.listaInstalaciones();
	}

	public boolean borrarInstalacion(Object o) {
		return false;
		// TODO Auto-generated method stub
		
	}

	public boolean AltaInstalacion(String text, String string, PistaEnum tipo) {
		if (text != null && string != null && tipo != null) {
			instalaciones.altaInstalacion(ins);
			return true;
		} else
			return false;
	}

	public ArrayList<Instalaciones> verHoras() {
		// TODO Auto-generated method stub
		return null;
	}

}
