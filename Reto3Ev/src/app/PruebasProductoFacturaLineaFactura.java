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
import modelo.LineaFactura;
import modelo.Producto;

public class PruebasProductoFacturaLineaFactura {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		FacturaDAO fdao = new FacturaDAO();
		LineaFacturaDAO ldao = new LineaFacturaDAO();
		ProductoDAO pdao = new ProductoDAO();
		ClienteDAO cdao = new ClienteDAO();
		EmpleadoDAO edao = new EmpleadoDAO();
		//System.out.println(cdao.obtenerPorId(1));
		//System.out.println(edao.obtenerPorId(5));
		System.out.println(pdao.obtenerPorId(1));	
	}

}
