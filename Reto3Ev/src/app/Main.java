package app;

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

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		FacturaDAO fdao = new FacturaDAO();
		LineaFacturaDAO ldao = new LineaFacturaDAO();
		ProductoDAO pdao = new ProductoDAO();
		ClienteDAO cdao = new ClienteDAO();
		EmpleadoDAO edao = new EmpleadoDAO();
		String menu = """
				1. Para mostrar clientes,elegir uno por id y mostrar las facturas que tiene
				2. Para mostrar empleados, elegir uno por id y mostrar las facturas hechas
				3. Para una factura y obtener todas las líneas de factura con ese id de factura
				4. Para mostrar todas las facturas por mes
				5. Para mostrar todas las facturas por una fecha
				6. Para insertar un cliente
				7. Para insertar un producto
				8. Para actualizar un producto
				9. Para insertar una factura
				10. Para mostrar todos los productos, elegir uno por id y mostrar todas las facturas en las que esta
				11. Para borrar un producto que no este en una línea de factura
				12. Para guardar una lista de clientes en un archivo
				13. Para duplicar una factura y todas sus líneas de factura pero con una fecha diferente
				14. Para eliminar una línea de factura y actualizar la factura correspondiente
				15. Para mostrar por mes cuanto ha vendido cada empleado y lo facturado por cada uno
				fin Para salir
				""";
		boolean salida = true;
		do {
			System.out.println("Escribe \n" + menu);
			String opcion = sc.nextLine();
			if(opcion.equalsIgnoreCase("fin")) {
				salida = false;
			} else {
				int num = Integer.parseInt(opcion);
				switch (num) {
				
				case 1: 
					int contadorCliente = 0;
					for (Cliente c : cdao.obtenerTodos()) {
						System.out.println(c);
					}
					System.out.println();
					System.out.println("Escribe un id del cliente de los mostrados");
					int id_cliente = Integer.parseInt(sc.nextLine());
					for (Cliente c : cdao.obtenerTodos()) {
						if(c.getId() == id_cliente) {
							contadorCliente++;
						}
					}
					if(contadorCliente > 0) {
						for (Factura f : fdao.obtenerPorIdCliente(id_cliente)) {
							System.out.println(f);
						}
						System.out.println();
					} else {
						System.out.println("no has insertado un id de los clientes mostrados antes");
					}
					break;
				
				case 2:
					int contadorEmpleado = 0;
					for (Empleado e : edao.obtenerTodos()) {
						System.out.println(e);
					}
					System.out.println();
					System.out.println("Escribe un id del empleado de los mostrados");
					System.out.println();
					int id_empleado = Integer.parseInt(sc.nextLine());
					for (Cliente c : cdao.obtenerTodos()) {
						if(c.getId() == id_empleado) {
							contadorEmpleado++;
						}
					}
					if(contadorEmpleado > 0) {
						for (Factura f : fdao.obtenerPorIdEmpleado(id_empleado)) {
							System.out.println(f);
						}
						System.out.println();
					} else {
						System.out.println("no has insertado un id de los empleados mostrados antes");
					}
					break;
				default:
					System.out.println("No es ni fin ni un número de los indicados");
				}
			}
		} while (salida != false);
		
	}
}

