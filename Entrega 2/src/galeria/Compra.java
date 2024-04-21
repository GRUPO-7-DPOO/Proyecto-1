package galeria;

public class Compra {
	private String metodoPago;
	public String id;
	private String comprador;
	private String piezaAComprar;
	private int valor;
	
	public Compra(String metodoPago, String id, String comprador, String piezaAComprar, int valor) {
		super();
		this.metodoPago = metodoPago;
		this.id = id;
		this.comprador = comprador;
		this.piezaAComprar = piezaAComprar;
		this.valor = valor;
	}
	
	public String getComprador() {
		return this.comprador;
	}

	public String getId() {
		return this.id;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	public String piezaAComprar() {
		return this.piezaAComprar;
	}
	
	public String getMetodoPago() {
		return this.metodoPago;
	}
	
}
