package Logica;

import java.sql.Connection;
import java.util.ArrayList;

import Daos.DaoMaterial;
import Daos.DaoMaterialUsuario;
import transfers.Material;

public class SubSistemaMateriales implements FachadaMateriales {

	private DaoMaterial materiales;
	private DaoMaterialUsuario materialesU;
	private Connection c;
	private ArrayList<Material> lista;
	
	public SubSistemaMateriales(Connection con) {
		this.c = con;
		materiales = new DaoMaterial();
		materialesU = new DaoMaterialUsuario();
		lista = new ArrayList<Material>();
	}
	
	@Override
	public ArrayList<Material> listaMateriales() {
		return lista;		
	}

	@Override
	public boolean altaMaterial(Material mat) {
		if(mat != null) {
			materiales.insertMaterial(this.c, mat);
			lista.add(mat);
		} else {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean bajaMaterial(Material mat) {
		if (mat != null) {
			materiales.borrarMaterial(this.c, mat.getId());
			lista.remove(mat.getId());
		} else {
			return false;
		}
		return true;
	}

	@Override
	public boolean modificarMaterial(Material mat) {
		if (mat != null) {
			materiales.modificarMaterial(this.c, mat);
		} else {
			return false;
		}
		return true;
	}

	@Override
	public Material verMaterial(Material mat) {
		if (mat != null) {
			return materiales.findById(this.c, mat.getId());
		} else {
			return null;
		}
	}

}
