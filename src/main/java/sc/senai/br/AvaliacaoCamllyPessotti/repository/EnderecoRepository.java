package sc.senai.br.AvaliacaoCamllyPessotti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}