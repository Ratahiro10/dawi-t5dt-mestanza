package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {

	public static void main(String[] args) {
		// similar a DAOFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		// similar a crear el objeto DAOFactory
		EntityManager em = fabrica.createEntityManager();
		
		// proceso que consiste en registrar un nuevo usuario
		Usuario u = new Usuario();
		u.setCodigo(123);
		u.setNombre("Ramel");
		u.setApellido("Mestanza");
		u.setUsuario("rmestanza@gmail.com");
		u.setClave("1234");
		u.setFnacim("2021/12/10");
		u.setTipo(1);
		u.setEstado(1);
		
		em.getTransaction().begin();
		
		em.persist(u);  // <---- automaticamente registra
		
		em.getTransaction().commit();
		
		em.close();
	}
}
