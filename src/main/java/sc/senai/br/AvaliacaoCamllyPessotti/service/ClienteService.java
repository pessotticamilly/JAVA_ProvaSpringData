package sc.senai.br.AvaliacaoCamllyPessotti.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.Cliente;
import sc.senai.br.AvaliacaoCamllyPessotti.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteService {
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long aLong) {
        return clienteRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return clienteRepository.existsById(aLong);
    }

    public <S extends Cliente> S save(S entity) {
        return clienteRepository.save(entity);
    }

    public void deleteById(Long aLong) {
        clienteRepository.deleteById(aLong);
    }
}