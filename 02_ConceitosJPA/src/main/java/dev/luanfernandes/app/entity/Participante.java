package dev.luanfernandes.app.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "participantes")
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "EMAIL")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDEVENTO")
    private Evento evento;

    public Participante(String nome, String email, Evento evento) {
        this.nome = nome;
        this.email = email;
        this.evento = evento;
    }
}