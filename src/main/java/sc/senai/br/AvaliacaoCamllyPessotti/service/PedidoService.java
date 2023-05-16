package sc.senai.br.AvaliacaoCamllyPessotti.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.Pedido;
import sc.senai.br.AvaliacaoCamllyPessotti.repository.PedidoRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PedidoService {
    private PedidoRepository pedidoRepository;

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> findById(Long aLong) {
        return pedidoRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return pedidoRepository.existsById(aLong);
    }

    public <S extends Pedido> S save(S entity) {
        return pedidoRepository.save(entity);
    }

    public void deleteById(Long aLong) {
        pedidoRepository.deleteById(aLong);
    }
}