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
								break;
							case 2:
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
	
	private void registrarPieza(String titulo, int anio, String lugarCreacion, ArrayList<String> autores, String propietario, int duracion, String resolucion, String peso, String categoria) {
		galeria.registrarVideo(titulo, anio, lugarCreacion, autores, propietario, duracion, resolucion, peso, categoria);
	//Ahora lo corrijo, apenas sirve para video 
	}
	
	public boolean encontrarPieza(String nombre) {
		return galeria.existePiezas(nombre);	
	}

	public static void main(String[] args) throws Exception {
		new consola();
	}
}
