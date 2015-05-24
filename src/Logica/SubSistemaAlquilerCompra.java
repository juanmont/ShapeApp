package Logica;

import java.util.ArrayList;

import transfers.ClaseSocio;
import transfers.Clases;
import transfers.Entrenador;
import transfers.InstalacionUsuario;
import transfers.MaterialUsuario;
import transfers.Bono;
import Daos.DaoBono;
import Daos.DaoClase;
import Daos.DaoClaseSocio;
import Daos.DaoEntrenador;
import Daos.DaoInstalacionUsuario;
import Daos.DaoMaterialUsuario;

import java.sql.Connection;

import enums.BonoEnum;
import enums.ClaseEnum;

public class SubSistemaAlquilerCompra implements FachadaAlquilerCompra {

	private Connection c;
	private DaoBono bonoU;
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
		bonoU = new DaoBono();
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
	public boolean alquilerInstalacion(InstalacionUsuario insta) {
		if(insta != null) {
			int a = this.insta.insertInstalacionUsuario(c, insta);
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
	public boolean alquilerMaterial(MaterialUsuario alqui) {
		if(alqui != null) {
			int a = this.mat.insertMaterialUsuario(c, alqui);
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
	public boolean contratacionEntrenador(ClaseSocio claseU) {
		if(claseU != null){
			Clases cla = this.clase.findById(c, claseU.getId_clase());
			if(cla.getClase() == ClaseEnum.INDIVIDUAL) {
				int a = this.claseS.insertClaseSocio(c, claseU);
				if (a == 1) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
		
	}

	@Override
	public boolean contratacionClase(ClaseSocio claseU) {
		if(claseU != null){
			Clases cla = this.clase.findById(c, claseU.getId_clase());
			if(cla.getClase() == ClaseEnum.GRUPO) {
				int a = this.claseS.insertClaseSocio(c, claseU);
				if (a == 1) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean compraAbonoPis(Bono bonoU) {
		if(bonoU != null) {
			if(bonoU.getBono() == BonoEnum.PISCINA) {
				int a = this.bonoU.insertBonoUsuario(c, bonoU);
				if (a == 1) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean compraAbonoGim(Bono bonoU) {
		if(bonoU != null) {
			if(bonoU.getBono() == BonoEnum.GIMNASIO) {
				int a = this.bonoU.insertBonoUsuario(c, bonoU);
				if (a == 1) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
