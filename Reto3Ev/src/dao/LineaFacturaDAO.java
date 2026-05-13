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
		// TODO Auto-generated method stub
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
