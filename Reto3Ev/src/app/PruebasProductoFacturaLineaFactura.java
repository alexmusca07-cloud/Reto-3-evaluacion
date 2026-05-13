package app;

import dao.FacturaDAO;
import dao.LineaFacturaDAO;
import dao.ProductoDAO;

public class PruebasProductoFacturaLineaFactura {

	public static void main(String[] args) {
		FacturaDAO fdao = new FacturaDAO();
		LineaFacturaDAO ldao = new LineaFacturaDAO();
		ProductoDAO pdao = new ProductoDAO();
	}

}
