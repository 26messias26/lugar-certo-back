package br.com.lugarcerto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lugarcerto.model.Login;
import br.com.lugarcerto.model.Usuario;
import br.com.lugarcerto.services.UsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public List<Usuario> getReservas() {
		return this.usuarioService.getUsuarios();
	}
	
	@GetMapping("/{id}")
	public Usuario getUsuarioPorId(@PathVariable("id") Long idUsuario) {
		return this.usuarioService.getUsuarioPorId(idUsuario);
	}
	
	@PostMapping
	public Usuario inserirUsuario(@RequestBody Usuario usuario) {
		return this.usuarioService.inserirOuAtualizar(usuario);
	}
	
	@PostMapping("/login")
	public Usuario logarUsuario(@RequestBody Login login) {
		return this.usuarioService.autenticarUsuario(login);
	}
	
	@PutMapping("/{id}")
	public Usuario getUsuarioPorId(@RequestBody Usuario usuario) {
		return this.usuarioService.inserirOuAtualizar(usuario);
	}
	
	@DeleteMapping("/{id}")
	public void apagarUsuario(@PathVariable("id") Long idUsuario) {
		this.usuarioService.apagar(idUsuario);
	}
	
}
