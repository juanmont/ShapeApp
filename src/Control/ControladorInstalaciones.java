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
		instalaciones = new SubSistemaInstalaciones(c);
		
	}

	public ArrayList<Instalaciones> listaInstalaciones() {
		return instalaciones.listaInstalaciones();
	}

	public boolean borrarInstalacion(Object o) {
		return false;
		// TODO Auto-generated method stub
		
	}

	public boolean AltaInstalacion(String numero, String tipoDeporte, String tipo) {
		ins.setNumero(Integer.parseInt(numero));
		ins.setTipo(tipoDeporte);
		ins.setPista(tipo);
		return instalaciones.altaInstalacion(ins);
	}

	public boolean[] verHoras(Instalaciones insta) {
		// TODO Auto-generated method stub
		return instalaciones.verHoras(insta);
	}

}
