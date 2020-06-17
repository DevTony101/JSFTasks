package repositories;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

import entities.Usuario;
import lombok.Cleanup;

public class UsuarioRepository implements DAORepository<Usuario> {

	private static Logger LOG = Logger.getLogger(UsuarioRepository.class);

	@Override
	public void save(Usuario obj) {
		@Cleanup // Paso 4.2
		Session session = FACTORY.openSession(); // Paso 1
		Transaction trans = session.beginTransaction(); // Paso 2
		try {
			session.save(obj); // Paso 3
			LOG.info("Usuario guardado satisfactoriamente");
		} catch (Exception e) {
			LOG.error("Error: " + e.getMessage());
		} finally {
			trans.commit(); // Paso 4.1
		}
	}

	@Override
	public void update(Usuario obj) {
		@Cleanup
		Session session = FACTORY.openSession();
		Transaction trans = session.beginTransaction();
		try {
			session.update(obj);
			LOG.info("Usuario actualizado satisfactoriamente");
		} catch (Exception e) {
			LOG.error("Error: " + e.getMessage());
		} finally {
			trans.commit();
		}
	}

	@Override
	public void delete(Usuario obj) {
		@Cleanup
		Session session = FACTORY.openSession();
		Transaction trans = session.beginTransaction();
		try {
			Optional<Usuario> opt = this.getById(obj.getId());
			if (opt.isPresent()) {
				session.delete(opt.get());
				LOG.info("Usuario eliminado satisfactoriamente");
			}
		} catch (Exception e) {
			LOG.error("Error: " + e.getMessage());
		} finally {
			trans.commit();
		}
	}

	@Override
	public Optional<Usuario> getById(Long id) {
		@Cleanup
		Session session = FACTORY.openSession();
		Transaction trans = session.beginTransaction();
		String jpql = "SELECT u FROM Usuario u WHERE u.id = :id";
		Usuario usuario = session.createQuery(jpql, Usuario.class).setParameter("id", id).getSingleResult();
		trans.commit();
		return Optional.of(usuario);
	}

	@Override
	public List<Usuario> getAll() {
		@Cleanup
		Session session = FACTORY.openSession();
		Transaction trans = session.beginTransaction();
		List<Usuario> usuarios = new LinkedList<>();
		try {
			String jpql = "SELECT u FROM Usuario u";
			Query<Usuario> query = session.createQuery(jpql, Usuario.class); // Paso 1
			usuarios.addAll(query.getResultList()); // Paso 2
			LOG.info("Retornando todos los registros de usuarios...");
		} catch (Exception e) {
			LOG.error("Error: " + e.getMessage());
		} finally {
			trans.commit();
		}

		return usuarios; // Paso 3
	}
	
	public Usuario getUsuarioByNombre(String nombre) {
		// Asumiendo que el nombre del usuario no se repita
		@Cleanup
		Session session = FACTORY.openSession();
		Transaction trans = session.beginTransaction();
		String jpql = "SELECT u FROM Usuario u WHERE u.nombre = :nombre";
		Query<Usuario> query = session.createQuery(jpql, Usuario.class).setParameter("nombre", nombre);
		Usuario usuario = query.getSingleResult();
		trans.commit();
		return usuario;
	}
}
