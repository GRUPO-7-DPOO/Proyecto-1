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
	
	public void registrarVideo(String titulo, int anio, String lugarCreacion, ArrayList<String> autores, String propietario, int duracion, String resolucion, String peso, String categoria) {
		Video vid = new Video(titulo,anio,lugarCreacion,autores,propietario,duracion,resolucion,peso,categoria);
		this.Piezas.put(vid.getTitulo(), vid);
		Admin.registrarNuevaPieza(vid,this.Piezas);
	}
	
	public boolean existePiezas(String nombre) {
		if(this.Piezas.containsKey(nombre)) {
			return true;
		}
		return false;
	}
	
 
}
