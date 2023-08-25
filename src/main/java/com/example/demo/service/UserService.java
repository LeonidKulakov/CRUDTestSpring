package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.UserModel;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User registration(User user) throws UserAlreadyExistsException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistsException("Такой пользователь уже существует");
        }
        return userRepo.save(user);
    }


    public UserModel getUser(Long id) throws UserNotFoundException {
        User user = findByIdOrThrow(id);
        return UserModel.toModel(user);
    }

    public Long deleteUser(Long id) throws UserNotFoundException {
        findByIdOrThrow(id);
        userRepo.deleteById(id);
        return id;
    }

    private User findByIdOrThrow(Long id) throws UserNotFoundException {
        User user = userRepo.findById(id).orElse(null);
        if (user == null) {
            throw new UserNotFoundException("Такого пользователя не существует");
        }
        return user;
    }


}
