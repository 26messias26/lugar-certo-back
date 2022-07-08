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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.lugarcerto.model.Imovel;
import br.com.lugarcerto.services.ImovelService;


@RestController
@RequestMapping("/imoveis")
public class ImovelController {

	@Autowired
	private ImovelService imovelService;
	
	@GetMapping
	public List<Imovel> getImoveis() {
//		return "Teste get";
		return this.imovelService.getImovel();
	}
	
	@GetMapping("/{id}")
	public Imovel getImovelPorId(@PathVariable("id") Long idImovel) {
		return this.imovelService.getImovelPorId(idImovel);
	}
	
	
//	Cadastra um imovel relacionando com um tederminado usuario (id)
	@PostMapping("/{id}")
	public Imovel inserirImovel(@PathVariable Long id, @RequestBody Imovel imovel) {
		return this.imovelService.inserirOuAtualizar(imovel,id);
	}
	
//	Retorna os imoveis de um determinado usuario
	@GetMapping("/usuario/{id}")
	public List<Imovel> getImovelUsu(@PathVariable("id") Long idUsu) {
		return this.imovelService.getImovelUsuario(idUsu);
	}
	
	@PutMapping("/{id}")
	public Imovel getImovelPorId(@PathVariable("id") Long id ,@RequestBody Imovel imovel) {
		return this.imovelService.inserirOuAtualizar(imovel,id);
	}
	
	@DeleteMapping("/{id}")
	public void apagarImovel(@PathVariable("id") Long idImovel) {
		this.imovelService.apagar(idImovel);
	}
	
}
