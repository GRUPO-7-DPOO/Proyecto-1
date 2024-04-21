package usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import galeria.Compra;
import piezas.Pieza;

public class Cajero extends Usuario {

	public Cajero(String nombre, String login, String clave, String correo, int telefono) {
		super(nombre, login, clave, correo, telefono);
		this.tipoUsuario = "Cajero";
		// TODO Auto-generated constructor stub
	}
	
	public static void registrarPago(Compra compra,HashMap <String, Pieza> piezas, Scanner option, ArrayList<Compra> comprasVerificadas, int index, HashMap<String,Usuario> usuario, HashMap<Compra,String> pagos) {
		String nombrePieza = compra.piezaAComprar();
		Pieza pieza = piezas.get(nombrePieza);
		Comprador comprador = (Comprador) usuario.get(compra.getComprador());
		
		comprador.añadirPieza(pieza);
		piezas.remove(nombrePieza);
		comprasVerificadas.remove(index-1);
		pagos.put(compra, compra.getMetodoPago());
	}
}
