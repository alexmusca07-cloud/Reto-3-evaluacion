package modelo;

import java.io.Serializable;

public class Empleado extends Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	protected int id;
	protected String puesto;
	protected double salario;

	/**
	 * Constructor con todos los parametros heredados de persona y los de empleado
	 * 
	 * @param id      El id de la persona (heredado)
	 * @param dni     El dni de la persona (heredado)
	 * @param nombre  El nombre de la persona (heredado)
	 * @param id2     El id del emleado sera igual al de persona
	 * @param puesto  El puesto en el que trabaja el empleado
	 * @param salario El salario del empleado
	 */
	public Empleado(int id, String dni, String nombre, int id2, String puesto, double salario) {
		super(id, dni, nombre);
		id = id2;
		this.puesto = puesto;
		this.salario = salario;
	}

	/**
	 * Constructor con dni y nombre heredados de persona y los campos propios de
	 * empleado sin ids
	 * 
	 * @param dni     Heredado de persona
	 * @param nombre  Heredadp de persona
	 * @param puesto  Campo de emlpeado
	 * @param salario Campo de empleado
	 */
	public Empleado(String dni, String nombre, String puesto, double salario) {
		super(dni, nombre);
		this.puesto = puesto;
		this.salario = salario;
	}

	/**
	 * Este constructor esta vacio
	 */
	public Empleado() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", puesto=" + puesto + ", salario=" + salario + "]";
	}

}
