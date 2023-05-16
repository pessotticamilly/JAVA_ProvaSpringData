package sc.senai.br.AvaliacaoCamllyPessotti.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.CartaoCredito;
import sc.senai.br.AvaliacaoCamllyPessotti.repository.CartaoCreditoRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartaoCreditoService {
    private CartaoCreditoRepository cartaoCreditoRepository;

    public List<CartaoCredito> findAll() {
        return cartaoCreditoRepository.findAll();
    }

    public Optional<CartaoCredito> findById(Long aLong) {
        return cartaoCreditoRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return cartaoCreditoRepository.existsById(aLong);
    }

    public <S extends CartaoCredito> S save(S entity) {
        return cartaoCreditoRepository.save(entity);
    }

    public void deleteById(Long aLong) {
        cartaoCreditoRepository.deleteById(aLong);
    }
}