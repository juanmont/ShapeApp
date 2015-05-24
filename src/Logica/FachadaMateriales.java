package Logica;

import java.util.ArrayList;

import transfers.Material;

public interface FachadaMateriales {

	public boolean altaMaterial(Material mat);
	
	public boolean bajaMaterial(Material mat);
	
	public boolean modificarMaterial(Material mat);
	
	public Material verMaterial(Material mat);
	
	public ArrayList<Material> listaMateriales();
	public boolean[] verHoras(int id);
}
