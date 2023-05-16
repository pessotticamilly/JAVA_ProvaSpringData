package sc.senai.br.AvaliacaoCamllyPessotti.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    @Positive
    private Double preco;

    @Column(nullable = false)
    @Positive
    private Integer quantidade;

    @ManyToMany(mappedBy = "produtos")
    private List<Fornecedor> fornecedores;
}