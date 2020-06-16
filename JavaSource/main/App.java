package main;

import entities.Tarea;
import entities.Usuario;
import services.TareaService;
import services.UsuarioService;

public class App {
	public static void main(String... args) {
		UsuarioService uService = UsuarioService.getInstance();
		TareaService tService = TareaService.getInstance();
		
		Usuario u = new Usuario();
		u.setNombre("Margarita");
		u.setApellido("Robles");
		u.setNombreUsuario("margarita_32");
		u.setStatus("Soltera");
		uService.save(u);
		
		Tarea t = new Tarea();
		t.setTitulo("Construir aplicacion JSF");
		t.setCompletada(false);
		t.setFechaFinal(new java.util.Date());
		tService.save(t, u);
	}
}
