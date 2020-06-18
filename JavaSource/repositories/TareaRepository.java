package repositories;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

import entities.Tarea;
import lombok.Cleanup;

@ApplicationScoped
public class TareaRepository implements DAORepository<Tarea> {

	private static Logger LOG = Logger.getLogger(TareaRepository.class);

	@Override
	public void save(Tarea obj) {
		@Cleanup
		Session session = FACTORY.openSession();
		Transaction trans = session.beginTransaction();
		try {
			session.save(obj);
			LOG.info("Tarea guardada satisfactoriamente");
		} catch (Exception e) {
			LOG.error("Error: " + e.getMessage());
		} finally {
			trans.commit();
		}
	}

	@Override
	public void update(Tarea obj) {
		@Cleanup
		Session session = FACTORY.openSession();
		Transaction trans = session.beginTransaction();
		try {
			session.update(obj);
			LOG.info("Tarea guardada satisfactoriamente");
		} catch (Exception e) {
			LOG.error("Error: " + e.getMessage());
		} finally {
			trans.commit();
		}
	}

	@Override
	public void delete(Tarea obj) {
		@Cleanup
		Session session = FACTORY.openSession();
		Transaction trans = session.beginTransaction();
		try {
			Optional<Tarea> opt = this.getById(obj.getId());
			if (opt.isPresent()) {
				session.delete(opt.get());
				LOG.info("Tarea eliminada satisfactoriamente");
			}
		} catch (Exception e) {
			LOG.error("Error: " + e.getMessage());
		} finally {
			trans.commit();
		}
	}

	@Override
	public Optional<Tarea> getById(Long id) {
		@Cleanup
		Session session = FACTORY.openSession();
		Transaction trans = session.beginTransaction();
		String jpql = "SELECT t FROM Tarea t WHERE t.id = :id";
		Tarea tarea = session.createQuery(jpql, Tarea.class).setParameter("id", id).getSingleResult();
		trans.commit();
		return Optional.of(tarea);
	}

	@Override
	public List<Tarea> getAll() {
		@Cleanup
		Session session = FACTORY.openSession();
		Transaction trans = session.beginTransaction();
		List<Tarea> tareas = new LinkedList<>();
		try {
			String jpql = "SELECT t FROM Tarea t";
			Query<Tarea> query = session.createQuery(jpql, Tarea.class);
			tareas.addAll(query.getResultList());
			LOG.info("Retornando todos los registros de tareas...");
		} catch (Exception e) {
			LOG.error("Error: " + e.getMessage());
		} finally {
			trans.commit();
		}

		return tareas;
	}

}
