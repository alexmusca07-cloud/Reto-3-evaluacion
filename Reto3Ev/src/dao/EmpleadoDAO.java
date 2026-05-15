package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Empleado;
import util.ConexionBD;

public class EmpleadoDAO implements GenericDAO<Empleado> {

	@Override
	public boolean insertar(Empleado objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Empleado> obtenerTodos() {
		List<Empleado> clientes = new ArrayList<>();
		String sql = "SELECT p.id, p.dni, p.nombre, e.puesto, e.salario FROM persona p join empleado e on p.id=e.id";

		try (Connection conn = ConexionBD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				clientes.add(mapearFila(rs));

			}

		} catch (SQLException e) {
			System.err.println("Error SQL al obtener todos los empleados: " + e.getMessage());
		}
		return clientes;
	}

	@Override
	public Empleado obtenerPorId(int id) {
		String sql = "SELECT id, puesto, salario FROM empleado WHERE id = ?";

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
	public boolean actualizar(Empleado objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	private Empleado mapearFila(ResultSet rs) throws SQLException {
		Empleado e = new Empleado();
		e.setId(rs.getInt("id"));
		e.setPuesto(rs.getString("puesto"));
		e.setSalario(rs.getDouble("salario"));
		return e;

	}

}
