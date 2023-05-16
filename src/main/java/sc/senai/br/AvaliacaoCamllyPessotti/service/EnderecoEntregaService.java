package sc.senai.br.AvaliacaoCamllyPessotti.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.EnderecoEntrega;
import sc.senai.br.AvaliacaoCamllyPessotti.repository.EnderecoEntregaRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EnderecoEntregaService {
    private EnderecoEntregaRepository enderecoEntregaRepository;

    public List<EnderecoEntrega> findAll() {
        return enderecoEntregaRepository.findAll();
    }

    public Optional<EnderecoEntrega> findById(Long aLong) {
        return enderecoEntregaRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return enderecoEntregaRepository.existsById(aLong);
    }

    public <S extends EnderecoEntrega> S save(S entity) {
        return enderecoEntregaRepository.save(entity);
    }

    public void deleteById(Long aLong) {
        enderecoEntregaRepository.deleteById(aLong);
    }
}