package com.coderhouse.service.impl;

import com.coderhouse.handle.ApiRestException;
import com.coderhouse.model.User;
import com.coderhouse.repository.UserRepository;
import com.coderhouse.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public User getUser(String username, String pwd) throws ApiRestException {
        var user = repository.findUserByUsername(username);

        if (!(user.getUsername().equals(username) && user.getPassword().equals(pwd))) {
            throw ApiRestException.builder().message("El usuario o el password es inválido").build();
        }
        return User.builder().username(username).build();
    }
}
