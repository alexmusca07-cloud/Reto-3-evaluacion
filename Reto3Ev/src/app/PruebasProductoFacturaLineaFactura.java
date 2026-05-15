package app;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

import dao.ClienteDAO;
import dao.EmpleadoDAO;
import dao.FacturaDAO;
import dao.LineaFacturaDAO;
import dao.ProductoDAO;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Factura;
import modelo.Producto;

public class PruebasProductoFacturaLineaFactura {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		FacturaDAO fdao = new FacturaDAO();
		LineaFacturaDAO ldao = new LineaFacturaDAO();
		ProductoDAO pdao = new ProductoDAO();
		ClienteDAO cdao = new ClienteDAO();
		EmpleadoDAO edao = new EmpleadoDAO();
		
		double suma = 0;
		for (Factura f : fdao.obtenerPorMes(5)) {
			System.out.println(f);
			suma = suma + f.getTotal();
		}
		System.out.println("total gastado: " + suma);
		System.out.println();
		for (Factura f : fdao.obtenerPorFecha(LocalDate.of(2026, 05, 5))) {
			System.out.println(f);
		}
		//7
		boolean salida = true;
		do {
			System.out.println("Escribe un nombre");
			String nombre = sc.nextLine();
			System.out.println("Escribe un precio");
			double precio = Double.parseDouble(sc.nextLine());
			System.out.println("Escribe un stock");
			int stock = Integer.parseInt(sc.nextLine());
			if (pdao.insertar(new Producto(nombre,precio,stock)) ==  true) {
				System.out.println("insertado");
				salida = false;
			}
			else {
				System.out.println("No se puede insertar");
			}
		} while (salida != false);
		
		for (Cliente c : cdao.obtenerTodos()) {
			System.out.println(c);
		}
		System.out.println();
		System.out.println(cdao.obtenerPorId(1));
		for (Factura f : fdao.obtenerPorIdCliente(cdao.obtenerPorId(1).getId())) {
			System.out.println(f);
		}
		System.out.println();
		//2
		for (Empleado e : edao.obtenerTodos()) {
			System.out.println(e);
		}
		System.out.println();
		System.out.println(edao.obtenerPorId(1));
		for (Factura f : fdao.obtenerPorIdEmpleado(edao.obtenerPorId(1).getId())) {
			System.out.println(f);
		}
	}

}
