package Logica;

import java.sql.Connection;
import java.util.ArrayList;

import Daos.DaoMaterial;
import Daos.DaoMaterialUsuario;
import transfers.Clases;
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
		lista = (ArrayList<Material>) materiales.findAll(c);
		return lista;		
	}

	@Override
	public boolean altaMaterial(Material mat) {
		if(mat != null) {
			int a = materiales.insertMaterial(this.c, mat);
			if(a == 1) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean bajaMaterial(Material mat) {
		if (mat != null) {
			int a = materiales.borrarMaterial(this.c, mat.getId());
			if (a == 1) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean modificarMaterial(Material mat) {
		if (mat != null) {
			int a = materiales.modificarMaterial(this.c, mat);
			if (a == 1) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
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
