package Control;

import java.sql.Connection;
import java.util.ArrayList;

import Logica.FachadaClases;
import Logica.SubSistemaClases;
import transfers.Clases;
import transfers.Entrenador;

public class ControladorClases {
	private FachadaClases subsClases;
	private Clases clase;
	
	public ControladorClases(Connection con){
		subsClases = new SubSistemaClases(con);
	}
	
	public ControladorClases(Clases cla, Connection con){
		clase = cla;
		subsClases = new SubSistemaClases(con);
	}
	
	public ArrayList<Clases> listaClases() {
		return subsClases.listaClases();
	}

	public boolean altaClase(Entrenador entrenador, String tipoClase, String tipoDeporte) {
		clase = new Clases();
		clase.setIdEntrenador(entrenador.getNick());
		clase.setTipo(tipoDeporte);
		clase.setClase(tipoClase);
		return subsClases.altaClase(clase);
	}

	public boolean borrarClase(Clases clases) {
		return subsClases.bajaClase(clases);
	}

}
