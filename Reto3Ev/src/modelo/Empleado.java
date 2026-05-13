package modelo;

public class Empleado extends Persona {

	protected int id;
	protected String puesto;
	protected double salario;

	public Empleado(int id, String dni, String nombre, int id2, String puesto, double salario) {
		super(id, dni, nombre);
		id = id2;
		this.puesto = puesto;
		this.salario = salario;
	}

	public Empleado(String dni, String nombre, String puesto, double salario) {
		super(dni, nombre);
		this.puesto = puesto;
		this.salario = salario;
	}

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
