package dev.luanfernandes.app.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name = "pedidos")
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private PedidosPK pedidoPK;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "DATAPEDIDO")
    private Date dataPedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDCLIENTE")
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pedido")
    private Set<Item> itens = new LinkedHashSet<>();

    public Pedido(Date dataPedido, PedidosPK pedidoPK, Cliente cliente) {
        this.dataPedido = dataPedido;
        this.pedidoPK = pedidoPK;
        this.cliente = cliente;
    }

    public void addItem(Item item){
        getItens().add(item);
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<Item> getItens() {
        return itens;
    }

    public void setItens(Set<Item> itens) {
        this.itens = itens;
    }

    public PedidosPK getPedidoPK() {
        return pedidoPK;
    }

    public void setPedidoPK(PedidosPK pedidoPK) {
        this.pedidoPK = pedidoPK;
    }
}
