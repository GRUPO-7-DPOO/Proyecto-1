package galeria;

import java.util.*;
import piezas.*;

public class Subasta {
	public String id;
	public Date fecha;
	public ArrayList <Pieza> piezas;
	public HashMap <String, Integer> registros;
	
	public Subasta(String id, Date fecha, ArrayList <Pieza> piezas) {
		this.id = id;
		this.fecha = fecha;
		this.piezas = piezas;
	}
	
	public void añadirRegistro(String login, int precio) {
		this.registros.put(login, precio);
	}

	public Date getFecha() {
		return fecha;
	}

	public ArrayList<Pieza> getPiezas() {
		return piezas;
	}

	public HashMap<String, Integer> getRegistros() {
		return this.registros;
	}
	
	public void setRegistros(HashMap <String, Integer> registrosN) {
		this.registros = registrosN;
	}
	
}
