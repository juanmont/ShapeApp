package Main;

import java.sql.Connection;

import enums.SexoEnum;
import transfers.Admin;
import transfers.Material;
import transfers.Socio;
import Daos.Conexion;
import Daos.DaoAdmin;
import Daos.DaoMaterial;
import Daos.DaoSocio;

public class Main {
	
	public static void main(String[] args){
		Connection con = Conexion.obtenerConexion();
		DaoMaterial daoMa = new DaoMaterial();
		Material material = daoMa.findById(con, 1);
		System.out.printf(material.toString() + "\n");
		DaoSocio socioDao = new DaoSocio();
		Socio socio = socioDao.findByNick(con, "julia18");
		System.out.printf(socio.toString() + "\n");
		Admin socio2 = new Admin();
		DaoAdmin daoAd = new DaoAdmin();
		socio2.setApellidos("prueba");
		socio2.setDireccion("prueba");
		socio2.setDNI("56");
		socio2.setEmail("hagj");
		socio2.setNick("prueba");
		socio2.setNombre("prueba");
		socio2.setPass("pass");
		socio2.setSexo(SexoEnum.FEMENINO.toString());
		socio2.setTelefono("89");
		socio2.setSueldo(78.2);
		socio2.setHoraEntrada("8:30");
		socio2.setHoraSalida("9:7");
		daoAd.insertAdmin(con, socio2);
		socio2 = daoAd.findByNick(con, socio2.getNick());
		System.out.printf(socio2.toString() + "\n");
		daoAd.borrarAdmin(con, socio2.getNick());
		socio2 = daoAd.findByNick(con, socio2.getNick());
	}
	
}

