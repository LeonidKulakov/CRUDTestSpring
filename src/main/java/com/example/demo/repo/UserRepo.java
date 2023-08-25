package com.example.demo.repo;

import com.example.demo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UserRepo extends CrudRepository<User, Long> {

    User findByUsername(String username);

}
