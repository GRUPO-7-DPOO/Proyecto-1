package piezas;

import java.util.ArrayList;

public abstract class Pieza {
	protected String titulo;
	public int Anio;
	public String lugarCreacion;
	public ArrayList<String> Autores;
	protected String estadoC; // Disponible, No disponible, Bloqueada, Comprada
	public boolean enSubasta;
	public boolean enBodega;
	protected String propietario;
	protected int precioFijo; // En caso que no este disponible el valor sera 0000
	public int id;
	
	public Pieza (String titulo, int anio, String lugarCreacion, ArrayList<String> autores, String propietario, String estadoC, boolean bodega, int valor) {
		this.titulo = titulo;
		Anio = anio;
		this.lugarCreacion = lugarCreacion;
		Autores = autores;
		this.propietario = propietario;
		this.precioFijo = valor;
		this.enBodega = bodega;
	}
	
	public String getTitulo() {
		return this.titulo;
	}

	public String getEstadoC() {
		return estadoC;
	}

	public void setEstadoC(String estadoC) {
		this.estadoC = estadoC;
	}

	public String getPropietario() {
		return propietario;
	}
	
	public int getPrecioFijo() {
		return this.precioFijo;
	}
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
	


}
