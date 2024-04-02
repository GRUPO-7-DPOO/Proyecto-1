package piezas;

import java.util.ArrayList;

public abstract class Piezas {
	public String titulo;
	public int Anio;
	public String lugarCreacion;
	public ArrayList<String> Autores;
	public String estadoC;
	public boolean enSubasta;
	public boolean enBodega;
	public String propietario;
	public double precioFijo;
	public int id;
	
	public Piezas (String titulo, int anio, String lugarCreacion, ArrayList<String> autores, String propietario) {
		this.titulo = titulo;
		Anio = anio;
		this.lugarCreacion = lugarCreacion;
		Autores = autores;
		this.propietario = propietario;
	}
	
	
}
