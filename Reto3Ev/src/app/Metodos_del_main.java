package app;

import java.util.Scanner;

import dao.ClienteDAO;
import dao.EmpleadoDAO;
import dao.FacturaDAO;
import dao.LineaFacturaDAO;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Factura;
import modelo.LineaFactura;

public class Metodos_del_main {

	public static void eje1(Scanner sc, FacturaDAO fdao, ClienteDAO cdao) {
		int contadorCliente = 0;
		for (Cliente c : cdao.obtenerTodos()) {
			System.out.println(c);
		}
		System.out.println();
		System.out.println("Escribe un id del cliente de los mostrados");
		int id_cliente = Integer.parseInt(sc.nextLine());
		for (Cliente c : cdao.obtenerTodos()) {
			if (c.getId() == id_cliente) {
				contadorCliente++;
			}
		}
		if (contadorCliente > 0) {
			for (Factura f : fdao.obtenerPorIdCliente(id_cliente)) {
				System.out.println(f);
			}
			System.out.println();
		} else {
			System.out.println("no has insertado un id de los clientes mostrados antes");
		}
	}

	public static void eje2(Scanner sc, FacturaDAO fdao, ClienteDAO cdao, EmpleadoDAO edao) {
		int contadorEmpleado = 0;
		for (Empleado e : edao.obtenerTodos()) {
			System.out.println(e);
		}
		System.out.println();
		System.out.println("Escribe un id del empleado de los mostrados");
		System.out.println();
		int id_empleado = Integer.parseInt(sc.nextLine());
		for (Cliente c : cdao.obtenerTodos()) {
			if (c.getId() == id_empleado) {
				contadorEmpleado++;
			}
		}
		if (contadorEmpleado > 0) {
			for (Factura f : fdao.obtenerPorIdEmpleado(id_empleado)) {
				System.out.println(f);
			}
			System.out.println();
		} else {
			System.out.println("no has insertado un id de los empleados mostrados antes");
		}
	}

	public static void eje3(Scanner sc, FacturaDAO fdao, LineaFacturaDAO ldao) {
		System.out.println("Escribe un id de factura");
		int id_factura = Integer.parseInt(sc.nextLine());
		if (fdao.obtenerPorId(id_factura) != null) {
			System.out.println(fdao.obtenerPorId(id_factura));
			for (LineaFactura l : ldao.obtenerPorIdFactura(id_factura)) {
				System.out.println(l);
			}
		} else {
			System.out.println("No esta ese id de factura");
		}
	}
	
	public static void eje4(Scanner sc, FacturaDAO fdao) {
		System.out.println("Escribe un mes");
		int mes = Integer.parseInt(sc.nextLine());
		for (Factura f : fdao.obtenerPorMes(mes)) {
			System.out.println(f);
		}
	}
}
