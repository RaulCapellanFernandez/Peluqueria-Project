package es.peluqueria.data;

import java.util.Date;

import es.peluqueria.entidades.*;
import es.peluqueria.persistence.PersistEmpleados;

public class Application {

	public static void main(String[] args) {
																		   		
		PersistEmpleados persistE = new PersistEmpleados();
		
		Empleados empleado = new Empleados();
		empleado.setDni("123156381");
		empleado.setNombre("Raul");
		empleado.setApellidos("Capellan");
		empleado.setFechaContra(new Date());
		empleado.setEmail("raulcape.7@gmail.com");
		empleado.setCalle("Astorga 16");
		empleado.setPiso("4ºA");
		empleado.setCiudad("Leon");
		empleado.setProvincia("Leon");
		empleado.setCodPostal("24009");
		
		persistE.save(empleado);
		
	}
}