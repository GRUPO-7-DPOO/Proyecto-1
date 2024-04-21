package piezas;

import java.util.ArrayList;

public class Fotografia extends Pieza{
	
	private String formato;
	private String resolucion;
	private String dimensiones;
	private String Categoria;
	
	public Fotografia(String titulo, int anio, String lugarCreacion, ArrayList<String> autores, String propietario, String estadoC, boolean bodega, int valor, String formato, String resolucion, String dimensiones, float ppp, String categoria) {
		super(titulo, anio, lugarCreacion, autores, propietario, estadoC, bodega, valor);
		this.formato = formato;
		this.resolucion = resolucion;
		this.dimensiones = dimensiones;
		this.Categoria = categoria;
		// TODO Auto-generated constructor stub
	}

}
