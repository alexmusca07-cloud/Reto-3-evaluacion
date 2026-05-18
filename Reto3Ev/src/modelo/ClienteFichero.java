package modelo;

import java.util.List;
import java.io.*;

public class ClienteFichero {

	/**
	 * Este metodo guarda la lista que le pases en este caso de clientes en un
	 * fichero .dat
	 * 
	 * @param clientes Es la lista que pasaremos, que sera el ClienteDAO con el
	 *                 metodo .obtenerTodos
	 * @return Este metodo devolvera true si se ha podido guardar y false si no ha
	 *         podido guardarse
	 */
	public static boolean guardarFichero(List<Cliente> clientes) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("clientes.dat"))) {
			out.writeObject(clientes);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Este metodo lee ficheros .dat en este caso el que se crea al usar el metodo
	 * guardarFichero.
	 * 
	 * @return Devolvera la lista si ha podido leer el fichero .dat si no ha podido
	 *         leerlo devolvera false
	 */
	public static List<Cliente> leerFichero() {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("clientes.dat"))) {
			List<Cliente> clienteLeida = (List<Cliente>) in.readObject();
			return clienteLeida;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
