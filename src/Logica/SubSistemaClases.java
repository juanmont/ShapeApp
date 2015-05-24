package Logica;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import enums.ClaseEnum;
import transfers.Clases;
import transfers.Entrenador;
import transfers.InstalacionUsuario;
import transfers.Instalaciones;
import Daos.DaoClase;
import Daos.DaoInstalacionUsuario;


public class SubSistemaClases implements FachadaClases {

	private Connection con;
	private DaoClase clas;
	private ArrayList<Clases> lista;
	private DaoInstalacionUsuario instU;
	private Date fecha;
	
	public SubSistemaClases(Connection con){
		this.con = con;
		clas = new DaoClase();
		fecha = new Date();
		instU = new DaoInstalacionUsuario();
		lista = new ArrayList<Clases>();
	}

	@Override
	public ArrayList<Clases> listaClasesAll() {
		lista = (ArrayList<Clases>) clas.findAll(con);
		return lista;
	}
	
	public ArrayList<Clases> listaClasesInd() {
		return lista = (ArrayList<Clases>) clas.findByIndividualGrupo(con, ClaseEnum.INDIVIDUAL.toString());
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
	
	public boolean[] verHorasEntrenador(Entrenador entre) {
		boolean[] horasLibres = new boolean[12];//empieza a las 9 y acaba a las 20
		Arrays.fill(horasLibres, true);
		/*listaIU = (ArrayList<InstalacionUsuario>) instU.findByInstalacion(this.c, insta.getNumero());
		for (int i = 0; i < listaIU.size(); i++) {
			if((listaIU.get(i).getDia().getDate() == fecha.getDate()) && (fecha.getMonth() == listaIU.get(i).getDia().getMonth()))
				horasLibres[listaIU.get(i).getHorario() - 9] = false;
		}
		*/
		//instu.insertInstalacionUsuario(connection, instalacionUsuario)
		return horasLibres;
	}
	
	public boolean[] verHorasClases(Clases clas) {
		boolean[] horasLibres = new boolean[12];//empieza a las 9 y acaba a las 20
		Arrays.fill(horasLibres, true);
	
		List<InstalacionUsuario> listaIU = instU.findByClase(con, clas.getId());
		for (int i = 0; i < listaIU.size(); i++) {
			if((listaIU.get(i).getDia().getDate() == fecha.getDate()) && (fecha.getMonth() == listaIU.get(i).getDia().getMonth()))
				horasLibres[listaIU.get(i).getHorario() - 9] = false;
		}
		
		//instu.insertInstalacionUsuario(connection, instalacionUsuario)
		return horasLibres;
	}

}
