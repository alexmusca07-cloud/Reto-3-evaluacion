package modelo;

public class Producto {

	protected int id;
	protected String nombre;
	protected Double precio;
	protected int stock;
	/**
	 * Este constructor tiene todos los campos de producto
	 * @param id El id del producto
	 * @param nombre El nombre del producto
	 * @param precio El precio del producto
	 * @param stock La cantidad de stock que hay de ese producto
	 */
	public Producto(int id, String nombre, Double precio, int stock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}
	/**
	 * Este constructor tiene todos los campos de producto pero sin el id
	 * @param nombre El nombre del producto
	 * @param precio El precio del producto
	 * @param stock La cantidad de stock que hay de ese producto
	 */
	public Producto(String nombre, Double precio, int stock) {
		this(0, nombre, precio, stock);
	}
	/**
	 * Este constructor va vacio
	 */
	public Producto() {
		this(0, "producto", 0.0, 0);
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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
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
