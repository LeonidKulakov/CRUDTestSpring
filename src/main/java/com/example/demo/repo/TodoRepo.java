package com.example.demo.repo;

import com.example.demo.entity.Todo;
import com.example.demo.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<Todo,Long> {

    Todo findByTitleAndUser(String title, User user);
}
