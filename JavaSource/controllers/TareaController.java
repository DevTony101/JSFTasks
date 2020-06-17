package controllers;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.jboss.logging.Logger;

import entities.Tarea;
import entities.Usuario;
import lombok.Getter;
import lombok.Setter;
import services.TareaService;
import services.UsuarioService;

@Named
@RequestScoped
@Setter
@Getter
public class TareaController implements Serializable {

	private static final long serialVersionUID = 1L;
	private static Logger LOG = Logger.getLogger(TareaController.class);
	
	private UsuarioService uService = UsuarioService.getInstance();
	private TareaService tService = TareaService.getInstance();
	private Tarea tarea = new Tarea();
	
	// Variable auxiliar para el nombre del usuario
	private String usuario;

	public void guardarTarea() {
		LOG.info(String.format("Titulo de la Tarea: %s", this.tarea.getTitulo()));
		LOG.info(String.format("Descripcion de la Tarea: %s", this.tarea.getDescripcion()));
		LOG.info(String.format("Dueño de la Tarea: %s", this.usuario));
		Usuario usuario = uService.getByNombre(this.usuario.trim());
		tService.save(this.tarea, usuario);
		this.usuario = "";
		this.tarea = new Tarea();
	}
}
