package piezas;

import java.util.ArrayList;

public class Pintura extends Pieza{

	private String dimensiones;
	private ArrayList<String> materiales;
	private String cuidados;
	private String tecnica;
	
	public Pintura(String titulo, int anio, String lugarCreacion, ArrayList<String> autores, String propietario, String dimensiones, ArrayList<String> materiales, String cuidados, String tecnica) {
		super(titulo, anio, lugarCreacion, autores, propietario);
		this.dimensiones = dimensiones;
		this.materiales = materiales;
		this.cuidados = cuidados;
		this.tecnica = tecnica;
		
		// TODO Auto-generated constructor stub
	}

}
