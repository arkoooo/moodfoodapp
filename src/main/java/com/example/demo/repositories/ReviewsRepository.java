package com.example.demo.repositories;

import com.example.demo.model.Reviews;
import org.springframework.data.repository.CrudRepository;

public interface ReviewsRepository extends CrudRepository<Reviews, Long> {
}
