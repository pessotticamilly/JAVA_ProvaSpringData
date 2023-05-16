package sc.senai.br.AvaliacaoCamllyPessotti.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sc.senai.br.AvaliacaoCamllyPessotti.model.dto.CartaoCreditoDto;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.CartaoCredito;
import sc.senai.br.AvaliacaoCamllyPessotti.service.CartaoCreditoService;

import java.util.List;

@Controller
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/prova/cartaocredito")
public class CartaoCreditoController {
    private CartaoCreditoService cartaoCreditoService;

    @GetMapping
    public ResponseEntity<List<CartaoCredito>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(cartaoCreditoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long id) {
        if (!cartaoCreditoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum cartão de crédito com o ID informado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(cartaoCreditoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid CartaoCreditoDto cartaoCreditoDto) {
        CartaoCredito cartaoCredito = new CartaoCredito();
        BeanUtils.copyProperties(cartaoCreditoDto, cartaoCredito);

        return ResponseEntity.status(HttpStatus.OK).body(cartaoCreditoService.save(cartaoCredito));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@RequestBody @Valid CartaoCreditoDto cartaoCreditoDto, @PathVariable(name = "id") Long id) {
        if (!cartaoCreditoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum cartão de crédito com o ID informado");
        }

        CartaoCredito cartaoCredito = cartaoCreditoService.findById(id).get();
        BeanUtils.copyProperties(cartaoCreditoDto, cartaoCredito);
        cartaoCredito.setId(id);

        return ResponseEntity.status(HttpStatus.OK).body(cartaoCreditoService.save(cartaoCredito));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long id) {
        if (!cartaoCreditoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum cartão de crédito com o ID informado");
        }

        cartaoCreditoService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Cartão de crédito deletado com sucesso");
    }
}