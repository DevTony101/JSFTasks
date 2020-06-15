package repositories;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public interface DAORepository<T> {

	final static StandardServiceRegistry SSR = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
			.build();
	final static Metadata META = new MetadataSources(SSR).getMetadataBuilder().build();
	final static SessionFactory FACTORY = META.getSessionFactoryBuilder().build();

	void save(T obj);

	void update(T obj);

	void delete(T obj);

	Optional<T> getById(Long id);

	List<T> getAll();
}
