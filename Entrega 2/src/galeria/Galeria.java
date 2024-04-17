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
	}
	
	public void crearUsuario(String login, String clave, String nombre, int telefono, String correo, String tipoUsuario) throws Exception {
		if (existeUsuario(login)) {throw new Exception("Ya existe este usuario.");}
		
		else {
			Usuario user = new Comprador(nombre,login,telefono,clave,correo,tipoUsuario);
			this.Usuarios.put(login, user);
		}
	}
	
	public boolean existeUsuario(String login) {
		if (this.Usuarios.containsKey(login)) {
			return true;
		}
		return false;
	}
	
	public boolean existePiezas(String nombre) {
		if(this.Piezas.containsKey(nombre)) {
			return true;
		}
		return false;
	}
	
 
}
