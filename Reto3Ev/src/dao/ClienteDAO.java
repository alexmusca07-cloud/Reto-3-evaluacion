package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import modelo.Factura;
import util.ConexionBD;

public class ClienteDAO implements GenericDAO<Cliente>{

	@Override
	public boolean insertar(Cliente objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Cliente> obtenerTodos() {
		List<Cliente> clientes = new ArrayList<>();
		String sql = "SELECT id, nombre, nacionalidad FROM autor ORDER BY nombre";

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
		// TODO Auto-generated method stub
		return null;
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
