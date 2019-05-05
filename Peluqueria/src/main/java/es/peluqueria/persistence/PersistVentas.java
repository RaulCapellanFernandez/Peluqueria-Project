package es.peluqueria.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
	
	public void remove(Ventas venta) {
		try{
			emf = Persistence.createEntityManagerFactory("p-peluqueria");
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Ventas borrar = em.find(Ventas.class, venta.getIdVenta());
			em.remove(borrar);
			
			tx.commit();		
		}catch(Exception e){
			tx.rollback();
		}finally{
			em.close();
			emf.close();
		}
	}
	
	public void update(Ventas venta) {
		try{
			emf = Persistence.createEntityManagerFactory("p-peluqueria");
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Ventas actualizar = em.find(Ventas.class, venta.getIdVenta());
			
			actualizar.setFechaVenta(venta.getFechaVenta());
			actualizar.setTotalVenta(venta.getTotalVenta());
			actualizar.setEmpleado(venta.getEmpleado());
			actualizar.setProducto(venta.getProducto());
	
			tx.commit();		
		}catch(Exception e){
			tx.rollback();
		}finally{
			em.close();
			emf.close();
		}
	}
	
	public List<Ventas> recuperar() {
		
		emf = Persistence.createEntityManagerFactory("p-peluqueria");
		em = emf.createEntityManager();
		List<Ventas> listaVentas = (List<Ventas>) em.createQuery("FROM Ventas").getResultList();
		return listaVentas;
	}
}
