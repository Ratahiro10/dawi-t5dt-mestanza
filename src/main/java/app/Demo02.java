package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {

	public static void main(String[] args) {
		// similar a DAOFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		// similar a crear el objeto DAOFactory
		EntityManager em = fabrica.createEntityManager();
		
		// proceso que consiste en actualizar un usuario
		Usuario u = new Usuario();
		u.setCodigo(200);
		u.setNombre("Ramel");
		u.setApellido("Mestanza");
		u.setUsuario("rarengifo@gmail.com");
		u.setClave("5678");
		u.setFnacim("1991/11/12");
		u.setTipo(1);
		u.setEstado(1);
		
		em.getTransaction().begin();
		
		em.merge(u);  // <--- actualiza un dato si existe el código // no existe : registra un nuevo dato
		
		em.getTransaction().commit();
		System.out.println("Usuario actualizado");
		
		em.close();
	}
}
