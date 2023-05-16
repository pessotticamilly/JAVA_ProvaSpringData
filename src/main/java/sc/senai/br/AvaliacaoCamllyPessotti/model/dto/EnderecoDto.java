package sc.senai.br.AvaliacaoCamllyPessotti.model.dto;

import lombok.Data;

@Data
public class EnderecoDto {
    private String rua;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
}