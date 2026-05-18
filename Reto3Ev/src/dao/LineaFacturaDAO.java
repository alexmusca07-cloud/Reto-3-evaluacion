package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.LineaFactura;
import util.ConexionBD;

public class LineaFacturaDAO implements GenericDAO<LineaFactura> {

	@Override
	public boolean insertar(LineaFactura objeto) {
		String sql = """
				insert lineafactura (id_factura,id_producto,cantidad,precio_unitario,importe)
				values(?,?,?,?,?,?)
				""";
		try(Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, objeto.getId_factura());
			ps.setInt(3, objeto.getId_producto());
			ps.setInt(4, objeto.getCantidad());
			ps.setDouble(5, objeto.getPrecio_unitario());
			ps.setDouble(6, objeto.getImporte());
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
		// TODO Auto-generated method stub
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
				if (rs.next()) {
					lista.add(mapeo(rs));
				}
			}
			return lista;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public boolean insertarPorIdFactura(int id_factura_original, int id_factura_nueva) {
		String sql = """
				insert lineafactura (id_factura,id_producto,cantidad,precio_unitario,importe)
				select ?,id_producto,cantidad,precio_unitario,importe from lineafactura where id_factura = ?
				""";
		try(Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, id_factura_nueva);
			ps.setInt(2, id_factura_original);
			int num = ps.executeUpdate();
			if(num > 0) {
				return true;
			} 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	private LineaFactura mapeo(ResultSet rs) throws SQLException{
		LineaFactura f = new LineaFactura();
		f.setId(rs.getInt("id"));
		f.setId_factura(rs.getInt("id_factura"));
		f.setId_factura(rs.getInt("id_producto"));
		f.setCantidad(rs.getInt("cantidad"));
		f.setPrecio_unitario(rs.getDouble("precio_unitario"));
		f.setImporte(rs.getDouble("importe"));
		return f;

	}

}
