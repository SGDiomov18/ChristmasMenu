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
@Table (name = "FOOD")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String name;

    @ManyToOne()
    @JoinColumn(name = "foodTypesId", nullable = false)
    private FoodType foodTypesId;

    private int calories;

    public Food(Integer id, String name, FoodType foodTypesId, int calories) {
        Id = id;
        this.name = name;
        this.foodTypesId = foodTypesId;
        this.calories = calories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Food food)) return false;
        return calories == food.calories && Id.equals(food.Id) && name.equals(food.name) && foodTypesId.equals(food.foodTypesId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, foodTypesId, calories);
    }
}
