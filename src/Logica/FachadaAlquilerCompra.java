package Logica;

import java.util.ArrayList;

import transfers.Bono;
import transfers.BonoUsuario;
import transfers.ClaseSocio;
import transfers.Clases;
import transfers.InstalacionUsuario;
import transfers.MaterialUsuario;
import transfers.Entrenador;

public interface FachadaAlquilerCompra {
	
	public ArrayList<InstalacionUsuario> listaInstalaciones();
	
	public ArrayList<Entrenador> listaEntrenadores();
	
	public ArrayList<MaterialUsuario> listaMateriales();
	
	public void alquilerInstalacion(InstalacionUsuario inst);
	
	public void alquilerMaterial(MaterialUsuario mat);
	
	public void contratacionEntrenador(ClaseSocio clase);
	
	public void contratacionClase(ClaseSocio clase);
	
	public void compraAbonoPis(BonoUsuario bono);
	
	public void compraAbonoGim(BonoUsuario bono);
}
