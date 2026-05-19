package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Factura;
import modelo.LineaFactura;
import util.ConexionBD;

public class LineaFacturaDAO implements GenericDAO<LineaFactura> {

	@Override
	public boolean insertar(LineaFactura objeto) {
		String sql = """
				insert lineafactura (id_factura,id_producto,cantidad,precio_unitario,importe)
				values(?,?,?,?,?)
				""";
		try(Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, objeto.getId_factura());
			ps.setInt(2, objeto.getId_producto());
			ps.setInt(3, objeto.getCantidad());
			ps.setDouble(4, objeto.getPrecio_unitario());
			ps.setDouble(5, objeto.getImporte());
			int num = ps.executeUpdate();
			if(num > 0) {
				return true;
			} 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public List<LineaFactura> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LineaFactura obtenerPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean actualizar(LineaFactura objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int id) {
		String sql = """
				delete from lineafactura where id = ?
				""";
		try(Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, id);
			int num = ps.executeUpdate();
			if(num > 0) {
				return true;
			} 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public List<LineaFactura> obtenerPorIdFactura(int id){
		List<LineaFactura> lista = new ArrayList<LineaFactura>();
		String sql = """
				select id,id_factura,id_producto,cantidad,precio_unitario,importe from lineafactura where id_factura = ?
				""";
		try(Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, id);
			try(ResultSet rs = ps.executeQuery()){
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
	
	public boolean insertarPorIdFactura(List<LineaFactura> lista, Factura f) {
		int filas = 0;
		for (LineaFactura lineaFactura : lista) {
			String sql = """
					insert lineafactura (id_factura,id_producto,cantidad,precio_unitario,importe)
					values(?,?,?,?,?)
					""";
			try(Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
				ps.setInt(1, f.getId());
				ps.setInt(2, lineaFactura.getId_producto());
				ps.setInt(3, lineaFactura.getCantidad());
				ps.setDouble(4, lineaFactura.getPrecio_unitario());
				ps.setDouble(5, lineaFactura.getImporte());
				filas = ps.executeUpdate();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		if(filas > 0) {
			return true;
		}
		return false;
	}
		
	private LineaFactura mapeo(ResultSet rs) throws SQLException{
		LineaFactura f = new LineaFactura();
		f.setId(rs.getInt("id"));
		f.setId_factura(rs.getInt("id_factura"));
		f.setId_producto(rs.getInt("id_producto"));
		f.setCantidad(rs.getInt("cantidad"));
		f.setPrecio_unitario(rs.getDouble("precio_unitario"));
		f.setImporte(rs.getDouble("importe"));
		return f;

	}

}
