package sc.senai.br.AvaliacaoCamllyPessotti.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sc.senai.br.AvaliacaoCamllyPessotti.model.dto.ProdutoDto;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.ProdutoPedido;
import sc.senai.br.AvaliacaoCamllyPessotti.service.ProdutoPedidoService;

import java.util.List;

@Controller
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/prova/produtopedido")
public class ProdutoPedidoController {
    private ProdutoPedidoService produtoPedidoService;

    @GetMapping
    public ResponseEntity<List<ProdutoPedido>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(produtoPedidoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long id) {
        if (!produtoPedidoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum produto-pedido com o ID informado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(produtoPedidoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid ProdutoDto produtoDto) {
//        if (produtoDto.getQuantidade() <= 0) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Valor inválido! (Deve ser maior que 0)");
//        }

        ProdutoPedido produtoPedido = new ProdutoPedido();
        BeanUtils.copyProperties(produtoDto, produtoPedido);

        return ResponseEntity.status(HttpStatus.OK).body(produtoPedidoService.save(produtoPedido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@RequestBody @Valid ProdutoDto produtoDto, @PathVariable(name = "id") Long id) {
        if (!produtoPedidoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum produto-pedido com o ID informado");
        }

        ProdutoPedido produtoPedido = produtoPedidoService.findById(id).get();
        BeanUtils.copyProperties(produtoDto, produtoPedido);
        produtoPedido.setId(id);

        return ResponseEntity.status(HttpStatus.OK).body(produtoPedidoService.save(produtoPedido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long id) {
        if (!produtoPedidoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum produto-pedido com o ID informado");
        }

        produtoPedidoService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Produto-pedido deletado com sucesso");
    }
}