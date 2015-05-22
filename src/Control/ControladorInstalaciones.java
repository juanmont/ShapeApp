package Control;

import java.sql.Connection;
import java.util.ArrayList;

import Logica.FachadaInstalaciones;
import Logica.SubSistemaInstalaciones;
import enums.DisponibilidadEnum;
import enums.PistaEnum;
import transfers.Instalaciones;

public class ControladorInstalaciones {

	Connection c;
	FachadaInstalaciones instalaciones;
	Instalaciones ins;
	
	public ControladorInstalaciones(Instalaciones insta, Connection con) {
		this.c = con;
		this.ins = insta;
		instalaciones = new SubSistemaInstalaciones(c);
	}
	
	public ControladorInstalaciones(Connection con) {
		ins = new Instalaciones();
		this.c = con;
		instalaciones = new SubSistemaInstalaciones(c);
		
	}

	public ArrayList<Instalaciones> listaInstalaciones() {
		return instalaciones.listaInstalaciones();
	}

	public boolean borrarInstalacion(Object o) {
		return false;
		// TODO Auto-generated method stub
		
	}

	public boolean AltaInstalacion(String Disponibilidad, String tipoDeporte, PistaEnum tipo) {
		ins.setDisponibilidad(Disponibilidad);
		ins.setTipo(tipoDeporte);
		ins.setPista(tipo.toString());
		return instalaciones.altaInstalacion(ins);
	}

	public ArrayList<Instalaciones> verHoras() {
		// TODO Auto-generated method stub
		return null;
	}

}
