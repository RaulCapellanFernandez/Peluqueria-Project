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
																		   		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try{
			emf = Persistence.createEntityManagerFactory("infinite-finances");
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Empleados empleado = new Empleados();
			empleado.setDni("123156789");
			empleado.setNombre("Raul");
			empleado.setApellidos("Capellan");
			
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