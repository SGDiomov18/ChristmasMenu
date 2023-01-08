package com.example.jdbcproject.repositories;

import com.example.jdbcproject.models.Food;
import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food, Integer> {
    Food findFoodByName(String name);
}
