package usuario;

public abstract class Usuario {
	public String login;
	protected String clave;
	public String nombre;
	public int telefono;
	public String correo;
	protected String tipoUsuario;
	
	public String getClave(){
		return this.clave;
	}
	
	public String getTipoUsuario() {
		return this.tipoUsuario;
	}
}
