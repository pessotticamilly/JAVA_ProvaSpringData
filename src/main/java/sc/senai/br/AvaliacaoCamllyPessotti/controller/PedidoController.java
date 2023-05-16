package sc.senai.br.AvaliacaoCamllyPessotti.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sc.senai.br.AvaliacaoCamllyPessotti.model.dto.PedidoDto;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.EnderecoEntrega;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.Pedido;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.ProdutoPedido;
import sc.senai.br.AvaliacaoCamllyPessotti.service.EnderecoEntregaService;
import sc.senai.br.AvaliacaoCamllyPessotti.service.PedidoService;
import sc.senai.br.AvaliacaoCamllyPessotti.service.ProdutoPedidoService;

import java.util.List;

@Controller
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/prova/pedido")
public class PedidoController {
    private PedidoService pedidoService;
    private ProdutoPedidoService produtoPedidoService;
    private EnderecoEntregaService enderecoEntregaService;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long id) {
        if (!pedidoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum pedido com o ID informado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid PedidoDto pedidoDto) {
        Pedido pedido = new Pedido();
        BeanUtils.copyProperties(pedidoDto, pedido);

        Pedido pedidoSalvo = pedidoService.save(pedido);

        for (ProdutoPedido produtoPedido : pedidoSalvo.getProdutos()) {
            produtoPedido.setPedido(pedidoSalvo);
            produtoPedidoService.save(produtoPedido);
        }

        EnderecoEntrega enderecoEntrega = pedidoSalvo.getEndereco();
        enderecoEntrega.setPedido(pedidoSalvo);
        enderecoEntregaService.save(enderecoEntrega);

        return ResponseEntity.status(HttpStatus.OK).body(pedidoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@RequestBody @Valid PedidoDto pedidoDto, @PathVariable(name = "id") Long id) {
        if (!pedidoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum pedido com o ID informado");
        }

        Pedido pedido = pedidoService.findById(id).get();
        BeanUtils.copyProperties(pedidoDto, pedido);
        pedido.setId(id);

        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.save(pedido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long id) {
        if (!pedidoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum pedido com o ID informado");
        }

        pedidoService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Pedido deletado com sucesso");
    }
}