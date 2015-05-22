package Control;

import java.sql.Connection;
import java.util.ArrayList;

import Logica.FachadaMateriales;
import Logica.SubSistemaMateriales;
import transfers.Material;

public class ControladorMateriales {
	private FachadaMateriales materiales;
	private Material mat;
	
	public ControladorMateriales(Connection c){
		materiales = new SubSistemaMateriales(c);
	}
	
	public ControladorMateriales(Material m, Connection c){
		mat = m;
		materiales = new SubSistemaMateriales(c);
	}

	public ArrayList<Material> listaMateriales() {
		return materiales.listaMateriales();
	}

	public boolean borrarMaterial(Material o) {
		return materiales.bajaMaterial(o);
	}

	public boolean AltaMaterial(String nombre, String descripcion, String tipo) {
		mat = new Material();
		mat.setNombre(nombre);
		mat.setDescripcion(descripcion);
		mat.setTipo(tipo);
		return materiales.altaMaterial(mat);
	}

}
