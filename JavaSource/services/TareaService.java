package services;

import entities.Tarea;
import entities.Usuario;
import repositories.TareaRepository;

public class TareaService {
	
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
		repo.save(t);
	}
}
