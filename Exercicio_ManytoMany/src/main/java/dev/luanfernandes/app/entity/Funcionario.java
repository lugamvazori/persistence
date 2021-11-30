package dev.luanfernandes.app.entity;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@Entity
@Table(name="FUNCIONARIO", catalog="dbtarefas", uniqueConstraints =
        {
                @UniqueConstraint(columnNames="CODIGO_FUNCIONARIO")
        })
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", unique=true, nullable=false)
    private Long id;

    @Type(type = "uuid-char")
    @Column(name="CODIGO_FUNCIONARIO", unique=true, nullable=false)
    private UUID matricula;

    @Column(name="NOME_FUNCIONARIO", unique=true, nullable=false, length=45)
    private String nome;

    @ManyToMany(fetch= FetchType.LAZY, cascade= CascadeType.ALL)
    @JoinTable(name="FUNCIONARIO_TAREFA", catalog="dbtarefas", joinColumns =
            {@JoinColumn(name="FUNCIONARIO_ID", nullable=false, updatable=false)},
            inverseJoinColumns = {@JoinColumn(name="TAREFA_ID", nullable=false,
                    updatable=false)})
    private Set<Tarefa> tarefas = new HashSet<>();

    public Funcionario(UUID matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public UUID getMatricula() {
        return matricula;
    }
    public void setMatricula(UUID matricula) {
        this.matricula = matricula;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Set<Tarefa> getTarefas() {
        return tarefas;
    }
    public void setTarefas(Set<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                ", matricula=" + matricula +
                ", nome='" + nome + '\'' +
                '}';
    }
}