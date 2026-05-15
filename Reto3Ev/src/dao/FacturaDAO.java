package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.Factura;
import util.ConexionBD;

public class FacturaDAO implements GenericDAO<Factura> {

	@Override
	public boolean insertar(Factura objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Factura> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Factura obtenerPorId(int id) {
		String sql = """
				select id,fecha,id_cliente,id_empleado,subtotal,iva,total from factura where id = ?
				""";
		try(Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, id);
			try(ResultSet rs = ps.executeQuery()){
				if (rs.next()) {
					return mapeo(rs);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean actualizar(Factura objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Factura> obtenerPorIdCliente(int id){
		List<Factura> lista = new ArrayList<Factura>();
		String sql = """
				select id,fecha,id_cliente,id_empleado,subtotal,iva,total from factura where id_cliente = ?
				""";
		try(Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, id);
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					lista.add(mapeo(rs));
				}
			}
			return lista;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public List<Factura> obtenerPorIdEmpleado(int id){
		List<Factura> lista = new ArrayList<Factura>();
		String sql = """
				select id,fecha,id_cliente,id_empleado,subtotal,iva,total from factura where id_empleado = ?
				""";
		try(Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, id);
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					lista.add(mapeo(rs));
				}
			}
			return lista;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public List<Factura> obtenerPorMes(int mes){
		List<Factura> lista = new ArrayList<Factura>();
		String sql = """
				select id,fecha,id_cliente,id_empleado,subtotal,iva,total from factura where month(fecha) = ?
				""";
		try(Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, mes);
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					lista.add(mapeo(rs));
				}
			}
			return lista;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public List<Factura> obtenerPorFecha(LocalDate fecha){
		List<Factura> lista = new ArrayList<Factura>();
		String sql = """
				select id,fecha,id_cliente,id_empleado,subtotal,iva,total from factura where fecha = ?
				""";
		try(Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
			ps.setObject(1, fecha);
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					lista.add(mapeo(rs));
				}
			}
			return lista;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}	
	private Factura mapeo(ResultSet rs) throws SQLException{
		Factura f = new Factura();
		f.setId(rs.getInt("id"));
		f.setFecha(rs.getObject("fecha",LocalDate.class));
		f.setId_cliente(rs.getInt("id_cliente"));
		f.setId_empleado(rs.getInt("id_empleado"));
		f.setSubtotal(rs.getDouble("subtotal"));
		f.setIva(rs.getDouble("iva"));
		f.setTotal(rs.getDouble("total"));
		return f;

	}
}
