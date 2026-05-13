package modelo;

import java.math.BigDecimal;

public class LineaFactura {

	protected int id;
	protected int id_factura;
	protected int id_producto;
	protected int cantidad;
	protected BigDecimal precio_unitario;
	protected BigDecimal importe;
	
	public LineaFactura(int id, int id_factura, int id_producto, int cantidad, BigDecimal precio_unitario,
			BigDecimal importe) {
		super();
		this.id = id;
		this.id_factura = id_factura;
		this.id_producto = id_producto;
		this.cantidad = cantidad;
		this.precio_unitario = precio_unitario;
		this.importe = importe;
	}
	
	public LineaFactura(int id_factura, int id_producto, int cantidad, BigDecimal precio_unitario,
			BigDecimal importe) {
		this(0,id_factura,id_producto,cantidad,precio_unitario,importe);
	}
	
	public LineaFactura() {
		this(0,0,0,0,new BigDecimal(0),new BigDecimal(0));
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

	public BigDecimal getPrecio_unitario() {
		return precio_unitario;
	}

	public void setPrecio_unitario(BigDecimal precio_unitario) {
		this.precio_unitario = precio_unitario;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	@Override
	public String toString() {
		return "LineaFactura [id=" + id + ", id_factura=" + id_factura + ", id_producto=" + id_producto + ", cantidad="
				+ cantidad + ", precio_unitario=" + precio_unitario + ", importe=" + importe + "]";
	}
	
	
}
