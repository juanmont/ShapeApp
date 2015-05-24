package Control;

import java.sql.Connection;
import java.sql.Date;

import Logica.FachadaAlquilerCompra;
import Logica.SubSistemaAlquilerCompra;
import transfers.Bono;
import transfers.ClaseSocio;
import transfers.Clases;
import transfers.InstalacionUsuario;
import transfers.MaterialUsuario;
import enums.BonoEnum;

public class ControladorAlquilerCompra {

	private FachadaAlquilerCompra alquilerCompra;
	private Connection con;
	
	public ControladorAlquilerCompra(Connection con){
		this.con = con;
		alquilerCompra = new SubSistemaAlquilerCompra(this.con);
	}
	
	public boolean alquilarInstalacion(int id, String nick, int hora, Date fecha, int claseId) {
		InstalacionUsuario ins = new InstalacionUsuario();
		ins.setNumInstalacion(id);
		ins.setDia(fecha);
		ins.setHorario(hora);
		ins.setNick(nick);
		ins.setIdClase(claseId);
		return alquilerCompra.alquilerInstalacion(ins);
		// TODO Auto-generated method stub
		
	}

	public boolean alquilarMaterial(int id, String nick, int hora, Date fecha) {
		MaterialUsuario mat = new MaterialUsuario();
		mat.setDia(fecha);
		mat.setHorario(hora);
		mat.setIdCliente(nick);
		mat.setIdMateriales(id);
		return alquilerCompra.alquilerMaterial(mat);
		// TODO Auto-generated method stub
		
	}
	
	public boolean contratarClase(int idClase, String nick){
		ClaseSocio clase = new ClaseSocio();
		clase.setId_clase(idClase);
		clase.setNick(nick);
		return alquilerCompra.contratacionClase(clase);
	}
	
	public boolean compraBono(BonoEnum tipo,int  meses, String nick){
		Bono bono = new Bono();
		bono.setBono(tipo.toString());
		bono.setMeses(meses);
		bono.setNick(nick);
		if(tipo == BonoEnum.PISCINA){
			bono.setPrecio(20 * meses);
			return alquilerCompra.compraAbonoPis(bono);
		}else if(tipo == BonoEnum.GIMNASIO){
			bono.setPrecio(18 * meses);
			return alquilerCompra.compraAbonoGim(bono);
		}
		else
			return false;
	}

}
