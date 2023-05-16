package sc.senai.br.AvaliacaoCamllyPessotti.model.dto;

import lombok.Data;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.Cliente;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.Produto;

import java.util.List;

@Data
public class FornecedorDto {
    private String nome;
    private String cnpj;
    private List<Produto> produtos;
    private List<Cliente> clientes;
}