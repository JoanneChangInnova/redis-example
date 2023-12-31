package org.example.service;

import org.example.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User findById(Integer pId);

    void clearAllUserCache();

    void clear(Integer pId);


}
