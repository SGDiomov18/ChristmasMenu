package com.example.jdbcproject.repositories;

import com.example.jdbcproject.models.Drink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends CrudRepository<Drink, Integer> {
    Drink findDrinkByName(String name);
}
