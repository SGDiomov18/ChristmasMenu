package com.example.jdbcproject.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@Table(name = "DRINKTYPES")
public class DrinkType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String name;

    @OneToMany(mappedBy = "drinkTypesId")
    @ToString.Exclude
    private Set<Drink> drinks;

    public DrinkType(Integer id, String name) {
        Id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DrinkType drinkType)) return false;
        return Id.equals(drinkType.Id) && name.equals(drinkType.name) && drinks.equals(drinkType.drinks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, drinks);
    }
}
