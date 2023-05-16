package sc.senai.br.AvaliacaoCamllyPessotti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.CartaoCredito;

@Repository
public interface CartaoCreditoRepository extends JpaRepository<CartaoCredito, Long> {

}