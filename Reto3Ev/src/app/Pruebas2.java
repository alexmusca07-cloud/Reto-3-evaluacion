package app;

import dao.*;
import modelo.*;

public class Pruebas2 {

	public static void main(String[] args) {
		ClienteDAO cdao = new ClienteDAO();
		EmpleadoDAO edao = new EmpleadoDAO();
		FacturaDAO fdao = new FacturaDAO();
		LineaFacturaDAO ldao = new LineaFacturaDAO();
		ProductoDAO pdao = new ProductoDAO();
		/*
		 * case 6: cdao.insertar(new Cliente("12345678V", "Pepe Carrera",
		 * "Plaza Mozart")); break;
		 * 
		 * ClienteFichero.guardarFichero(cdao.obtenerTodos());
		 * ClienteFichero.leerFichero();
		 */
		// case 15:
		int contador = 0;
		double sum = 0;
		for (Empleado e : edao.obtenerTodos()) {
			for (Factura f : fdao.obtenerPorMesEIdEmpleado(5, e.getId())) {
				sum += f.getTotal();
				contador++;
			}
			System.out.println("Empleado de id " + e.getId() + " ha hecho " + contador + "facturas  y ha facturado " + sum + "€");
			contador=0;
			sum=0;
		}

	}

}
