package com.learning.spring_worshop.services;

import com.learning.spring_worshop.entities.User;
import com.learning.spring_worshop.repositories.UserRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepositorie userRepositorie;

    public List<User> findAll(){
        List<User> obj = userRepositorie.findAll();
        return obj;

    }

    public User findById(Long id){
        Optional<User> obj = userRepositorie.findById(id);
        return obj.get();
    }

    public User insert(User obj){
        return userRepositorie.save(obj);
    }

}
