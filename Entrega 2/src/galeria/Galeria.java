package galeria;

import java.util.*;

import usuario.*;
import piezas.*;

public class Galeria {
	private HashMap <String, Usuario > Usuarios;
	private ArrayList<Compra> Compras;
	private HashMap <String, Pieza> Piezas;
	
	
	public Galeria() {
		this.Usuarios = new HashMap<String,Usuario>();
		this.Compras = new ArrayList<Compra>();
		this.Piezas = new HashMap<String, Pieza>();
		Usuario admin = new Admin("Sebastian", "1234", "1234" , "awww", 123);
		this.Usuarios.put("1234", admin);
	}
	
	public void crearUsuario(String login, String clave, String nombre, int telefono, String correo, String tipoUsuario) throws Exception {
		if (existeUsuario(login)) {throw new Exception("Ya existe este usuario.");}
		
		else {
			Usuario user = new Comprador(nombre,login,telefono,clave,correo,tipoUsuario);
			this.Usuarios.put(login, user);
		}
	}
	
	public String iniciarSesion(String login, String clave) throws Exception{
		if (existeUsuario(login)) {
			Usuario user = this.Usuarios.get(login);
			if (clave.equals(user.getClave())) {
				return user.getTipoUsuario();
			}
			else {
				throw new Exception("Clave Incorrecta");
			}	
		}
		else {
			throw new Exception("Este usuario no existe");	
		}
	}
	
	public boolean existeUsuario(String login) {
		return this.Usuarios.containsKey(login);
	}
	
	public void registrarPieza(String titulo, int anio, String lugarCreacion, ArrayList<String> autores, String propietario, String tipoPieza, Scanner info) {
		String dimensiones;
		ArrayList <String> materiales;
		String resolucion;
		float peso;
		String categoria;
		switch (tipoPieza) {
		
		case "Impresiones":
			System.out.println("Diga la dimension de la impresión (Ancho x Largo): ");
			dimensiones = info.next();
			System.out.println("Diga los formatos de la impresion: ");
			String formatos = info.next();
			System.out.println("Diga el material de la impresion: ");
			String material = info.next();
			System.out.println("Escriba la resolucion de la impresion: ");
			resolucion = info.next();
			System.out.println("Diga el acabado de la impresion: ");
			String acabado = info.next();
			
			Impresiones imp = new Impresiones(titulo, anio, lugarCreacion, autores, propietario, dimensiones, formatos, material, resolucion, acabado);
			Admin.registrarNuevaPieza(imp, this.Piezas);
			break;
			
		case "Fotografia":
			
			System.out.println("Diga el formato de la fotografia: ");
			String formato = info.next();
			System.out.println("Escriba la resolucion de la fotografia: ");
			String resolucionFto = info.next();
			System.out.println("Diga la dimension de la fotografia (Ancho x Largo): ");
			dimensiones = info.next();
			System.out.println("Escriba los pixeles por pulgada (ppp) de la fotografia: ");
			float ppp = info.nextFloat();
			System.out.println("Diga la categoria de la fotografia: ");
			categoria = info.next();
			Fotografia fto = new Fotografia(titulo, anio, lugarCreacion, autores, propietario, formato, resolucionFto, dimensiones,ppp, categoria);
			Admin.registrarNuevaPieza(fto, this.Piezas);
			break;
			
		case "Escultura":
			System.out.println("Diga la dimension de la escultura (Ancho x Largo x Profundidad): ");
			dimensiones = info.next();
			System.out.println("Diga los materiales de la escultura: ");
			materiales = listaMateriales(info);
			System.out.println("Escriba el peso de la escultura: ");
			peso = info.nextFloat();
			System.out.println("Necesita electricidad?");
			boolean necesitaElectricidad = info.hasNext("true");
			System.out.println("Algun otro detalle de la instalacion?");
			String detallesInstalacion = info.next();
			Escultura esc = new Escultura(titulo, anio, lugarCreacion, autores, propietario, dimensiones, materiales, peso, necesitaElectricidad, detallesInstalacion);
			Admin.registrarNuevaPieza(esc, this.Piezas);
			break;
			
		case "Pintura":
			System.out.println("Diga la dimension de la pintura (Ancho x Largo): ");
			dimensiones = info.next();
			System.out.println("Diga los materiales de la pintura: ");
			materiales = listaMateriales(info);
			System.out.println("Escriba cuidados especificos para la pintura: ");
			String cuidados = info.next();
			System.out.println("Escriba la tecnica de la pintura");
			String tecnica = info.next();
			Pintura pint = new Pintura(titulo, anio, lugarCreacion, autores, propietario, dimensiones, materiales, cuidados, tecnica);
			Admin.registrarNuevaPieza(pint, this.Piezas);
			break;
		case "Video":
			System.out.println("Escriba la duracion del video: ");
			int duracion = info.nextInt();
			System.out.println("Escriba la resolucion del video: ");
			resolucion = info.next();
			System.out.println("Escriba el peso del video: ");
			peso = info.nextFloat();
			System.out.println("Escriba la categoria del video: ");
			categoria = info.next();
			Video vid = new Video(titulo, anio, lugarCreacion, autores, propietario, duracion, resolucion, peso, categoria);
			Admin.registrarNuevaPieza(vid, this.Piezas);
			break;
		}
	}
	
	public boolean existePiezas(String nombre) {
		if(this.Piezas.containsKey(nombre)) {
			return true;
		}
		return false;
	}
	
	private ArrayList<String> listaMateriales(Scanner sc){
		System.out.println("Diga la lista de Materiales de esta pieza (Escriba 1 para finalizar: ");
		String material;
		ArrayList<String> mat = new ArrayList<String>();
		do {
			material = sc.next();
			mat.add(material);
		}
		while(!material.equals("1"));
		return mat;
	}
 
}
