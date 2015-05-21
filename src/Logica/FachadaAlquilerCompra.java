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
	
	public boolean alquilerInstalacion(InstalacionUsuario inst);
	
	public boolean alquilerMaterial(MaterialUsuario mat);
	
	public boolean contratacionEntrenador(ClaseSocio clase);
	
	public boolean contratacionClase(ClaseSocio clase);
	
	public boolean compraAbonoPis(BonoUsuario bono);
	
	public boolean compraAbonoGim(BonoUsuario bono);
}
