package com.example.jdbcproject.repositories;

import com.example.jdbcproject.models.DrinkType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkTypeRepository extends CrudRepository<DrinkType, Integer> {
}
