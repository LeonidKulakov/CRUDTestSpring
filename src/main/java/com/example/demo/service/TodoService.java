package com.example.demo.service;

import com.example.demo.entity.Todo;
import com.example.demo.entity.User;
import com.example.demo.exception.TodoNotFoundException;
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

    public TodoModel todoIsDone(Long userId, String title) throws TodoNotFoundException {
        Todo todo = todoRepo.findByTitleAndUserId(title, userId);
        if (todo == null) throw new TodoNotFoundException("Такое дело не найдено");
        todo.setCompleted(true);
        return TodoModel.toModel(todoRepo.save(todo));
    }

}
