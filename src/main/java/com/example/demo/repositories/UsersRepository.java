package com.example.demo.repositories;

import com.example.demo.model.Users;
import org.springframework.data.repository.CrudRepository;



public interface UsersRepository extends CrudRepository<Users, Long> {
}
