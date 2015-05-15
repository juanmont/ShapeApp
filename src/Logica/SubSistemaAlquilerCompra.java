package Logica;

import java.util.ArrayList;

import transfers.BonoUsuario;
import transfers.ClaseSocio;
import transfers.Clases;
import transfers.Entrenador;
import transfers.InstalacionUsuario;
import transfers.MaterialUsuario;
import transfers.Bono;
import Daos.DaoBono;
import Daos.DaoBonoUsuario;
import Daos.DaoClase;
import Daos.DaoClaseSocio;
import Daos.DaoEntrenador;
import Daos.DaoInstalacionUsuario;
import Daos.DaoMaterialUsuario;

import com.mysql.jdbc.Connection;

import enums.BonoEnum;
import enums.ClaseEnum;

public class SubSistemaAlquilerCompra implements FachadaAlquilerCompra {

	private Connection c;
	private DaoBonoUsuario bonoU;
	private DaoBono bono;
	private DaoClase clase;
	private DaoClaseSocio claseS;
	private DaoInstalacionUsuario insta;
	private DaoMaterialUsuario mat;
	private DaoEntrenador entre;
	private ArrayList<InstalacionUsuario> listaIU;
	private ArrayList<Entrenador> listaE;
	private ArrayList<MaterialUsuario> listaM;
	
	public SubSistemaAlquilerCompra(Connection con) {
		this.c = con;
		bono = new DaoBono();
		bonoU = new DaoBonoUsuario();
		clase = new DaoClase();
		claseS = new DaoClaseSocio();
		insta = new DaoInstalacionUsuario();
		mat = new DaoMaterialUsuario();
		entre = new DaoEntrenador();
		listaIU = new ArrayList<InstalacionUsuario>();
		listaE = new ArrayList<Entrenador>();
		listaM = new ArrayList<MaterialUsuario>();
		
	}
	
	@Override
	public ArrayList<InstalacionUsuario> listaInstalaciones() {
		return listaIU;
	}

	@Override
	public ArrayList<Entrenador> listaEntrenadores() {
		return listaE;
		
	}

	@Override
	public ArrayList<MaterialUsuario> listaMateriales() {
		return listaM;
		
	}

	@Override
	public void alquilerInstalacion(InstalacionUsuario insta) {
		if(insta != null) {
			this.insta.insertInstalacionUsuario(c, insta);
		}
	}

	@Override
	public void alquilerMaterial(MaterialUsuario alqui) {
		if(alqui != null) {
			this.mat.insertMaterialUsuario(c, alqui);
		}
		
	}

	@Override
	public void contratacionEntrenador(ClaseSocio claseU) {
		if(claseU != null){
			Clases cla = this.clase.findById(c, claseU.getId_clase());
			if(cla.getClase() == ClaseEnum.INDIVIDUAL) {
				this.claseS.insertClaseSocio(c, claseU);
			}
		}
		
	}

	@Override
	public void contratacionClase(ClaseSocio claseU) {
		if(claseU != null){
			Clases cla = this.clase.findById(c, claseU.getId_clase());
			if(cla.getClase() == ClaseEnum.GRUPO) {
				this.claseS.insertClaseSocio(c, claseU);
			}
		}
	}

	@Override
	public void compraAbonoPis(BonoUsuario bonoU) {
		if(bonoU != null) {
			Bono b = this.bono.findById(c, bonoU.getBonoId());
			if(b.getBono() == BonoEnum.PISCINA) {
				this.bonoU.insertBonoUsuario(c, bonoU);
			}
		}
	}

	@Override
	public void compraAbonoGim(BonoUsuario bonoU) {
		if(bonoU != null) {
			Bono b = this.bono.findById(c, bonoU.getBonoId());
			if(b.getBono() == BonoEnum.GIMNASIO) {
				this.bonoU.insertBonoUsuario(c, bonoU);
			}
		}
	}

}
