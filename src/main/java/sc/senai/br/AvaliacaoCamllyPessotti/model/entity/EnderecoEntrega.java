package sc.senai.br.AvaliacaoCamllyPessotti.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class EnderecoEntrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @OneToOne
    private Endereco endereco;

    @OneToOne(mappedBy = "endereco")
    @JsonIgnore
    private Pedido pedido;
}