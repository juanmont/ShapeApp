package Control;

import java.sql.Connection;
import java.util.ArrayList;

import Logica.SubSistemaClases;
import transfers.Clases;
import transfers.Entrenador;

public class ControladorClases {
	
	private Connection con;
	private SubSistemaClases subCla;
	
	public ControladorClases(Connection con){
		this.con = con;
		subCla = new SubSistemaClases(this.con);
	}

	public boolean borrarClase(Clases clases) {
		return subCla.bajaClase(clases);
	}
	
	public ArrayList<Clases> listaClasesAll() {
		// TODO Auto-generated method stub
		return subCla.listaClasesAll();
	}
	
	public ArrayList<Clases> listaClasesIndividual(){
		return subCla.listaClasesInd();
	}
	
	public boolean[] verHoras(Clases clase){
		return subCla.verHorasClases(clase);
	}
	
	public boolean altaClase(Entrenador entrenador, String tipoClase, String tipoDeporte) {
		Clases clase = new Clases();
		clase.setIdEntrenador(entrenador.getNick());
		clase.setTipo(tipoDeporte);
		clase.setClase(tipoClase);
		return subCla.altaClase(clase);
	}
	
	public boolean AltaClase(Clases clase){
		return subCla.altaClase(clase);
	}

}
