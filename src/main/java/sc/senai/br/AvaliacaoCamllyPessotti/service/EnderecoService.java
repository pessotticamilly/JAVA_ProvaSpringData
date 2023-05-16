package sc.senai.br.AvaliacaoCamllyPessotti.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.Endereco;
import sc.senai.br.AvaliacaoCamllyPessotti.repository.EnderecoRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EnderecoService {
    private EnderecoRepository enderecoRepository;

    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> findById(Long aLong) {
        return enderecoRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return enderecoRepository.existsById(aLong);
    }

    public <S extends Endereco> S save(S entity) {
        return enderecoRepository.save(entity);
    }

    public void deleteById(Long aLong) {
        enderecoRepository.deleteById(aLong);
    }
}