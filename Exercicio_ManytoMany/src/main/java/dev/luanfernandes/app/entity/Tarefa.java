package dev.luanfernandes.app.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Entity
@Table(name="TAREFA", catalog="dbtarefas")
public class Tarefa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", unique=true, nullable=false)
    private Long id;

    @Column(name = "DESCRICAO", nullable = false, length=45)
    private String descricao;

    @Column(name = "DURACAO", nullable = false)
    private Integer duracao;


    @ManyToMany(fetch= FetchType.LAZY, mappedBy="tarefas")
    private Set<Funcionario> funcionarios = new HashSet<>();

    public Tarefa(String descricao, int duracao,Funcionario funcionario) {
        this.descricao = descricao;
        this.duracao = duracao;
        getFuncionarios().add(funcionario);
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Integer getDuracao() {
        return duracao;
    }
    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }
    public Set<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    public void setFuncionarios(Set<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

}
