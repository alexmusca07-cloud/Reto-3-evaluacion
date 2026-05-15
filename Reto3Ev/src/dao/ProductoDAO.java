package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import modelo.Producto;
import util.ConexionBD;

public class ProductoDAO implements GenericDAO<Producto> {

	@Override
	public boolean insertar(Producto objeto) {
		boolean salida = true;
		int contador = 0;
		do {
			String sql = """
					select id,nombre,precio,stock from producto where nombre = ?
					""";
			try(Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, objeto.getNombre());
				try (ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						contador++;
					}
					if(contador == 0) {
						String sql2 = """
								insert producto (nombre,precio,stock)
								values(?,?,?)
								""";
						PreparedStatement ps2 = con.prepareStatement(sql2);
						ps2.setString(1, objeto.getNombre());
						ps2.setDouble(2, objeto.getPrecio());
						ps2.setInt(3, objeto.getStock());
						return true;
					} else {
						salida = false;
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (salida != false);
		return false;
	}

	@Override
	public List<Producto> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto obtenerPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean actualizar(Producto objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
