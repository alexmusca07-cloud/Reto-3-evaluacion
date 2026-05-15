package app;

import java.time.LocalDate;
import java.util.Scanner;

import dao.ClienteDAO;
import dao.EmpleadoDAO;
import dao.FacturaDAO;
import dao.LineaFacturaDAO;
import dao.ProductoDAO;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Factura;
import modelo.LineaFactura;
import modelo.Producto;

public class Metodos_del_main {

	public static void eje1(Scanner sc, FacturaDAO fdao, ClienteDAO cdao) {
		int contadorCliente = 0;
		for (Cliente c : cdao.obtenerTodos()) {
			System.out.println(c);
		}
		System.out.println();
		System.out.println("Escribe un id del cliente de los mostrados");
		int id_cliente = Integer.parseInt(sc.nextLine());
		for (Cliente c : cdao.obtenerTodos()) {
			if (c.getId() == id_cliente) {
				contadorCliente++;
			}
		}
		if (contadorCliente > 0) {
			for (Factura f : fdao.obtenerPorIdCliente(id_cliente)) {
				System.out.println(f);
			}
			System.out.println();
		} else {
			System.out.println("no has insertado un id de los clientes mostrados antes");
		}
	}

	public static void eje2(Scanner sc, FacturaDAO fdao, ClienteDAO cdao, EmpleadoDAO edao) {
		int contadorEmpleado = 0;
		for (Empleado e : edao.obtenerTodos()) {
			System.out.println(e);
		}
		System.out.println();
		System.out.println("Escribe un id del empleado de los mostrados");
		System.out.println();
		int id_empleado = Integer.parseInt(sc.nextLine());
		for (Cliente c : cdao.obtenerTodos()) {
			if (c.getId() == id_empleado) {
				contadorEmpleado++;
			}
		}
		if (contadorEmpleado > 0) {
			for (Factura f : fdao.obtenerPorIdEmpleado(id_empleado)) {
				System.out.println(f);
			}
			System.out.println();
		} else {
			System.out.println("no has insertado un id de los empleados mostrados antes");
		}
	}

	public static void eje3(Scanner sc, FacturaDAO fdao, LineaFacturaDAO ldao) {
		System.out.println("Escribe un id de factura");
		int id_factura = Integer.parseInt(sc.nextLine());
		if (fdao.obtenerPorId(id_factura) != null) {
			System.out.println(fdao.obtenerPorId(id_factura));
			for (LineaFactura l : ldao.obtenerPorIdFactura(id_factura)) {
				System.out.println(l);
			}
		} else {
			System.out.println("No esta ese id de factura");
		}
	}

	public static void eje4(Scanner sc, FacturaDAO fdao) {
		System.out.println("Escribe un mes");
		int mes = Integer.parseInt(sc.nextLine());
		for (Factura f : fdao.obtenerPorMes(mes)) {
			System.out.println(f);
		}
	}
	
	public static void eje5(Scanner sc, FacturaDAO fdao) {
		LocalDate fecha = LocalDate.now();
		try {
			System.out.println("Escribe un dia de mes");
			int dia = Integer.parseInt(sc.nextLine());
			System.out.println("Escribe un mes");
			int mes = Integer.parseInt(sc.nextLine());
			System.out.println("Escribe un año");
			int ano = Integer.parseInt(sc.nextLine());
			fecha = LocalDate.of(ano, mes, dia);
			for (Factura f : fdao.obtenerPorFecha(fecha)) {
				System.out.println(f);
			}
		} catch (Exception e) {
			System.out.println("Error en la fecha");
		}
	}
	
	public static void eje7(Scanner sc, ProductoDAO pdao) {
		System.out.println("Escribe el nombre del producto");
		String nombre = sc.nextLine();
		System.out.println("Escribe el precio del producto");
		double precio = Double.parseDouble(sc.nextLine());
		System.out.println("Escribe el stock del producto");
		int stock = Integer.parseInt(sc.nextLine());
		Producto p = new Producto(nombre,precio,stock);
		System.out.println(pdao.insertar(p));
	}
	
	public static void eje8(Scanner sc, ProductoDAO pdao) {
		System.out.println("Escribe el id de un producto");
		int id_producto = Integer.parseInt(sc.nextLine());
		System.out.println("Escribe el proximo precio de ese producto");
		double precio = Double.parseDouble(sc.nextLine());
		pdao.actualizarPasandoIdYPrecio(id_producto, precio);
	}
}
