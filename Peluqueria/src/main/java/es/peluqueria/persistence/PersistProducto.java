package es.peluqueria.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import es.peluqueria.entidades.Productos;

public class PersistProducto {
	EntityManagerFactory emf = null;
	EntityManager em = null;
	EntityTransaction tx = null;
	
	public void save(Productos producto) {
		try{
			emf = Persistence.createEntityManagerFactory("p-peluqueria");
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			em.persist(producto);
			
			tx.commit();		
		}catch(Exception e){
			tx.rollback();
		}finally{
			em.close();
			emf.close();
		}
	}

	public void remove(Productos producto) {
		try{
			emf = Persistence.createEntityManagerFactory("p-peluqueria");
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Productos borrar = em.find(Productos.class, producto.getIdProd());
			em.remove(borrar);
			
			tx.commit();		
		}catch(Exception e){
			tx.rollback();
		}finally{
			em.close();
			emf.close();
		}
	}
	
	public void update(Productos producto) {
		try{
			emf = Persistence.createEntityManagerFactory("p-peluqueria");
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Productos actualizar = em.find(Productos.class, producto.getIdProd());
			
			actualizar.setNombre(producto.getNombre());
			actualizar.setPrecio(producto.getPrecio());
			actualizar.setAlmacen(producto.getAlmacen());
			
			tx.commit();		
		}catch(Exception e){
			tx.rollback();
		}finally{
			em.close();
			emf.close();
		}
	}
	
	public List<Productos> recuperar() {
		
		emf = Persistence.createEntityManagerFactory("p-peluqueria");
		em = emf.createEntityManager();
		List<Productos> listaProductos = (List<Productos>) em.createQuery("FROM Productos").getResultList();
		return listaProductos;
	}
}
