package piezas;

import java.util.ArrayList;

public class Impresiones extends Pieza {
	
	private ArrayList<Float> dimensiones;
	private String formato;
	private String material;
	private String resolucion;
	private String acabado;
	
	public Impresiones(String titulo, int anio, String lugarCreacion, ArrayList<String> autores, String propietario, ArrayList<Float> dimensiones, String formato, String material, String resolucion, String acabado) {
		super(titulo, anio, lugarCreacion, autores, propietario);
		this.dimensiones = dimensiones;
		this.formato = formato;
		this.material = material;
		this.resolucion = resolucion;
		this.acabado = acabado;
		// TODO Auto-generated constructor stub
	}

}