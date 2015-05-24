package Logica;

import java.util.ArrayList;

import transfers.Clases;

public interface FachadaClases {
	public boolean altaClase(Clases clase);
	public boolean bajaClase(Clases clase);
	public ArrayList<Clases> listaClasesAll();
	
}