package services;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import entities.Tarea;
import entities.Usuario;
import repositories.TareaRepository;

public class TareaService implements ITareaService {
	
	private final TareaRepository repo = new TareaRepository();
	private final UsuarioService uService = UsuarioService.getInstance();
	private static final TareaService INSTANCE = new TareaService();
	
	private TareaService() {
		// El constructor es privado para evitar que los usuarios
		// creen nuevas instancias
	}
	
	public static TareaService getInstance() {
		return INSTANCE;
	}
	
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
