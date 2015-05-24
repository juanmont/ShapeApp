package Control;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import Logica.FachadaMateriales;
import Logica.SubSistemaMateriales;
import transfers.Material;
import transfers.MaterialUsuario;

public class ControladorMateriales {
	private FachadaMateriales materiales;
	
	public ControladorMateriales(Connection c){
		materiales = new SubSistemaMateriales(c);
	}

	public ArrayList<Material> listaMateriales() {
		return materiales.listaMateriales();
	}

	public boolean borrarMaterial(Material o) {
		return materiales.bajaMaterial(o);
	}
	
	public boolean[] VerHoras(int id){
		return materiales.verHoras(id);
	}

	public boolean AltaMaterial(String nombre, String descripcion, String tipo) {
		Material mat = new Material();
		mat.setNombre(nombre);
		mat.setDescripcion(descripcion);
		mat.setTipo(tipo);
		return materiales.altaMaterial(mat);
	}

}
