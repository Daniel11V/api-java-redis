package com.coderhouse.service;

import com.coderhouse.model.User;

public interface UserService {
    User getUser(String username, String pwd) throws Exception;
}
