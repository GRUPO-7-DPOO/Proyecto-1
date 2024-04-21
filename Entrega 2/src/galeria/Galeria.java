package galeria;

import java.util.*;

import usuario.*;
import piezas.*;

public class Galeria {
	private HashMap <String, Usuario > Usuarios;
	private ArrayList<Compra> Compras;
	private HashMap <String, Pieza> Piezas;
	private ArrayList<Compra> ComprasVerificadas;
	private HashMap<Compra,String> pagos;
	private HashMap<String,Subasta> subastas;
	
	public Galeria() {
		this.Usuarios = new HashMap<String,Usuario>();
		this.Compras = new ArrayList<Compra>();
		this.Piezas = new HashMap<String, Pieza>();
		this.ComprasVerificadas = new ArrayList<Compra>();
		this.subastas = new HashMap<String, Subasta>();
		Usuario admin = new Admin("Admin", "1234", "1234" , "w", 123);
		Comprador comprador = new Comprador("Comprador", "Comprador", "Comprador", "w", 1);
		Cajero operador = new Cajero("Operador","Operador","Operador","w",1);
		this.Usuarios.put("1234", admin);
		this.Usuarios.put("Comprador", comprador);
		this.Usuarios.put("Operador", operador);
		ArrayList<String> autores = new ArrayList<>();
	}
	
	public void crearUsuario(String login, String clave, String nombre, int telefono, String correo, String tipoUsuario) throws Exception {
		if (existeUsuario(login)) {throw new Exception("Ya existe este usuario.");}
		
		else {
			Usuario user = new Comprador(nombre,login,clave,correo,telefono);
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
	
	public void registrarPieza(String titulo, int anio, String lugarCreacion, ArrayList<String> autores, String propietario, String tipoPieza, Scanner info) throws Exception {
		
		String dimensiones;
		ArrayList <String> materiales;
		String resolucion;
		float peso;
		String categoria;
		System.out.println("Escriba el estado de Compra (Disponible o no Disponible, si escribe algo diferente a disponible se considerara no disponible): ");
		String estadoC = info.next();
		if (!estadoC.equalsIgnoreCase("Disponible")) 
		{estadoC = "No disponible";}
		System.out.println("Escriba si estara en bodega o exhibida (Si escribe algo diferente a Bodega se considerara que no estara en esta.): ");
		boolean bodega = true;
		String respuesta = info.next();
		if (respuesta.equalsIgnoreCase("Bodega")){
			bodega=false;
		}
		System.out.println("Escriba el valor de su pieza: ");
		int valor = info.nextInt();
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
			
			Impresiones imp = new Impresiones(titulo, anio, lugarCreacion, autores, propietario, estadoC, bodega, valor, dimensiones, formatos, material, resolucion, acabado);
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
			Fotografia fto = new Fotografia(titulo, anio, lugarCreacion, autores, propietario, estadoC, bodega, valor, formato, resolucionFto, dimensiones,ppp, categoria);
			Admin.registrarNuevaPieza(fto, this.Piezas);
			break;
			
		case "Escultura":
			System.out.println("Diga la dimension de la escultura (Ancho x Largo x Profundidad): ");
			dimensiones = info.next();
			materiales = listaMateriales(info);
			System.out.println("Escriba el peso de la escultura: ");
			peso = info.nextFloat();
			System.out.println("Necesita electricidad? (Escriba si o no): ");
			boolean necesitaElectricidad = true;
			if (!info.next().equalsIgnoreCase("Si")) {necesitaElectricidad=false;}
			System.out.println("Algun otro detalle de la instalacion?");
			String detallesInstalacion = info.next();
			Escultura esc = new Escultura(titulo, anio, lugarCreacion, autores, propietario, estadoC, bodega, valor, dimensiones, materiales, peso, necesitaElectricidad, detallesInstalacion);
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
			Pintura pint = new Pintura(titulo, anio, lugarCreacion, autores, propietario, estadoC, bodega, valor, dimensiones, materiales, cuidados, tecnica);
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
			Video vid = new Video(titulo, anio, lugarCreacion, autores, propietario, estadoC, bodega, valor, duracion, resolucion, peso, categoria);
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
	
	public void comprarPieza (String metodoPago, String comprador, String nombre, int valor ) throws Exception{
		if (existePiezas(nombre)) {
			Pieza pieza = this.Piezas.get(nombre);
			if (pieza.getEstadoC()=="No disponible") {
				throw new Exception("Esta pieza no esta disponible para ser comprada. \nCerrando Sesion...");
			}
			else if (pieza.getEstadoC()=="Bloqueada"){
				throw new Exception("Esta pieza esta siendo comprada en su momento. \nCerrando Sesion...");
			}
			else if (pieza.getEstadoC()=="Comprada") {
				throw new Exception("Esta pieza ya ha sido verificada y esta en proceso de pago. \nCerrando Sesion...");
			}
			else {
				Comprador.comprarPieza(nombre, comprador, metodoPago, valor, pieza, this.Piezas, this.Compras);
			}
		}
		else {
			throw new Exception("Esta pieza no existe");
		}
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
	
	public String getNameUser(String login) {
		Usuario user = this.Usuarios.get(login);
		return user.getName();
	}

	public int getCompras(){
		return this.Compras.size();
	}

	public int getComprasPagos() {
		return this.ComprasVerificadas.size();
	}
	
	public void verificarCompras(Scanner sc) {
		mostrarCompras(this.Compras);
		int c = sc.nextInt();
		Compra compra =this.Compras.get(c-1);
		Admin.verificarCompra(compra,this.Piezas,sc,this.Compras,this.ComprasVerificadas,c-1);
	}
	
	public void mostrarCompras(ArrayList<Compra> comprasLista) {
		int cantidad = 1;
		for (Compra compra : comprasLista) {
			System.out.println(Integer.toString(cantidad)+") Pieza: "+compra.piezaAComprar());
		}
	}
	
	public void piezasPropias(String login) {
		Comprador comprador = (Comprador) this.Usuarios.get(login);
		HashMap <String, Pieza> obrasPropiedad = comprador.getObrasPropiedad();
		int i = 1;
		Set <String> nombresObras = obrasPropiedad.keySet();
		
		for (String name : nombresObras) {
			System.out.println(Integer.toString(i)+") "+name);
			i++;
		}
	}
	
	public void registrarPagos(Scanner sc) {
		mostrarCompras(this.ComprasVerificadas);
		int c = sc.nextInt();
		Compra compra = this.ComprasVerificadas.get(c-1);
		Cajero.registrarPago(compra, this.Piezas, sc, ComprasVerificadas, c, this.Usuarios, this.pagos);
	}
	
	public void crearSubasta(Scanner sc, Date date,String fecha) throws Exception{
		String id = "-" + fecha +"-";
		ArrayList<Pieza> listaPiezas = listaPiezas(sc,id);
		Admin.crearSubasta(id, listaPiezas, date, this.subastas);
	}
	
	private ArrayList<Pieza> listaPiezas(Scanner sc, String id) throws Exception{
		System.out.println("Diga la lista de piezas que pasaran a la subasta (Escriba 1 para finalizar): ");
		String pieza;
		ArrayList<Pieza> piezas = new ArrayList<Pieza>();
		do {
			pieza = sc.next();
			if (!existePiezas(pieza)) {
				throw new Exception("Esta pieza no existe.\nCerrando sesion...");
			}
			else {
				piezas.add(this.Piezas.get(pieza));
				id+=pieza+"-";
			}
		}
		while(!pieza.equalsIgnoreCase("1"));
		return piezas;
	}
}
