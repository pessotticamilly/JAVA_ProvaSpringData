package sc.senai.br.AvaliacaoCamllyPessotti.model.dto;

import lombok.Data;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.Endereco;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.Pedido;

@Data
public class EnderecoEntregaDto {
    private Endereco endereco;
    private Pedido pedido;
}