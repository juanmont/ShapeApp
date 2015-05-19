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
	
	public ControladorInstalaciones(Instalaciones insta, Connection con) {
		this.c = con;
		this.ins = insta;
		instalaciones = new SubSistemaInstalaciones(c);
	}
	
	public ControladorInstalaciones(Connection con) {
		ins = new Instalaciones();
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

	public boolean AltaInstalacion(String numero, String tipoDeporte, PistaEnum tipoPista) {
		ins.setNumero(Integer.parseInt(numero));
		ins.setTipo(tipoDeporte);
		ins.setPista(tipoPista.toString());
		return instalaciones.altaInstalacion(ins);
	}

	public ArrayList<Instalaciones> verHoras() {
		// TODO Auto-generated method stub
		return null;
	}

}
