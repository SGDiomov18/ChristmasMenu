package com.example.jdbcproject.repositories;

import com.example.jdbcproject.models.FoodType;
import org.springframework.data.repository.CrudRepository;

public interface FoodTypeRepository extends CrudRepository<FoodType, Integer> {
}
