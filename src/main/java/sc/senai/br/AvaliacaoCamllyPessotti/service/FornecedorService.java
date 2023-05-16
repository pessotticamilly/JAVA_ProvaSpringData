package sc.senai.br.AvaliacaoCamllyPessotti.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.Fornecedor;
import sc.senai.br.AvaliacaoCamllyPessotti.repository.FornecedorRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FornecedorService {
    private FornecedorRepository fornecedorRepository;

    public List<Fornecedor> findAll() {
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> findById(Long aLong) {
        return fornecedorRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return fornecedorRepository.existsById(aLong);
    }

    public <S extends Fornecedor> S save(S entity) {
        return fornecedorRepository.save(entity);
    }

    public void deleteById(Long aLong) {
        fornecedorRepository.deleteById(aLong);
    }
}