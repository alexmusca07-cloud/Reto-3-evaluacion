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
import modelo.ClienteFichero;
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
		

		//1
				/*for (Cliente c : cdao.obtenerTodos()) {
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
				}*/
				ClienteFichero.guardarFichero(cdao.obtenerTodos());
				ClienteFichero.leerFichero();
	}

}
