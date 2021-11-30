package dev.luanfernandes.app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "endereco")
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "RUA")
    private String rua;

    @Column(name = "CIDADE")
    private String cidade;

    @Column(name = "CEP")
    private String cep;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDCLIENTE")
    private Cliente cliente;


    public Endereco(String rua, String cidade, String cep, Cliente cliente) {
        this.rua = rua;
        this.cidade = cidade;
        this.cep = cep;
        this.cliente = cliente;
    }
}