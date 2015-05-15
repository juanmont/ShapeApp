package Logica;

import java.util.ArrayList;
import java.util.Vector;

import transfers.InstalacionUsuario;
import transfers.Instalaciones;

public interface FachadaInstalaciones {
	
	public boolean altaInstalacion(Instalaciones insta);
	
	public boolean bajaInstalacion(Instalaciones insta);
	
	public boolean modificarInstalacion(Instalaciones insta);
	
	public Instalaciones verInstalacion(Instalaciones insta);
	
	public ArrayList<Instalaciones> listaInstalaciones();

	public boolean[] verHoras(Instalaciones insta);
}
