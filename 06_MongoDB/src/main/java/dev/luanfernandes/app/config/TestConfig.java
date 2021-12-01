package dev.luanfernandes.app.config;

import dev.luanfernandes.app.entity.Address;
import dev.luanfernandes.app.entity.Person;
import dev.luanfernandes.app.repository.PessoaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@Slf4j
public class TestConfig implements CommandLineRunner {

    @Autowired
    public PessoaRepository pessoaRepository;


    @Override
    public void run(String... args) {

        Address residencial = new Address("Rua Jose Caetano", "SP");
        Address comercial = new Address("Avenida Silva Santos", "SP");
        var addresses = new ArrayList<>(Arrays.asList(residencial, comercial));

        pessoaRepository.save(new Person("Paulo Silva", 45, addresses));
        pessoaRepository.save(new Person("Pamela Brito", 60, addresses));
        pessoaRepository.save(new Person("Silvio Goncalves", 30, addresses));
        pessoaRepository.save(new Person("Silvana", 27, addresses));
        pessoaRepository.save(new Person("Silvia", 30, addresses));
        pessoaRepository.save(new Person("Marcela", 19, addresses));
        
        // find all
        log.info("Documents found with findAll():");
        pessoaRepository.findAll().forEach(person -> log.info(person.toString()));

        // find all and sort by nome
        log.info("Documents found with findAll(Sort.by(\"nome\").ascending())):");
        pessoaRepository.findAll(Sort.by("name").ascending()).forEach(person -> log.info(person.toString()));

        // find by nome
        log.info("Documents found with findByNome('Silvia'):");
        pessoaRepository.findByName("Silvia").forEach(person -> log.info(person.toString()));


        // find by nome using like
        log.info("Documents found with findByNomeLike('Pa'):");
        pessoaRepository.findByNameLike("Pa").forEach(person -> log.info(person.toString()));

        //  find by idade
        log.info("Documents found with findByIdade(30):");
        pessoaRepository.findByAge(30).forEach(person -> log.info(person.toString()));

        // find by idade between
        log.info("Documents found with findByIdadeBetween(25,35):");
        pessoaRepository.findByAgeBetween(25, 35).forEach(person -> log.info(person.toString()));

        // find by regexp nome
        log.info("Documents found with findByRegexpNome(\"^Silv\"):");
        pessoaRepository.findByNameRegex("^Silv").forEach(person -> log.info(person.toString()));


        // find by regexp nome and order by idade
        log.info("Documents found with findByRegexpNomeOrderByIdade('^Silv'):");
        pessoaRepository.findByNameRegexOrderByAge("^Silv").forEach(person -> log.info(person.toString()));

    }

}
