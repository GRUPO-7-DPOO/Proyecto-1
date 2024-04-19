package piezas;

import java.util.ArrayList;

public class Fotografia extends Pieza{
	
	private String formato;
	private String resolucion;
	private ArrayList<Float> dimensiones;
	private String Categoria;
	
	public Fotografia(String titulo, int anio, String lugarCreacion, ArrayList<String> autores, String propietario, String formato, String resolucion, ArrayList<Float> dimensiones, String categoria) {
		super(titulo, anio, lugarCreacion, autores, propietario);
		this.formato = formato;
		this.resolucion = resolucion;
		this.dimensiones = dimensiones;
		this.Categoria = categoria;
		// TODO Auto-generated constructor stub
	}

}
