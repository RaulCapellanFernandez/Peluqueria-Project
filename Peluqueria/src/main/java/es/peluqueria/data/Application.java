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
		PersistEmpleados persistE = new PersistEmpleados();
		PersistAlmacen persistA = new PersistAlmacen();
		PersistProducto persistP = new PersistProducto();
		PersistVentas persistV  = new PersistVentas();
		
		//Guardar cada clase
		Empleados empleado = new Empleados();
		empleado.setDni("71471266P");
		empleado.setContrasenia("hola");
		empleado.setNombre("Maria");
		empleado.setApellidos("Hernandez");
		empleado.setFechaContra(new Date());
		empleado.setEmail("mcapef00@estudiantes.unileon.es");
		empleado.setCalle("Universidad de Leon");
		empleado.setPiso("12");
		empleado.setCiudad("Madrid");
		empleado.setProvincia("Sanse");
		empleado.setCodPostal("24010");
		
		Almacen almacen = new Almacen();
		almacen.setNombre("Tinte");
		almacen.setCantidad(3);
		
		persistA.save(almacen);
		persistE.save(empleado);
		
	
		Productos producto = new Productos();
		producto.setNombre("Pintar el pelo");
		producto.setPrecio(24);
		
		List<Almacen>listaAlmacen = persistA.recuperar();
	//	producto.setAlmacen(listaAlmacen.get(0));
		
		persistP.save(producto);
		
		List<Productos>listaProductos = persistP.recuperar();
		List<Empleados>listaEmpleados = persistE.recuperar();
		
		Ventas venta = new Ventas();
		venta.setTotalVenta(24);
		venta.setFechaVenta(new Date());
		venta.setEmpleado(listaEmpleados.get(0));
		venta.setProducto(listaProductos.get(0));
		
		persistV.save(venta);
		
		
		//Actualizar cada clase
		empleado.setNombre("Teresa");
		
		almacen.setNombre("Tinte rojo");
		
		producto.setNombre("Cortar el pelo");
		
		venta.setTotalVenta(999);
		
		persistE.update(empleado);
		persistA.update(almacen);
		persistP.update(producto);
		persistV.update(venta);
		
		
		//Borrar cada clase
		persistV.remove(venta);
		persistP.remove(producto);
		persistE.remove(empleado);
		persistA.remove(almacen);
	}
}