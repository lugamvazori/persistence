package dev.luanfernandes.app.repository;

import dev.luanfernandes.app.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends MongoRepository<Person, String> {
//    List<Person> findByNome(String nome);
//
//    List<Person> findByNomeLike(String nome);

    List<Person> findByAge(int age);

//    List<Person> findByIdadeBetween(int idadeMinima, int idadeMaxima);
//
//    List<Person> findByRegexpNome(String nameRegex);
//
//    List<Person> findByRegexpNomeOrderByIdade(String nameRegex);
//
//    List<Person> countByName(String name);
//
//    List<Person> findByCidade(String cidade);
}