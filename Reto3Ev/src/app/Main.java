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
		//1
		for (Cliente c : cdao.obtenerTodos()) {
			System.out.println(c);
		}
		System.out.println();
		System.out.println(cdao.obtenerPorId(1));
		for (Factura f : fdao.obtenerPorIdCliente(1)) {
			System.out.println(f);
		}
		System.out.println();
		//2
		for (Empleado e : edao.obtenerTodos()) {
			System.out.println(e);
		}
	}
}

