package es.peluqueria.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import es.peluqueria.entidades.Empleados;

public class PersistEmpleados {
	
	EntityManagerFactory emf = null;
	EntityManager em = null;
	EntityTransaction tx = null;
	
	public void save(Empleados empleado) {
		try{
			emf = Persistence.createEntityManagerFactory("p-peluqueria");
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			em.persist(empleado);
			
			tx.commit();		
		}catch(Exception e){
			tx.rollback();
		}finally{
			em.close();
			emf.close();
		}
	}
	
	public void remove(Empleados empleado) {
		try{
			emf = Persistence.createEntityManagerFactory("p-peluqueria");
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Empleados borrar = em.find(Empleados.class, empleado.getDni());
			em.remove(borrar);
			
			tx.commit();		
		}catch(Exception e){
			tx.rollback();
		}finally{
			em.close();
			emf.close();
		}
	}
	
	public void update(Empleados empleado) {
		try{
			emf = Persistence.createEntityManagerFactory("p-peluqueria");
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Empleados actualizar = em.find(Empleados.class, empleado.getDni());
			
			actualizar.setNombre(empleado.getNombre());
			actualizar.setApellidos(empleado.getApellidos());
			actualizar.setFechaContra(empleado.getFechaContra());
			actualizar.setEmail(empleado.getEmail());
			actualizar.setCalle(empleado.getEmail());
			actualizar.setPiso(empleado.getPiso());
			actualizar.setCiudad(empleado.getCiudad());
			actualizar.setProvincia(empleado.getProvincia());
			actualizar.setCodPostal(empleado.getCodPostal());
			
			tx.commit();		
		}catch(Exception e){
			tx.rollback();
		}finally{
			em.close();
			emf.close();
		}
	}
}
