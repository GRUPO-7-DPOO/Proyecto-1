package usuario;

public abstract class Usuario {
	public String login;
	protected String clave;
	protected String nombre;
	public int telefono;
	public String correo;
	protected String tipoUsuario;
	
	public Usuario(String nombre, String login, String clave, String correo, int telefono) {
		this.nombre = nombre;
		this.login = login;
		this.clave = clave;
		this.correo = correo;
		this.telefono = telefono;
	}
	
	public String getClave(){
		return this.clave;
	}
	
	public String getTipoUsuario() {
		return this.tipoUsuario;
	}
	
	public String getName() {
		return this.nombre;
	}
}
