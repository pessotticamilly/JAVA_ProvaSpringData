package sc.senai.br.AvaliacaoCamllyPessotti.model.dto;

import jakarta.validation.constraints.Positive;
import lombok.Data;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.Cliente;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.EnderecoEntrega;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.ProdutoPedido;

import java.util.List;

@Data
public class PedidoDto {
    @Positive
    private Double valorTotal;
    private List<ProdutoPedido> produtos;
    private Cliente cliente;
    private EnderecoEntrega endereco;
}