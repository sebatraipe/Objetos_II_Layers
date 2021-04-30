package ar.unrn.tp.persistencia;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.unrn.tp.modelo.Empleado;
import ar.unrn.tp.modelo.RepositorioDeEmpleados;

public class EnDiscoRegistroDeEmpleados implements RepositorioDeEmpleados {

	private String direccion;

	public EnDiscoRegistroDeEmpleados(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public void registrarEmpleado(Empleado empleado) {
		String datosEmpleado = empleado.obtenerApellido() + ", " + empleado.obtenerNombre() + ", "
				+ empleado.obtenerFechaNacimiento().toString() + ", " + empleado.obtenerDireccionEmail() + "\n";
		try {
			Files.write(Paths.get(direccion), datosEmpleado.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException("No se pudo persistir...", e);
		}
	}

	@Override
	public List<Empleado> leerContenidoDelArchivo() {
		List<Empleado> listaEmpleados = new ArrayList<>();
		try {
			for (String empleado : Files.readAllLines(Paths.get(direccion))) {
				listaEmpleados.add(construirEmpleado(empleado));
			}
		} catch (IOException e) {
			throw new RuntimeException("No se puede leer el archivo...", e);
		}
		return listaEmpleados;
	}

	private Empleado construirEmpleado(String lineaRegistro) {
		String[] parts = lineaRegistro.split(",");
		Empleado empleado = new Empleado(parts[0], parts[1], construirFecha(parts[2]), parts[3]);
		return empleado;
	}

	private LocalDate construirFecha(String fecha) {
		String[] parts = fecha.split("-");
		LocalDate fechaConstruida = LocalDate.of(Integer.valueOf(parts[0]), Integer.valueOf(parts[1]),
				Integer.valueOf(parts[2]));
		return fechaConstruida;
	}
}