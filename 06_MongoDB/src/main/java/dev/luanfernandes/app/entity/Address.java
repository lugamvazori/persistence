package dev.luanfernandes.app.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    private String id;
    private String street;
    private String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }
}