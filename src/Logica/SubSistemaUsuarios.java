package Logica;



import java.sql.Connection;

import enums.UsuarioEnum;
import transfers.Admin;
import transfers.Funcionario;
import transfers.Socio;
import transfers.Usuario;
import Daos.DaoAdmin;
import Daos.DaoFuncionario;
import Daos.DaoSocio;

public class SubSistemaUsuarios implements FachadaUsuarios {

	DaoAdmin adminDao = new DaoAdmin();
	DaoFuncionario funDao = new DaoFuncionario();
	DaoSocio socDao=new DaoSocio();
	
	@Override
	public boolean altaUsuario(Usuario usuario) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarUsuario() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean bajaUsuario() {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario verUsuario() {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listaUsuarios() {
		// TODO Auto-generated method stub
		
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
