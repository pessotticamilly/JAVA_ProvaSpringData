package sc.senai.br.AvaliacaoCamllyPessotti.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    @Positive
    private Double valorTotal;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ProdutoPedido> produtos;

    @ManyToOne
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private EnderecoEntrega endereco;
}