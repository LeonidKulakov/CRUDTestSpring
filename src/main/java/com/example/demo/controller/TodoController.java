package com.example.demo.controller;

import com.example.demo.entity.Todo;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;
    @PostMapping
    private ResponseEntity createTodo(@RequestBody Todo todo, @RequestParam Long userId){
        try {
            return ResponseEntity.ok(todoService.createTodo(todo,userId));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Общая ошибка");
        }
    }
    private ResponseEntity updateTodo(@RequestParam(name = "id") Long userId,
                                      @RequestParam String title,
                                      @RequestParam String description){
        try {
           return ResponseEntity.ok(todoService.updateTodo(userId,title,description));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body("все плохо");
        }

    }
}
