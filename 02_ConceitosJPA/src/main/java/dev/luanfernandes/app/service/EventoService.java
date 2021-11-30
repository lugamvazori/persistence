package dev.luanfernandes.app.service;

import dev.luanfernandes.app.entity.Evento;
import dev.luanfernandes.app.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {

    @Autowired
    EventoRepository eventoRepository;

    public void save(Evento evento) {
        eventoRepository.save(evento);
    }

    public void printALl() {
        eventoRepository.findAll().forEach(e -> e.getParticipantes().forEach(System.out::println));
    }
}
