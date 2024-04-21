package piezas;

import java.util.ArrayList;

public class Escultura extends Pieza {

	private String dimensiones;
	private ArrayList<String> materiales;
	private float peso;
	private boolean electricidad;
	private String instalacion;
	
	public Escultura(String titulo, int anio, String lugarCreacion, ArrayList<String> autores, String propietario, String estadoC, boolean bodega, int valor, String dimensiones, ArrayList <String> materiales, float peso, boolean electricidad, String instalacion) {
		super(titulo, anio, lugarCreacion, autores, propietario, estadoC, bodega, valor);
		this.dimensiones = dimensiones;
		this.materiales = materiales;
		this.peso = peso;
		this.electricidad = electricidad;
		this.instalacion = instalacion;
		// TODO Auto-generated constructor stub
	}

	public String getDimensiones() {
		return dimensiones;
	}

	public ArrayList<String> getMateriales() {
		return materiales;
	}

	public float getPeso() {
		return peso;
	}

	public boolean isElectricidad() {
		return electricidad;
	}

	public String getInstalacion() {
		return instalacion;
	}

}
