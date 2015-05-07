package transfers;

import enums.TipoEnum;


public class Material {
	private String nombre;
	private int id;
	private TipoEnum tipo;
	private String descripcion;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "TransferMaterial [nombre=" + nombre + ", id=" + id + ", tipo="
				+ tipo + ", descripcion=" + descripcion + "]";
	}

	public TipoEnum getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = TipoEnum.valueOf(tipo);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
