package com.example.jdbcproject.repositories;

import com.example.jdbcproject.models.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends CrudRepository<Food, Integer> {
    Food findFoodByName(String name);
}
