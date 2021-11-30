package dev.luanfernandes.app.config;

import dev.luanfernandes.app.entity.Evento;
import dev.luanfernandes.app.entity.Participante;
import dev.luanfernandes.app.repository.EventoRepository;
import dev.luanfernandes.app.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Date;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    EventoRepository eventoRepository;

    @Autowired
    EventoService eventoService;

    @Override
    public void run(String... args) {

        Evento evento = new Evento("SpringBoot", "Juvenal Santos", new Date());

        evento.getParticipantes().addAll(Arrays.asList(
                new Participante("Jose Antonio", "jantonio@fap.com.br", evento),
                new Participante("Camila", "camila@fap.com.br", evento),
                new Participante("Bonifacio", "bonifacio@fap.com.br", evento)));

        eventoService.save(evento);
        eventoService.printALl();
    }

}
