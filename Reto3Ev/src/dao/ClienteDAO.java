package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import util.ConexionBD;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ClienteDAO implements GenericDAO<Cliente>, Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public boolean insertar(Cliente cliente) {
		String sql = "INSERT INTO persona (dni, nombre) VALUES (?, ?)";

		try (Connection conn = ConexionBD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstmt.setString(1, cliente.getDni());
			pstmt.setString(2, cliente.getNombre());

			int filas = pstmt.executeUpdate();

			if (filas > 0) {
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					if (rs.next()) {
						cliente.setId(rs.getInt(1)); // asigna el ID
						return true;
					}
				}
			}
			String sql2 = "INSERT INTO cliente (direccion) VALUES (?)";

			try (Connection conn2 = ConexionBD.getConnection();
					PreparedStatement pstmt2 = conn2.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS)) {

				pstmt2.setString(1, cliente.getDireccion());

				filas = pstmt2.executeUpdate();

				if (filas > 0) {
					try (ResultSet rs = pstmt2.getGeneratedKeys()) {
						if (rs.next()) {
							cliente.setId(rs.getInt(1)); // asigna el ID
							return true;
						}
					}
				}

				return false;

			} catch (SQLException e) {
				System.err.println("Error SQL al insertar '" + cliente.getNombre() + "': " + e.getMessage());
				return false;
			}
		} catch (SQLException e) {
			System.err.println("Error SQL al insertar '" + cliente.getNombre() + "': " + e.getMessage());
			return false;
		}

	}

	@Override
	public List<Cliente> obtenerTodos() {
		List<Cliente> clientes = new ArrayList<>();
		String sql = "SELECT p.id, p.dni, p.nombre, c.id as idcliente, c.direccion  FROM persona p join cliente c on p.id=c.id";

		try (Connection conn = ConexionBD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				clientes.add(mapearFila(rs));
			}
			// Guardar clientes
			try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("clientes.dat"))) {
				out.writeObject(clientes);

				// Leer cliente
				try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("clientes.dat"))) {
					Cliente clienteLeida = (Cliente) in.readObject();
					System.out.println(clienteLeida);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			System.err.println("Error SQL al obtener todos los clientes: " + e.getMessage());
		}
		return clientes;
	}

	@Override
	public Cliente obtenerPorId(int id) {
		String sql = "\"SELECT p.id, p.dni, p.nombre, c.id as idcliente, c.direccion  FROM persona p join cliente c on p.id=c.id WHERE id = ?";

		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, id);

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return mapearFila(rs);
				}
			}

		} catch (SQLException e) {
			System.err.println("Error SQL al buscar ID " + id + ": " + e.getMessage());
		}
		return null; // no encontrado
	}

	@Override
	public boolean actualizar(Cliente objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	private Cliente mapearFila(ResultSet rs) throws SQLException {
		Cliente c = new Cliente();
		c.setId(rs.getInt("id"));
		c.setDireccion(rs.getString("direccion"));
		return c;

	}

}
