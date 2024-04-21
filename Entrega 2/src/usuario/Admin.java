package usuario;

import java.util.*;

import galeria.*;
import piezas.*;

public class Admin extends Usuario {
	

	


	public Admin(String nombre, String login, String clave, String correo, int telefono) {
		super(nombre, login, clave, correo, telefono);
		this.tipoUsuario = "Administrador";
		// TODO Auto-generated constructor stub
	}

	public static void registrarNuevaPieza(Pieza pieza, HashMap <String, Pieza> piezas) {
		piezas.put(pieza.getTitulo(), pieza);
	}
	
	public static void verificarCompra(Compra compra,HashMap <String, Pieza> piezas, Scanner option, ArrayList<Compra> compras, ArrayList<Compra> comprasVerificadas, int index) {
		String nombrePieza = compra.piezaAComprar();
		Pieza pieza = piezas.get(nombrePieza);

		
		System.out.println("¿Deseas verificar esta compra?");
		System.out.println("Valor de la Pieza: " + Integer.toString(pieza.getPrecioFijo()) + "  ---------->  Valor ofrecido por el usuario: " + Integer.toString(compra.getValor()) );
		System.out.println("1. Si\n2. No\n");
		
		
		int slc = option.nextInt();
		
		
		if (slc == 1) {
			compras.remove(index);
			comprasVerificadas.add(compra);
			pieza.setEstadoC("Comprada");
			piezas.put(nombrePieza, pieza);
			
		}
		else if (slc == 2){
			pieza.setEstadoC("Disponible");
			piezas.put(nombrePieza, pieza);
			compras.remove(index);
		}
		else {
			System.out.println("Opcion no valida.");
		}
		
		
		
	}

	
}	
