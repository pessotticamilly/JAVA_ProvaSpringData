package sc.senai.br.AvaliacaoCamllyPessotti.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.Produto;
import sc.senai.br.AvaliacaoCamllyPessotti.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProdutoService {
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> findById(Long aLong) {
        return produtoRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return produtoRepository.existsById(aLong);
    }

    public <S extends Produto> S save(S entity) {
        return produtoRepository.save(entity);
    }

    public void deleteById(Long aLong) {
        produtoRepository.deleteById(aLong);
    }
}