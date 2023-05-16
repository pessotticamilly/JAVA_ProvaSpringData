package sc.senai.br.AvaliacaoCamllyPessotti.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sc.senai.br.AvaliacaoCamllyPessotti.model.dto.ClienteDto;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.CartaoCredito;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.Cliente;
import sc.senai.br.AvaliacaoCamllyPessotti.service.CartaoCreditoService;
import sc.senai.br.AvaliacaoCamllyPessotti.service.ClienteService;

import java.util.List;

@Controller
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/prova/cliente")
public class ClienteController {
    private ClienteService clienteService;
    private CartaoCreditoService cartaoCreditoService;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long id) {
        if (!clienteService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum cliente com o ID informado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid ClienteDto clienteDto) {
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteDto, cliente);

        return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@RequestBody @Valid ClienteDto clienteDto, @PathVariable(name = "id") Long id) {
        if (!clienteService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum cliente com o ID informado");
        }

        CartaoCredito cartao = clienteDto.getCartao();
        clienteDto.setCartao(cartao);
        System.out.println(">>>>>>>> CARTAO > " + cartao);

        Cliente cliente = clienteService.findById(id).get();
        BeanUtils.copyProperties(clienteDto, cliente);
        cliente.setId(id);

        return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long id) {
        if (!clienteService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum cliente com o ID informado");
        }

        clienteService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso");
    }
}