package modelo;

import java.time.LocalDate;

public class Factura {

	protected int id;
	protected LocalDate fecha;
	protected int id_cliente;
	protected int id_empleado;
	protected double subtotal;
	protected double iva;
	protected double total;

	/**
	 * Este constructor contiene todos los datos de la factura
	 * 
	 * @param id          El id de la factura
	 * @param fecha       La fecha de la factura
	 * @param id_cliente  El id del cliente al que va destinado al factura
	 * @param id_empleado El id del empleado que emite la factura
	 * @param subtotal    El precio sin IVA de la factura
	 * @param iva         El coste del IVA
	 * @param total       El subtotal+IVA
	 */
	public Factura(int id, LocalDate fecha, int id_cliente, int id_empleado, double subtotal, double iva,
			double total) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.id_cliente = id_cliente;
		this.id_empleado = id_empleado;
		this.subtotal = subtotal;
		this.iva = iva;
		this.total = total;
	}

	/**
	 * Este constructor contiene todos los datos de la factura menos el id
	 * 
	 * @param fecha       La fecha de la factura
	 * @param id_cliente  El id del cliente al que va destinado al factura
	 * @param id_empleado El id del empleado que emite la factura
	 * @param subtotal    El precio sin IVA de la factura
	 * @param iva         El coste del IVA
	 * @param total       El subtotal+IVA
	 */
	public Factura(LocalDate fecha, int id_cliente, int id_empleado, double subtotal, double iva, double total) {
		this(0, fecha, id_cliente, id_empleado, subtotal, iva, total);
	}

	/**
	 * Este constructor va vacio
	 */
	public Factura() {
		this(0, LocalDate.now(), 0, 0, 0.0, 0.0, 0.0);
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

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", fecha=" + fecha + ", id_cliente=" + id_cliente + ", id_empleado=" + id_empleado
				+ ", subtotal=" + subtotal + ", iva=" + iva + ", total=" + total + "]";
	}

}
