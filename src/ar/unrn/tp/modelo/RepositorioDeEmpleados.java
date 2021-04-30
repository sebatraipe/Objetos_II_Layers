package ar.unrn.tp.modelo;

import java.util.List;

public interface RepositorioDeEmpleados {

	void registrarEmpleado(Empleado empleado);

	List<Empleado> leerContenidoDelArchivo();

}
