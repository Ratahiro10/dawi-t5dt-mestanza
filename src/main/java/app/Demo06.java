package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo06 {

	public static void main(String[] args) {
		// similar a DAOFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		// similar a crear el objeto DAOFactory
		EntityManager em = fabrica.createEntityManager();
		
		// proceso que consulta los datos de un usuario
		Usuario u = em.find(Usuario.class, 300);		
		
		if(u == null) {
			System.out.println("Usuario NO existe");
			
			Usuario u1 = new Usuario();
			u1.setCodigo(300);
			u1.setNombre("Antonio");
			u1.setApellido("Salazar");
			u1.setUsuario("antosala@gmail.com");
			u1.setClave("6352");
			u1.setFnacim("1995/08/10");
			u1.setTipo(1);
			u1.setEstado(1);
			
			em.getTransaction().begin();
			
			em.merge(u1);  // <--- actualiza un dato si existe el código // no existe : registra un nuevo dato
			
			
			em.getTransaction().commit();
			System.out.println("Usuario Actualizado");
			
		} else {
			System.out.println("Usuario Existe !!!\n" + u);	
			em.getTransaction().begin();
		}
		
		em.close();
	}
}
