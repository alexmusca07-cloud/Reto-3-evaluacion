package app;

import java.time.LocalDate;

import dao.FacturaDAO;
import dao.LineaFacturaDAO;
import dao.ProductoDAO;
import modelo.Factura;

public class PruebasProductoFacturaLineaFactura {

	public static void main(String[] args) {
		FacturaDAO fdao = new FacturaDAO();
		LineaFacturaDAO ldao = new LineaFacturaDAO();
		ProductoDAO pdao = new ProductoDAO();
		
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
	}

}
