package dev.luanfernandes.app.config;


import dev.luanfernandes.app.entity.Funcionario;
import dev.luanfernandes.app.entity.Tarefa;
import dev.luanfernandes.app.repository.FuncionarioRepository;
import dev.luanfernandes.app.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    FuncionarioRepository repository;

    @Autowired
    FuncionarioService service;

    @Override
    public void run(String... args) {

        Funcionario f1 = new Funcionario(UUID.randomUUID(), "Paulo Kleber");
        Tarefa t1 = new Tarefa("Teste Unitário", 100,f1);

        f1.getTarefas().add(t1);

        service.save(f1);
        service.printAll();

        service.findByMatricula(f1.getMatricula());
        service.findByMatricula("e6bcdd4d-1f42-42be-8d0f-1c7c94075c2b");

    }


}
