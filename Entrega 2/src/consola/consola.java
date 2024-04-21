package consola;


import java.util.ArrayList;
import java.util.Scanner;

import galeria.*;

public class consola {
	private Galeria galeria;
	
	public consola() {
		this.galeria = new Galeria();
		menu();
	}
	
	public void menu() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int option;
		do {
			System.out.println("Galeria");
			
			System.out.println("1. Iniciar Sesion en la galeria.");
			System.out.println("2. Salir del programa.");
			option = sc.nextInt();
			
			
			if (option == 1) {
				String login,clave;
				System.out.println("Login: ");
				login = sc.next();
				System.out.println("Clave: ");
				clave = sc.next();
				
				try {
					String bLogin = iniciarSesion(login, clave);

					switch (bLogin) {
					
					case "Administrador":
						do {
							System.out.println("Funciones de Administrador: ");
							System.out.println("1. Registrar Nueva Pieza");
							System.out.println("2. Buscar Pieza");
							System.out.println("3. Verificar compras");
							option = sc.nextInt();
							
							switch (option) {
							
							case 1:
								
								
								registrarPieza(sc);
								break;
							case 2:
								System.out.println("Diga el nombre de la pieza que quiere buscar: ");
								String pieza = sc.next();
								System.out.println(encontrarPieza(pieza));
								break;
							case 3:
								verificarPiezas(sc);
								break;
							}
							
						}
						while (option!=4);
						break;
					case "Cajero":
						do {
							System.out.println("Funciones de Cajero: ");
							System.out.println("1. Verificar pagos.");
							option = sc.nextInt();
							
							switch (option) {
							case 1:
								registrarPagos(sc);
								break;
							case 2:
								break;
							}
							}
						while (option!=3);
						break;
					case "Comprador":
						do {
							System.out.println("Funciones de Comprador: ");
							System.out.println("1. Comprar Pieza");
							System.out.println("2. Consultar obras de mi propiedad");
							option = sc.nextInt();
							switch (option) {
							case 1:
								comprarPieza(sc, login);
								break;
							
							case 2:
								piezasPropias(login);
								break;
							}
							}
						while (option!=3);
						break;
					case "Operador":
						do {
							System.out.println("Funciones de Operador: ");
							option = sc.nextInt();
							}
						while (option!=3);
						break;
					case "Empleados":
						do {
							System.out.println("Funciones de Empleados: ");
							option = sc.nextInt();
							}
						while (option!=3);
						break;
					default:
						System.out.println("Tipo de Funcion indeterminado?");
						break;
					}
					
					
						
				}
				
				catch(Exception e){
					System.out.println(e.getMessage());
				}
				
				
			}
			
			
		} while (option != 2);
		sc.close();	
	}

	private String iniciarSesion(String login, String clave) throws Exception {
		return galeria.iniciarSesion(login, clave);
	}
	
	private void registrarPieza(Scanner sc) {
		System.out.println("Escriba el titulo de una pieza: ");
		String titulo = sc.next();
		System.out.println("Escriba el año de publicacion de esta: ");
		int año = sc.nextInt();
		System.out.println("Escriba el lugar de creacion de la pieza: ");
		String lugarCreacion = sc.next();
		ArrayList <String> autores = listaAutores(sc);
		System.out.println("Escriba el propietario actual de la obra: ");
		String propietario = sc.next();
		System.out.println("Escriba el tipo de pieza: ");
		String tipoObra = sc.next();
		galeria.registrarPieza(titulo, año, lugarCreacion, autores, propietario, tipoObra ,sc);
	}
	
	private boolean encontrarPieza(String nombre) {
		return galeria.existePiezas(nombre);	
	}
	
	private void comprarPieza(Scanner sc, String usuario) throws Exception {
		System.out.println("Escriba la pieza que desea comprar: ");
		String nombre = sc.next();
		System.out.println("Diga el valor que va a pagar por esta pieza: ");
		int valor = sc.nextInt();
		System.out.println("Diga el metodo de pago (Solo se acepta tarjeta, efectivo o transferencia): ");
		String metodoPago = sc.next();
		if (!metodoPago.equalsIgnoreCase("Tarjeta")&&!metodoPago.equalsIgnoreCase("Efectivo")&&!metodoPago.equalsIgnoreCase("Transferencia")) {throw new Exception("Metodo de Pago no valido. \nCerrando sesion...");}
		galeria.comprarPieza(metodoPago,usuario,nombre,valor);
	}
	
	private ArrayList<String> listaAutores(Scanner sc){
		System.out.println("Diga los autores de esta pieza (Escriba 1 para finalizar: ");
		String autor;
		ArrayList<String> mat = new ArrayList<String>();
		do {
			autor = sc.next();
			mat.add(autor);
		}
		while(!autor.equalsIgnoreCase("1"));
		return mat;
	}
	
	private int getCompras(){
		return galeria.getCompras();
	}
	
	private void verificarPiezas(Scanner sc) {
		if (getCompras()==0) {System.out.println("No hay piezas para verificar");}
		else {
		System.out.println("Hay " + Integer.toString(getCompras()) + " compras que verificar, Diga cual pieza desea verificar: ");
		  galeria.verificarCompras(sc);}
	}
	
	private void piezasPropias(String login) {
		galeria.piezasPropias(login);
	}
	
	private int getComprasVerificadas() {
		return galeria.getComprasPagos();
	}
	
	private void registrarPagos(Scanner sc) {
		if (getComprasVerificadas()==0) {System.out.println("No hay piezas para verificar");}
		else {
		System.out.println("Hay " + Integer.toString(getComprasVerificadas()) + " compras que verificar, Diga cual pieza desea verificar: ");
		galeria.registrarPagos(sc);}
	}
	
	public static void main(String[] args) throws Exception {
		new consola();
	}

}
