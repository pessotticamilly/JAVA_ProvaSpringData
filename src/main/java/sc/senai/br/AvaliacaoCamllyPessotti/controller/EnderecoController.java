package sc.senai.br.AvaliacaoCamllyPessotti.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sc.senai.br.AvaliacaoCamllyPessotti.model.dto.EnderecoDto;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.Endereco;
import sc.senai.br.AvaliacaoCamllyPessotti.service.EnderecoService;

import java.util.List;

@Controller
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/prova/endereco")
public class EnderecoController {
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long id) {
        if (!enderecoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum endereço com o ID informado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid EnderecoDto enderecoDto) {
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(enderecoDto, endereco);

        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.save(endereco));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@RequestBody @Valid EnderecoDto enderecoDto, @PathVariable(name = "id") Long id) {
        if (!enderecoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum endereço com o ID informado");
        }

        Endereco endereco = enderecoService.findById(id).get();
        BeanUtils.copyProperties(enderecoDto, endereco);
        endereco.setId(id);

        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.save(endereco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long id) {
        if (!enderecoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum endereço com o ID informado");
        }

        enderecoService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Endereço deletado com sucesso");
    }
}