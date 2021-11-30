package dev.luanfernandes.app.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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