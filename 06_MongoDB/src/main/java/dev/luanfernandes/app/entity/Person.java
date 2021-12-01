package dev.luanfernandes.app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Document
public class Person {

    @Id
    private String id;
    private String name;
    private int age;
    private List<Address> address;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, List<Address> address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}