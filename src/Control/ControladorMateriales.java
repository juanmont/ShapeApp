package Control;

import java.sql.Connection;
import java.util.ArrayList;

import Logica.FachadaMateriales;
import Logica.SubSistemaMateriales;
import transfers.Material;

public class ControladorMateriales {
	private FachadaMateriales materiales;
	
	public ControladorMateriales(Connection c){
		materiales = new SubSistemaMateriales(c);
	}

	public ArrayList<Material> listaMateriales() {
		// TODO Auto-generated method stub
		return null;
	}

	public void borrarMaterial(Object o) {
		// TODO Auto-generated method stub
		
	}

	public boolean AltaMaterial(String nombre, String descripcion, String tipo) {
		Material mat = new Material();
		mat.setNombre(nombre);
		mat.setDescripcion(descripcion);
		mat.setTipo(tipo);
		return materiales.altaMaterial(mat);
	}

}
