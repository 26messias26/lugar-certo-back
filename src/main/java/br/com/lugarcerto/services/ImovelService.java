package br.com.lugarcerto.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lugarcerto.model.Imovel;
import br.com.lugarcerto.model.Usuario;
import br.com.lugarcerto.repositories.ImovelRepository;
import br.com.lugarcerto.repositories.UsuarioRepository;

@Service
public class ImovelService {

	@Autowired
	private ImovelRepository ImovelRepository; 
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
//	LISTA TODOS OS IMOVEIS
	public List<Imovel> getImovel(){
		return ImovelRepository.findAll();
	}
	
//	BUSCA UM IMOVEL POR ID
	public Imovel getImovelPorId(Long id) {
		return this.ImovelRepository.findById(id).orElse(null);
	}
	
//	INSERE E ATUALISA O IMOVEL
	
	@Transactional
	public Imovel inserirOuAtualizar(Imovel imovel, Long id) {
		Usuario usuario = usuarioRepository.findById(id).get();
		
		if(usuario != null) {
			imovel.setUsuario(usuario);
			Imovel imovelInserido = this.ImovelRepository.save(imovel);
		}
		
		return imovel;
	}
	
//	APAGA POR ID
	public void apagar(Long id) {
		this.ImovelRepository.deleteById(id);
	}

	public List<Imovel> getImovelUsuario(Long idUsu) {
		
		return this.ImovelRepository.getImovelFromUsuario(idUsu);
	}
	
}
