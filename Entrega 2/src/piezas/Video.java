package piezas;

import java.util.ArrayList;

public class Video extends Pieza {
	public int duracion;
	public String resolucion;
	public String peso;
	public String categoria;
	

	public Video(String titulo, int anio, String lugarCreacion, ArrayList<String> autores, String propietario, int duracion, String resolucion, String peso, String categoria) {
		super(titulo, anio, lugarCreacion, autores, propietario);
		this.duracion = duracion;
		this.resolucion = resolucion;
		this.peso = peso;
		this.categoria = categoria;
		// TODO Auto-generated constructor stub
	}

}
