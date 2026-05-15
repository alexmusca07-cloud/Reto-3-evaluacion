package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import dao.ClienteDAO;

public class ClienteFichero {

	// Guardar clientes
	public void guardarFichero(ClienteDAO cdao) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("clientes.dat"))) {
			out.writeObject(cdao.obtenerTodos());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void leerFichero() {
		// Leer cliente
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("clientes.dat"))) {
			Cliente clienteLeida = (Cliente) in.readObject();
			System.out.println(clienteLeida);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
