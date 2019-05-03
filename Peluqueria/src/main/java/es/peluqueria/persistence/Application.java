package es.peluqueria.persistence;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import es.peluqueria.entidades.*;

public class Application {

	public static void main(String[] args) {
																		   		
		PersistEmpleados persist = new PersistEmpleados();
		
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
		
		persist.save(empleado);
		
	}
}