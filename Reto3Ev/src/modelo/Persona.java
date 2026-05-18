package modelo;

import java.io.Serializable;

public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	protected int id;
	protected String dni;
	protected String nombre;

	/**
	 * Los parametros de Persona seran el id el dni y el nombre de la persona, este
	 * consttructor easta completo
	 * 
	 * @param id     El id de la persona
	 * @param dni    El dni de la persona
	 * @param nombre El nombre de la persona
	 */
	public Persona(int id, String dni, String nombre) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
	}

	/**
	 * Este constructor no contendra el id de la persona pero si el resto de campos
	 * 
	 * @param dni
	 * @param nombre
	 */
	public Persona(String dni, String nombre) {
		this(0, dni, nombre);
	}

	/**
	 * Este constructor va vacio
	 */
	public Persona() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", dni=" + dni + ", nombre=" + nombre + "]";
	}

}
