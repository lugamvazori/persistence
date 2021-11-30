package dev.luanfernandes.app.service;

import dev.luanfernandes.app.entity.Funcionario;
import dev.luanfernandes.app.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository repository;

    public void save(Funcionario f1) {
        try {
            repository.save(f1);
        } catch (Exception e) {
            System.out.println("ERRO -> " + e);
        }
    }

    public void printAll() {
        repository.findAll().forEach(System.out::println);
    }

    public void findByMatricula(String matricula) {
        var f = repository.
                findFuncionariosByMatricula(UUID.fromString(matricula));
        System.out.printf("%nFuncionário encontrado: %s%n", f);
    }

    public void findByMatricula(UUID matricula) {
        var f = repository.
                findFuncionariosByMatricula(matricula);
        if (f == null){
            System.out.println("Funcionário não encontrado!");
        }else {
            System.out.println("Funcionário encontrado: "+ f);
        }

    }
}
