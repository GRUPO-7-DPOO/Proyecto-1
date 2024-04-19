package usuario;

import java.util.HashMap;
import piezas.*;

public class Admin extends Usuario {
	
	public Admin (String nombre, String login, String clave, String correo, int telefono) {
		this.nombre = nombre;
		this.login = login;
		this.clave = clave;
		this.correo = correo;
		this.telefono = telefono;
		this.tipoUsuario = "Administrador";
		}
	
	public static void registrarNuevaPieza(Pieza pieza, HashMap <String, Pieza> piezas) {
		piezas.put(pieza.getTitulo(), pieza);
	}
}	
