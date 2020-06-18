package services;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import entities.Tarea;
import entities.Usuario;
import repositories.TareaRepository;

@ApplicationScoped
public class TareaService implements ITareaService {
	
	@Inject
	private UsuarioService uService;
	
	@Inject
	private TareaRepository repo;
	
	public void save(Tarea t, Usuario u) {
		if (t != null && u != null) {
			t.setUsuario(u);
			u.getTareas().add(t);
			uService.update(u);
		}
		t.setCompletada(false);
		t.setFechaFinal(new java.util.Date());
		repo.save(t);
	}
	
	public void update(Tarea t) {
		repo.update(t);
	}
	
	public void delete(Tarea t) {
		repo.delete(t);
	}
	
	public Optional<Tarea> getById(Long id) {
		return repo.getById(id);
	}
	
	public List<Tarea> getAll() {
		return new LinkedList<>(repo.getAll());
	}
}
