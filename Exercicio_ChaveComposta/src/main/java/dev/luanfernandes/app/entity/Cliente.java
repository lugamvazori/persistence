package dev.luanfernandes.app.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name="clientes")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="ID")
    private Long id;

    @Column(name="EMPRESA", length=45)
    private String empresa;

    @OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY, mappedBy="cliente")
    private Set<Pedido> pedidos = new LinkedHashSet<Pedido>();

    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="cliente")

    private Set<Endereco> enderecos = new LinkedHashSet<Endereco>();

    public Cliente(Long id, String empresa) {
        this.id = id;
        this.empresa = empresa;
    }

    public void addEndereco(Endereco endereco){
        getEnderecos().add(endereco);
    }

    public void addPedido(Pedido pedido){
        getPedidos().add(pedido);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    public Set<Endereco> getEnderecos() {
        return enderecos;
    }
    public void setEnderecos(Set<Endereco> enderecos) {
       this.enderecos = enderecos;
    }
}