package sc.senai.br.AvaliacaoCamllyPessotti.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.ProdutoPedido;
import sc.senai.br.AvaliacaoCamllyPessotti.repository.ProdutoPedidoRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProdutoPedidoService {
    private ProdutoPedidoRepository produtoPedidoRepository;

    public List<ProdutoPedido> findAll() {
        return produtoPedidoRepository.findAll();
    }

    public Optional<ProdutoPedido> findById(Long aLong) {
        return produtoPedidoRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return produtoPedidoRepository.existsById(aLong);
    }

    public <S extends ProdutoPedido> S save(S entity) {
        return produtoPedidoRepository.save(entity);
    }

    public void deleteById(Long aLong) {
        produtoPedidoRepository.deleteById(aLong);
    }
}