package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import dao.ClienteDAO;

public class ClienteFichero {

	// Guardar clientes
	public static void guardarFichero(List<Cliente> clientes) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("clientes.dat"))) {
			out.writeObject(clientes);
			System.out.println("Se ha guardado correctamente");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void leerFichero() {
		// Leer cliente
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("clientes.dat"))) {
			List<Cliente> clienteLeida = (List<Cliente>) in.readObject();
			System.out.println(clienteLeida);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
