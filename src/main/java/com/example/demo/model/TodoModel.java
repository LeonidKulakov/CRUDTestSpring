package com.example.demo.model;

import com.example.demo.entity.Todo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoModel {
    private String title;
    private Boolean completed;
    private String description;
    private Long userId;

    public static TodoModel toModel(Todo todo){
      return TodoModel.builder()
              .title(todo.getTitle())
              .completed(todo.getCompleted())
              .description(todo.getDescription())
              .userId(todo.getUser().getId())
              .build();

    }
}
