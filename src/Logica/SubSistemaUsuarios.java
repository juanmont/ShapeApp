package Logica;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Vector;

import enums.UsuarioEnum;
import transfers.Admin;
import transfers.Funcionario;
import transfers.Socio;
import transfers.Usuario;
import Daos.DaoAdmin;
import Daos.DaoFuncionario;
import Daos.DaoSocio;

public class SubSistemaUsuarios implements FachadaUsuarios {
	private DaoAdmin adminDao;
	private DaoFuncionario funDao;
	private DaoSocio socDao;
	private Connection con;
	private ArrayList<Usuario> lista;

	public SubSistemaUsuarios(Connection con){
		adminDao = new DaoAdmin();
		funDao = new DaoFuncionario();
		socDao = new DaoSocio();
		lista = new ArrayList<Usuario>();
		this.con = con;
	}
	
	
	
	@Override
	public boolean altaUsuario(Socio s, Admin ad, Funcionario f) {
		if(s != null){
			socDao.insertSocio(con, s);
			lista.add(s);
		}else if(ad != null){
			adminDao.insertAdmin(con, ad);
			lista.add(ad);
		}else if(f != null){
			funDao.insertAdmin(con, f);
			lista.add(f);
		}else
			return false;	
		return true;
	}

	@Override
	public boolean modificarUsuario(Socio s, Admin ad, Funcionario f) {
		if(s != null){
			socDao.modificarSocio(con, s);
		}else if(ad != null){
			adminDao.modificarAdmin(con, ad);
		}else if(f != null){
			funDao.modificarFuncionario(con, f);
		}else
			return false;	
		return true;
	}

	@Override
	public boolean bajaUsuario(Socio s, Admin ad, Funcionario f) {
		if(s != null){
			socDao.borrarSocio(con, s.getNick());
			lista.remove(s.getNick());
		}else if(ad != null){
			adminDao.borrarAdmin(con, ad.getNick());
			lista.remove(ad.getNick());
		}else if(f != null){
			funDao.borrarAdmin(con, f.getNick());
			lista.remove(f.getNick());
		}else
			return false;	
		return true;
		
	}

	@Override
	public Usuario verUsuario(Socio s, Admin ad, Funcionario f) {
		if(s != null){
			return socDao.findByNick(con, s.getNick());
		}else if(ad != null){
			return adminDao.findByNick(con, ad.getNick());
		}else if(f != null){
			return funDao.findByNick(con, f.getNick());
		}else
			return null;
	}

	@Override
	public ArrayList<Usuario> listaUsuarios() {
			return lista;
	}

	@Override
	public UsuarioEnum tipoUsuario(Connection c, String user, String pass) {
		if(adminDao.findByNick(c, user) != null && adminDao.findByNick(c, user).getPass().equalsIgnoreCase(pass)) {
			return UsuarioEnum.Admin;
		} else if (funDao.findByNick(c, user) != null && funDao.findByNick(c, user).getPass().equalsIgnoreCase(pass)) {
			return UsuarioEnum.Funcionario;
		} else if (socDao.findByNick(c, user) != null && socDao.findByNick(c, user).getPass().equalsIgnoreCase(pass)) {
			return UsuarioEnum.Socio;
		} else {
			return null;
		}
	}
}