package sc.senai.br.AvaliacaoCamllyPessotti.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cnpj;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Produto> produtos;

    @OneToMany
    @JoinColumn(name = "id_fornecedor")
    private List<Cliente> clientes;
}