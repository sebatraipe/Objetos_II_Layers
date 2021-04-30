package ar.unrn.tp.modelo;

public class SaludosPorEmail {

	private EnvioEmail envio;
	private RepositorioDeEmpleados repositorio;

	public SaludosPorEmail(EnvioEmail envio, RepositorioDeEmpleados repositorio) {
		this.envio = envio;
		this.repositorio = repositorio;
	}

	public void enviarSaludoDeCumpleaños() {

		for (Empleado empleado : this.repositorio.leerContenidoDelArchivo()) {
			if (empleado.cumpleAnioHoy()) {
				envio.enviarSaludo(empleado.obtenerDireccionEmail(), "Feliz Cumpleaños", "Feliz cumpleaños");
			}
		}
	}
}
