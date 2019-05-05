package es.peluqueria.data;

import java.util.Date;
import java.util.List;

import es.peluqueria.entidades.*;
import es.peluqueria.persistence.PersistAlmacen;
import es.peluqueria.persistence.PersistEmpleados;
import es.peluqueria.persistence.PersistProducto;
import es.peluqueria.persistence.PersistVentas;

public class Application {

	public static void main(String[] args) {
		
		
		PersistAlmacen persistA = new PersistAlmacen();
		
		Almacen almacen = new Almacen();
		almacen.setNombre("H&S Limon");
		almacen.setCantidad(3);
		
		persistA.save(almacen);
		
		
		PersistEmpleados persistE = new PersistEmpleados();
	
		Empleados empleado = new Empleados();
		empleado.setDni("722255221");
		empleado.setNombre("Raul");
		empleado.setApellidos("Capellan");
		empleado.setFechaContra(new Date());
		empleado.setEmail("raulcape.7@gmail.com");
		empleado.setCalle("Astorga 16");
		empleado.setPiso("4ºA");
		empleado.setCiudad("Leon");
		empleado.setProvincia("Leon");
		empleado.setCodPostal("24009");
		
		
		//persistE.save(empleado);
		
		PersistProducto persistP = new PersistProducto();
		
		Productos producto = new Productos();
		producto.setNombre("Corte de pelo");
		producto.setPrecio(12);
		
		List<Almacen>listaAlmacen = persistA.recuperar();
		
		producto.setAlmacen(listaAlmacen.get(0));
		
		persistP.save(producto);
		
		/*List<Empleados>listaEmpleados = persistE.recuperar();
		List<Productos>listaProductos = persistP.recuperar();
		
		PersistVentas persistV  = new PersistVentas();
		
		Ventas venta = new Ventas();
		venta.setTotalVenta(124);
		venta.setFechaVenta(new Date());
		venta.setEmpleado(listaEmpleados.get(0));
		venta.setProducto(listaProductos.get(0));
		
		persistV.save(venta);*/
		
	}
}