package galeria;

import java.util.*;
import piezas.*;

public class Subasta {
	public int id;
	public String fecha;
	public ArrayList <Pieza> piezas;
	public HashMap <String, Integer> registros;
	
	public Subasta(int id, String fecha) {
		this.id = id;
		this.fecha = fecha;	
	}
	
	public void añadirRegistro(String login, int precio) {
		this.registros.put(login, precio);
	}
}
