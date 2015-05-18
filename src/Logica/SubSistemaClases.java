package Logica;

import java.util.ArrayList;

import transfers.Clases;
import Daos.DaoClase;

import com.mysql.jdbc.Connection;

public class SubSistemaClases implements FachadaClases {

	private Connection con;
	private DaoClase clas;
	
	public SubSistemaClases(Connection con){
		this.con = con;
		clas = new DaoClase();
	}

	@Override
	public ArrayList<Clases> listaClases() {
		// TODO Auto-generated method stub
		return (ArrayList<Clases>) clas.findAll(this.con);
	}

	@Override
	public int altaClase(Clases clase) {
		// TODO Auto-generated method stub 
		return clas.insertClase(this.con, clase);
	}

	@Override
	public int bajaClase(Clases clase) {
		// TODO Auto-generated method stub
		return clas.borrarClase(this.con, clase.getId());
	}

}
