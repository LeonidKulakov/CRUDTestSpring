package com.example.demo.service;

import com.example.demo.entity.Todo;
import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.TodoModel;
import com.example.demo.repo.TodoRepo;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private TodoRepo todoRepo;

    public TodoModel createTodo(Todo todo, Long userId) throws UserNotFoundException {
        User user = userRepo.findById(userId).orElse(null);
        if (user == null) throw new UserNotFoundException("Такого пользователя не существует");

        todo.setUser(user);
        return TodoModel.toModel(todoRepo.save(todo));
    }

    public TodoModel updateTodo(Long userId, String title, String description) throws UserNotFoundException {
        User user = userRepo.findById(userId).orElse(null);
        if (user == null) throw new UserNotFoundException("Такого пользователя не существует");
        Todo todo = todoRepo.findById(userId).orElse(null);
      //  Todo todo = todoRepo.findByTitleAndUser(title, user);
        todo.setDescription(description);
        return TodoModel.toModel(todoRepo.save(todo));
    }

}
