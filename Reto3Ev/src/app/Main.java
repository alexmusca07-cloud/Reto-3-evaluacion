package app;

import java.util.Locale;
import java.util.Scanner;

import dao.ClienteDAO;
import dao.EmpleadoDAO;
import dao.FacturaDAO;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Factura;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		ClienteDAO cdao = new ClienteDAO();
		FacturaDAO fdao = new FacturaDAO();
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
				""";
		boolean salida = true;
		do {
			System.out.println("Escribe \n" + menu);
			salida = false;
		} while (salida != false);
		
	}
}

