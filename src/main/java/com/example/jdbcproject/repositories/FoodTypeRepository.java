package com.example.jdbcproject.repositories;

import com.example.jdbcproject.models.FoodType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodTypeRepository extends CrudRepository<FoodType, Integer> {
}
