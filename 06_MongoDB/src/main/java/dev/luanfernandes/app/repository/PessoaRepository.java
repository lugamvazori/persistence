package dev.luanfernandes.app.repository;

import dev.luanfernandes.app.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends MongoRepository<Person, String> {

    @Query(value = "{ 'age' : ?0, 'questions.questionID' : ?1 }", fields = "{ 'questions.questionID' : 1 }")
    List<Person> findByIdade(int userId, int questionID);

    List<Person> findByName(String name);

    List<Person> findByNameLike(String name);

    List<Person> findByAge(int age);

    List<Person> findByAgeBetween(int min, int max);

    List<Person> findByNameRegex(String name);

    List<Person> findByNameRegexOrderByAge(String name);
}