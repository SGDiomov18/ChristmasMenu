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
@Table(name = "FOODTYPES")
public class FoodType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String name;

    @OneToMany(mappedBy = "foodTypesId")
    @ToString.Exclude
    private Set<Food> food;

    public FoodType(Integer id, String name) {
        Id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FoodType foodType)) return false;
        return Id.equals(foodType.Id) && name.equals(foodType.name) && food.equals(foodType.food);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, food);
    }
}
