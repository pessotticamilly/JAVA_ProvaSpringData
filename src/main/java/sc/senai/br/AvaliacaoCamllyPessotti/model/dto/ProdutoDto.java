package sc.senai.br.AvaliacaoCamllyPessotti.model.dto;

import jakarta.validation.constraints.Positive;
import lombok.Data;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.Fornecedor;

import java.util.List;

@Data
public class ProdutoDto {
    private String nome;
    @Positive
    private Double preco;
    @Positive
    private Integer quantidade;
    private List<Fornecedor> fornecedores;
}