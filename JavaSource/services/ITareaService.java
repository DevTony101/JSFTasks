package services;

import java.util.List;
import java.util.Optional;

import entities.Tarea;
import entities.Usuario;

public interface ITareaService {

	public void save(Tarea t, Usuario u);
	public void update(Tarea t);
	public void delete(Tarea t);
	public Optional<Tarea> getById(Long id);
	public List<Tarea> getAll();
}
