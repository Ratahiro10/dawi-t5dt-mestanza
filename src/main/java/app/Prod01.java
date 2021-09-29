package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;

public class Prod01 {
	public static void main(String[] args) {
		// similar a DAOFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		// similar a crear el objeto DAOFactory
		EntityManager em = fabrica.createEntityManager();
		
		// proceso que consiste en registrar un nuevo usuario
		Producto p = new Producto();
		p.setIdprod("P0050");
		p.setDescripcion("Prueba 50");
		p.setIdcategoria(1);
		p.setEstado(1);
		p.setStock(80);
		p.setPrecio(1.99);
		
		
		em.getTransaction().begin();
		
		em.persist(p);  // <---- automaticamente registra
		
		em.getTransaction().commit();
		
		em.close();
	}
}
