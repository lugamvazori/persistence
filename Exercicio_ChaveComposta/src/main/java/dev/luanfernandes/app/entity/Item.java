package dev.luanfernandes.app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "itens")
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "QUANTIDADE")
    private int quantidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({@JoinColumn(name = "NUMPEDIDO", referencedColumnName = "NUMPEDIDO"), @JoinColumn(name = "CATEGORIA", referencedColumnName = "CATEGORIA")})
    private Pedido pedido;

    public Item(int quantidade) {
        this.quantidade = quantidade;
    }
}