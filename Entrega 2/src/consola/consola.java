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
							
							option = sc.nextInt();
							
							switch (option) {
							
							case 1:
								System.out.println("Escriba el titulo de una pieza: ");
								String titulo = sc.next();
								System.out.println("Escriba el año de publicacion de esta: ");
								int año = sc.nextInt();
								System.out.println("Escriba el lugar de creacion de la pieza: ");
								ArrayList <String> autores = listaAutores(sc);
								System.out.println("Escriba el propietario actual de la obra: ");
								String propietario = sc.next();
								System.out.println("Escriba el tipo de pieza: ");
								String tipoObra = sc.next();
								
								registrarPieza(titulo, año, titulo, autores, propietario, tipoObra, sc);
								break;
							case 2:
								System.out.println("Diga el nombre de la pieza que quiere buscar: ");
								String pieza = sc.next();
								System.out.println(encontrarPieza(pieza));
								break;
								
							}
							
						}
						while (option!=3);
						break;
					case "Cajero":
						do {
							System.out.println("Funciones de Cajero: ");
							option = sc.nextInt();
							}
						while (option!=3);
						break;
					case "Comprador":
						do {
							System.out.println("Funciones de Comprador: ");
							option = sc.nextInt();
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
	
	private void registrarPieza(String titulo, int anio, String lugarCreacion, ArrayList<String> autores, String propietario, String tipoPieza,Scanner sc) {
		galeria.registrarPieza(titulo, anio, lugarCreacion, autores, propietario, tipoPieza,sc);
	}
	
	public boolean encontrarPieza(String nombre) {
		return galeria.existePiezas(nombre);	
	}

	private ArrayList<String> listaAutores(Scanner sc){
		System.out.println("Diga los autores de esta pieza (Escriba 1 para finalizar: ");
		String autor;
		ArrayList<String> mat = new ArrayList<String>();
		do {
			autor = sc.next();
			mat.add(autor);
		}
		while(!autor.equals("1"));
		return mat;
	}
	
	public static void main(String[] args) throws Exception {
		new consola();
	}
}
