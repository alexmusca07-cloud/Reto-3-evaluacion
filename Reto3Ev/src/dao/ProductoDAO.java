package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.Factura;
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
						ps2.executeUpdate();
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
		List<Producto> lista = new ArrayList<Producto>();
		String sql = """
				select id,nombre,precio,stock from producto
				""";
		try(Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
			try (ResultSet rs = ps.executeQuery()){
				while (rs.next()) {
					lista.add(mapeo(rs));
				}
			}
			return lista;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return null;
	}

	@Override
	public Producto obtenerPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean actualizar(Producto objeto) {
		return false;
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean actualizarPasandoIdYPrecio(int id,double precio) {
		String sql = """
				update producto set precio = ? where id = ?
				""";
		try(Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
			ps.setDouble(1, precio);
			ps.setInt(2, id);
			int filas = ps.executeUpdate();
			if(filas > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public boolean eliminarProductoSiNoEstaEnLineaFactura(int id) {
		String sql = """
				delete from producto left t1 join lineafactura t2 on t1.id = t2.id_producto where t1.id = ? and t2.idproducto is null
				""";
		try(Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, id);
			int filas = ps.executeUpdate();
			if(filas > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	private Producto mapeo(ResultSet rs) throws SQLException{
		Producto p = new Producto();
		p.setId(rs.getInt("id"));
		p.setNombre(rs.getString("nombre"));
		p.setPrecio(rs.getDouble("precio"));
		p.setStock(rs.getInt("stock"));
		return p;
	}
}
