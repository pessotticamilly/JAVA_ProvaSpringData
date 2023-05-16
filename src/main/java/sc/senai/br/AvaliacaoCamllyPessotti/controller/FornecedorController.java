package sc.senai.br.AvaliacaoCamllyPessotti.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sc.senai.br.AvaliacaoCamllyPessotti.model.dto.FornecedorDto;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.Fornecedor;
import sc.senai.br.AvaliacaoCamllyPessotti.service.FornecedorService;

import java.util.List;

@Controller
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/prova/fornecedor")
public class FornecedorController {
    private FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<List<Fornecedor>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(fornecedorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long id) {
        if (!fornecedorService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum fornecedor com o ID informado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(fornecedorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid FornecedorDto fornecedorDto) {
        Fornecedor fornecedor = new Fornecedor();
        BeanUtils.copyProperties(fornecedorDto, fornecedor);

        return ResponseEntity.status(HttpStatus.OK).body(fornecedorService.save(fornecedor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@RequestBody @Valid FornecedorDto fornecedorDto, @PathVariable(name = "id") Long id) {
        if (!fornecedorService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum fornecedor com o ID informado");
        }

        Fornecedor fornecedor = fornecedorService.findById(id).get();
        BeanUtils.copyProperties(fornecedorDto, fornecedor);
        fornecedor.setId(id);

        return ResponseEntity.status(HttpStatus.OK).body(fornecedorService.save(fornecedor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long id) {
        if (!fornecedorService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum endereço com o ID informado");
        }

        fornecedorService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Fornecedor deletado com sucesso");
    }
}