package com.example.demo.repositories;

import com.example.demo.model.Restaurants;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantsRepository extends CrudRepository<Restaurants, Long> {
}
