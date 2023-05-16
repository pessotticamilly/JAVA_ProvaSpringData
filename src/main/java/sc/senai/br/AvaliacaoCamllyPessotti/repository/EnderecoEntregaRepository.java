package sc.senai.br.AvaliacaoCamllyPessotti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.EnderecoEntrega;

@Repository
public interface EnderecoEntregaRepository extends JpaRepository<EnderecoEntrega, Long> {

}