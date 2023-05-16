package sc.senai.br.AvaliacaoCamllyPessotti.model.dto;

import jakarta.validation.constraints.Positive;
import lombok.Data;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.Pedido;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.Produto;

@Data
public class ProdutoPedidoDto {
    @Positive
    private Integer quantidade;
    private Produto produto;
    private Pedido pedido;
}