package br.com.lugarcerto.services;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lugarcerto.model.Login;
import br.com.lugarcerto.model.Usuario;
import br.com.lugarcerto.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository; 
	
//	BUSCA TODOS OS USUARIOS 
	public List<Usuario> getUsuarios(){
		return usuarioRepository.findAll();
	}
	
//	BUSCA USUARIO POR ID
	public Usuario getUsuarioPorId(Long id) {
		return this.usuarioRepository.findById(id).orElse(null);
	}
	
	
//	ATUALIZA E INSERE O USUARIO
	@Transactional
	public Usuario inserirOuAtualizar(Usuario reserva) {
		Usuario reservaInserida = this.usuarioRepository.save(reserva);
		return reservaInserida;
	}
	
//	DELETA POR ID
	public void apagar(Long id) {
		this.usuarioRepository.deleteById(id);
	}

	public Usuario autenticarUsuario(Login login) {
		Usuario usuario = this.usuarioRepository.findByEmailAndSenha(login.getEmail(), login.getSenha());
		return usuario;
	}
	
}
