package usuario;

import java.util.ArrayList;
import piezas.*;

public class Comprador extends Usuario {
	public double precioLimite;
	public ArrayList <String> obrasPropiedad;
	
	public Comprador(String nombre, String login, int telefono, String clave, String correo, String tipoUsuario) {
		this.nombre = nombre;
		this.login = login;
		this.clave = clave;
		this.correo = correo;
		this.telefono = telefono;
		this.tipoUsuario = tipoUsuario;
		
		obrasPropiedad = new ArrayList<>();
		}
	
	public void setPrecioLimite(int precio) {
		this.precioLimite = precio;
	}
	
}
