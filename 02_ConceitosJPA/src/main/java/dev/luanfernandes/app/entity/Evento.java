package dev.luanfernandes.app.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "eventos")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "DESCRICAO", length = 45)
    private String descricao;

    @Column(name = "RESPONSAVEL", length = 45)
    private String responsavel;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "DATA", length = 45)
    private Date data;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "evento", cascade = CascadeType.ALL)
    private Set<Participante> participantes = new HashSet<>();

    public Evento(String descricao, String responsavel, Date data) {
        this.descricao = descricao;
        this.responsavel = responsavel;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", responsavel='" + responsavel + '\'' +
                ", data=" + data +
                '}';
    }

}