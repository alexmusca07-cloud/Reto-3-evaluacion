package modelo;

import java.time.LocalDate;

public class Factura {

	protected int id;
	protected LocalDate fecha;
	protected int id_cliente;
	protected int id_empleado;
	protected Double subtotal;
	protected double iva;
	protected Double total;

	public Factura(int id, LocalDate fecha, int id_cliente, int id_empleado, Double subtotal, double iva,
			Double total) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.id_cliente = id_cliente;
		this.id_empleado = id_empleado;
		this.subtotal = subtotal;
		this.iva = iva;
		this.total = total;
	}

	public Factura(LocalDate fecha, int id_cliente, int id_empleado, Double subtotal, double iva, Double total) {
		this(0, fecha, id_cliente, id_empleado, subtotal, iva, total);
	}

	public Factura() {
		this(0, LocalDate.now(), 0, 0, 0.0, 0, 0.0);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", fecha=" + fecha + ", id_cliente=" + id_cliente + ", id_empleado=" + id_empleado
				+ ", subtotal=" + subtotal + ", iva=" + iva + ", total=" + total + "]";
	}

}
