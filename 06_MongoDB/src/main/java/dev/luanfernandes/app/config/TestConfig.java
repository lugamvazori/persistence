package dev.luanfernandes.app.config;

import dev.luanfernandes.app.entity.Address;
import dev.luanfernandes.app.entity.Person;
import dev.luanfernandes.app.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    public PessoaRepository repository;


    @Override
    public void run(String... args) {

        repository.deleteAll();

        repository.save(new Person("Silvia", 27));
        repository.save(new Person("Silvia", 22));

        Address residencial = new Address("Rua Jose Caetano", "SP");
        Address comercial = new Address("Avenida Silva Santos", "SP");
        List<Address> addresses = new ArrayList<>();
        addresses.add(residencial);
        addresses.add(comercial);

        repository.save(new Person("Paulo Silva", 45, addresses));
        repository.save(new Person("Pamela Brito", 60, addresses));
        repository.save(new Person("Julia Goncalves", 30, addresses));

        Address rj = new Address("Rua João Caxias", "RJ");

        List<Address> ends = new ArrayList<>();
        ends.add(rj);

        repository.save(new Person("Patricio Souza", 31, ends));

        // find all
        System.out.println("Documents found with findAll():");
        System.out.println("-------------------------------");
        for (Person person : repository.findAll()) {
            System.out.println(person);
        }
        System.out.println("\n");

        // find all and sort by nome
        System.out.println("Documents found with findAll(Sort.by(\"nome\").ascending())):");
        System.out.println("-------------------------------");
        for (Person person : repository.findAll(Sort.by("name").ascending())) {
            System.out.println(person);
        }
        System.out.println("\n");

//          find by nome
//        System.out.println("Documents found with findByNome('Silvia'):");
//        System.out.println("--------------------------------");
//        System.out.println(repository.findByNome("Silvia"));
//        System.out.println("\n");

//          find by nome using like
//        System.out.println("Documents found with findByNomeLike('Pa'):");
//        System.out.println("--------------------------------");
//        System.out.println(repository.findByNomeLike("Pa"));
//        System.out.println("\n");

//        find by idade
        System.out.println("Documents found with findByIdade(30):");
        System.out.println("--------------------------------");
        repository.findByAge(30).forEach(System.out::println);

        // find by idade between
//        System.out.println("Documents found with findByIdadeBetween(25,35):");
//        System.out.println("--------------------------------");
//        System.out.println(repository.findByIdadeBetween(25,35));
//        System.out.println("\n");

        // find by regexp nome
//        System.out.println("Documents found with findByRegexpNome(\"^Silv\"):");
//        System.out.println("--------------------------------");
//        System.out.println(repository.findByRegexpNome("^Silv"));
//        System.out.println("\n");


        // find by regexp nome and order by idade
//        System.out.println("Documents found with findByRegexpNomeOrderByIdade('^Silv'):");
//        System.out.println("--------------------------------");
//        System.out.println(repository.findByRegexpNomeOrderByIdade("^Silv"));
//        System.out.println("\n");
        // count by name
//        System.out.println("Documents found with countByName(\"Silvia\"):");
//        System.out.println("--------------------------------");
//        System.out.println(repository.countByName("Silvia"));
//        System.out.println("\n");

        // find by cidade
//        System.out.println("Documents found with findByCidade(\"RJ\"):");
//        System.out.println("--------------------------------");
//        System.out.println(repository.findByCidade("RJ"));
//        System.out.println("\n");
    }

}
