package sc.senai.br.AvaliacaoCamllyPessotti.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sc.senai.br.AvaliacaoCamllyPessotti.model.dto.EnderecoEntregaDto;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.EnderecoEntrega;
import sc.senai.br.AvaliacaoCamllyPessotti.service.EnderecoEntregaService;

import java.util.List;

@Controller
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/prova/enderecoentrega")
public class EnderecoEntregaController {
    private EnderecoEntregaService enderecoEntregaService;

    @GetMapping
    public ResponseEntity<List<EnderecoEntrega>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoEntregaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long id) {
        if (!enderecoEntregaService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum endereço-entrega com o ID informado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(enderecoEntregaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid EnderecoEntregaDto enderecoEntregaDto) {
        EnderecoEntrega enderecoEntrega = new EnderecoEntrega();
        BeanUtils.copyProperties(enderecoEntregaDto, enderecoEntrega);

        return ResponseEntity.status(HttpStatus.OK).body(enderecoEntregaService.save(enderecoEntrega));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@RequestBody @Valid EnderecoEntregaDto enderecoEntregaDto, @PathVariable(name = "id") Long id) {
        if (!enderecoEntregaService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum endereço-entrega com o ID informado");
        }

        EnderecoEntrega enderecoEntrega = enderecoEntregaService.findById(id).get();
        BeanUtils.copyProperties(enderecoEntregaDto, enderecoEntrega);
        enderecoEntrega.setId(id);

        return ResponseEntity.status(HttpStatus.OK).body(enderecoEntregaService.save(enderecoEntrega));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long id) {
        if (!enderecoEntregaService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum endereço com o ID informado");
        }

        enderecoEntregaService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Endereço-entrega deletado com sucesso");
    }
}