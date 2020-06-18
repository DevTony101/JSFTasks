package services;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import entities.Usuario;
import repositories.UsuarioRepository;

@ApplicationScoped
public class UsuarioService implements IUsuarioService {
	
	@Inject
	private UsuarioRepository repo;
	
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
	
	public Usuario getByNombre(String nombre) {
		return repo.getUsuarioByNombre(nombre);
	}
	
	public Optional<Usuario> getById(Long id) {
		return repo.getById(id);
	}
	
	public List<Usuario> getAll() {
		return new LinkedList<>(repo.getAll());
	}
}
