package app;

import dao.ClienteDAO;
import dao.FacturaDAO;
import modelo.Cliente;
import modelo.Factura;

public class Main {

	public static void main(String[] args) {
		ClienteDAO cdao = new ClienteDAO();
		FacturaDAO fdao = new FacturaDAO();
		//1
		for (Cliente c : cdao.obtenerTodos()) {
			System.out.println(c);
		}
		System.out.println();
		System.out.println(cdao.obtenerPorId(1));
		System.out.println();
		for (Factura f : fdao.obtenerPorIdCliente(1)) {
			System.out.println(f);
		}
		System.out.println();
	}
}

