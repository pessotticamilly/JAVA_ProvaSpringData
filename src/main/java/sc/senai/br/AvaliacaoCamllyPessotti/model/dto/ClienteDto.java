package sc.senai.br.AvaliacaoCamllyPessotti.model.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.CartaoCredito;
import sc.senai.br.AvaliacaoCamllyPessotti.model.entity.Endereco;

import java.util.List;

@Data
public class ClienteDto {
    private String nome;
    @Email
    private String email;
    private String telefone;
    private List<Endereco> enderecos;
    private CartaoCredito cartao;
}