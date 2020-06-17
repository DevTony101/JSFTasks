package controllers;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.jboss.logging.Logger;

import entities.Usuario;
import lombok.Getter;
import lombok.Setter;
import services.UsuarioService;

@Named
@RequestScoped
@Getter
@Setter
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;
	private static Logger LOG = Logger.getLogger(UsuarioController.class);
	
	private UsuarioService uService = UsuarioService.getInstance();
	private Usuario usuario = new Usuario();
	
	public void guardarUsuario() {
		LOG.info(String.format("Nombre: %s", this.usuario.getNombre()));
		LOG.info(String.format("Apellido: %s", this.usuario.getApellido()));
		LOG.info(String.format("Status Civil: %s", this.usuario.getStatus()));
		LOG.info(String.format("Nombre de Usuario: %s", this.usuario.getNombreUsuario()));
		uService.save(this.usuario);
		this.usuario = new Usuario();
	}
}
