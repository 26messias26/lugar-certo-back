package br.com.lugarcerto.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lugarcerto.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
//	pode ser criado metodos de busca personalizados

	
	public List<Usuario> findByIdAndNome(long id, String nome);

	public Usuario findByEmailAndSenha(String email, String senha);
}
