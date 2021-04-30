package ar.unrn.tp.modelo;

import java.time.LocalDate;

public class Empleado {

	private String apellido;
	private String nombre;
	private LocalDate fechaNacimiento;
	private String direccionEmail;

	public Empleado(String apellido, String nombre, LocalDate fechaNacimiento, String direccionEmail) {
		this.apellido = apellido;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.direccionEmail = direccionEmail;
	}

	public String obtenerApellido() {
		return this.apellido;
	}

	public String obtenerNombre() {
		return this.nombre;
	}

	public LocalDate obtenerFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public String obtenerDireccionEmail() {
		return this.direccionEmail;
	}

	@Override
	public String toString() {
		return "Empleado [apellido=" + apellido + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento
				+ ", direccionEmail=" + direccionEmail + "]";
	}

	public boolean cumpleAnioHoy() {
		LocalDate fecha = LocalDate.now();
		if (fechaDiaEsIgul(fecha.getDayOfMonth()) && fechaMesEsIgual(fecha.getMonthValue()))
			return true;
		return false;
	}

	private boolean fechaDiaEsIgul(int dayOfMonth) {
		if (this.fechaNacimiento.getDayOfMonth() == dayOfMonth)
			return true;
		return false;
	}

	private boolean fechaMesEsIgual(int monthValue) {
		if (this.fechaNacimiento.getMonthValue() == monthValue)
			return true;
		return false;
	}
}