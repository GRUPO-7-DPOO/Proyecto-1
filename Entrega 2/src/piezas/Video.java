package piezas;

import java.util.ArrayList;

public class Video extends Pieza {
	public int duracion;
	public String resolucion;
	public float peso;
	public String categoria;
	

	public Video(String titulo, int anio, String lugarCreacion, ArrayList<String> autores, String propietario, String estadoC, boolean bodega, int valor, int duracion, String resolucion, float peso, String categoria) {
		super(titulo, anio, lugarCreacion, autores, propietario, estadoC, bodega, valor);
		this.duracion = duracion;
		this.resolucion = resolucion;
		this.peso = peso;
		this.categoria = categoria;
		// TODO Auto-generated constructor stub
	}

}
