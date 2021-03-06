package ar.unrn.tp.modelo;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import ar.unrn.tp.persistencia.EnMemoriaRegistroDeEmpleados;
import ar.unrn.tp.servicio.email.EnviarEmailTest;

public class EmpleadoTest {

	@Test
	public void verificarEmpleadosCumpleaniosHoy() {

		RepositorioDeEmpleados repositorioEmpleados = new EnMemoriaRegistroDeEmpleados();

		Empleado empleadoSeba = new Empleado("Sebastián", "Traipe", LocalDate.now(), "traipesebastian@gmail.com");

		Empleado empleadoHugo = new Empleado("Hugo", "Traipe", LocalDate.of(1997, 8, 31), "htraipe@gmail.com");

		repositorioEmpleados.registrarEmpleado(empleadoSeba);

		repositorioEmpleados.registrarEmpleado(empleadoHugo);

		EnviarEmailTest envioEmailTest = new EnviarEmailTest();

		SaludosPorEmail saludo = new SaludosPorEmail(envioEmailTest, repositorioEmpleados);

		saludo.enviarSaludoDeCumpleaños();

		boolean emailSeba = envioEmailTest.envioCorrectoDeEmail("traipesebastian@gmail.com");
		boolean emailHugo = envioEmailTest.envioCorrectoDeEmail("htraipe@gmail.com");

		Assert.assertTrue(emailSeba); /* Verificamos que el email se haya enviado correctamente */
		Assert.assertFalse(emailHugo);/* Verificamos que el email no se haya enviadoR */
	}
}