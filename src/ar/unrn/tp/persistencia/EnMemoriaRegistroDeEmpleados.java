package ar.unrn.tp.persistencia;

import java.util.ArrayList;
import java.util.List;

import ar.unrn.tp.modelo.Empleado;
import ar.unrn.tp.modelo.RepositorioDeEmpleados;

public class EnMemoriaRegistroDeEmpleados implements RepositorioDeEmpleados {

	private List<Empleado> listaEmpleados = new ArrayList<>();

	@Override
	public void registrarEmpleado(Empleado empleado) {
		this.listaEmpleados.add(empleado);
	}

	@Override
	public List<Empleado> leerContenidoDelArchivo() {
		return this.listaEmpleados;
	}

}
