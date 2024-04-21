package usuario;
import java.util.HashMap;

import galeria.*;

public class Operador extends Usuario {
	
	private HashMap <String, Integer> mapaRegistro;
	
	public Operador(String nombre, String login, String clave, String correo, int telefono) {
		super(nombre, login, clave, correo, telefono);
		this.tipoUsuario = "Operador";
		this.mapaRegistro = new HashMap<>();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String getClave() {
		// TODO Auto-generated method stub
		return super.getClave();
	}

	@Override
	public String getTipoUsuario() {
		// TODO Auto-generated method stub
		return super.getTipoUsuario();
	}
	
	public void getMapa(Subasta s) {
		this.mapaRegistro = s.getRegistros();
	}
	
	public void agregarRegistro(String login, int valor) {
		this.mapaRegistro.put(login, valor);
	}
	
	public void cambiarMapaSubasta(Subasta s) {
		s.setRegistros(this.mapaRegistro);
	}
	
}
