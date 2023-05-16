package sc.senai.br.AvaliacaoCamllyPessotti.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sc.senai.br.AvaliacaoCamllyPessotti.model.dto.ProdutoDto;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.Produto;
import sc.senai.br.AvaliacaoCamllyPessotti.service.ProdutoService;

import java.util.List;

@Controller
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/prova/produto")
public class ProdutoController {
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long id) {
        if (!produtoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum produto com o ID informado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid ProdutoDto produtoDto) {
//        if(produtoDto.getPreco() <= 0 || produtoDto.getQuantidade() <= 0){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Valores inválidos! (Devem ser maiores que 0)");
//        }

        Produto produto = new Produto();
        BeanUtils.copyProperties(produtoDto, produto);

        return ResponseEntity.status(HttpStatus.OK).body(produtoService.save(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@RequestBody @Valid ProdutoDto produtoDto, @PathVariable(name = "id") Long id) {
        if (!produtoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum produto com o ID informado");
        }

        Produto produto = produtoService.findById(id).get();
        BeanUtils.copyProperties(produtoDto, produto);
        produto.setId(id);

        return ResponseEntity.status(HttpStatus.OK).body(produtoService.save(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long id) {
        if (!produtoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum produto com o ID informado");
        }

        produtoService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso");
    }
}