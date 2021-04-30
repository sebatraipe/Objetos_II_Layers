package ar.unrn.tp.main;

import ar.unrn.tp.modelo.RepositorioDeEmpleados;
import ar.unrn.tp.modelo.SaludosPorEmail;
import ar.unrn.tp.persistencia.EnDiscoRegistroDeEmpleados;
import ar.unrn.tp.servicio.email.EnviarEmail;

public class Main {

	public static void main(String[] args) {

		String direccion = "/home/sebastian/archivo-empleados";
		RepositorioDeEmpleados repositorioEmpleados = new EnDiscoRegistroDeEmpleados(direccion);

		SaludosPorEmail saludosPorEmail = new SaludosPorEmail(new EnviarEmail(), repositorioEmpleados);

		saludosPorEmail.enviarSaludoDeCumpleaños();

	}
}
