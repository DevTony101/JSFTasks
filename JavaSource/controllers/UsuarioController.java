package controllers;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import lombok.Setter;

@Named
@RequestScoped
@Setter
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String mensaje;
	
	public UsuarioController() {
		this.mensaje = "Hola Mundo";
	}
	
	public String getMensaje() {
		this.mensaje += String.format(", desde %s", this.getClass().getName());
		return this.mensaje;
	}

}