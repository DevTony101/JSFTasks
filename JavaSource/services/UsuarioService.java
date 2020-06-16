package services;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import entities.Usuario;
import repositories.UsuarioRepository;

public class UsuarioService {
	
	private final UsuarioRepository repo = new UsuarioRepository();
	private static final UsuarioService INSTANCE = new UsuarioService();
	
	private UsuarioService() {
		// El constructor es privado para evitar que los usuarios
		// creen nuevas instancias
	}
	
	public static UsuarioService getInstance() {
		return INSTANCE;
	}
	
	public void save(Usuario obj) {
		if (obj != null) {
			obj.setFechaCreacion(new java.util.Date());
			obj.setVerificado(true);
		}
		repo.save(obj);
	}
	
	public void update(Usuario obj) {
		repo.update(obj);
	}
	
	public void delete(Usuario obj) {
		repo.delete(obj);
	}
	
	public Optional<Usuario> getById(Long id) {
		return repo.getById(id);
	}
	
	public List<Usuario> getAll() {
		return new LinkedList<>(repo.getAll());
	}
}
