package consola;


import java.util.Scanner;

import galeria.*;

public class consola {
	private Galeria galeria;
	
	public consola() {
		this.galeria = new Galeria();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int option;
		do {
			System.out.println("Galeria");
			
			System.out.println("1. Ingrese su login para iniciar sesion en la galeria.");
			System.out.println("2. Salir del programa.");
			option = sc.nextInt();
			
		} while (option != 2);
		
		
	}

}
