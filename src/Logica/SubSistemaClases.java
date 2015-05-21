package Logica;

import java.sql.Connection;
import java.util.ArrayList;

import transfers.Clases;
import Daos.DaoClase;


public class SubSistemaClases implements FachadaClases {

	private Connection con;
	private DaoClase clas;
	private ArrayList<Clases> lista;
	
	public SubSistemaClases(Connection con){
		this.con = con;
		clas = new DaoClase();
		lista = new ArrayList<Clases>();
	}

	@Override
	public ArrayList<Clases> listaClases() {
		lista = (ArrayList<Clases>) clas.findAll(con);
		return lista;
	}

	@Override
	public boolean altaClase(Clases clase) {
		if(clase != null){
			int a = clas.insertClase(con, clase);
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
	public boolean bajaClase(Clases clase) {
		if(clase != null){
			int a = clas.borrarClase(con, clase.getId());
			if (a == 1) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
