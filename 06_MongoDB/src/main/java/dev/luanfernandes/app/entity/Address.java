package dev.luanfernandes.app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;


@NoArgsConstructor
@Getter
@Setter
@ToString
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