package app;

import dao.ClienteDAO;
import modelo.Cliente;
import modelo.ClienteFichero;

public class Pruebas2 {

	
	public static void main(String[] args) {
		ClienteDAO cdao = new ClienteDAO();
		/*case 6:
		cdao.insertar(new Cliente("12345678V", "Pepe Carrera", "Plaza Mozart"));
		break;
		*/
		ClienteFichero.guardarFichero(cdao.obtenerTodos());
		ClienteFichero.leerFichero();
	}

}
