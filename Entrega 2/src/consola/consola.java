package consola;


import java.util.Scanner;

import galeria.*;

public class consola {
	private Galeria galeria;
	
	public consola() throws Exception {
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
				login = sc.nextLine();
				System.out.println("Clave: ");
				clave = sc.nextLine();
				
				
			}
			
			
		} while (option != 2);
		sc.close();	
	}

	private boolean encontrarUsuario(String login) {
		boolean existe = galeria.existeUsuario(login);
		return existe;
	}



	public static void main(String[] args) throws Exception {
		new consola();
	}
}
