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
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telefone;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente")
    @JsonIgnore
    private List<Endereco> enderecos;

    @OneToOne(cascade = CascadeType.ALL)
    private CartaoCredito cartao;
}