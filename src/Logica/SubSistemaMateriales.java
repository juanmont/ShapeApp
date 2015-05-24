package Logica;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import Daos.DaoMaterial;
import Daos.DaoMaterialUsuario;
import transfers.Clases;
import transfers.InstalacionUsuario;
import transfers.Instalaciones;
import transfers.Material;
import transfers.MaterialUsuario;

public class SubSistemaMateriales implements FachadaMateriales {

	private DaoMaterial materiales;
	private DaoMaterialUsuario materialesU;
	private Connection c;
	private ArrayList<Material> lista;
	private ArrayList<MaterialUsuario> listaIU;
	private Date fecha;
	
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
	
	public boolean[] verHoras(int id) {
		fecha = new Date();
		boolean[] horasLibres = new boolean[12];//empieza a las 9 y acaba a las 20
		Arrays.fill(horasLibres, true);
		listaIU = (ArrayList<MaterialUsuario>) materialesU.findByMaterial(c, id);
		for (int i = 0; i < listaIU.size(); i++) {
			if((listaIU.get(i).getDia().getDate() == fecha.getDate()) && (fecha.getMonth() == listaIU.get(i).getDia().getMonth()))
				horasLibres[listaIU.get(i).getHorario() - 9] = false;
		}
		
		//instu.insertInstalacionUsuario(connection, instalacionUsuario)
		return horasLibres;
	}

}
