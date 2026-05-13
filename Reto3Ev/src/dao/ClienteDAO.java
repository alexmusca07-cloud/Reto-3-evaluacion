package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import util.ConexionBD;

public class ClienteDAO implements GenericDAO<Cliente>{

	@Override
	public boolean insertar(Cliente cliente) {
		String sql = "INSERT INTO autor (nombre, direccion) VALUES (?, ?)";

		try (Connection conn = ConexionBD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstmt.setString(1, cliente.getNombre());
			pstmt.setString(3, cliente.getDireccion());

			int filas = pstmt.executeUpdate();

			if (filas > 0) {
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
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
	}

	@Override
	public List<Cliente> obtenerTodos() {
		List<Cliente> clientes = new ArrayList<>();
		String sql = "SELECT id, direccion FROM cliente";

		try (Connection conn = ConexionBD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				clientes.add(mapearFila(rs));

			}

		} catch (SQLException e) {
			System.err.println("Error SQL al obtener todos los clientes: " + e.getMessage());
		}
		return clientes;
	}
	@Override
	public Cliente obtenerPorId(int id) {
		String sql = "SELECT id, direccion FROM cliente WHERE id = ?";

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
	private Cliente mapearFila(ResultSet rs) throws SQLException{
		Cliente c = new Cliente();
		c.setId(rs.getInt("id"));
		c.setDireccion(rs.getString("direccion"));
		return c;

	}

}
