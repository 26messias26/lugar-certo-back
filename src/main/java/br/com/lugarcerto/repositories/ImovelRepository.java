package br.com.lugarcerto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.lugarcerto.model.Imovel;
@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long>{

	@Query(value = "SELECT i FROM Imovel i WHERE i.usuario.id = :idUsu")
	List<Imovel> getImovelFromUsuario(@Param("idUsu") Long idUsu);
	
}
