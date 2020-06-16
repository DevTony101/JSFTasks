package services;

import java.util.List;
import java.util.Optional;

import entities.Usuario;

public interface IUsuarioService {
	
	public void save(Usuario u);
	public void update(Usuario u);
	public void delete(Usuario u);
	public Optional<Usuario> getById(Long id);
	public List<Usuario> getAll();
}
