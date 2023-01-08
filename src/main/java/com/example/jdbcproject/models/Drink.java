package com.example.jdbcproject.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@Table(name = "DRINKS")
public class Drink {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String name;

    @ManyToOne()
    @JoinColumn(name = "drinkTypesId", nullable = false)
    private DrinkType drinkTypesId;

    private int calories;

    public Drink(Integer id, String name, DrinkType drinkTypesId, int calories) {
        Id = id;
        this.name = name;
        this.drinkTypesId = drinkTypesId;
        this.calories = calories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drink drink)) return false;
        return calories == drink.calories && Id.equals(drink.Id) && name.equals(drink.name) && drinkTypesId.equals(drink.drinkTypesId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, drinkTypesId, calories);
    }
}
