package com.learning.spring_worshop.services;

import com.learning.spring_worshop.entities.User;
import com.learning.spring_worshop.repositories.UserRepositorie;
import com.learning.spring_worshop.services.exceptions.ResourceNotFoundException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj){
        return userRepositorie.save(obj);
    }

    public void deleteByid(Long id){
        userRepositorie.deleteById(id);
    }

    public User put(Long id, User obj){
        User entity = userRepositorie.getReferenceById(id);
        setEntity(entity, obj);

        return userRepositorie.save(entity);
    }

    public User setEntity(User entity, User obj){
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
        entity.setPassword(obj.getPassword());

        return entity;
    }
}
