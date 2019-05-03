package es.peluqueria.persistence;

import java.util.Date;

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

}
