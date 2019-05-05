package es.peluqueria.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import es.peluqueria.entidades.Empleados;
import es.peluqueria.entidades.Ventas;

public class PersistVentas {
	EntityManagerFactory emf = null;
	EntityManager em = null;
	EntityTransaction tx = null;
	
	public void save(Ventas venta) {
		try{
			emf = Persistence.createEntityManagerFactory("p-peluqueria");
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			em.persist(venta);
			
			tx.commit();		
		}catch(Exception e){
			tx.rollback();
		}finally{
			em.close();
			emf.close();
		}
	}
}
