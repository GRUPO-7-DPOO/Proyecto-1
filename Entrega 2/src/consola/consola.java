package consola;


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
					System.out.println(bLogin);
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



	public static void main(String[] args) throws Exception {
		new consola();
	}
}
