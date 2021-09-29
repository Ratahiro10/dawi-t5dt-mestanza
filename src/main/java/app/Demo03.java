package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {

	public static void main(String[] args) {
		// similar a DAOFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		// similar a crear el objeto DAOFactory
		EntityManager em = fabrica.createEntityManager();
		
		// proceso que consiste en actualizar un usuario
		Usuario u = new Usuario();
		u.setCodigo(123);
		u.setNombre("Yahiro");
		u.setApellido("Rengifo");
		u.setUsuario("yamestanza@gmail.com");
		u.setClave("1234");
		u.setFnacim("1993/12/10");
		u.setTipo(1);
		u.setEstado(1);
		
		em.getTransaction().begin();
		
		em.remove(u);  // <--- eliminar
		
		em.getTransaction().commit();
		System.out.println("Usuario eliminado");
		
		em.close();
	}
}
