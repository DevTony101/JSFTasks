package main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Usuario;
import repositories.DAORepository;

public class App {

	public static void main(String[] args) {
		Session session = DAORepository.FACTORY.openSession();
		Transaction t = session.beginTransaction();

		Usuario u = new Usuario();
		u.setNombre("Tony");
		u.setApellido("Manjarres");
		u.setNombreUsuario("devtony");
		u.setVerificado(true);
		u.setStatus("Soltero");
		u.setFechaCreacion(new java.util.Date());

		session.save(u);
		t.commit();
		DAORepository.FACTORY.close();
		session.close();
	}
}
