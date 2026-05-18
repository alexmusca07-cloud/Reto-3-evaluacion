package modelo;

public class LineaFactura {

	protected int id;
	protected int id_factura;
	protected int id_producto;
	protected int cantidad;
	protected Double precio_unitario;
	protected Double importe;

	/**
	 * Este constructor contiene todos los parametros de LineaFactura
	 * 
	 * @param id              El id de la LineaFactura
	 * @param id_factura      El id de la factura
	 * @param id_producto     El id del producto
	 * @param cantidad        La cantidad de productos
	 * @param precio_unitario El precio unitario de cada producto
	 * @param importe         El importe total
	 */
	public LineaFactura(int id, int id_factura, int id_producto, int cantidad, Double precio_unitario, Double importe) {
		super();
		this.id = id;
		this.id_factura = id_factura;
		this.id_producto = id_producto;
		this.cantidad = cantidad;
		this.precio_unitario = precio_unitario;
		this.importe = importe;
	}

	/**
	 * Este constructor contiene todos los campos de LineaFactura menos el id
	 * 
	 * @param id_factura      El id de la factura
	 * @param id_producto     El id del producto
	 * @param cantidad        La cantidad de productos
	 * @param precio_unitario El precio unitario de cada producto
	 * @param importe         El importe total
	 */
	public LineaFactura(int id_factura, int id_producto, int cantidad, Double precio_unitario, Double importe) {
		this(0, id_factura, id_producto, cantidad, precio_unitario, importe);
	}

	/**
	 * Este constructor va vacio
	 */
	public LineaFactura() {
		this(0, 0, 0, 0, 0.0, 0.0);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_factura() {
		return id_factura;
	}

	public void setId_factura(int id_factura) {
		this.id_factura = id_factura;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio_unitario() {
		return precio_unitario;
	}

	public void setPrecio_unitario(Double precio_unitario) {
		this.precio_unitario = precio_unitario;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	@Override
	public String toString() {
		return "LineaFactura [id=" + id + ", id_factura=" + id_factura + ", id_producto=" + id_producto + ", cantidad="
				+ cantidad + ", precio_unitario=" + precio_unitario + ", importe=" + importe + "]";
	}

}
