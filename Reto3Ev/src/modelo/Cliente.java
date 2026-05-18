package modelo;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	protected int id;
	protected String direccion;

	/**
	 * Constructor con todos los parametros de de persona y con los de cliente
	 * 
	 * @param id        El id de la persona (heredado)
	 * @param dni       El dni de la persona (heredado)
	 * @param nombre    El nombre de la persona (heredado)
	 * @param id2       El id del cliente (igual al id de la persona)
	 * @param direccion La dirección del cliente
	 */
	public Cliente(int id, String dni, String nombre, int id2, String direccion) {
		super(id, dni, nombre);
		id = id2;
		this.direccion = direccion;
	}

	/**
	 * Constructor con dni y nombre heredados de persona y con dirección de cliente, y sin ids
	 * 
	 * @param dni       Heredado de persona
	 * @param nombre    Heredadp de persona
	 * @param direccion Campo de cliente
	 */
	public Cliente(String dni, String nombre, String direccion) {
		super(dni, nombre);
		this.direccion = direccion;
	}

	/**
	 * Este constructor esta vacio
	 */
	public Cliente() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", direccion=" + direccion + "]";
	}

}
