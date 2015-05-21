package Logica;

import java.sql.Connection;
import java.util.ArrayList;

import enums.UsuarioEnum;
import transfers.Admin;
import transfers.Clases;
import transfers.Entrenador;
import transfers.Funcionario;
import transfers.Socio;
import transfers.Usuario;
import Daos.DaoAdmin;
import Daos.DaoEntrenador;
import Daos.DaoFuncionario;
import Daos.DaoSocio;

public class SubSistemaUsuarios implements FachadaUsuarios {
	private DaoAdmin adminDao;
	private DaoFuncionario funDao;
	private DaoSocio socDao;
	private DaoEntrenador entDao;
	private Connection con;
	private ArrayList<Usuario> lista;
	private ArrayList<Socio> listaS;
	private ArrayList<Entrenador> listaE;
	private ArrayList<Funcionario> listaF;
	private ArrayList<Admin> listaA;

	public SubSistemaUsuarios(Connection con){
		adminDao = new DaoAdmin();
		funDao = new DaoFuncionario();
		socDao = new DaoSocio();
		entDao = new DaoEntrenador();
		lista = new ArrayList<Usuario>();
		listaS = new ArrayList<Socio>();
		listaA = new ArrayList<Admin>();
		listaE = new ArrayList<Entrenador>();
		listaF = new ArrayList<Funcionario>();
		this.con = con;
	}
	
	
	
	@Override
	public boolean altaUsuario(Socio s, Admin ad, Funcionario f, Entrenador e) {
		if(s != null){
			int a = socDao.insertSocio(con, s);
			if (a == 1) {
				return true;
			} else {
				return false;
			}
		}else if(ad != null){
			int a = adminDao.insertAdmin(con, ad);
			if (a == 1) {
				return true;
			} else {
				return false;
			}
		}else if(f != null){
			int a = funDao.insertAdmin(con, f);
			if (a == 1) {
				return true;
			} else {
				return false;
			}
		}else if(e != null){
			int a = entDao.insertEntrenador(con, e);
			if (a == 1) {
				return true;
			} else {
				return false;
			}
		}else
			return false;
	}

	@Override
	public boolean modificarUsuario(Socio s, Admin ad, Funcionario f, Entrenador e) {
		if(s != null){
			socDao.modificarSocio(con, s);
		}else if(ad != null){
			adminDao.modificarAdmin(con, ad);
		}else if(f != null){
			funDao.modificarFuncionario(con, f);
		}else if(e != null){
			entDao.modificarEntrenador(con, e);
		}else
			return false;	
		return true;
	}

	@Override
	public boolean bajaUsuario(Socio s, Admin ad, Funcionario f, Entrenador e) {
		if(s != null){
			socDao.borrarSocio(con, s.getNick());
		}else if(ad != null){
			adminDao.borrarAdmin(con, ad.getNick());
		}else if(f != null){
			funDao.borrarAdmin(con, f.getNick());
		}else if(e != null){
			entDao.borrarEntrenador(con, e.getNick());
		}else
			return false;	
		return true;
		
	}

	@Override
	public Usuario verUsuario(Socio s, Admin ad, Funcionario f, Entrenador e) {
		if(s != null){
			return socDao.findByNick(con, s.getNick());
		}else if(ad != null){
			return adminDao.findByNick(con, ad.getNick());
		}else if(f != null){
			return funDao.findByNick(con, f.getNick());
		}else if (e != null){
			return entDao.findByNick(con, f.getNick());
		}else
			return null;
	}

	public ArrayList<Admin> getListaAdmin() {
		listaA = (ArrayList<Admin>) adminDao.findAll(con);
		return listaA;
	}
	
	public ArrayList<Socio> getListaSocio(){
		listaS = (ArrayList<Socio>) socDao.findAll(con);
		return listaS;
	}
	
	public ArrayList<Funcionario> getListaFuncionario(){
		listaF = (ArrayList<Funcionario>) funDao.findAll(con);
		return listaF;
	}
	
	public ArrayList<Entrenador> getListaEntrenador(){
		listaE = (ArrayList<Entrenador>) entDao.findAll(con);
		return listaE;
	}

	@Override
	public UsuarioEnum tipoUsuario(Connection c, String user, String pass) {
		if(adminDao.findByNick(c, user) != null && adminDao.findByNick(c, user).getPass().equalsIgnoreCase(pass)) {
			return UsuarioEnum.Admin;
		} else if (funDao.findByNick(c, user) != null && funDao.findByNick(c, user).getPass().equalsIgnoreCase(pass)) {
			return UsuarioEnum.Funcionario;
		} else if (socDao.findByNick(c, user) != null && socDao.findByNick(c, user).getPass().equalsIgnoreCase(pass)) {
			return UsuarioEnum.Socio;
		} else if (entDao.findByNick(c, user) != null && entDao.findByNick(c, user).getPass().equalsIgnoreCase(pass)) {
			return UsuarioEnum.Entrenador;
		}else {
			return null;
		}
	}


	@Override
	public Funcionario tipoUsuarioFuncionario(Connection c, String user, String pass) {
		Funcionario fun = funDao.findByNick(c, user);
		if (fun != null && funDao.findByNick(c, user).getPass().equalsIgnoreCase(pass)) {
			return fun;
		} else {
			return null;
		}
	}



	@Override
	public Socio tipoUsuarioSocio(Connection c, String user, String pass) {
		Socio soc = socDao.findByNick(c, user);
		if (soc != null && socDao.findByNick(c, user).getPass().equalsIgnoreCase(pass)) {
			return soc;
		} else {
			return null;
		}
	}



	@Override
	public Admin tipoUsuarioAdmin(Connection c, String user, String pass) {
		Admin admin = adminDao.findByNick(c, user);
		if(admin != null && adminDao.findByNick(c, user).getPass().equalsIgnoreCase(pass)) {
			return admin;
		} else {
			return null;
		}
	}
}