package com.example.demo.model;

import com.example.demo.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserModel {
    private String username;
    private String password;

    public static UserModel toModel(User user) {
        UserModel userModel = new UserModel();
        userModel.setUsername(user.getUsername());
        userModel.setPassword(user.getPassword());
        return userModel;
    }

}
