package usuario;

import java.util.*;

import galeria.Compra;
import piezas.*;

public class Comprador extends Usuario {


	public Comprador(String nombre, String login, String clave, String correo, int telefono) {
		super(nombre, login, clave, correo, telefono);
		this.tipoUsuario = "Comprador";
		obrasPropiedad = new HashMap<>();
		// TODO Auto-generated constructor stub
	}

	@Override
	
	public String getClave() {
		// TODO Auto-generated method stub
		return super.getClave();
	}

	public double precioLimite;
	private HashMap <String, Pieza> obrasPropiedad;
	public ArrayList <String> obrasquePertenecieron;

	
	public void setPrecioLimite(int precio) {
		this.precioLimite = precio;
	}
	
	public HashMap <String, Pieza> getObrasPropiedad(){
		return this.obrasPropiedad;
	}
	
	public void setObrasPorpiedad(HashMap <String, Pieza> obras) {
		this.obrasPropiedad = obras;
	}
	
	public void añadirPieza(Pieza pieza) {
		this.obrasPropiedad.put(pieza.getTitulo(), pieza);
	}
	
	public static void comprarPieza(String nombre, String comprador, String metodoPago, int valor, Pieza pieza, HashMap<String,Pieza> piezas , ArrayList<Compra> compras) {
		String id = nombre + "-" + comprador + "-" + metodoPago + "-" + Integer.toString(valor); 
		Compra compra = new Compra(metodoPago, id, comprador, nombre, valor);
		pieza.setEstadoC("Bloqueada");
		piezas.put(nombre, pieza);
		compras.add(compra);
	}
}
