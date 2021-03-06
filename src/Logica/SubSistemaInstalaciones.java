package Logica;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.util.Date;

import transfers.InstalacionUsuario;
import transfers.Instalaciones;
import Daos.DaoInstalacionUsuario;
import Daos.DaoInstalaciones;

public class SubSistemaInstalaciones implements FachadaInstalaciones {

	private DaoInstalaciones instalaciones;
	private DaoInstalacionUsuario instU;
	private Connection c;
	private ArrayList<Instalaciones> lista;
	private ArrayList<InstalacionUsuario> listaIU;
	private Date fecha;
	
	public SubSistemaInstalaciones(Connection con) {
		this.c = con;
		instalaciones = new DaoInstalaciones();
		instU = new DaoInstalacionUsuario();
		lista = new ArrayList<Instalaciones>();
		listaIU = new ArrayList<InstalacionUsuario>();
		fecha = new Date();
	}
	
	public boolean altaInstalacion(Instalaciones insta) {
		if (insta != null) {
			instalaciones.insertInstalacion(this.c, insta);
			lista.add(insta);
		} else {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean bajaInstalacion(Instalaciones insta) {
		if (insta != null) {
			instalaciones.borrarInstalacion(this.c, insta.getNumero());
			lista.remove(insta.getNumero());
		} else {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean modificarInstalacion(Instalaciones insta) {
		if (insta != null) {
			instalaciones.modificarInstalacion(this.c, insta);
		} else {
			return false;
		}
		return true;
	}

	@Override
	public Instalaciones verInstalacion(Instalaciones insta) {
		if (insta != null) {
			return instalaciones.findByNumero(this.c, insta.getNumero());
		} else {
			return null;
		}
	}

	@Override
	public ArrayList<Instalaciones> listaInstalaciones() {
		return lista;
	}

	@Override
	public boolean[] verHoras(Instalaciones insta) {
		boolean[] horasLibres = new boolean[12];//empieza a las 9 y acaba a las 20
		Arrays.fill(horasLibres, true);
		listaIU = (ArrayList<InstalacionUsuario>) instU.findByInstalacion(this.c, insta.getNumero());
		for (int i = 0; i < listaIU.size(); i++) {
			if((listaIU.get(i).getDia().getDate() == fecha.getDate()) && (fecha.getMonth() == listaIU.get(i).getDia().getMonth()))
				horasLibres[listaIU.get(i).getHorario() - 9] = false;
		}
		
		//instu.insertInstalacionUsuario(connection, instalacionUsuario)
		return horasLibres;
	}

}
