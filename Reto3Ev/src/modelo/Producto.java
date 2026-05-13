package modelo;

import java.math.BigDecimal;

public class Producto {

	protected int id;
	protected String nombre;
	protected BigDecimal precio;
	protected int stock;
	
	public Producto(int id, String nombre, BigDecimal precio, int stock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}
	
	public Producto(String nombre, BigDecimal precio, int stock) {
		this(0,nombre,precio,stock);
	}
	
	public Producto() {
		this(0,"producto",new BigDecimal(0),0);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + "]";
	}
	
	
}
